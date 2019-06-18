package org.sid.entities;

import java.io.Serializable;

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
private String zep ;
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
public OperationZep() {
	super();
	// TODO Auto-generated constructor stub
}
public OperationZep(Long id, double idActivites, String zep) {
	super();
	this.id = id;
	this.idActivites = idActivites;
	this.zep = zep;
}

}