package Funcionario;

public class Funcionario {
	
	private int id;
	private String nome;
	private int id_cargo;
	
	public Funcionario(int id, String nome, int id_cargo) {
		super();
		this.id = id;
		this.nome = nome;
		this.id_cargo = id_cargo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId_cargo() {
		return id_cargo;
	}
	public void setId_cargo(int id_cargo) {
		this.id_cargo = id_cargo;
	}
	
	

}
