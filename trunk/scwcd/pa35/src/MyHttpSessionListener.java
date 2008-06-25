import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("sessionCreated");
		addicionaUm(event.getSession());
	}

	@SuppressWarnings("unchecked")
	private void addicionaUm(HttpSession session) {
		ServletContext sc = session.getServletContext();
		synchronized (sc) {
			List<HttpSession> l = (List) sc.getAttribute("sessoes");
			if (l == null) {
				l = new ArrayList<HttpSession>();
			}

			l.add(session);
			sc.setAttribute("sessoes", l);
		}
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("sessionDestroyed");
		subtraiUm(event.getSession());
	}

	@SuppressWarnings("unchecked")
	private void subtraiUm(HttpSession session) {
		ServletContext sc = session.getServletContext();
		synchronized (sc) {
			List<HttpSession> l = (List) sc.getAttribute("sessoes");
			if (l == null) {
				throw new RuntimeException("Estranho, como é possível?????");
			}
			
			l.remove(session);
		}
	}
}
