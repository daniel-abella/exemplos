/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package my;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 * @author kyrios
 */

public class OuvinteAplicacao implements ServletContextListener {

    public void contextInitialized(ServletContextEvent arg0) {
        String[] l1 = { "Primeiro", "Segundo exemplo" };
        String[] l2 = { "Terceiro", "Quarto", "Quinto" };
        /* 
        List<String[]> lista = new ArrayList<String[]>();
        lista.add(l1);
        lista.add(l2);
         */
        
        // Alternativa para o código acima (mesmo efeito)
        String[][] lista = { l1, l2 };
        
        ServletContext sc = arg0.getServletContext();
        sc.setAttribute("listaDeArrays", lista);
    }

    public void contextDestroyed(ServletContextEvent arg0) {
      
    }
}