package Funcionario;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;

import org.primefaces.context.RequestContext;

@ManagedBean(name="funcionarioMB")

public class FuncionarioBean {
	int ra;
	int quantidade;
	
	public void viewVenda() throws SQLException{
		Map<String,Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        options.put("width", 640);
        options.put("height", 340);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        options.put("headerElement", "customheader");
         
        RequestContext.getCurrentInstance().openDialog("vendatotal", options, null);
	}

	public int getRa() {
		return ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
