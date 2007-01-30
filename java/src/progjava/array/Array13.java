package progjava.array;

public class Array13 {
    public static void mostraArray(int[] array) {
        if (array == null) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        mostraArray(new int[] { 1, 2, new byte[] { 1 }[0], 4 });
    }
}
