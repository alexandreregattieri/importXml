package br.com.cesan.importacao.sgb.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.cesan.importacao.common.model.Conexao;
import br.com.cesan.importacao.sgb.model.to.TabelaProcedSGBTO;


public class ValidaTabelaDAO {
	
	public TabelaProcedSGBTO getTabelas (Long tab, String proced) throws SQLException {
		TabelaProcedSGBTO info = new TabelaProcedSGBTO();
		Connection con = null;
		StringBuilder sql = new StringBuilder()
		.append(" SELECT ");
		try {
			con = new Conexao().getConexao();
			PreparedStatement stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				info.setCodtiptab(rs.getLong(1));
				info.setNubeneficio(rs.getLong(2));
				info.setValor(rs.getDouble(3));
				info.setSexo(rs.getString(4));
				info.setAutorizacao(rs.getString(5));
				info.setIdadeinicial(rs.getLong(6));
				info.setIdadefinal(rs.getLong(7));
				info.setTipodigit(rs.getString(8));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return info;
	}

}
