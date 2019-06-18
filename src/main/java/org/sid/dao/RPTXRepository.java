package org.sid.dao;

import org.sid.entities.RPTX;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.binding.QuerydslPredicate;

public interface RPTXRepository extends JpaRepository<RPTX, Double> {

}
