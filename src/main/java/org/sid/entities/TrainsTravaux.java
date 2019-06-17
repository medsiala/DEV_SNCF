package org.sid.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
@Entity
public class TrainsTravaux implements Serializable {
@Id 
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id ;
private String ttx ;
private String conducteur ;
@OneToOne
@JoinColumn(name = "idActivite",referencedColumnName = "opid")
private Operation operation ;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Long getIdActivites() {
	return id;
}
public void setIdActivites(Long idActivites) {
	this.id = idActivites;
}
public String getTtx() {
	return ttx;
}
public void setTtx(String ttx) {
	this.ttx = ttx;
}
public String getConducteur() {
	return conducteur;
}
public void setConducteur(String conducteur) {
	this.conducteur = conducteur;
}
public Operation getOperation() {
	return operation;
}
public void setOperation(Operation operation) {
	this.operation = operation;
}
public TrainsTravaux(String ttx, String conducteur, Operation operation) {
	super();
	this.ttx = ttx;
	this.conducteur = conducteur;
	this.operation = operation;
}
public TrainsTravaux() {
	super();
	// TODO Auto-generated constructor stub
}

}