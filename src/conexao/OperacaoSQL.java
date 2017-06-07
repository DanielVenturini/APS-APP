package conexao;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class OperacaoSQL {

	Connection con;
	
		public OperacaoSQL(){
			try {
				con = Conexao.getConection("postgres", "root", "apsapp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Erro ao abrir conexao");
			}
		}

	public boolean insert(String insert) throws SQLException{

		Statement st = con.createStatement();
		return st.execute(insert);

	}

	public ResultSet select(String select) throws SQLException{
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		return st.executeQuery(select);	
	}

}
