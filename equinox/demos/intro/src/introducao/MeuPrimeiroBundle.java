package introducao;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class MeuPrimeiroBundle implements BundleActivator {

	public void start(BundleContext context) throws Exception {
		System.out.println("Iniciado");
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Interrompido");
	}	
}
