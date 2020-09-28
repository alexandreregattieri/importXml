package br.com.cesan.importacao.sgb.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.cesan.importacao.common.model.Conexao;

public class ValidaAtendimentoDAO {
	
	public Long getAtendConsulta(String numtiu, String coddpd, Long plano, String cid, String data, String cpfcgc) throws SQLException {
		Long ret = null;
		Connection con = null;
		StringBuilder sql = new StringBuilder()
		.append(" SELECT ");
		try {
			con = new Conexao().getConexao();
			PreparedStatement stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				ret = rs.getLong(1);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return ret;
	}
	
	public String getNumeroAutoriz(String data) throws SQLException {
		String aut = null;
		Connection con = null;
		StringBuilder sql = new StringBuilder()
		.append(" SELECT ");
		try {
			con = new Conexao().getConexao();
			PreparedStatement stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				aut = rs.getString(1);
			}
			rs.close();
			stmt.close();
			con.close();
			setAtualizaAutoriz(aut, data);
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return aut;
	}

	public void setAtualizaAutoriz (String aut, String data) throws SQLException {
		String sql = "UPDATE ";
		Connection con = null;
		try {
			con = new Conexao().getConexao();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, aut);
			stmt.setString(2, data.substring(0, 4));
			stmt.execute();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	public void setAtualizaGuia (Double valinr, Double valgls, Double valgro, Double valexr, Double valusu, Double valpln, Long fat) throws SQLException {
		String sql = "UPDATE ";
		Connection con = null;
		try {
			con = new Conexao().getConexao();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setDouble(1, valinr);
			stmt.setDouble(2, valgls);
			stmt.setDouble(3, valgro);
			stmt.setDouble(4, valexr);
			stmt.setDouble(5, valusu);
			stmt.setDouble(6, valpln);
			stmt.setLong(7, fat);
			stmt.execute();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	public Long getFatExisteAut (String numtiu, String coddpd, Long plano, String cpf, Long tab, Long benef) throws SQLException {
		Long fat = null;
		Connection con = null;
		StringBuilder sql = new StringBuilder()
		.append(" SELECT ");
		try {
			con = new Conexao().getConexao();
			PreparedStatement stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				fat = rs.getLong(1);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return fat;
	}
	
	public Long getIteExisteAut (String numtiu, String coddpd, Long plano, String cpf, Long tab, Long benef) throws SQLException {
		Long fat = null;
		Connection con = null;
		StringBuilder sql = new StringBuilder()
		.append(" SELECT ");
		try {
			con = new Conexao().getConexao();
			PreparedStatement stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				fat = rs.getLong(1);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return fat;
	}
	
	public Long getFatProcedJaRealiz (String numtiu, String coddpd, Long plano, String cpf, Long tab, Long benef, Double perc, String data) throws SQLException {
		Long ret = null;
		Connection con = null;
		StringBuilder sql = new StringBuilder()
		.append(" SELECT ");
		try {
			con = new Conexao().getConexao();
			PreparedStatement stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				ret = rs.getLong(1);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return ret;
	}
	
	public Long getIteProcedJaRealiz (Long fat, String cpf, Long tab, Long benef, Float perc, String data) throws SQLException {
		Long ret = null;
		Connection con = null;
		StringBuilder sql = new StringBuilder()
		.append(" SELECT ");
		try {
			con = new Conexao().getConexao();
			PreparedStatement stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				ret = rs.getLong(1);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return ret;
	}
	
	public Long getEspecPrincipal (String cpf, Long tab) throws SQLException {
		Long ret = null;
		Connection con = null;
		StringBuilder sql = new StringBuilder()
		.append(" SELECT ");
		try {
			con = new Conexao().getConexao();
			PreparedStatement stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				ret = rs.getLong(1);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return ret;
	}
	
	public void setAtualizaItem (Double ite, Double valinr, Double valgls, Double valgro, Double perc, Double valusu, Double valpln, Long fat, Long glosa, Long protiss, Long lotiss, String data, Long cod) throws SQLException {
		Connection con = null;
		StringBuilder sql = new StringBuilder()
		.append(" UPDATE ");
		try {
			con = new Conexao().getConexao();
			PreparedStatement stmt = con.prepareStatement(sql.toString());
			stmt.execute();
			stmt.close();
			con.close();
			setAtualExisteAut(fat);
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	public void setAtualExisteAut (Long fat) throws SQLException {
		Connection con = null;
		StringBuilder sql = new StringBuilder()
		.append(" UPDATE ");
		try {
			con = new Conexao().getConexao();
			PreparedStatement stmt = con.prepareStatement(sql.toString());
			stmt.execute();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	
}
