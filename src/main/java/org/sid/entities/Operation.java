package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Operation implements Serializable {
@Id
@Column(name = "opid")
private double idActivites ;
@Column(length = 1024)
private String strucResp ;
@Column(length = 1024)
private String libAct ;
@Column(length = 1024)
private String capacite ;
private double pkDebut ;
private double pkFin ;
private double ligne;
public double getLigne() {
	return ligne;
}
public void setLigne(double ligne) {
	this.ligne = ligne;
}
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "dd/MM/yyyy")
private Date dateDebut ;
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "dd/MM/yyyy")
private Date dateFin ;
/*@OneToOne(mappedBy = "operation")
private TrainsTravaux trainsTravaux;
@OneToOne(mappedBy = "operation")
private RPTX rptx ;*/
public Operation(double idActivite, String strucResp, String libAct, String capacite, double pkDebut, double pkFin,
		Date dateDebut, Date dateFin,double ligne) {
	super();
	this.idActivites = idActivite;
	this.strucResp = strucResp;
	this.libAct = libAct;
	this.capacite = capacite;
	this.pkDebut = pkDebut;
	this.pkFin = pkFin;
	this.dateDebut = dateDebut;
	this.dateFin = dateFin;
	this.ligne=ligne;
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
public String getCapacite() {
	return capacite;
}
public void setCapacite(String capacite) {
	this.capacite = capacite;
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
public Operation() {
	super();
	// TODO Auto-generated constructor stub
}
/*public TrainsTravaux getTrainsTravaux() {
	return trainsTravaux;
}
public void setTrainsTravaux(TrainsTravaux trainsTravaux) {
	this.trainsTravaux = trainsTravaux;
}
public RPTX getRptx() {
	return rptx;
}
public void setRptx(RPTX rptx) {
	this.rptx = rptx;
} */


}