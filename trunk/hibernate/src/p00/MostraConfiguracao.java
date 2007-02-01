package p00;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.cfg.Configuration;

public class MostraConfiguracao {
    public static void main(String[] args) {
        // Configura o Log4j (sem log4j.properties)
        // (não impede que seja fornecido log4j.properties)
        BasicConfigurator.configure();

        Configuration cfg = new Configuration().configure();
        Properties props = cfg.getProperties();
        Enumeration keys = props.propertyNames();
        List<String> lkeys = Collections.list(keys);
        Collections.sort(lkeys);
        for (String key : lkeys) {
            if (key.contains("hibernate")) {
                System.out.println(key + " " + props.getProperty(key));
            }
        }
    }
}
