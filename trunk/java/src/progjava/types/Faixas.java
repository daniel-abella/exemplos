package progjava.types;

public class Faixas {
    public static void main (String args []) {
      floatRange(); doubleRange(); special();
    }
  /** uses multiplication and division and the Double class */
    static void doubleRange () {
      double min = 1, max = 1;
      for (double d = 1; d != 0.; min = d, d /= 2.)
        ;
      for (double d = 1, n = d * 2.; d != n; max = d, d = n, n *= 2.)
        ;
      for (double d = max, w = Math.sqrt(2.), n = d * w; d != n; ) {
        max = d; d = n; w = Math.sqrt(w); n *= w;
      }
      System.out.println("double\t"+ min +"\t"+ max);
      System.out.println("Double\t"+ Double.MIN_VALUE +"\t"+ Double.MAX_VALUE);
    }
  /** uses the Float class */
    static void floatRange () {
      System.out.println("float\t"+ Float.MIN_VALUE +"\t"+ Float.MAX_VALUE);
    }
  /** operations with infinity and NaN */
    static void special () {
      System.out.println("infinity:\t"+ 1/(-0.) +"\t"+ 1/(+0.));
      System.out.println("\t\t"+ Float.intBitsToFloat(0xff800000)
              +"\t"+ Float.intBitsToFloat(0x7f800000));
      System.out.println("\t\t"+ Double.longBitsToDouble(0xfff0000000000000L)
              +"\t"+ Double.longBitsToDouble(0x7ff0000000000000L));
      System.out.println("NaN:\t"+ Math.sqrt(-1.)
              +"\t"+ 0.0f/0.0f
              +"\t"+ Float.intBitsToFloat(0x7f800001)
              +"\t"+ Double.longBitsToDouble(0x7ff0000000000001L));
    }

}
