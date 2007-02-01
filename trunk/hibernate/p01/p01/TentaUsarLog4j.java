package p01;

import org.apache.log4j.Logger;

/**
 * Log4j não está configurado. 
 * WARN avisa que não foi possível iniciar Log4j.
 */
public class TentaUsarLog4j {
    public static void main(String[] args) {
        Logger log = Logger.getLogger(TentaUsarLog4j.class);
        log.warn("Esta mensagem não será exibida!!!??");  
    }
}
