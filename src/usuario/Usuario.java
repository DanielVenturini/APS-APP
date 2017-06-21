package Usuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped

public class Usuario {
	private int ra;
	public String senha;
	private String nome;
	private Tipo tipo;
	private String foto;

	public Usuario(int ra, String senha, String nome, Tipo tipo, String foto) {
		super();
		this.ra = ra;
		this.senha = senha;
		this.nome = nome;
		this.tipo = tipo;
		this.foto = foto;
	}
	public int getRa() {
		return ra;
	}
	public void setRa(int ra) {
		this.ra = ra;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	
	

}
