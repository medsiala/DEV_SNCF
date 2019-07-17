package org.sid.dao;

import java.util.Date;
import java.util.List;

import org.sid.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends JpaRepository<Operation,Long> {
	@Query("select o from Operation o where (o.capacite='VOIE+CAT' OR o.capacite='CAT')")
	public List<Operation> findOperaCat();
	
	@Query(value = "select lib_act,struc_resp,rptx,pk_debut,pk_fin,ttx,conducteur,zep,com,date_debut,date_fin from operation left outer join rptx " + 
			"	on operation.opid = rptx.id_activites" + 
			"	left outer join trains_travaux" + 
			"	on  operation.opid = trains_travaux.id_activites" + 
			"	left outer join creq" + 
			"	on  operation.opid = creq.id_activites" +
			"	left outer join operation_zep" +
			"	on operation.opid = operation_zep.id_activites"+
			"	WHERE operation.date_debut<= ?1 AND operation.date_fin>= ?1  ",nativeQuery = true)
	public List<Object[]> AHT(Date dateNuit);

	public List<Operation> findAllByOrderByLigneAsc();
	
	
	
}
