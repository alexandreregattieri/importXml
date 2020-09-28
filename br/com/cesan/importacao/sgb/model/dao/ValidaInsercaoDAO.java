package br.com.cesan.importacao.sgb.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.cesan.importacao.common.model.Conexao;
import br.com.cesan.importacao.sgb.model.to.ProtocoloSGBTO;


public class ValidaInsercaoDAO {

	public void setInsereFatura(String sql) throws SQLException{
		Connection con = null;
		try {
			con = new Conexao().getConexao();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.execute();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	public void setInsereItem(String sql) throws SQLException{
		Connection con = null;
		try {
			con = new Conexao().getConexao();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.execute();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	public void setInsereProtocolo(ProtocoloSGBTO to) throws SQLException{
		Connection con = null;
		StringBuilder sql = new StringBuilder()
		.append(" INSERT ");
		try {
			con = new Conexao().getConexao();
			PreparedStatement stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, to.getNumcpfcgccri());
			stmt.setString(2, to.getIndcpfcgc());
			stmt.setLong(3, to.getNumpto());
			stmt.setLong(4, to.getAnopto());
			stmt.setDate(5, to.getDatapevpgt());
			stmt.setString(6, to.getObspto());
			stmt.setDate(7, to.getDtfaturamento());
			stmt.execute();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	public String getNumFatura(String aut, String data) throws SQLException {
		String fat = null;
		Connection con = null;
		StringBuilder sql = new StringBuilder()
		.append(" SELECT ");
		try {
			con = new Conexao().getConexao();
			PreparedStatement stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				fat = rs.getString(1);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return fat;
	}
	
}
