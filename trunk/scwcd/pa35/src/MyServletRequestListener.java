import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Conta requisições para a aplicação e atualiza valor corrente em
 * propriedade "contador" de ServletContext.
 *
 */
public class MyServletRequestListener implements
		ServletRequestListener {

	public void requestInitialized(ServletRequestEvent event) {
		int novoValor = 0;
		ServletContext sc = event.getServletContext();

		synchronized (sc) {
			Integer contador = (Integer) sc.getAttribute("contador");

			if (contador == null) {
				novoValor++;
			} else {
				novoValor = contador.intValue() + 1;
			}
			sc.setAttribute("contador", new Integer(novoValor));
		}
	}

	public void requestDestroyed(ServletRequestEvent event) {

	}
}
