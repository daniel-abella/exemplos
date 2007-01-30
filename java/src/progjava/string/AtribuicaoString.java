package progjava.string;

public class AtribuicaoString {
    public static void main(String[] args) {
        String s1 = "";
        String s2 = "ok";
        String s3 = s1;
        s1 = s2;
        if (s3.equals(s1)) {
            System.out.println("OK");
        }
    }
}