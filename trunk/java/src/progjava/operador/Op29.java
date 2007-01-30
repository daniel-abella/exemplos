package progjava.operador;

public class Op29 {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(0x00000001));
        System.out.println(Integer.toBinaryString( (0x00000001<<31) >> 31));
    }
}
