package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class TrainsTravaux implements Serializable {
@Id 
private double idActivites ;
private String ttx ;
public double getIdActivites() {
	return idActivites;
}
public void setIdActivites(double idActivites) {
	this.idActivites = idActivites;
}
public String getTtx() {
	return ttx;
}
public void setTtx(String ttx) {
	this.ttx = ttx;
}
public TrainsTravaux(double idActivites, String ttx) {
	super();
	this.idActivites = idActivites;
	this.ttx = ttx;
}
public TrainsTravaux() {
	super();
	// TODO Auto-generated constructor stub
}
}