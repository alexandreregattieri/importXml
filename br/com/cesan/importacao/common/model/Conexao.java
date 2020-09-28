package br.com.cesan.importacao.common.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private String serverName = "SERVIDOR";
	private String mydatabase = "BD";
	private String username = "USUARIO";
	private String password = "SENHA";
	
	private String url = "jdbc:jtds:sqlserver://" + serverName + "/" + mydatabase;
	private Connection con = null;

	public Connection getConexao() {
        try {
        	if(con == null){
        		Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
        		con = DriverManager.getConnection(url, username, password);
        	}
        } catch (Exception e) {
            System.out.println(e.toString());
        } 
        return con;
	}

}
