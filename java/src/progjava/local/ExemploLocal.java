package progjava.local;

import java.util.ResourceBundle;

public class ExemploLocal {

    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle("local.LocalStrings");

        System.out.print(rb.getString("meu.nome.primeiro") + " ");
        System.out.println(rb.getString("meu.nome.segundo"));
        System.out.print(rb.getString("meu.dia.nascimento"));
        System.out.println("/" + rb.getString("meu.mes.nascimento"));
        System.out.println("Mes: " + rb.getString("meu.mes.nome.nascimento"));
    }
}

