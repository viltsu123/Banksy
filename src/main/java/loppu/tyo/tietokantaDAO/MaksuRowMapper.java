package loppu.tyo.tietokantaDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import loppu.tyo.MaksuOlio.MaksuFace;
import loppu.tyo.MaksuOlio.MaksuOlioImpli;

import org.springframework.jdbc.core.RowMapper;

public class MaksuRowMapper implements RowMapper<MaksuFace>{

public MaksuFace mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		MaksuFace m = new MaksuOlioImpli();
		
		m.setKortti_id(rs.getString("kortti_id"));
		m.setMaksunsaaja(rs.getString("maksunsaaja"));
		m.setPvm(rs.getString("pvm"));
		m.setHinta(rs.getInt("hinta"));
		m.setViesti(rs.getString("viesti"));
		
		return m;
	}
}
