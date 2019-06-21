package org.sid.dao;

import java.util.List;

import org.sid.entities.Catenaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CatenaireRepository extends JpaRepository<Catenaire, Long> {
	@Query("select CSecteurs from Catenaire c WHERE ((c.CPkDebut<= ?1 AND CPkFin>=?1 AND c.CPkDebut<= ?2 AND CPkFin>= ?2) OR (c.CPkDebut<= ?1 AND CPkFin>=?1) OR (c.CPkDebut<= ?2 AND CPkFin>= ?2))")
	public List<Object[]> findCat(double pkdebut,double pkfin);
}
