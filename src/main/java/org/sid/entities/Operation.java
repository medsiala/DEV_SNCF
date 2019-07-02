package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Cacheable(false)
public class Operation implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id ;
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

@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "dd/MM/yyyy")
private Date dateDebut ;
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "dd/MM/yyyy")
private Date dateFin ;
@OneToOne(cascade=CascadeType.ALL)
private RPTX rptx ;
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
public double getLigne() {
	return ligne;
}
public void setLigne(double ligne) {
	this.ligne = ligne;
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
public RPTX getRptx() {
	return rptx;
}
public void setRptx(RPTX rptx) {
	this.rptx = rptx;
}
public Operation(Long id, double idActivites, String strucResp, String libAct, String capacite, double pkDebut,
		double pkFin, double ligne, Date dateDebut, Date dateFin, RPTX rptx) {
	super();
	this.id = id;
	this.idActivites = idActivites;
	this.strucResp = strucResp;
	this.libAct = libAct;
	this.capacite = capacite;
	this.pkDebut = pkDebut;
	this.pkFin = pkFin;
	this.ligne = ligne;
	this.dateDebut = dateDebut;
	this.dateFin = dateFin;
	this.rptx = rptx;
}
public Operation() {
	super();
	// TODO Auto-generated constructor stub
}













}