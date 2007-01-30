package progjava.threads;

public class VersaoSequencial {
    private static double[] doubles = new double[10]; // M�gico 10

    public static void geraImprime() {

        // Gasta CPU
        for (int i = 0; i < doubles.length; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
            }
            doubles[i] = i;
        }

        // Consome n�meros
        for (int i = 0; i < doubles.length; i++) {
            System.out.println(i + " " + doubles[i]);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
            }
        }
    }

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        geraImprime();
        long fim = System.currentTimeMillis();

        System.out.println("\nTempo: " + (fim - inicio) / 1000.0);
    }
}