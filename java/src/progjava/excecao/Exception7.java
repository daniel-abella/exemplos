package progjava.excecao;

class Exception7 {

    private static int variável = 0;

    public static int metodo() {
        try {
            variável = 1;
            return 2;
        } finally {
            variável = 2;
        }
    }

    public static void main(String[] args) {
        System.out.println("Retorno: " + metodo() + "\n = " + variável);
    }
}