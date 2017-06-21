package Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import Conexao.ConexaoSQL;
import Conexao.OperacaoSQL;
import Usuario.Tipo;
import Usuario.Usuario;

public class FuncionarioDAO {
	
	private Funcionario funcionario;
	private ConexaoSQL n = new ConexaoSQL();
	private Connection conn = n.getConexao();
	private ResultSet rs;
	private Statement smt;
	
	public boolean autenticaFuncionario(int id) throws SQLException{
		String sql = "Select * From funcionario where id = "+id;
		smt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = smt.executeQuery(sql);
		
		if(rs.first()){
				funcionario = new Funcionario(rs.getInt(1),rs.getString(2),rs.getInt(3));
				return true;
		}
		return false;
	}

	public boolean vender(int qtd, int ra) throws SQLException{
		//verifica se o funcionario é um vendedor
		if(!autorizaOp(Cargo.VENDEDOR)){
			return false;
		}
		//verifica a existencia do ra no banco de dados.
		String sql = "select * from usuario where ra="+ra;
		smt = conn.createStatement();
		if(!smt.execute(sql)) return false;
		
		int novoSaldo;
		int idreajuste;
		int saldoAnterior=0;
		
		//seleciona o ultimo saldo do usuario no banco
		sql = "select saldo from refeicao where id = (select max(id) from refeicao where ra ="+ra+");";
		smt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = smt.executeQuery(sql);
		
		if(rs.first())
			saldoAnterior = rs.getInt(1);
		
		//seleciona o ultimo reajuste disponivel
		sql = "select max(id) from reajuste";
		rs = smt.executeQuery(sql);
		rs.next();
		idreajuste = rs.getInt(1);
		
		novoSaldo = saldoAnterior + qtd;
	
		//insere a nova refeiçao
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		sql = "insert into refeicao (timestamp, ra, saldo, quantidade, idreajuste) values (?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, timestamp);
			stmt.setInt(2, ra);
			stmt.setFloat(3, novoSaldo);
			stmt.setInt(4, qtd); 
			stmt.setInt(5, idreajuste);
			stmt.execute();
			
		} catch (Exception e) {
			System.out.println(e);
			return false;

		}
		return true;
		
	}

	private boolean autorizaOp(Cargo c) throws SQLException{
		String sql = "select * from funcionario where id = "+funcionario.getId() +" and id_cargo = " + c.getId();
		smt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		rs = smt.executeQuery(sql);

		return rs.first();
	}

	public boolean consumo(int ra) throws SQLException{
		//seleciona o saldo do usuario
		String sql = "Select saldo from refeicao where id = (select max(id) from refeicao where ra = "+ra+");";
		smt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		rs = smt.executeQuery(sql);
		rs.first();
		int saldo = rs.getInt(1);		 
		
		//seleciona o reajuste atual
		sql = "select max(id) from reajuste";
		rs = smt.executeQuery(sql);
		rs.first();
		int idReajuste = rs.getInt(1);
		System.out.println(idReajuste);
		
		if(saldo <= 0){
			return false;
		}else{ 
			//realiza o consumo e insere na tabela
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			sql = "insert into refeicao (timestamp, ra, saldo, quantidade, idreajuste) values (?,?,?,?,?)";
			int novoSaldo = saldo - 1;
			try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, timestamp);
				stmt.setInt(2, ra);
				stmt.setFloat(3, novoSaldo);
				stmt.setInt(4, -1); 
				stmt.setInt(5, idReajuste);
				stmt.execute();
					
				} catch (Exception e) {
					System.out.println(e);
					return false;
				}
			 return true;
		}
	}
}
