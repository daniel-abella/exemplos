package progjava.heranca.overriding;

class SuperClasse {
    private void doPrivate() {
    }

    void doDefault() {
    }

    protected void doProtected() {
    }

    public void doPublic() {
    }
}

public class Ex1 extends SuperClasse {
    protected void doPrivate() {
        System.out.println("doPrivate");
    }

    protected void doDefault() {
        System.out.println("doDefault");
    }

    public void doProtected() {
        System.out.println("doProtected");
    }

    public void doPublic() {
        System.out.println("doPublic");
    }

    public static void main(String[] args) {
        Ex1 e = new Ex1();
        e.doPrivate();
        e.doDefault();
        e.doProtected();
        e.doPublic();
    }
}

// N�o ocorre erro na linha 15.
// A linha 18 n�o � uma sobreposi��o do m�todo de mesmo nome em SuperClasse.
// Na linha 22 tem-se uma sobreposi��o v�lida do m�todo doDefault.
// A linha 30 n�o � o �nico exemplo de sobreposi��o v�lida na classe Ex1.