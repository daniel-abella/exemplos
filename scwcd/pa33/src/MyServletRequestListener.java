import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequestListener implements ServletRequestListener {
	
	public void requestInitialized(ServletRequestEvent event) {
		ServletContext sc = event.getServletContext();
		synchronized (sc) {
			int contador = (Integer) sc.getAttribute("contador");
			contador++;
			sc.setAttribute("contador", new Integer(contador));
		}
	}

	public void requestDestroyed(ServletRequestEvent event) {
	}
}
