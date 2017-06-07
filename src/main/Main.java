package main;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import conexao.Conexao;
import conexao.OperacaoSQL;
import usuario.Usuario;

public class Main {
	
	public static void main(String[] args) throws SQLException, FileNotFoundException{
		
		//Conexao.getConection("postgres", "root", "apsapp");
		//OperacaoSQL op = new OperacaoSQL();
		Usuario u= new Usuario("1724487", "nome", "senha", "foto");
		u.comprar(3);	
		
		
		
		
	}

}
