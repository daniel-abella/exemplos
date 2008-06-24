import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class InicializaContexto implements ServletContextListener {
	public void contextInitialized(ServletContextEvent event) {
		ServletContext sc = event.getServletContext();
		sc.setAttribute("contador", new Integer(0));
	}
	
	public void contextDestroyed(ServletContextEvent event) {}

}
