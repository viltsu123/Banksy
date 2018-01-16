package loppu.tyo.VisaOlio;

public interface Kortti {

	public abstract String getEtunimi();
	
	public abstract void setEtunimi(String enimi);
	
	public abstract String getSukunimi();
	
	public abstract void setSukunimi(String snimi);
	
	public abstract int getSaldo();
	
	public abstract void setSaldo(int saldo);
	
	public abstract void setId(int id);
	
	public abstract int getId();
	
	public abstract void setKortti_id(String knum);//näyttö vaiheessa kannasta palaa int
	
	public abstract String getKortti_id();//luonti vaiheessa korttinumero on String
	
}
