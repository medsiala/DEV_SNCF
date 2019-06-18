package org.sid.dao;

import org.sid.entities.CREQ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CREQRepository extends JpaRepository<CREQ, Double> {

}
