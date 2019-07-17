package org.sid.dao;


import java.util.List;

import org.sid.entities.OperationZep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OperaZepRepository extends JpaRepository<OperationZep, Long> {
@Query(value="select distinct id_activites,id,min_pk,pkdebut,pkfin,zep from operation_zep o where (id_activites,id) IN (select id_activites,min(id) from operation_zep group by  id_activites )",nativeQuery = true)
public List<OperationZep> selectZep();
}
