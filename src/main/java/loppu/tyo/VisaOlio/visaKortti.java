package loppu.tyo.VisaOlio;

import javax.validation.constraints.Size;

import loppu.tyo.Validaattorit.AlkaaIsollaKirjaimella;


public class visaKortti implements Kortti {
	
	@Size(min=1, max=50)
	@AlkaaIsollaKirjaimella
	private String etunimi;
	
	@Size(min=1, max=50)
	@AlkaaIsollaKirjaimella
	private String sukunimi;
	
	private int saldo;
	
	private String kortti_id;
	
	private int id;
	
	
	public String getEtunimi() {
		return etunimi;
	}
	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}
	public String getSukunimi() {
		return sukunimi;
	}
	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public String getKortti_id() {
		return kortti_id;
	}
	public void setKortti_id(String korttinumero) {
		this.kortti_id = korttinumero;
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	
	
}
