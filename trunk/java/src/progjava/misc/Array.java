
package progjava.misc;
class Array {

    int[] ai;

    public static void main(String[] args) {

        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = {1, 2, 3, 4, 5};

        System.out.println("\na==b => " + a.equals(b));

        a = b;
        System.out.println("\na==b => " + a.equals(b));

        int i = 0;
        if (a[0] == 1)
            i = 1;

        int y = i;
        System.out.println(y);
    }

}
