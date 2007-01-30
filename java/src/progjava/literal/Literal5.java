package progjava.literal;

public class Literal5 {
    public static void main(String[] args) {

        // Array de 1M caracteres
        char charArray[] = new char[1024 * 1024];

        // string de 1MB caracteres
        String str1 = new String(charArray).intern();
        String str2 = new String(charArray).intern();
        System.out.println(str1 == str2);
        String str3 = String.valueOf(str1);
        System.out.println(str1.equals(str3) /* str3 == str1 */);
    }
}