package progjava.erro;

public class Excecoes {

    public static void main(final String args[]) {
        try {
            geraExcecao();
            System.out.println("Mensagem jamais impressa!");
        } catch (Exception exception) {
            System.out.println("Exceção capturada em main");
        }
        naoGeraExcecao();
    }

    public static void geraExcecao() throws Exception {
        try {
            System.out.println("Method geraExcecao");
            class MyExcecao extends Exception {
				private static final long serialVersionUID = 1L;

				MyExcecao(final String msg) { super(msg); }            	
            }
            throw new MyExcecao("gerada");
        } catch (Exception exception) {
            System.out.println("Exceção tratada em geraExcecao");
            throw exception;
        } finally {
            System.out.println("Finally executed in geraExcecao");
        }
    }

    public static String naoGeraExcecao() {
        try {
            System.out.println("Method naoGeraExcecao");
        } catch (Exception exception) {
            System.out.println(exception.toString());
        } finally {
            System.out.println("Finally executado em naoGeraExcecao");
        }
        System.out.println("Fim de naoGeraExcecao");
        return "ok";
    }
}