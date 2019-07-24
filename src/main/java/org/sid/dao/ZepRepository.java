package org.sid.dao;

import java.util.Date;
import java.util.List;

import org.sid.entities.Zep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ZepRepository extends JpaRepository<Zep, Long> {
	@Transactional
	@Modifying
	@Query("DELETE FROM Zep z WHERE z.emplacement=:emplacement")
	void deleteImport(String emplacement);
	@Query("select zep,pkdebut,pkfin from Zep z WHERE (z.pkdebut<= ?1 AND z.pkfin>=?1 AND z.pkdebut<= ?2 AND z.pkfin>= ?2 AND z.ligneA= ?3)  ")
	public List<Object[]> findZEp(double pkdebut,double pkfin,double ligneA);
	
} 
