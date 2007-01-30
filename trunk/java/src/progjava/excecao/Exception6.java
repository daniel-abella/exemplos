package progjava.excecao;
public class Exception6 {

    public static int f() {
        try {
            System.out.print("1 ");
            return 3;
        } finally {
            System.out.print("2 ");
        }
    }

    public static void main(String[] args) {
        try {
            System.out.print(f() + " ");
            return;
        } finally {
            System.out.print("4");
        }
    }
}