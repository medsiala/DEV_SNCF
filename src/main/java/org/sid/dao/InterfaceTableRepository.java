package org.sid.dao;


import java.util.Date;
import java.util.List;

import org.sid.entities.InterfaceTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InterfaceTableRepository extends JpaRepository<InterfaceTable, Long>{
	public List<InterfaceTable> findAllByOrderByIdTriAsc();
	@Query("select l from InterfaceTable l WHERE l.dateNuit= ?1  order by l.idTri ")
	public List<InterfaceTable> afficheAHT(Date date);
	@Query ("select distinct dateNuit from InterfaceTable l order by dateNuit")
	public List<Date>ListAht();
}

