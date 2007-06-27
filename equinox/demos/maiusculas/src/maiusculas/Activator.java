package maiusculas;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	public void start(BundleContext context) throws Exception {
		String nomeServico = ConverteParaMaiusculas.class.getName();
		Object obj = new ConverteParaMaiusculasImpl();
		context.registerService(nomeServico, obj, null);
		System.out.println("Conversao para maiusculas ativado...");
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Conversao para maiusculas desativado...");
	}
}