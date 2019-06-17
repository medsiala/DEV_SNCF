package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class LaplacePlanDeCharge implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id ;
	private double idActivites ;
	private String strucResp ;
	private String libAct ;
	private String jourOuNuit ;
	private String capacite ;
	private double libLigne ;
	private String libelleVoie ;
	private double pkDebut ;
	private double pkFin ;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateDebut ;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateFin ;
	private String typeResou ;
	private String habilitation ;
	private String resouAffecte;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getIdActivites() {
		return idActivites;
	}
	public void setIdActivites(double idActivites) {
		this.idActivites = idActivites;
	}
	public String getStrucResp() {
		return strucResp;
	}
	public void setStrucResp(String strucResp) {
		this.strucResp = strucResp;
	}
	public String getLibAct() {
		return libAct;
	}
	public void setLibAct(String libAct) {
		this.libAct = libAct;
	}
	public String getJourOuNuit() {
		return jourOuNuit;
	}
	public void setJourOuNuit(String jourOuNuit) {
		this.jourOuNuit = jourOuNuit;
	}
	public String getCapacite() {
		return capacite;
	}
	public void setCapacite(String capacite) {
		this.capacite = capacite;
	}
	public String getLibelleVoie() {
		return libelleVoie;
	}
	public void setLibelleVoie(String libelleVoie) {
		this.libelleVoie = libelleVoie;
	}
	public double getPkDebut() {
		return pkDebut;
	}
	public void setPkDebut(double pkDebut) {
		this.pkDebut = pkDebut;
	}
	public double getPkFin() {
		return pkFin;
	}
	public void setPkFin(double pkFin) {
		this.pkFin = pkFin;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getTypeResou() {
		return typeResou;
	}
	public void setTypeResou(String typeResou) {
		this.typeResou = typeResou;
	}
	public String getHabilitation() {
		return habilitation;
	}
	public void setHabilitation(String habilitation) {
		this.habilitation = habilitation;
	}
	public String getResouAffecte() {
		return resouAffecte;
	}
	public void setResouAffecte(String resouAffecte) {
		this.resouAffecte = resouAffecte;
	}
	
	public double getLibLigne() {
		return libLigne;
	}
	public void setLibLigne(double libLigne) {
		this.libLigne = libLigne;
	}
	public LaplacePlanDeCharge(Long id, double idActivites, String strucResp, String libAct, String jourOuNuit,
			String capacite, double libLigne, String libelleVoie, double pkDebut, double pkFin, Date dateDebut,
			Date dateFin, String typeResou, String habilitation, String resouAffecte) {
		super();
		this.id = id;
		this.idActivites = idActivites;
		this.strucResp = strucResp;
		this.libAct = libAct;
		this.jourOuNuit = jourOuNuit;
		this.capacite = capacite;
		this.libLigne = libLigne;
		this.libelleVoie = libelleVoie;
		this.pkDebut = pkDebut;
		this.pkFin = pkFin;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.typeResou = typeResou;
		this.habilitation = habilitation;
		this.resouAffecte = resouAffecte;
	}
	public LaplacePlanDeCharge() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LaplacePlanDeCharge [id=" + id + ", idActivites=" + idActivites + ", strucResp=" + strucResp
				+ ", libAct=" + libAct + ", jourOuNuit=" + jourOuNuit + ", capacite=" + capacite + ", libLigne="
				+ libLigne + ", libelleVoie=" + libelleVoie + ", pkDebut=" + pkDebut + ", pkFin=" + pkFin
				+ ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", typeResou=" + typeResou + ", habilitation="
				+ habilitation + ", resouAffecte=" + resouAffecte + "]";
	}
	
	
	
}
