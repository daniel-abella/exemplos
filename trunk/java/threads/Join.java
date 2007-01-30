
public class Join extends Thread {
    double valorDePi = 0.0; 

    public void run() {  // Método "lento" para cálculo de Pi
        double d = -1;
        int s = -1;
        double p = 0.0;
        for (long i = 0; i < (long) 1E+8; i++) {
            d += 2;
            s *= -1;
            p += s / d;
        }
        valorDePi = 4 * p;
    }

    public static void main(String[] args) {
        Join tu = new Join();
        tu.start();  // Muitas atividades a serem realizadas!
        System.out.println("Calculando o valor de Pi. Aguarde ...");     

        try {
            tu.join();  // Aguarde pelo cálculo de pi
        } catch (InterruptedException ex) {
        }

        System.out.printf("Pi obtido: %f", tu.valorDePi);
    }
}
