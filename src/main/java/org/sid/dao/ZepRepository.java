package org.sid.dao;

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
} 
