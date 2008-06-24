import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyServletContextAttributeListener implements ServletContextAttributeListener {
	public void attributeAdded(ServletContextAttributeEvent event) {
		event.getServletContext().setAttribute("attributeAdded", "Adicionado atributo");
	}
	
	public void attributeRemoved(ServletContextAttributeEvent event) {
		event.getServletContext().setAttribute("attributeRemoved", "Atributo removido");
	}
	
	public void attributeReplaced(ServletContextAttributeEvent event) {
		//event.getServletContext().setAttribute("attributeReplaced", "Atributo substituído");
	}
}
