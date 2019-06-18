package org.sid.dao;

import java.util.List;

import org.sid.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends JpaRepository<Operation,Long> {
	@Query("select o from Operation o where o.capacite='VOIE+CAT'")
	public List<Operation> findOperaCat();

	
	
	
}
