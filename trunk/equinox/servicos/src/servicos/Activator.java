package servicos;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator, ServiceListener {

	public void start(BundleContext context) {
		System.out.println("Estou atento a objetos ServiceEvent");
		context.addServiceListener(this);
	}

	public void stop(BundleContext context) {
		context.removeServiceListener(this);
		System.out.println("Objetos ServiceEvent desconsiderados");
	}

	public void serviceChanged(ServiceEvent event) {
		ServiceReference sr = event.getServiceReference();
		// Obtém todos os nomes de classes atribuídos ao serviço
		String[] nomes = (String[]) sr.getProperty(Constants.OBJECTCLASS);

		System.out.print("Serviço " + nomes[0]);
		if (event.getType() == ServiceEvent.REGISTERED) {
			System.out.println(" registrado");
		} else if (event.getType() == ServiceEvent.UNREGISTERING) {
			System.out.println(" descadastrado");
		} else if (event.getType() == ServiceEvent.MODIFIED) {
			System.out.println(" modificado");
		}
	}
}