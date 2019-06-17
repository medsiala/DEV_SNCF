package org.sid.entities;



import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("SSUD")
public class ZepSUD extends Zep {

	public ZepSUD() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ZepSUD(int id, String zep, double pkdebut, double pkfin, String poste, String numPoste, String voieA,
			String voieB, String voieC, String voieD, String voieE, String voieF, String voieG, double ligneA,
			double ligneB, double ligneC, String secteur, String ttxAut, String groupZep) {
		super(id, zep, pkdebut, pkfin, poste, numPoste, voieA, voieB, voieC, voieD, voieE, voieF, voieG, ligneA, ligneB, ligneC,
				secteur, ttxAut, groupZep);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ZepSUD [getId()=" + getId() + ", getZep()=" + getZep() + ", getPkdebut()=" + getPkdebut()
				+ ", getPkfin()=" + getPkfin() + ", getPoste()=" + getPoste() + ", getNumPoste()=" + getNumPoste()
				+ ", getVoieA()=" + getVoieA() + ", getVoieB()=" + getVoieB() + ", getVoieC()=" + getVoieC()
				+ ", getVoieD()=" + getVoieD() + ", getVoieE()=" + getVoieE() + ", getVoieF()=" + getVoieF()
				+ ", getVoieG()=" + getVoieG() + ", getLigneA()=" + getLigneA() + ", getLigneB()=" + getLigneB()
				+ ", getLigneC()=" + getLigneC() + ", getSecteur()=" + getSecteur() + ", getTtxAut()=" + getTtxAut()
				+ ", getGroupZep()=" + getGroupZep() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

	
}