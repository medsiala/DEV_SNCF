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
@Entity
public class Operation implements Serializable {
@Id
@Column(name = "opid")
private double idActivites ;
private String strucResp ;
private String libAct ;
private String capacite ;
private double pkDebut ;
private double pkFin ;
private Date dateDebut ;
private Date dateFin ;
/*@OneToOne(mappedBy = "operation")
private TrainsTravaux trainsTravaux;
@OneToOne(mappedBy = "operation")
private RPTX rptx ;*/
public Operation(double idActivite, String strucResp, String libAct, String capacite, double pkDebut, double pkFin,
		Date dateDebut, Date dateFin) {
	super();
	this.idActivites = idActivite;
	this.strucResp = strucResp;
	this.libAct = libAct;
	this.capacite = capacite;
	this.pkDebut = pkDebut;
	this.pkFin = pkFin;
	this.dateDebut = dateDebut;
	this.dateFin = dateFin;
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