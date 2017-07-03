package Principal;

import java.io.FileNotFoundException;

import java.sql.SQLException;

import Conexao.OperacaoSQL;
import Funcionario.FuncionarioDAO;
import Usuario.UsuarioDAO;

public class main {

	public static void main(String[] args) throws SQLException, FileNotFoundException {
		OperacaoSQL.criarTabelas();
		OperacaoSQL.criarCargos();
		OperacaoSQL.criarFuncionarios();
		OperacaoSQL.ciarCursos();
		OperacaoSQL.criarUsuarios();
		OperacaoSQL.criarReajuste();
		
		FuncionarioDAO f = new FuncionarioDAO();
		UsuarioDAO u = new UsuarioDAO();

		if(f.autenticaFuncionario(1))
			System.out.println("americamemes");

		if(u.autenticaLogin(1724533, "gorvvq85"))
			System.out.println("americamemes");

		f.vender(5, 1724533);
		f.vender(3, 1724487);

		f.consumo(1724533);
		f.consumo(1724533);

		f.consumo(1724487);
		f.consumo(1724487);
		f.consumo(1724487);
		f.consumo(1724487);
	}
}
