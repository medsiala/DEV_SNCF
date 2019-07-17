package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class OperationZep implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id ;
private double idActivites ;
@Column(length = 1024)
private String zep ;
private double pkdebut;
private double pkfin ;
private double minPk ;

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
public String getZep() {
	return zep;
}
public void setZep(String zep) {
	this.zep = zep;
}

public double getPkdebut() {
	return pkdebut;
}
public void setPkdebut(double pkdebut) {
	this.pkdebut = pkdebut;
}
public double getPkfin() {
	return pkfin;
}
public void setPkfin(double pkfin) {
	this.pkfin = pkfin;
}

public double getMinPk() {
	return minPk;
}
public void setMinPk(double minPk) {
	this.minPk = minPk;
}

public OperationZep(Long id, double idActivites, String zep, double pkdebut, double pkfin, double minPk) {
	super();
	this.id = id;
	this.idActivites = idActivites;
	this.zep = zep;
	this.pkdebut = pkdebut;
	this.pkfin = pkfin;
	this.minPk = minPk;
}
public OperationZep() {
	super();
	// TODO Auto-generated constructor stub
}

}