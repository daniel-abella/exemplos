import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyServletContextAttributeListener implements ServletContextAttributeListener {
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("attributeAdded " + event.getName());
	}
	
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("attributeRemoved " + event.getName());
	}
	
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("attributeReplaced " + event.getName());
	}
}
