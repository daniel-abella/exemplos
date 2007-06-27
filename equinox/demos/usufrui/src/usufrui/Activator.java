package usufrui;

import maiusculas.ConverteParaMaiusculas;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {
	private ConverteParaMaiusculas cpm = null;
	
	public void start(BundleContext context) throws Exception {
		String classe = ConverteParaMaiusculas.class.getName();
		ServiceReference sr = context.getServiceReference(classe);
		if (sr == null) {
			System.out.println("Servico nao registrado");
			return;
		}
		cpm = (ConverteParaMaiusculas) context.getService(sr);
		System.out.println(cpm.paraMaiusculas("string simples"));
	}
	
	public void stop(BundleContext context) throws Exception {
	}
}
