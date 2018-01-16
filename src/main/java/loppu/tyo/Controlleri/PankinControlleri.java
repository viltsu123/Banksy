package loppu.tyo.Controlleri;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import loppu.tyo.MaksuOlio.MaksuFace;
import loppu.tyo.MaksuOlio.MaksuOlioImpli;
import loppu.tyo.VisaOlio.Kortti;
import loppu.tyo.VisaOlio.visaKortti;
import loppu.tyo.tietokantaDAO.KortinHaltijaInt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/kortti")
public class PankinControlleri {

	@Inject
	private KortinHaltijaInt dao;

	public KortinHaltijaInt getDao() {
		return dao;
	}

	public void setDao(KortinHaltijaInt dao) {
		this.dao = dao;
	}
	// --------------------------------------------------------------------------------------------
	//-----------------------------OHJE PAINIKE----------------------------------------------------
	// --------------------------------------------------------------------------------------------
	
	@RequestMapping(value="ohje", method=RequestMethod.GET)
	public String lueOhje(){
		return "kort/ohje";
	}
	
	// --------------------------------------------------------------------------------------------
	//-----------------------------KOTI PAINIKE----------------------------------------------------
	// --------------------------------------------------------------------------------------------
	
	@RequestMapping(value = "koti", method = RequestMethod.GET)
	public String goHome() {
		return "kort/koti";
	}

	// ---------------------------------------------------------------------------------------------
	// ---------------------------ID-HAKU, PALAUTTAA KORTINHALTIJAN---------------------------------
	// ---------------------------------------------------------------------------------------------

	@RequestMapping(value = "id", method = RequestMethod.GET)
	public String naytaId(Model model) {
		Kortti kortti = new visaKortti();
		model.addAttribute("id", kortti);
		return "idhaku/haeid";
	}

	@RequestMapping(value = "id", method = RequestMethod.POST)
	public String ukkeliId(@ModelAttribute(value = "id") visaKortti kortti,
			Model model) {

		Kortti koko = dao.haeIdperusteella(kortti.getId());

		model.addAttribute("tyyppi", koko);
		return "idhaku/naytaId";
	}

	// ---------------------------------------------------------------------------------------------------
	// ---------------------------HAKEE TAPAHTUMAT KORTTINUMERON PERUSTEELLA------------------------------
	// ---------------------------------------------------------------------------------------------------

	@RequestMapping(value = "tapahtuma", method = RequestMethod.GET)
	public String teeFormi(Model model) {
		Kortti tapahtuma = new visaKortti();
		model.addAttribute("tapahtuma", tapahtuma);
		return "kort/tiedot";
	}
	
	@RequestMapping(value = "tapahtuma", method = RequestMethod.POST)
	public String tapaNakyma(
			@ModelAttribute(value = "tapahtuma") visaKortti maksu, Model model) {
		List<MaksuFace> tapahtuma = dao.haeTapahtuma(maksu.getKortti_id());
		model.addAttribute("tapahtumat", tapahtuma);
		return "rahaliikenne/Tapahtumat";
	}

	// -------------------------------------------------------------------------------------
	// -------------------------------OTTO KORTILTA-----------------------------------------
	// -------------------------------------------------------------------------------------
	@RequestMapping(value = "nosto", method = RequestMethod.GET)
	public String otaRahaa(Model model, @RequestParam(value="korttiId", required=false) int korttiId) {
		Kortti kortti = new visaKortti();
		model.addAttribute("otto", kortti);
		return "rahaliikenne/ottoForm";
	}

	@RequestMapping(value = "nosto", method = RequestMethod.POST)
	public String teeNosto(@ModelAttribute(value = "otto") visaKortti kortti, 
			Model model) {
		String nro = kortti.getKortti_id();
		int saldo = kortti.getSaldo();
		Kortti paivitys = dao.nosto(nro, saldo);
		model.addAttribute("uusisaldo", paivitys);
		return "rahaliikenne/ottoTulos";
	}
	// -------------------------------------------------------------------------------------
	// ------------------------------PANO KORTILLE------------------------------------------
	// -------------------------------------------------------------------------------------
	@RequestMapping(value="talletus", method=RequestMethod.GET)
	public String talletaTilille(Model model, @RequestParam(value="korttiIdp", required=false)int korttiIdp){
		Kortti dummie = new visaKortti();
		model.addAttribute("pano", dummie);
		return "rahaliikenne/panoForm";
	}
	@RequestMapping(value="talletus", method=RequestMethod.POST)
	public String suoritaTalletus(@ModelAttribute(value = "pano") visaKortti kortti, Model model){
		String nro = kortti.getKortti_id();
		int saldo = kortti.getSaldo();
		Kortti paivi = dao.pano(nro, saldo);
		model.addAttribute("uusisaldo", paivi);
		return "rahaliikenne/panoTulos";
	}
	
	
	// ------------------------------------------------------------------------
	// ------------------------NÄYTÄ TIETOKANTA KORTINHALTIJAT-----------------
	// ------------------------------------------------------------------------

	@RequestMapping(value = "hae", method = RequestMethod.GET)
	public String getAll(Model model) {
		List<Kortti> kortit = dao.haeKaikkiKortilliset();
		model.addAttribute("kortit", kortit);
		return "tietokanta/kannassa";
	}
	
	// ------------------------------------------------------------------------
	// ----------------------------NÄYTÄ TAPAHTUMAT----------------------------
	// ------------------------------------------------------------------------

	@RequestMapping(value = "haetapahtumat", method = RequestMethod.GET)
	public String getAllActions(Model model) {
		List<MaksuFace> tapahtumat = dao.haeKaikkiTapahtumat();
		model.addAttribute("tapahtumat", tapahtumat);
		return "kort/maksutapahtumat";
	}

	// ------------------------------------------------------------------------
	// -------------------------------LISÄÄ KANTAAN----------------------------
	// ------------------------------------------------------------------------
	
	@RequestMapping(value = "uusi", method = RequestMethod.GET)
	public String getCreateForm(Model model) {
		Kortti tyhjaKortti = new visaKortti();

		model.addAttribute("kortti", tyhjaKortti);
		return "tietokanta/lisaaKantaan";
	}

	@RequestMapping(value = "uusi", method = RequestMethod.POST)
	public String create(@ModelAttribute(value = "kortti") @Valid visaKortti kortti,
			BindingResult result) {
		if (result.hasErrors()) {
			return "tietokanta/lisaaKantaan";
		} else {
			dao.lisaa(kortti);
			return "tietokanta/lisattykantaan";
		}
	}
	
	// ---------------------------------------------------------------------------------------------
	// ----------------------------------POISTA KANNASTA KORTINHALTIJA------------------------------
	// ---------------------------------------------------------------------------------------------
	//toimii nyt korttinumeron perusteella mutta numero pitää itse syöttää...........
	@RequestMapping(value="poisto", method=RequestMethod.GET)
	public String poistoFormi(Model model, @RequestParam(value="korttiIdx", required=false)int korttiIdx){
		Kortti dummy = new visaKortti();
		model.addAttribute("dummy", dummy);
		return "tietokanta/poistaKannasta";
	}
	
	@RequestMapping(value="poisto", method=RequestMethod.POST)
	public String poistaKohde(@ModelAttribute(value="dummy") visaKortti kortti, Model model){
		String nro = kortti.getKortti_id();
		dao.poistaKannasta(nro);
		return "kort/koti";
	}
	
}
