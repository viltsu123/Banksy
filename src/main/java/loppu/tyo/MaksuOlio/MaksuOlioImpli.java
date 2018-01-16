package loppu.tyo.MaksuOlio;

public class MaksuOlioImpli implements MaksuFace {
	
	private String maksunsaaja;
	private int hinta;
	private String pvm;
	private String kortti_id;
	private String viesti;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMaksunsaaja() {
		return maksunsaaja;
	}
	public void setMaksunsaaja(String maksunsaaja) {
		this.maksunsaaja = maksunsaaja;
	}
	public int getHinta() {
		return hinta;
	}
	public void setHinta(int hinta) {
		this.hinta = hinta;
	}
	public String getPvm() {
		return pvm;
	}
	public void setPvm(String pvm) {
		this.pvm = pvm;
	}
	public String getKortti_id() {
		return kortti_id;
	}
	public void setKortti_id(String kortti_id) {
		this.kortti_id = kortti_id;
	}
	public String getViesti() {
		return viesti;
	}
	public void setViesti(String viesti) {
		this.viesti = viesti;
	}

}
