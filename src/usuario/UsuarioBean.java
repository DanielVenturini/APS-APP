package Usuario;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

@ManagedBean(name="usuarioMB")
@SessionScoped

public class UsuarioBean implements Serializable{
	private int ra;
	private String senha;
	private int quantidade;
	private float total;
	
	private Usuario usuario;
	

	UsuarioDAO usuarioDao = new UsuarioDAO();
	
	public String autenticaLogin() throws ClassNotFoundException{
		try{
			Class.forName("org.postgresql.Driver");
			if(usuarioDao.autenticaLogin(this.ra, this.senha)){
				return "principal";
			}
		} catch(SQLException e){
			e.printStackTrace();
			return "Erro";
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erro!", "Login incorreto"));
		return null;	
	}
	
	public void setQuantidade(int qnt){
		this.quantidade = qnt;
	}
	
	public int getQuantidade(){
		return quantidade;
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
		return usuarioDao.getUsuario().getNome();
	}
	public String getFoto() {
		return usuarioDao.getUsuario().getFoto();
	}
	public String getCurso(){
		return usuarioDao.getUsuario().getCurso().toString();
	}
	
	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
	public float getPreco() throws SQLException{
		return usuarioDao.getPreco();
	}
	public float getPrecototal() throws SQLException{
		return usuarioDao.getPreco() * this.quantidade;
	}
	
	public String sair(){
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.invalidate();

		return "login";
	}
	
	public String getSaldo(){
		int saldo = usuarioDao.getSaldo();
		if(saldo > 1)
			return saldo+" REFEICOES";
		else
			return saldo+" REFEICAO";
	}

	public List<Extrato> getExtrato(){
		return usuarioDao.getExtrato();
	}
	
	public void viewExtrato(ActionEvent action) {
		Map<String,Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        options.put("width", 640);
        options.put("height", 340);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        options.put("headerElement", "customheader");
         
        RequestContext.getCurrentInstance().openDialog("extrato", options, null);
    }
	
	public void fecharVenda(ActionEvent action){
		//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Venda", "Venda Efetuada"));
	}
}
