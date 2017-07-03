package Funcionario;
import Usuario.UsuarioDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

@ManagedBean(name="funcionarioMB")
@SessionScoped

public class FuncionarioBean implements Serializable{
	int ra;
	int quantidade;
	float total;
	
	FuncionarioDAO funcionarioDao = new FuncionarioDAO();
	UsuarioDAO usuarioDao = new UsuarioDAO();

	public int getRa() {
		return ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}
	
	public void setTotal(float total){
		this.total = total;
	}
	
	public float getTotal(){
		return this.total;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getQuantidade() {
		return this.quantidade;
	}
	
	public float getPreco() throws SQLException{
		return funcionarioDao.getPreco();
	}
	public float getPrecototal() throws SQLException{
		return funcionarioDao.getPreco() * this.quantidade;
	}
	
	public float getTroco() throws SQLException{
		return this.total - this.getPrecototal();
	}
	
	public void autenticaVenda(ActionEvent Action) throws ClassNotFoundException, SQLException{

		Class.forName("org.postgresql.Driver");
		System.out.println(ra+", "+quantidade);
		
		if(usuarioDao.autenticaUsuario(ra)){
			Map<String,Object> options = new HashMap<String, Object>();
	        options.put("modal", true);
	        options.put("width", 640);
	        options.put("height", 340);
	        options.put("contentWidth", "100%");
	        options.put("contentHeight", "100%");
	        options.put("headerElement", "customheader");
	         
	        RequestContext.getCurrentInstance().openDialog("vendatotal", options, null);
	        return;
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erro!", "Usuário Inexistente"));
	}
	
	public void autenticaConsumo(ActionEvent event) throws SQLException, ClassNotFoundException{
		Class.forName("org.postgresql.Driver");

		if(funcionarioDao.autenticaConsumo(ra)){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Sucesso"));
		}
		else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro"));
		}
			
	}
	
	public void vender(ActionEvent action) throws SQLException{
		System.out.println("Qtd: "+this.quantidade+" Ra: "+this.ra);
		funcionarioDao.vender(this.quantidade, this.ra);
        RequestContext.getCurrentInstance().closeDialog(null);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));
	}
	
	public String getNome(){
		return usuarioDao.getUsuario().getNome();
	}
	public String getCurso(){
		return usuarioDao.getUsuario().getCurso().toString();
	}
	
}
