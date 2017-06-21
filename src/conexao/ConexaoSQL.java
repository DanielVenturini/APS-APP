package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoSQL {
	private String user = "postgres";
	private String pass = "root";
	private String database = "apsapp";
	private String url = "jdbc:postgresql://localhost:5432/apsapp";
	
	public Connection getConexao (){
		Connection con;
		
		try {
			con = DriverManager.getConnection(url,user,pass);
			//System.out.println("Conectado !!");
			return con;
		} catch (SQLException e) {
			System.out.println("Erro na conexão!!");
			e.printStackTrace();
		}
		return null;
		
	}
}
