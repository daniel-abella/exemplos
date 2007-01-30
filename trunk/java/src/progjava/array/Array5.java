package progjava.array;

class Numero {
    int n;

    int getN() {
        return n;
    }
}

public class Array5 {
    public static void main(String[] args) {
        Numero[] aN = new Numero[2];
        aN[0] = new Numero();
        aN[1] = new Numero();
        System.out.println(aN[0].getN() + aN[1].getN());
    }
}
