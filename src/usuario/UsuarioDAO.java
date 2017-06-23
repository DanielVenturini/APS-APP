package Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Conexao.ConexaoSQL;

public class UsuarioDAO {

	private Usuario usuario;
	private ConexaoSQL n = new ConexaoSQL();

	public boolean autenticaUsuario(int ra , String senha) throws SQLException{
		System.out.println("Autenticando usuario");
		
		Connection conn = n.getConexao();
		String sql = "Select * From usuario where ra = "+ra;
		Statement smt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = smt.executeQuery(sql);
		
		if(rs.first()){
			if(rs.getString(2).equals(senha)){
				usuario = new Usuario(ra, senha, rs.getString(3),Tipo.ESTUDANTE, rs.getString(5));
				conn.close();
				System.out.println("Usuario autenticado");
				return true;
			}
		}
		conn.close();
		System.out.println("Usuario nao autenticado");
		return false;
	}

	
	public int getSaldo (){
		String sql = "select saldo from refeicao where id = (select max(id) from refeicao where ra = "+ usuario.getRa()+")";
		Connection conn = n.getConexao();
		
		try {
			Statement smt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = smt.executeQuery(sql);
			if(rs.first()){
				int saldo = rs.getInt(1);
				conn.close();
				return saldo;
			}
			conn.close();
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	public ArrayList<Extrato> getExtrato(){
		
		String sql = "select * from refeicao where ra = "+usuario.getRa()+"order by id";
		ArrayList<Extrato> extrato = new ArrayList<>();
		Connection conn = n.getConexao();

		try {
			Statement smt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = smt.executeQuery(sql);
			while(rs.next()){
				String data = String.format("%s/%s/%s", rs.getString(2).substring(0, 4), rs.getString(2).substring(4,6), rs.getString(2).substring(6, 8));
				String hora = String.format("%s:%s:%s", rs.getString(2).substring(0,2), rs.getString(2).substring(2,4), rs.getString(2).substring(4,6));
				String operacao;
				int quantidade = rs.getInt(5);
				if(quantidade>0){
					operacao = String.format("Compra(%d)", quantidade);
				}
				
				else{
					operacao = "Consumo";
				}
				
				float saldo_dinheiro = rs.getFloat(4);
				int saldo_qtd = rs.getInt(5);
				Extrato ex = new Extrato(data, hora, operacao, saldo_qtd, saldo_dinheiro);
				extrato.add(ex);
				conn.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return extrato;
	}
	public Usuario getUsuario(){
		return usuario;
	}
}

