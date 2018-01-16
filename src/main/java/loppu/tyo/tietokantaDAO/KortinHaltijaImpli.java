package loppu.tyo.tietokantaDAO;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import loppu.tyo.MaksuOlio.MaksuFace;
import loppu.tyo.VisaOlio.Kortti;
import loppu.tyo.VisaOlio.KorttiNumeroGen;
import loppu.tyo.VisaOlio.visaKortti;
import loppu.tyo.tietokantaDAO.KortinHaltijaInt;
import loppu.tyo.tietokantaDAO.KorttiRowMapper;;

@Repository
public class KortinHaltijaImpli implements KortinHaltijaInt{
	
		@Inject JdbcTemplate jdbcTemplate;
		
		public JdbcTemplate getJdbcTemplate() {
			return jdbcTemplate;
		}
		
		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}
		//-------------------------------------------------------------------------------------
		//--------------------HAETAAN KAIKKI KORTILLISET KANNASTA:-----------------------------
		//-------------------------------------------------------------------------------------
		public List<Kortti> haeKaikkiKortilliset() {

			String sql = "select id, etunimi, sukunimi, kortti_id, saldo from kortinhaltijat";
			RowMapper<Kortti> mapper = new KorttiRowMapper();
			List<Kortti> haltijat = jdbcTemplate.query(sql, mapper);

			return haltijat;
		}
		//-------------------------------------------------------------------------------------
		//-----------------------------ID HAKU KANNASTA----------------------------------------
		//-------------------------------------------------------------------------------------
		
		public Kortti haeIdperusteella(int id){
			
			String sql = "select id, etunimi, sukunimi, kortti_id, saldo from kortinhaltijat where id = ?";
			Object[] parametrit = new Object[] { id };
			RowMapper<Kortti> mapper = new KorttiRowMapper();

			Kortti h = null;
			try {
				h = jdbcTemplate.queryForObject(sql, parametrit, mapper);
			} catch (IncorrectResultSizeDataAccessException e) {
				System.out.println("Henkilöä ei löydy! " + e);
			}
			return h;
		}
		//-------------------------------------------------------------------------------------
		//---------------------------------ID HAKU MAKSUTAPAHTUMISTA---------------------------
		//--PALAUTTAA KORTTI_ID PERUSTEELLA KAIKKI TAPAHTUMAT----------------------------------
		
		public List<MaksuFace> haeTapahtuma(String kortti_id){
			String sql = "select id, kortti_id, maksunsaaja, pvm, hinta, viesti from maksutapahtumat where kortti_id = ?";
			Object [] param = new Object [] { kortti_id };
			RowMapper<MaksuFace> mapper = new MaksuRowMapper();
			
			List<MaksuFace> haltijat =jdbcTemplate.query(sql, param, mapper);
			return haltijat;
		}
		//-------------------------------------------------------------------------------------
		//----------------------LISÄÄ KANTAAN KORTINHALITJA------------------------------------
		//-------------------------------------------------------------------------------------
		public void lisaa(visaKortti h){
			final String sql = "insert into kortinhaltijat(id, etunimi, sukunimi, kortti_id, saldo) values (?,?,?,?,?)";
			KorttiNumeroGen numero = new KorttiNumeroGen();
			String kortti = numero.teeNumero();
			int id = haeKaikkiKortilliset().size() + 1;
			
			//käyttäjä antaa vain nimensä jonka jälkeen kone antaa korttinumeron. Saldo on kaikilla alussa 0.
			final String etunimi = h.getEtunimi();
			final String sukunimi = h.getSukunimi();
			final String kortti_id = kortti;
			final int saldo = 0;
			
			Object[] parametrit = new Object[] {id, etunimi, sukunimi, kortti_id, saldo};

		    jdbcTemplate.update(sql , parametrit);
			
		}
		//-------------------------------------------------------------------------------------
		//----------------------POISTA KANNASTA KORTINHALITJA----------------------------------
		//-------------------------------------------------------------------------------------
		
		public void poistaKannasta(String id){
			String sql = "delete from kortinhaltijat where kortti_id = " + id;
			jdbcTemplate.update(sql);
		}
		
		//-------------------------------------------------------------------------------------
		//-----------------NÄYTTÄÄ KAIKKI TAPAHTUMAT PANKISSA----------------------------------
		//-------------------------------------------------------------------------------------
		public List<MaksuFace> haeKaikkiTapahtumat(){
			String sql = "select kortti_id, maksunsaaja, pvm, hinta, viesti from maksutapahtumat";
			RowMapper<MaksuFace> mapper = new MaksuRowMapper();
			List<MaksuFace> haltijat = jdbcTemplate.query(sql, mapper);

			return haltijat;
		}
		//-------------------------------------------------------------------------------------
		//----------------------------OTTO TAPAHTUMA KORTILLE----------------------------------
		//-------------------------------------------------------------------------------------
		public Kortti nosto(String kortti_id, int otto){
			//haetaan henkilö jolta nostetaan rahaa:
			String sql = "select id, etunimi, sukunimi, kortti_id, saldo from kortinhaltijat where kortti_id = ?";
			
			Object[] parametrit = new Object[] { kortti_id };
			RowMapper<Kortti> mapper = new KorttiRowMapper();

			Kortti h = null;
			try {
				h = jdbcTemplate.queryForObject(sql, parametrit, mapper);
			} catch (IncorrectResultSizeDataAccessException e) {
				System.out.println("Henkilöä ei löydy! " + e);
			}
			
			int id = h.getId();//päivittämistoimenpidettä varten
			int saldo = h.getSaldo();//if lauseketta varten
			
			if(saldo < otto){
				System.out.println("EI TARPEEKSI RAHAA NOSTOA VARTEN!" + saldo);
				return h;
			}else{
			saldo = saldo - otto;
			}
			
			String sqlkaksi = "UPDATE kortinhaltijat SET saldo = " + saldo + " where id = " + id;
			jdbcTemplate.update(sqlkaksi);
			
			return h;
		}
		//-------------------------------------------------------------------------------------
		//----------------------------PANO TAPAHTUMA KORTILLE----------------------------------
		//-------------------------------------------------------------------------------------
		public Kortti pano(String kortti_id, int talletus){
			//haetaan henkilö jolta nostetaan rahaa:
			String sql = "select id, etunimi, sukunimi, kortti_id, saldo from kortinhaltijat where kortti_id = ?";
			
			Object[] parametrit = new Object[] { kortti_id };
			RowMapper<Kortti> mapper = new KorttiRowMapper();

			Kortti h = null;
			try {
				h = jdbcTemplate.queryForObject(sql, parametrit, mapper);
			} catch (IncorrectResultSizeDataAccessException e) {
				System.out.println("Henkilöä ei löydy! " + e);
			}
			
			int id = h.getId();//id taas päivitystä varten
			int saldo = h.getSaldo();//if lausetta varten
			
			if(talletus < 0){
				System.out.println("POSITIIVISIA NUMEROITA VAIN KIITOS!");
				return h;
			}else{
			saldo = saldo + talletus;
			}
			String sqlkaksi = "UPDATE kortinhaltijat SET saldo = "+ saldo + " where id = " + id;
			jdbcTemplate.update(sqlkaksi);
			
			return h;
		}
}
