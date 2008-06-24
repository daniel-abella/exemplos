import javax.servlet.ServletContext;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class MyServletRequestAttributeListener implements
		ServletRequestAttributeListener {

	public void attributeAdded(ServletRequestAttributeEvent event) {
		montaAtributo(event, "attributeAdded");
	}

	public void attributeRemoved(ServletRequestAttributeEvent event) {
		montaAtributo(event, "attributeRemoved");
	}

	public void attributeReplaced(ServletRequestAttributeEvent event) {
		montaAtributo(event, "attributeReplaced");
	}

	private void montaAtributo(ServletRequestAttributeEvent event, String msg) {
		ServletContext sc = event.getServletContext();
		String atributo = (String) sc.getAttribute("atributo");
		if (atributo == null)
			atributo = "";
		atributo += "<br>" + msg;
		sc.setAttribute("atributo", atributo);
	}
}