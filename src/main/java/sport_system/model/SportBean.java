package sport_system.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

// 本類別封裝單筆書籍資料
public class SportBean implements Serializable {
	private static final long serialVersionUID = 1L; ;
	private int  ID;
	private String  SPORTNAME;
	private String  ADDRESS;
	private String  PHONE;
	private double  LAT   ;
	private double  LNG		;
	private String  INDOOR	;
	private String  ITEAM	;
	private String  COST;
	private int  SCORE;
	private Blob  PICTURE;
	private String  blobFileName;
	private String  DETAIL;
	private Timestamp   STARTDATE;
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getSPORTNAME() {
		return SPORTNAME;
	}
	public void setSPORTNAME(String sPORTNAME) {
		SPORTNAME = sPORTNAME;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public String getPHONE() {
		return PHONE;
	}
	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}
	public double getLAT() {
		return LAT;
	}
	public void setLAT(double lAT) {
		LAT = lAT;
	}
	public double getLNG() {
		return LNG;
	}
	public void setLNG(double lNG) {
		LNG = lNG;
	}
	public String getINDOOR() {
		return INDOOR;
	}
	public void setINDOOR(String iNDOOR) {
		INDOOR = iNDOOR;
	}
	public String getITEAM() {
		return ITEAM;
	}
	public void setITEAM(String iTEAM) {
		ITEAM = iTEAM;
	}
	public String getCOST() {
		return COST;
	}
	public void setCOST(String cOST) {
		COST = cOST;
	}
	public int getSCORE() {
		return SCORE;
	}
	public void setSCORE(int sCORE) {
		SCORE = sCORE;
	}
	public Blob getPICTURE() {
		return PICTURE;
	}
	public void setPICTURE(Blob pICTURE) {
		PICTURE = pICTURE;
	}
	public String getBlobFileName() {
		return blobFileName;
	}
	public void setBlobFileName(String blobFileName) {
		this.blobFileName = blobFileName;
	}
	public String getDETAIL() {
		return DETAIL;
	}
	public void setDETAIL(String dETAIL) {
		DETAIL = dETAIL;
	}
	public Timestamp getSTARTDATE() {
		return STARTDATE;
	}
	public void setSTARTDATE(Timestamp sTARTDATE) {
		STARTDATE = sTARTDATE;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public SportBean() {
		super();
	}
	public SportBean(int iD) {
		super();
		ID = iD;
	}
	public SportBean(int iD, String sPORTNAME, String aDDRESS, String pHONE, double lAT, double lNG, String dETAIL) {
		super();
		ID = iD;
		SPORTNAME = sPORTNAME;
		ADDRESS = aDDRESS;
		PHONE = pHONE;
		LAT = lAT;
		LNG = lNG;
		DETAIL = dETAIL;
	}
	public SportBean(int iD, String sPORTNAME, String aDDRESS, String pHONE, double lAT, double lNG, String iNDOOR,
			String iTEAM, String cOST, int sCORE, Blob pICTURE, String blobFileName, String dETAIL,
			Timestamp sTARTDATE) {
		super();
		ID = iD;
		SPORTNAME = sPORTNAME;
		ADDRESS = aDDRESS;
		PHONE = pHONE;
		LAT = lAT;
		LNG = lNG;
		INDOOR = iNDOOR;
		ITEAM = iTEAM;
		COST = cOST;
		SCORE = sCORE;
		PICTURE = pICTURE;
		this.blobFileName = blobFileName;
		DETAIL = dETAIL;
		STARTDATE = sTARTDATE;
	}
	public SportBean(int iD, String sPORTNAME, String aDDRESS, String pHONE, double lAT, double lNG, String iNDOOR,
			String iTEAM, String cOST, int sCORE, Blob pICTURE, String blobFileName, String dETAIL) {
		super();
		ID = iD;
		SPORTNAME = sPORTNAME;
		ADDRESS = aDDRESS;
		PHONE = pHONE;
		LAT = lAT;
		LNG = lNG;
		INDOOR = iNDOOR;
		ITEAM = iTEAM;
		COST = cOST;
		SCORE = sCORE;
		PICTURE = pICTURE;
		this.blobFileName = blobFileName;
		DETAIL = dETAIL;
	}

}