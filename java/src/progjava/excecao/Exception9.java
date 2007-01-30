package progjava.excecao;
class Exception9 {

    public static void main(String[] args) {
        String s = "";

        try {
            System.out.println(s.trim());
        } catch (RuntimeException rte) {
            System.out.println("exception foi gerada");
        }
    }
}