package org.sid.dao;

import java.util.List;

import org.sid.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends JpaRepository<Operation,Long> {
	@Query("select o from Operation o where (o.capacite='VOIE+CAT' OR o.capacite='CAT')")
	public List<Operation> findOperaCat();
	
	@Query(value = "select opid,lib_act,struc_resp,rptx,capacite,date_debut,date_fin ,pk_debut,pk_fin,ttx,conducteur from operation left outer join rptx " + 
			"	on operation.opid = rptx.id_activites" + 
			"	left outer join trains_travaux" + 
			"	on  operation.opid = trains_travaux.id_activites" + 
			"	left outer join creq" + 
			"	on  operation.opid = creq.id_activites" ,nativeQuery = true)
	public List<Object[]> AHT();

	
	
	
}
