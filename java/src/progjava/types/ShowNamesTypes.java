package progjava.types;

public class ShowNamesTypes {
    private static boolean[] booleanArray = new boolean[] {};
    private static char[] charArray = new char[] { 'a', 'b' };
    private static byte[] byteArray = "casa".getBytes();
    private static short[] shortArray = { 'a', 'b' };
    private static int[] intArray = { 1 };
    private static long[] longArray = { 1 };
    private static float[] floatArray = { 1.0f, 2F };
    private static double[] doubleArray = { 1, 2 };
    private static Object[] objectArray = new Object[1];
    private static ShowNamesTypes[] showNamesTypesArray = new ShowNamesTypes[2];
    
    public static void main(String[] args) {
        System.out.print(booleanArray);
        System.out.println(" boolean[]");
        
        System.out.print((Object) charArray);
        System.out.println(" char[]");

        System.out.print(byteArray);
        System.out.println(" byte[]");
        
        System.out.print(shortArray);
        System.out.println(" short[]");
        
        System.out.print(intArray);
        System.out.println(" int[]");
        
        System.out.print(longArray);
        System.out.println(" long[]");
        
        System.out.print(floatArray);
        System.out.println(" float[]");
        
        System.out.print(doubleArray);
        System.out.println(" double[]");
        
        System.out.print(objectArray);
        System.out.println(" objectArray[]");
        
        System.out.print(showNamesTypesArray);
        System.out.println(" showNamesTypesArray[]");
        
        objectArray = showNamesTypesArray;
    }
}
