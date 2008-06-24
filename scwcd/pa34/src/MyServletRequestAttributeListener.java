import javax.servlet.ServletContext;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class MyServletRequestAttributeListener implements
		ServletRequestAttributeListener {

	public void attributeAdded(ServletRequestAttributeEvent event) {
		ServletContext sc = event.getServletContext();
		sc.setAttribute("attributeAdded", "attributeAdded");
	}

	public void attributeRemoved(ServletRequestAttributeEvent event) {
		ServletContext sc = event.getServletContext();
		sc.setAttribute("attributeRemoved", "attributeRemoved");
	}

	public void attributeReplaced(ServletRequestAttributeEvent event) {
		ServletContext sc = event.getServletContext();
		sc.setAttribute("attributeReplaced", "attributeReplaced");
	}
}
