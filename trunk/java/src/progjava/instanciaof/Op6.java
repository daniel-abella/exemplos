package progjava.instanciaof;

class Base {
}

class Op6 extends progjava.instanciaof.Base {

    public static void main(String[] args) {
        Object obj = new Op6();

        if (obj instanceof Op6 & obj instanceof progjava.instanciaof.Base)
            System.out.println("Instância de " + Op6.class.getName());

        progjava.instanciaof.Base b = (progjava.instanciaof.Base) obj;
        if (b instanceof Op6)
            System.out.println("Instância de " + Base.class.getName());
    }
}
