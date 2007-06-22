import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class ExplorandoBundleContext implements BundleActivator {

	public String showStatus(Bundle b) {
		switch (b.getState()) {
		case Bundle.ACTIVE:
			return "ACTIVE";
		case Bundle.INSTALLED:
			return "INSTALLED";
		case Bundle.RESOLVED:
			return "RESOLVED";
		case Bundle.STARTING:
			return "STARTING";
		case Bundle.STOPPING:
			return "STOPPING";
		case Bundle.UNINSTALLED:
			return "UNINSTALLED";
		default:
			return null;
		}
	}

	public void start(BundleContext context) throws Exception {
		// Exibe todos os bundles instalados e respectivos status
		for (Bundle b : context.getBundles())
			System.out.println(showStatus(b) + " " + b.getSymbolicName());
	}

	public void stop(BundleContext context) throws Exception {
	}
}
