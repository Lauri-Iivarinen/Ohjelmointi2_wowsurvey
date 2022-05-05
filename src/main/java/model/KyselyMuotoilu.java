package model;

import java.util.HashMap;
import java.util.Map;

public class KyselyMuotoilu {
	
	private double avgplayed;
	private Map favbossMap = new HashMap();
	private double avgmplus;
	private int playpvpyes;
	private int playpvpno;
	private int expachypeyes;
	private int expachypeno;
	private double progLfr;
	private double progN;
	private double progHc;
	private double progM;
	private Map removeclassMap = new HashMap();
	
	
	
	public KyselyMuotoilu() {
	}

	public KyselyMuotoilu(double avgplayed, Map favbossMap, double avgmplus, int playpvpyes, int playpvpno,
			int expachypeyes, int expachypeno, double avgprogressnumLfr, double avgprogressnumN, double avgProgressnumHc,
			double avgprogressnumM, Map removeclassMap) {
		super();
		this.avgplayed = avgplayed;
		this.favbossMap = favbossMap;
		this.avgmplus = avgmplus;
		this.playpvpyes = playpvpyes;
		this.playpvpno = playpvpno;
		this.expachypeyes = expachypeyes;
		this.expachypeno = expachypeno;
		this.progLfr = avgprogressnumLfr;
		this.progN = avgprogressnumN;
		this.progHc = avgProgressnumHc;
		this.progM = avgprogressnumM;
		this.removeclassMap = removeclassMap;
	}
	
	//Setters
	public void setAvgplayed(double avgplayed) {
		this.avgplayed = avgplayed;
	}
	public void setFavbossMap(Map favbossMap) {
		this.favbossMap = favbossMap;
	}
	public void setAvgmplus(double avgmplus) {
		this.avgmplus = avgmplus;
	}
	public void setPlaypvpyes(int playpvpyes) {
		this.playpvpyes = playpvpyes;
	}
	public void setPlaypvpno(int playpvpno) {
		this.playpvpno = playpvpno;
	}
	public void setExpachypeyes(int expachypeyes) {
		this.expachypeyes = expachypeyes;
	}
	public void setExpachypeno(int expachypeno) {
		this.expachypeno = expachypeno;
	}
	public void setAvgprogressnumLfr(int avgprogressnumLfr) {
		this.progLfr = avgprogressnumLfr;
	}
	public void setAvgprogressnumN(int avgprogressnumN) {
		this.progN = avgprogressnumN;
	}
	public void setAvgProgressnumHc(int avgProgressnumHc) {
		this.progHc = avgProgressnumHc;
	}
	public void setAvgprogressnumM(int avgprogressnumM) {
		this.progM = avgprogressnumM;
	}
	public void setRemoveclassMap(Map removeclassMap) {
		this.removeclassMap = removeclassMap;
	}
	
	
	//getters
	public double getAvgplayed() {
		return avgplayed;
	}
	public Map getFavbossMap() {
		return favbossMap;
	}
	public double getAvgmplus() {
		return avgmplus;
	}
	public int getPlaypvpyes() {
		return playpvpyes;
	}
	public int getPlaypvpno() {
		return playpvpno;
	}
	public int getExpachypeyes() {
		return expachypeyes;
	}
	public int getExpachypeno() {
		return expachypeno;
	}



	public double getProgLfr() {
		return progLfr;
	}

	public double getProgN() {
		return progN;
	}

	public double getProgHc() {
		return progHc;
	}

	public double getProgM() {
		return progM;
	}

	public Map getRemoveclassMap() {
		return removeclassMap;
	}

	@Override
	public String toString() {
		return "KyselyMuotoilu [avgplayed=" + avgplayed + ", favbossMap=" + favbossMap + ", avgmplus=" + avgmplus
				+ ", playpvpyes=" + playpvpyes + ", playpvpno=" + playpvpno + ", expachypeyes=" + expachypeyes
				+ ", expachypeno=" + expachypeno + ", progLfr=" + progLfr + ", progN=" + progN + ", progHc=" + progHc
				+ ", progM=" + progM + ", removeclassMap=" + removeclassMap + "]";
	}
	
	//TOSTRING
	


}
