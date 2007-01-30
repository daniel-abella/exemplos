package progjava.threads;

public class VersaoConcorrente extends Thread {
    private static double[] doubles = new double[10];
    private static int produtor = 0;

    public void run() {
        for (int i = 0; i < doubles.length; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {}
            synchronized (this) {
                doubles[i] = i;
                produtor = i;
                notifyAll();
            }
        }
        synchronized (this) {
            produtor++;
            notifyAll();
        }
    }

    public void imprime() {
        for (int i = 0; i < doubles.length;) {
            if (i < produtor) {
                System.out.println(i + " " + doubles[i]);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ie) {}
                i++;
            } else {
                synchronized (this) {
                    try {
                        if (i >= produtor) { 
                            wait();
                        }
                    } catch (InterruptedException ie) {}
                }
            }
        }
    }

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        VersaoConcorrente vc = new VersaoConcorrente();
        vc.start();
        vc.imprime();
        long fim = System.currentTimeMillis();
        System.out.println("Tempo: " + (fim - inicio) / 1000.0);
    }
}