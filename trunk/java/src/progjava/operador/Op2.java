package progjava.operador;

class Op2 {
    public static void main(String[] args) {

        byte b = 0, c = 0, d = 1;

// Todas as comparações são executadas
//        if ((++b == c++) & (++b == ++c) & (c++ == b++))
//            d = 1;
//        else
//            d = 2;

        if ((b != c) && (++b == ++c) && (++b == ++c))
            System.out.println("true");
        else
            System.out.println("false");

        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
    }
}
