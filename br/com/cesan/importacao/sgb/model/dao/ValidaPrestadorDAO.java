package br.com.cesan.importacao.sgb.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.cesan.importacao.common.model.Conexao;
import br.com.cesan.importacao.sgb.model.to.CredenciadoSGBTO;
import br.com.cesan.importacao.sgb.model.to.ProfissionalSGBTO;

public class ValidaPrestadorDAO {
	
	public CredenciadoSGBTO getInstConsulta(String cpf, String tipoCons, String numeroCons, String ufCons) throws SQLException {
		CredenciadoSGBTO cred = new CredenciadoSGBTO();
		Connection con = null;
		StringBuilder sql = new StringBuilder()
		.append(" SELECT ");
		try {
			con = new Conexao().getConexao();
			PreparedStatement stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				cred.setNumcpfcgccri(rs.getString(1));
				cred.setIndcpfcgc(rs.getString(2));
				cred.setNomcri(rs.getString(3));
				cred.setTipoConselho(rs.getString(4));
				cred.setNumeroConselho(rs.getString(5));
				cred.setUfconselho(rs.getString(6));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return cred;
	}
	
	public ProfissionalSGBTO getProf(String tipoCons, String numeroCons, String ufCons) throws SQLException {
		ProfissionalSGBTO prof = new ProfissionalSGBTO();
		Connection con = null;
		StringBuilder sql = new StringBuilder()
		.append(" SELECT ");
		try {
			con = new Conexao().getConexao();
			PreparedStatement stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				prof.setTipoConselho(rs.getString(1));
				prof.setNumeroConselho(rs.getString(2));
				prof.setUfConselho(rs.getString(3));
				prof.setNome(rs.getString(4));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return prof;
	}

}
