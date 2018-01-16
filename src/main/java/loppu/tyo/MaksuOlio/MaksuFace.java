package loppu.tyo.MaksuOlio;

public interface MaksuFace {

	public abstract String getMaksunsaaja();
	
	public abstract void setMaksunsaaja(String maksunsaaja);
	
	public abstract String getPvm();
	
	public abstract void setPvm(String pvm);
	
	public abstract int  getHinta();
	
	public abstract void setHinta(int hinta);
	
	public abstract String getKortti_id();
	
	public abstract void setKortti_id(String kortti_id);
	
	public abstract String getViesti();
	
	public abstract void setViesti(String viesti);
	
	public abstract int getId();
	
	public abstract void setId(int id);
}
