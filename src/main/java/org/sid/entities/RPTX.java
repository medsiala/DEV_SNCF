package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
@Entity
public class RPTX implements Serializable {
	@Id 
	private double idActivites;
	private String rptx ;

	
	public String getRptx() {
		return rptx;
	}
	public void setRptx(String rptx) {
		this.rptx = rptx;
	}
	public double getIdActivites() {
		return idActivites;
	}
	public void setIdActivites(double idActivites) {
		this.idActivites = idActivites;
	}
	public RPTX(double idActivites, String rptx) {
		super();
		
		this.rptx = rptx;
		this.idActivites = idActivites;
	}
	public RPTX() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}