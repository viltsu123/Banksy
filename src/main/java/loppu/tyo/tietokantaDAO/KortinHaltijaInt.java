package loppu.tyo.tietokantaDAO;

import java.util.List;

import loppu.tyo.MaksuOlio.MaksuFace;
import loppu.tyo.VisaOlio.Kortti;
import loppu.tyo.VisaOlio.visaKortti;

public interface KortinHaltijaInt {
	
	public abstract List<Kortti> haeKaikkiKortilliset();
	
	public abstract void lisaa(visaKortti kortti);
	
	public abstract void poistaKannasta(String id);
	
	public abstract List<MaksuFace> haeKaikkiTapahtumat();
	
	public abstract Kortti haeIdperusteella(int id);
	
	public abstract Kortti nosto(String kortti_id, int otto);
	
	public abstract List<MaksuFace> haeTapahtuma(String kortti_id);
	
	public abstract Kortti pano(String kortti_id, int saldo);

}
