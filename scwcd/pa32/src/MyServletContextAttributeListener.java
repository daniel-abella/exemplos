import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyServletContextAttributeListener implements ServletContextAttributeListener {
	public void attributeAdded(ServletContextAttributeEvent event) {
		StringBuilder msg = (StringBuilder) event.getServletContext().getAttribute("msg");
		msg.append("<br>attributeAdded: " + event.getName());
	}
	
	public void attributeRemoved(ServletContextAttributeEvent event) {
		StringBuilder msg = (StringBuilder) event.getServletContext().getAttribute("msg");
		msg.append("<br>attributeRemoved: " + event.getName());
	}
	
	public void attributeReplaced(ServletContextAttributeEvent event) {
		StringBuilder msg = (StringBuilder) event.getServletContext().getAttribute("msg");
		msg.append("<br>attributeReplaced: " + event.getName());
	}
}
