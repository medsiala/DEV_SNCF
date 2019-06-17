package org.sid.dao;
import java.util.Date;
import java.util.List;
import org.sid.entities.LaplacePlanDeCharge;
import org.sid.entities.RPTX;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface LaplacePlanDeChargeRepository extends JpaRepository<LaplacePlanDeCharge, Long> {
@Query("select DISTINCT idActivites,strucResp,libAct,capacite,pkDebut,pkFin,dateDebut,dateFin FROM LaplacePlanDeCharge l WHERE l.dateDebut <= ?1 AND l.dateFin >= ?1 AND jourOuNuit='N' AND (l.strucResp='SECT DPX VOIE Cheval-Blanc'"
		+ "OR l.strucResp='SECT DPX VOIE Roquemaure' OR l.strucResp='SECT ST Cheval-Blanc' OR l.strucResp='SECT ST Roquemaure'"
		+ "OR l.strucResp='SECT CATENAIRE Provence' OR (l.strucResp='SECT SM Rhône-Provence' AND l.pkDebut>='555.150' AND l.pkFin<='709.951')) ")
public List<Object[]> findLAplaceChargesByidActivites(Date date);
@Query("select idActivites,resouAffecte FROM  LaplacePlanDeCharge l WHERE ((l.idActivites=Operation.idActivites) AND (l.dateDebut <= ?1 AND l.dateFin >= ?1) AND (l.habilitation='C1 - TES C - RPTX/CCH sans mobile' OR l.habilitation='C3 - TES C - RPTX/CCH avec un  TTX'))")
public List<Object[]> findLAplaceChargesByRPTX(Date date);

}
