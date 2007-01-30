package progjava.datas;

import java.util.Calendar;


public class DataCorrente {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.print(c.get(Calendar.YEAR));
    }
}

// A classe java.util.Calendar deve ser importada (import).
// Substituir print por println (linha 9) provocaria um resultado diferente.