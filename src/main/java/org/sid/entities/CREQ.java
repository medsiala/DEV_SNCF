package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class CREQ implements Serializable {
@Id 
private double idActivites ;
private String conducteur ;
public double getIdActivites() {
	return idActivites;
}
public void setIdActivites(double idActivites) {
	this.idActivites = idActivites;
}
public String getConducteur() {
	return conducteur;
}
public void setConducteur(String conducteur) {
	this.conducteur = conducteur;
}
public CREQ(double idActivites, String conducteur) {
	super();
	this.idActivites = idActivites;
	this.conducteur = conducteur;
}
public CREQ() {
	super();
	// TODO Auto-generated constructor stub
}


}