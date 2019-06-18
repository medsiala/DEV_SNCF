package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class OperationCat implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id ;
private double idActivites ;
private String sectCat ;
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
public String getSectCat() {
	return sectCat;
}
public void setSectCat(String sectCat) {
	this.sectCat = sectCat;
}
public OperationCat(Long id, double idActivites, String sectCat) {
	super();
	this.id = id;
	this.idActivites = idActivites;
	this.sectCat = sectCat;
}
public OperationCat() {
	super();
	// TODO Auto-generated constructor stub
}

}