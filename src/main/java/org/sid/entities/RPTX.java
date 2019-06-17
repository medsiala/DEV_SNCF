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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id ;
	private String rptx ;
	private double idActivites;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public RPTX(Long id, String rptx, double idActivites) {
		super();
		this.id = id;
		this.rptx = rptx;
		this.idActivites = idActivites;
	}
	public RPTX() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}