package loppu.tyo.VisaOlio;

public class KorttiNumeroGen {

	public String teeNumero(){
		String kortti = "";
		
		for(int i=0;i < 8;i++){
			int ji = (int) (Math.random()*10);
			kortti +=String.valueOf(ji);
		}
		return kortti;
	}
}
