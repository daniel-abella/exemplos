import java.util.Hashtable;
import javax.naming.*;
import javax.naming.directory.*;


public class dns {
    private static String[] dnss = { "200.184.26.3", "200.184.26.4",
                                     "200.185.6.131", "200.185.6.163",
				     "200.175.182.139", "200.175.5.139" };
    private static String[] ips = { "A" };

    public static void main(String[] args) {
	if (args.length != 1) {
	    System.out.println("uso: java dns <dominio> (p. ex., google.com)");
	    System.out.println("Realiza consulta em vários servidores DNS");
	    return;
	}

	Hashtable env = new Hashtable();
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.dns.DnsContextFactory");

	Attributes atrs = null;
	try {
	    InitialDirContext ctx = new InitialDirContext(env);

	    for (String dns : dnss) {
		try {
		    String search = "dns://" + dns + "/" + args[0];
		    atrs = ctx.getAttributes(search, ips);
		    if (atrs != null) {
			System.out.println(args[0] + " : " + atrs);
			break;
		    }
		} catch (NamingException e) {
		}
	    }
	    
	    ctx.close(); 
	} catch (Exception e) {}
	if (atrs == null)
	    System.out.println("Não foi possível localizar ip de " + args[0]);
    }
}
