package progjava.lista;

public class FilaTeste {
    public static void main(final String[] args) {
        final Fila f = new Fila();
        
        System.out.println("Criando elementos ...");
        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            f.adiciona(i);
        }
        
        System.out.println("Removendo " + f.tamanho() + " elementos");
        while (f.tamanho() > 0) {
            f.remove();
        }
        
        System.out.println("Elementos restantes: " + f.tamanho());
    }
}