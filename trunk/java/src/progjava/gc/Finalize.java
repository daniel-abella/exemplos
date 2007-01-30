package progjava.gc;

public class Finalize {
    private double[] wasteMem = new double[100];
    private static int numRefs = 0;

    Finalize() {
        numRefs++;
        wasteMem[0] = numRefs++;
    }

    protected void finalize() {
        System.out.println(numRefs--);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 1000 * 1000; i++ ){
            new Finalize();
            if (Finalize.numRefs > 10000) {
                System.gc();
            }
        }
    }
}
