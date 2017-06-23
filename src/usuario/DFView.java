package Usuario;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

import org.primefaces.context.RequestContext;

@ManagedBean(name="dfView")
public class DFView {

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
	
}
