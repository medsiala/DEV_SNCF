package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "emplacement",discriminatorType=DiscriminatorType.STRING,length=4)

public abstract class Zep implements Serializable  {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
	
	private String zep ;
	
	private double pkdebut ;
	
	private double pkfin ;
	
	private String poste ;
	
	private String numPoste ;
	
	private String voieA ;
	
	private String voieB ;
	
	private String voieC ;
	
	private String voieD ;
	
	private String voieE ;
	
	private String voieF ;
	
	private String voieG ;
	
	private double ligneA ;
	
	private double ligneB ;
	
	private double ligneC ;
	
	private String secteur ;
	
	private String ttxAut ;
	
	private String groupZep;
	@Column(name="emplacement",nullable=false,updatable=false,insertable=false)
	private String emplacement ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public String getNumPoste() {
		return numPoste;
	}

	public void setNumPoste(String numPoste) {
		this.numPoste = numPoste;
	}

	public String getVoieA() {
		return voieA;
	}

	public void setVoieA(String voieA) {
		this.voieA = voieA;
	}

	public String getVoieB() {
		return voieB;
	}

	public void setVoieB(String voieB) {
		this.voieB = voieB;
	}

	public String getVoieC() {
		return voieC;
	}

	public void setVoieC(String voieC) {
		this.voieC = voieC;
	}

	public String getVoieD() {
		return voieD;
	}

	public void setVoieD(String voieD) {
		this.voieD = voieD;
	}

	public String getVoieE() {
		return voieE;
	}

	public void setVoieE(String voieE) {
		this.voieE = voieE;
	}

	public String getVoieF() {
		return voieF;
	}

	public void setVoieF(String voieF) {
		this.voieF = voieF;
	}

	public String getVoieG() {
		return voieG;
	}

	public void setVoieG(String voieG) {
		this.voieG = voieG;
	}

	public double getLigneA() {
		return ligneA;
	}

	public void setLigneA(double ligneA) {
		this.ligneA = ligneA;
	}

	public double getLigneB() {
		return ligneB;
	}

	public void setLigneB(double ligneB) {
		this.ligneB = ligneB;
	}

	public double getLigneC() {
		return ligneC;
	}

	public void setLigneC(double ligneC) {
		this.ligneC = ligneC;
	}

	public String getSecteur() {
		return secteur;
	}

	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}

	public String getTtxAut() {
		return ttxAut;
	}

	public void setTtxAut(String ttxAut) {
		this.ttxAut = ttxAut;
	}

	public String getGroupZep() {
		return groupZep;
	}

	public void setGroupZep(String groupZep) {
		this.groupZep = groupZep;
	}

	public Zep(int id, String zep, double pkdebut, double pkfin, String poste, String numPoste, String voieA,
			String voieB, String voieC, String voieD, String voieE, String voieF, String voieG, double ligneA,
			double ligneB, double ligneC, String secteur, String ttxAut, String groupZep) {
		super();
		this.id = id;
		this.zep = zep;
		this.pkdebut = pkdebut;
		this.pkfin = pkfin;
		this.poste = poste;
		this.numPoste = numPoste;
		this.voieA = voieA;
		this.voieB = voieB;
		this.voieC = voieC;
		this.voieD = voieD;
		this.voieE = voieE;
		this.voieF = voieF;
		this.voieG = voieG;
		this.ligneA = ligneA;
		this.ligneB = ligneB;
		this.ligneC = ligneC;
		this.secteur = secteur;
		this.ttxAut = ttxAut;
		this.groupZep = groupZep;
	}

	public Zep() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Zep [id=" + id + ", zep=" + zep + ", pkdebut=" + pkdebut + ", pkfin=" + pkfin + ", poste=" + poste
				+ ", numPoste=" + numPoste + ", voieA=" + voieA + ", voieB=" + voieB + ", voieC=" + voieC + ", voieD="
				+ voieD + ", voieE=" + voieE + ", voieF=" + voieF + ", voieG=" + voieG + ", ligneA=" + ligneA
				+ ", ligneB=" + ligneB + ", ligneC=" + ligneC + ", secteur=" + secteur + ", ttxAut=" + ttxAut
				+ ", groupZep=" + groupZep + "]";
	}

	public String getEmplacement() {
		return emplacement;
	}

	
	
	
}