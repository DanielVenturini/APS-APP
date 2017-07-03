package Usuario;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

import org.primefaces.context.RequestContext;

@ManagedBean(name="dfView")
public class DFView implements Serializable{
	
	private int ra;
	private String senha;
	
	@ManagedProperty(value="#{usuarioMB}")
	private UsuarioBean userbean;
	
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
	public void viewVenda(ActionEvent Action) throws SQLException, ClassNotFoundException{
				
		Map<String,Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        options.put("width", 640);
        options.put("height", 340);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        options.put("headerElement", "customheader");
         
        RequestContext.getCurrentInstance().openDialog("vendatotal", options, null);
	}
	
	public void setUserbean(UsuarioBean userbean){
		this.userbean = userbean;
	}
	
}
