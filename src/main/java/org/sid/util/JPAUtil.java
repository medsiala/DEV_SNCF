package org.sid.util;

import javassist.util.proxy.MethodFilter;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * todo
 */
public class JPAUtil {
    private static Logger logger = LoggerFactory.getLogger(JPAUtil.class);
    static EntityManagerFactory emf;

    public static void init(String pm) {
        Thread.currentThread().setContextClassLoader(Persistence.class.getClassLoader()); // scala REPL hack
        emf = Persistence.createEntityManagerFactory(pm);

    }


    private static ThreadLocal<EntityManager> entityManagerThreadLocal = new ThreadLocal<EntityManager>();
    private static ThreadLocal<Boolean> rollbackFlag = new ThreadLocal<Boolean>();

    /**
     * Returns the <code>EntityManager</code> for this thread
     *
     * @return
     */
    public static EntityManager getEntityManager() {
        if (emf == null)
            throw new RuntimeException("JPAUtil not initialised, call init method first");
        EntityManager entityManager = entityManagerThreadLocal.get();
        if (entityManager == null) {
            entityManager = emf.createEntityManager();
            entityManagerThreadLocal.set(entityManager);
        }
        return entityManager;

    }

    /**
     * Creates an JPA transactional proxy with following semantics:
     * <ul>
     * <li>Shares an <code>EntityManager</code> </code> per thread</li>
     * <li>Opens and closes the entityManager for each method call </li>
     * <li>Transaction follow REQUIRED pattern (will join an existing transaction)</li>
     * <li>Rollsback on any exception</li>
     * </ul>
     * This implementation does not inject the <code>EntityManager</code>  into the target object
     *
     * @param clazz
     * @param <T>   The class for which to create a proxy (using Javassist)
     * @return
     */
    public static <T> T getTransactionalProxy(Class<? extends T> clazz) {
        ProxyFactory f = new ProxyFactory();
        f.setSuperclass(clazz);
        f.setFilter(new MethodFilter() {

            public boolean isHandled(Method m) {
                return Modifier.isPublic(m.getModifiers());
            }
        });
        Class c = f.createClass();
        MethodHandler mi = new MethodHandler() {


            public Object invoke(Object self, Method thisMethod, Method proceed, Object[] args) throws Throwable {
                final EntityManager entityManager = getEntityManager();
                try {
                    final EntityTransaction transaction = entityManager.getTransaction();
                    boolean iOwnTransaction = !transaction.isActive();
                    if (iOwnTransaction) {
                        rollbackFlag.set(false); //this is a new call
                        transaction.begin();
                    }
                    Object returnValue = null;
                    try {
                        returnValue = proceed.invoke(self, args);
                        if (iOwnTransaction) {
                            if (rollbackFlag.get()) {
                                logger.info("Rolling back transaction, as flag has been set");
                                transaction.rollback();
                            } else
                                transaction.commit();
                        }
                    } catch (InvocationTargetException e) {

                        if (iOwnTransaction) {
                            logger.info("Rolled back transaction due to exception", e);
                            transaction.rollback();
                        } else {
                            logger.info("Setting rollback-only flag due to exception", e);
                            rollbackFlag.set(true);
                        }
                        throw e;
                    }
                    return returnValue;
                } finally {
                    if (entityManager.isOpen()) {
                        entityManager.close();
                        entityManagerThreadLocal.remove();
                    }
                }


            }
        };
        final T instance;
        try {
            instance = (T) c.newInstance();
            ((ProxyObject) instance).setHandler(mi);
            return instance;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);

        }

    }

}
