package Usuario;

public class Usuario {
	private int ra;
	private String senha;
	private String nome;
	private String foto;
	private Curso curso;
	
	public Usuario(int ra, String senha, String nome, String foto, Curso curso) {
		super();
		this.ra = ra;
		this.senha = senha;
		this.nome = nome;
		this.foto = foto;
		this.curso = curso;
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
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Curso getCurso(){
		return curso;
	}
	public void setCurso(Curso curso){
		this.curso = curso;
	}
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	
	

}
