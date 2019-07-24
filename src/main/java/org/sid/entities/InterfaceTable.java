package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class InterfaceTable implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id ;
	private Long idTri;
	private Long Nop ;
	@Column(length = 1024)
	private String zep ;
	private String voie ;
	private String trainEncDebut;
	private String hDebut;
	private String trainEncFin;
	private String hFin;
	private String rptx ;
	@Column(length = 1024)
	private String natureTravaux ;
	private String cch ;
	private double pkDebutZch ;
	private double pkFinZch ;
	@Column(length = 1024)
	private String bouclage ;
	@Column(length = 1024)
	private String natureTravauxAa ;
	@Column(length = 1024)
	private String aa;
	private double pkDebutAa ;
	private double pkFinAa ;
	private Long NopCat ;
	@Column(length = 1024)
	private String CSecteurs;
	private String trainEncDebutCat;
	private String hDebutCat;
	private String trainEncFinCat;
	private String hFinCAt;
	private String ttx ;
	@Column(length = 1024)
	private String degarage;
	@Column(length = 1024)
	private String garage ;
	@Column(length = 1024)
	private String creq ;
	@Column(length = 1024)
	private String consIs;
	@Column(length = 1024)
	private String ctx ;
	@Column(length = 1024)
	private String com ;
	private double ligne;
	@Column(length = 1024)
	private String strucResp ;
	@Column(length = 1024)
	private String zepProp;
	@Column(length = 1024)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date datFin ;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateNuit ;
	private int editId;
	private int controlZep ;
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNop() {
		return Nop;
	}
	public void setNop(Long nop) {
		Nop = nop;
	}
	public String getZep() {
		return zep;
	}
	public void setZep(String zep) {
		this.zep = zep;
	}
	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}
	public String getTrainEncDebut() {
		return trainEncDebut;
	}
	public void setTrainEncDebut(String trainEncDebut) {
		this.trainEncDebut = trainEncDebut;
	}
	public String gethDebut() {
		return hDebut;
	}
	public void sethDebut(String hDebut) {
		this.hDebut = hDebut;
	}
	public String getTrainEncFin() {
		return trainEncFin;
	}
	public void setTrainEncFin(String trainEncFin) {
		this.trainEncFin = trainEncFin;
	}
	public String gethFin() {
		return hFin;
	}
	public void sethFin(String hFin) {
		this.hFin = hFin;
	}
	public String getRptx() {
		return rptx;
	}
	public void setRptx(String rptx) {
		this.rptx = rptx;
	}
	public String getNatureTravaux() {
		return natureTravaux;
	}
	public void setNatureTravaux(String natureTravaux) {
		this.natureTravaux = natureTravaux;
	}
	public String getCch() {
		return cch;
	}
	public void setCch(String cch) {
		this.cch = cch;
	}
	public double getPkDebutZch() {
		return pkDebutZch;
	}
	public void setPkDebutZch(double pkDebutZch) {
		this.pkDebutZch = pkDebutZch;
	}
	public double getPkFinZch() {
		return pkFinZch;
	}
	public void setPkFinZch(double pkFinZch) {
		this.pkFinZch = pkFinZch;
	}
	public String getBouclage() {
		return bouclage;
	}
	public void setBouclage(String bouclage) {
		this.bouclage = bouclage;
	}
	public String getNatureTravauxAa() {
		return natureTravauxAa;
	}
	public void setNatureTravauxAa(String natureTravauxAa) {
		this.natureTravauxAa = natureTravauxAa;
	}
	public String getAa() {
		return aa;
	}
	public void setAa(String aa) {
		this.aa = aa;
	}
	public double getPkDebutAa() {
		return pkDebutAa;
	}
	public void setPkDebutAa(double pkDebutAa) {
		this.pkDebutAa = pkDebutAa;
	}
	public double getPkFinAa() {
		return pkFinAa;
	}
	public void setPkFinAa(double pkFinAa) {
		this.pkFinAa = pkFinAa;
	}
	public Long getNopCat() {
		return NopCat;
	}
	public void setNopCat(Long nopCat) {
		NopCat = nopCat;
	}
	public String getCSecteurs() {
		return CSecteurs;
	}
	public void setCSecteurs(String cSecteurs) {
		CSecteurs = cSecteurs;
	}
	public String getTrainEncDebutCat() {
		return trainEncDebutCat;
	}
	public void setTrainEncDebutCat(String trainEncDebutCat) {
		this.trainEncDebutCat = trainEncDebutCat;
	}
	public String gethDebutCat() {
		return hDebutCat;
	}
	public void sethDebutCat(String hDebutCat) {
		this.hDebutCat = hDebutCat;
	}
	public String getTrainEncFinCat() {
		return trainEncFinCat;
	}
	public void setTrainEncFinCat(String trainEncFinCat) {
		this.trainEncFinCat = trainEncFinCat;
	}
	public String gethFinCAt() {
		return hFinCAt;
	}
	public void sethFinCAt(String hFinCAt) {
		this.hFinCAt = hFinCAt;
	}
	public String getTtx() {
		return ttx;
	}
	public void setTtx(String ttx) {
		this.ttx = ttx;
	}
	public String getDegarage() {
		return degarage;
	}
	public void setDegarage(String degarage) {
		this.degarage = degarage;
	}
	public String getGarage() {
		return garage;
	}
	public void setGarage(String garage) {
		this.garage = garage;
	}
	public String getCreq() {
		return creq;
	}
	public void setCreq(String creq) {
		this.creq = creq;
	}
	public String getConsIs() {
		return consIs;
	}
	public void setConsIs(String consIs) {
		this.consIs = consIs;
	}
	public String getCtx() {
		return ctx;
	}
	public void setCtx(String ctx) {
		this.ctx = ctx;
	}
	public String getCom() {
		return com;
	}
	public void setCom(String com) {
		this.com = com;
	}
	public double getLigne() {
		return ligne;
	}
	public void setLigne(double ligne) {
		this.ligne = ligne;
	}
	public String getStrucResp() {
		return strucResp;
	}
	public void setStrucResp(String strucResp) {
		this.strucResp = strucResp;
	}
	public Long getIdTri() {
		return idTri;
	}
	public void setIdTri(Long idTri) {
		this.idTri = idTri;
	}
	
	public InterfaceTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getZepProp() {
		return zepProp;
	}
	public void setZepProp(String zepProp) {
		this.zepProp = zepProp;
	}
	
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDatFin() {
		return datFin;
	}
	public void setDatFin(Date datFin) {
		this.datFin = datFin;
	}
	public Date getDateNuit() {
		return dateNuit;
	}
	public void setDateNuit(Date dateNuit) {
		this.dateNuit = dateNuit;
	}
	
	public int getEditId() {
		return editId;
	}
	public void setEditId(int editId) {
		this.editId = editId;
	}
	public int getControlZep() {
		return controlZep;
	}
	public void setControlZep(int controlZep) {
		this.controlZep = controlZep;
	}
	public InterfaceTable(Long id, Long idTri, Long nop, String zep, String voie, String trainEncDebut, String hDebut,
			String trainEncFin, String hFin, String rptx, String natureTravaux, String cch, double pkDebutZch,
			double pkFinZch, String bouclage, String natureTravauxAa, String aa, double pkDebutAa, double pkFinAa,
			Long nopCat, String cSecteurs, String trainEncDebutCat, String hDebutCat, String trainEncFinCat,
			String hFinCAt, String ttx, String degarage, String garage, String creq, String consIs, String ctx,
			String com, double ligne, String strucResp, String zepProp, Date dateDebut, Date datFin, Date dateNuit,
			int editId, int controlZep) {
		super();
		this.id = id;
		this.idTri = idTri;
		Nop = nop;
		this.zep = zep;
		this.voie = voie;
		this.trainEncDebut = trainEncDebut;
		this.hDebut = hDebut;
		this.trainEncFin = trainEncFin;
		this.hFin = hFin;
		this.rptx = rptx;
		this.natureTravaux = natureTravaux;
		this.cch = cch;
		this.pkDebutZch = pkDebutZch;
		this.pkFinZch = pkFinZch;
		this.bouclage = bouclage;
		this.natureTravauxAa = natureTravauxAa;
		this.aa = aa;
		this.pkDebutAa = pkDebutAa;
		this.pkFinAa = pkFinAa;
		NopCat = nopCat;
		CSecteurs = cSecteurs;
		this.trainEncDebutCat = trainEncDebutCat;
		this.hDebutCat = hDebutCat;
		this.trainEncFinCat = trainEncFinCat;
		this.hFinCAt = hFinCAt;
		this.ttx = ttx;
		this.degarage = degarage;
		this.garage = garage;
		this.creq = creq;
		this.consIs = consIs;
		this.ctx = ctx;
		this.com = com;
		this.ligne = ligne;
		this.strucResp = strucResp;
		this.zepProp = zepProp;
		this.dateDebut = dateDebut;
		this.datFin = datFin;
		this.dateNuit = dateNuit;
		this.editId = editId;
		this.controlZep = controlZep;
	}
	
	
	

	
}
