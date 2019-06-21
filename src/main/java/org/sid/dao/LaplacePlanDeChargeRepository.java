package org.sid.dao;
import java.util.Date;
import java.util.List;
import org.sid.entities.LaplacePlanDeCharge;
import org.sid.entities.RPTX;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface LaplacePlanDeChargeRepository extends JpaRepository<LaplacePlanDeCharge, Long> {
@Query("select DISTINCT idActivites,strucResp,libAct,capacite,pkDebut,pkFin,dateDebut,dateFin,libLigne "
		+ "FROM LaplacePlanDeCharge l "
		+ "WHERE l.dateDebut <= ?1 AND l.dateFin >= ?1 "
		+ "AND jourOuNuit='N' AND (l.strucResp='SECT DPX VOIE Cheval-Blanc'"
		+ "OR l.strucResp='SECT DPX VOIE Roquemaure' OR l.strucResp='SECT ST Cheval-Blanc' OR l.strucResp='SECT ST Roquemaure'"
		+ "OR l.strucResp='SECT CATENAIRE Provence' OR (l.strucResp='UP UO Travaux INFRAPOLE LGV Sud Est Européen'AND l.pkDebut>='24.1' AND l.pkFin<='28.7') OR (l.strucResp='SECT SM Rhône-Provence' AND l.pkDebut>='555.150' AND l.pkFin<='709.951') "
		+ "OR (l.libAct='OCVIA '))")
public List<Object[]> findLAplaceChargesByidActivites(Date date);
@Query("select DISTINCT idActivites,resouAffecte FROM  LaplacePlanDeCharge l "
		+ "WHERE (l.dateDebut <= ?1 AND l.dateFin >= ?1) AND (l.habilitation='C1 - TES C - RPTX/CCH sans mobile' OR l.habilitation='C3 - TES C - RPTX/CCH avec un  TTX' OR l.habilitation='C3 - TES C - RPTX/CCH avec un  TTX' OR l.habilitation='C4 - TES C - RPTX/CCH avec plusieurs TTX'OR l.habilitation='C4 - TES C - RPTX/CCH avec plusieurs TTX')"
		+ "AND jourOuNuit='N' AND (l.strucResp='SECT DPX VOIE Cheval-Blanc'"
				+ "OR l.strucResp='SECT DPX VOIE Roquemaure' OR l.strucResp='SECT ST Cheval-Blanc' OR l.strucResp='SECT ST Roquemaure'"
				+ "OR l.strucResp='SECT CATENAIRE Provence' OR (l.strucResp='SECT SM Rhône-Provence' AND l.pkDebut>='555.150' AND l.pkFin<='709.951') "
				+ "OR (l.strucResp='INFRAPOLE LGV Sud Est Européen' AND l.pkDebut>='24.1' AND l.pkFin<='28.7'))")
public List<Object[]> findLAplaceChargesByRPTX(Date date);
@Query("select DISTINCT idActivites,resouAffecte FROM  LaplacePlanDeCharge l "
		+ "WHERE (l.dateDebut <= ?1 AND l.dateFin >= ?1) AND (l.habilitation='AX - TSAE - Agent d''accompagnement TTx' OR l.habilitation='CE - Conducteur')"
		+ "AND jourOuNuit='N' AND (l.strucResp='SECT DPX VOIE Cheval-Blanc'"
				+ "OR l.strucResp='SECT DPX VOIE Roquemaure' OR l.strucResp='SECT ST Cheval-Blanc' OR l.strucResp='SECT ST Roquemaure'"
				+ "OR l.strucResp='SECT CATENAIRE Provence' OR (l.strucResp='SECT SM Rhône-Provence' AND l.pkDebut>='555.150' AND l.pkFin<='709.951') "
				+ "OR (l.strucResp='INFRAPOLE LGV Sud Est Européen' AND l.pkDebut>='24.1' AND l.pkFin<='28.7'))")
public List<Object[]> findLAplaceChargesByCREQ(Date date);
@Query("select DISTINCT idActivites,resouAffecte FROM  LaplacePlanDeCharge l "
		+ "WHERE (l.dateDebut <= ?1 AND l.dateFin >= ?1) AND (l.typeResou='Engin')"
		+ "AND jourOuNuit='N' AND (l.strucResp='SECT DPX VOIE Cheval-Blanc'"
				+ "OR l.strucResp='SECT DPX VOIE Roquemaure' OR l.strucResp='SECT ST Cheval-Blanc' OR l.strucResp='SECT ST Roquemaure'"
				+ "OR l.strucResp='SECT CATENAIRE Provence' OR (l.strucResp='SECT SM Rhône-Provence' AND l.pkDebut>='555.150' AND l.pkFin<='709.951') "
				+ "OR (l.strucResp='INFRAPOLE LGV Sud Est Européen' AND l.pkDebut>='24.1' AND l.pkFin<='28.7'))")
public List<Object[]> findLAplaceChargesByTTX(Date date);
}
