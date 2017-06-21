package Conexao;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class OperacaoSQL {
	private static ConexaoSQL n = new ConexaoSQL();
	private static Connection conn = n.getConexao();

	public static int insert(String sql) throws SQLException{
		
		Statement smt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		return smt.executeUpdate(sql);
	}
	
	public static ResultSet select(String sql) throws SQLException{
		Statement smt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		return smt.executeQuery(sql);
	}
	
	public static void criarTabelas() throws SQLException, FileNotFoundException{
		Statement smt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		Scanner s = new Scanner(new File("tabelas.sql")).useDelimiter(";");
		
		while(s.hasNext()){
			smt.executeUpdate(s.next());
		}
	}
	public static void criarCargos() throws SQLException{
		OperacaoSQL.insert("insert into cargo(nome) values"
				+ "('gerente'),"
				+ "('vendedor')");
	}
	
	public static void criarFuncionarios() throws SQLException{
		OperacaoSQL.insert("insert into funcionario(nome, id_cargo) values"
				+ "('Joao',2),"
				+ "('Maria',1)");
	}
	public static void criarTipos() throws SQLException{
		OperacaoSQL.insert("insert into tipo(nome) values"
				+ "('professor'),"
				+ "('aluno'),"
				+ "('visitante')");
	}
	public static void criarUsuarios() throws SQLException{
		OperacaoSQL.insert("insert into usuario(ra,nome,senha,tipo,foto) values"
				+ "(1724533,'rodrigo','gorvvq85',2,'www.orkut.com/foto.jpg'),"
				+ "(1724487,'danielzinho','ballas',3,'www.facebook.com/photo.jpg'),"
				+ "(1234567,'dougras','eusou',1,'www.google.com/foto.jpg')");
	}
	public static void criarReajuste() throws SQLException{
		OperacaoSQL.insert("insert into reajuste(data,valor,obs) values('10/08/2017',2.5,'obs exemplo')");
	}
	
}
