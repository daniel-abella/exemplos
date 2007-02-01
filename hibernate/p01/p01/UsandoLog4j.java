package p01;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class UsandoLog4j {
    public static void main(String[] args) {
    	
    	// Configura Log4j com valores predefinidos
    	// Não exige arquivo de configuração do Log4j
        BasicConfigurator.configure();
        
        Logger log = Logger.getLogger(UsandoLog4j.class);
        log.warn("Agora sim, log funcionando");        
    }
}
