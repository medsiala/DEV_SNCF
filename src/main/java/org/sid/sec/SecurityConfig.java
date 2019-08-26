package org.sid.sec;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
protected void configure(AuthenticationManagerBuilder auth,DataSource dataSource) throws Exception {
	/*auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select cp as principal,password as credentials,true from users where cp=?")
		.authoritiesByUsernameQuery("select users_cp as principal,roles_role as role from users_roles where users_cp=?")
		.passwordEncoder(new MessageDigestPasswordEncoder("MD5"));*/
	auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles("ADMIN");
		
	
     }

@Override
	protected void configure(HttpSecurity http) throws Exception {
	http
    .csrf().disable()
    .authorizeRequests()
    .antMatchers("/index").hasRole("ADMIN")
    .antMatchers("/upload").hasRole("ADMIN")
    .antMatchers("/nouveauUtilisateur").hasRole("ADMIN")
    .antMatchers("/ExportExcel").hasRole("ADMIN")
   
    
    .and()
    .formLogin()
    .loginPage("/login")
    . defaultSuccessUrl("/index", true);	
	}

}
