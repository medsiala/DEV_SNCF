package org.sid.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity

public class Catenaire implements Serializable {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id ;
	private String CSecteurs ;
	private double CPkDebut ;
	private double CPkFin ;
	private String CVoie ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCSecteurs() {
		return CSecteurs;
	}
	public void setCSecteurs(String cSecteurs) {
		CSecteurs = cSecteurs;
	}
	public double getCPkDebut() {
		return CPkDebut;
	}
	public void setCPkDebut(double cPkDebut) {
		CPkDebut = cPkDebut;
	}
	public double getCPkFin() {
		return CPkFin;
	}
	public void setCPkFin(double cPkFin) {
		CPkFin = cPkFin;
	}
	public String getCVoie() {
		return CVoie;
	}
	public void setCVoie(String cVoie) {
		CVoie = cVoie;
	}

	public Catenaire(Long id, String cSecteurs, double cPkDebut, double cPkFin, String cVoie) {
		super();
		this.id = id;
		CSecteurs = cSecteurs;
		CPkDebut = cPkDebut;
		CPkFin = cPkFin;
		CVoie = cVoie;
	}
	
	public Catenaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Catenaire [id=" + id + ", CSecteurs=" + CSecteurs + ", CPkDebut=" + CPkDebut + ", CPkFin=" + CPkFin
				+ ", CVoie=" + CVoie + ", getId()=" + getId() + ", getCSecteurs()=" + getCSecteurs()
				+ ", getCPkDebut()=" + getCPkDebut() + ", getCPkFin()=" + getCPkFin() + ", getCVoie()=" + getCVoie()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

}
