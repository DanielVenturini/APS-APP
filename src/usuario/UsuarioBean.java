package Usuario;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

@ManagedBean(name="usuarioMB")
@SessionScoped

public class UsuarioBean implements Serializable{
	private int ra;
	private String senha;
	
	UsuarioDAO usuario = new UsuarioDAO();
	
	private boolean erro = false;

	public String autenticaUsuario() throws SQLException, ClassNotFoundException{
		try{
			Class.forName("org.postgresql.Driver");
			this.erro = true;
			if(usuario.autenticaUsuario(this.ra, this.senha)){
				this.erro = false;
				return "principal";
			}	
		} catch(SQLException e){
			e.printStackTrace();
			return "Erro";
		}
		return null;	
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
		return usuario.getUsuario().getNome();
	}
	public Tipo getTipo() {
		return usuario.getUsuario().getTipo();
	}
	public String getFoto() {
		return usuario.getUsuario().getFoto();
	}

	public String getSaldo(){
		int saldo = usuario.getSaldo();
		if(saldo > 1)
			return saldo+" REFEICOES";
		else
			return saldo+" REFEICAO";
	}
	public boolean isErro() {
		return erro;
	}

	public void setErro(boolean erro) {
		this.erro = erro;
	}

	public List<Extrato> getExtrato(){
		return usuario.getExtrato();
	}
}
