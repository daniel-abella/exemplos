package progjava.misc;

strictfp abstract class ClasseNome {
    private int teste;

    abstract void foof();

    int getTeste() {
        return teste;
    }
}

public class Mod1 extends ClasseNome {
    strictfp void foof() {
    }

    public static void main(String[] args) {
        Mod1 app = new Mod1();
        System.out.println(app.getTeste());
    }
}
