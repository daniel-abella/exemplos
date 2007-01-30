package progjava.local;

import java.util.Properties;

public class Propriedades {
    public static void main(String[] args) {
        Properties ps = System.getProperties();
        ps.list(System.out); // Exibe todas as propriedades

        // Exibe diret�rio do usu�rio
        System.out.println(System.getProperty("user.dir"));
    }
}