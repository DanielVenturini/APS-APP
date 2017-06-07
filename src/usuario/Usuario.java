package usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import conexao.OperacaoSQL;

public class Usuario {
	
	private	String ra;
	private String nome;
	private String senha;
	private String foto;
	private OperacaoSQL op = new OperacaoSQL();

	public Usuario(String ra, String nome, String senha, String foto) {
		this.ra = ra;
		this.nome = nome;
		this.senha = senha;
		this.foto = foto;
		
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public boolean comprar(int quantidade) throws SQLException{
		Long timestamp = Long.valueOf(new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(Calendar.getInstance().getTime()).split("_")[1]);
		
		ResultSet rs = op.select("select id from reajuste");
		if(!rs.last()){
			System.out.println("Tabela reajuste vazia.");
			return false;
		}
		
		String idReajuste = rs.getString(1);
		
		rs = op.select("select saldo from refeicao where ra = '" + ra + "'");
		
		int saldo = (rs.last() == false ? quantidade : rs.getInt(1) + quantidade);

		String insert = "insert into refeicao(timestamp, ra, quantidade, reajuste, saldo) values ('"+timestamp+"', '"+ra+"', "+quantidade+", "+idReajuste+", "+saldo+")";
		
		return op.insert(insert);
	}
	
	public ResultSet getExtrato() throws SQLException{
		String consulta = "select * from refeicao where ra='"+ra+"'";
		return op.select(consulta);
	}

}
