package progjava.main;

public class Principal05 {
    public static void main(String[] args) {
        System.out.print("Ok");
        main(3);
    }

    public static void main(int $i) {
        System.out.println(+$i);
    }
}

// N�o ocorre erro de compila��o.
// N�o h� recurs�o na linha 5.
// N�o ocorre erro de sintaxe na linha 8.
// A sobrecarga do identificador main � v�lida.
