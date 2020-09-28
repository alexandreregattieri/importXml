package br.com.cesan.importacao.sgb.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.cesan.importacao.common.model.Conexao;
import br.com.cesan.importacao.sgb.model.to.BeneficiarioSGBTO;

public class ValidaBeneficiarioDAO {

	public Long getPlano(String data, String mat) throws SQLException {
		Long plano = null;
		Connection con = null;
		StringBuilder sql = new StringBuilder()
		.append(" SELECT ");
		try {
			con = new Conexao().getConexao();
			PreparedStatement stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				plano = rs.getLong(1);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return plano;
	}
	
	public String getNumtiu(Long plano, String mat) throws SQLException {
		String numtiu = null;
		Connection con = null;
		StringBuilder sql = new StringBuilder()
		.append(" SELECT ");
		try {
			con = new Conexao().getConexao();
			PreparedStatement stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				numtiu = rs.getString(1);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return numtiu;
	}
	
	public String getDepend(Long plano, String mat, String numtiu) throws SQLException {
		String coddpd = null;
		Connection con = null;
		StringBuilder sql = new StringBuilder()
		.append(" SELECT ");
		try {
			con = new Conexao().getConexao();
			PreparedStatement stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				coddpd = rs.getString(1);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return coddpd;
	}
	
	public BeneficiarioSGBTO getBenefSGB(Long plano, String numtiu, String coddpd, String data) throws SQLException {
		BeneficiarioSGBTO benef = new BeneficiarioSGBTO();
		Connection con = null;
		StringBuilder sql = new StringBuilder()
		.append(" SELECT ");
		try {
			con = new Conexao().getConexao();
			PreparedStatement stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				benef.setSexo(rs.getString(1));
				benef.setIdade(rs.getLong(2));
				if (plano == 1) {
					benef.setParticipacao(rs.getDouble(3));
				} else {
					benef.setParticipacao(0.0);
				}
				benef.setPlano(plano);
				benef.setNumtiu(numtiu);
				benef.setCoddpd(coddpd);
				if (coddpd.equals("00")) {
					benef.setIndtiptiu("T");
				} else {
					benef.setIndtiptiu("D");
				}
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return benef;
	}
	
}
