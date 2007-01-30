package progjava.operador;

class Bar {
    public int barNum = 28;
}

class Foo {
    private final Bar myBar = new Bar();

    static void changeIt(Bar myBar) {
        myBar.barNum = 99;
        System.out.println("myBar.barNum in changeIt is " + myBar.barNum);
        final Bar myBar2 = new Bar();
        myBar2.barNum = 420;
        System.out.println("myBar.barNum in changeIt is now " + myBar2.barNum);
    }

    public static void main(String[] args) {
        final Foo foo = new Foo();
        System.out.println("foo.myBar.barNum is " + foo.myBar.barNum);
        changeIt(foo.myBar);
        System.out.println("foo.myBar.barNum after changeIt is " + foo.myBar.barNum);
    }
}
