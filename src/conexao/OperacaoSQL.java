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

import Usuario.Curso;

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
		Scanner s = new Scanner(new File("tabelas.txt")).useDelimiter(";");

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
	public static void ciarCursos() throws SQLException{
		Curso[] cursos = Curso.values();
		System.out.println(cursos.length);
		for(int i=0; i < cursos.length; i++){
			OperacaoSQL.insert("insert into curso values("+i+",'"+cursos[i]+"')");
		}
	}
	public static void criarUsuarios() throws SQLException{
		OperacaoSQL.insert("insert into usuario(ra,nome,senha,foto,curso) values"
				+ "(1724533,'rodrigo','gorvvq85','https://yt3.ggpht.com/-17k5T_rvuQA/AAAAAAAAAAI/AAAAAAAAAAA/0zAiRFMgLbI/s900-c-k-no-mo-rj-c0xffffff/photo.jpg',"+Curso.ENGENHARIA_AMBIENTAL.ordinal()+"),"
				+ "(1724487,'danielzinho','ballas','https://media.lolusercontent.com/api/embedly/1/image/resize?url=http%3A%2F%2Fimgur.com%2FXgfTdsZ.png&key=f0abbd34f14549f3a15cd94dd9970851&width=425',"+Curso.CIENCIA_DA_COMPUTACAO.ordinal()+"),"
				+ "(1234567,'dougras','eusou','https://i.ytimg.com/vi/iLGjJ8Whjl4/hqdefault.jpg', "+Curso.ENGENHARIA_ALIMENTOS.ordinal()+"),"
				+ "(7654321,'Octavio','prof','http://vignette3.wikia.nocookie.net/meme/images/b/b2/Professor_Octavio.png/revision/latest?cb=20170223030600&path-prefix=pt-br',"+Curso.PROFESSOR.ordinal()+")");
	}
	public static void criarReajuste() throws SQLException{
		OperacaoSQL.insert("insert into reajuste(data,valor,obs) values('10/08/2017',2.5,'obs exemplo')");
	}
	
}
