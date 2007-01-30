package progjava.excecao;

import java.util.Arrays;

public class ArrayIndexOutOfBoundsException {
    static public void main(final String... args) {
        final Double[] d = new Double[] { 1.0d };
        try {
            d[-1] = 2.0;
        } catch (final java.lang.ArrayIndexOutOfBoundsException index) {
            System.out.print("indice inválido");
        } finally {
        	System.out.println(" f");
        }
        
        try {
            final Integer l = 3;
            d[l] = 2.;
        } catch (final java.lang.ArrayIndexOutOfBoundsException e) {
            System.out.println("indice invalido");
        }
        
        try {
            final short l = 3;
            d[l] = 2.;
        } catch (final java.lang.ArrayIndexOutOfBoundsException e) {
            System.out.println("indice invalido");
        }    
        
        try {
            final long l = 3;
            d[(int)l] = (double) 'a';
        } finally {
        	System.out.println("catch não fornecido");
        }
        
        System.out.println(Arrays.toString(d));
    }

}
