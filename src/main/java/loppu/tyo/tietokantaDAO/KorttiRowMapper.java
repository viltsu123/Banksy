package loppu.tyo.tietokantaDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import loppu.tyo.VisaOlio.Kortti;
import loppu.tyo.VisaOlio.visaKortti;

public class KorttiRowMapper implements RowMapper<Kortti>{

	public Kortti mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Kortti k = new visaKortti();
		k.setId(rs.getInt("id"));
		k.setEtunimi(rs.getString("etunimi"));
		k.setSukunimi(rs.getString("sukunimi"));
		k.setKortti_id(rs.getString("kortti_id"));
		k.setSaldo(rs.getInt("saldo"));
		
		return k;
	}

	
}
