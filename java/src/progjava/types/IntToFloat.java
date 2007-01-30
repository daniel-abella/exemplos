package progjava.types;

public class IntToFloat {
    public static void main(String[] args) {
        float fp = Integer.MIN_VALUE;
        float f = Integer.MIN_VALUE;
        int i = Integer.MIN_VALUE;
        int c = 0;

        while (i < Integer.MAX_VALUE) {
            i++;
            f = i;
            fp = fp + 1.0f;

            if ( f != fp ) {
                System.out.println("c: " + ++c + "\ti: " + i + "\tf: " + f);
            }
        }
    }
}
