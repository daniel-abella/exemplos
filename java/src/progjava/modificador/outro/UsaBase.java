package progjava.modificador.outro;

import progjava.modificador.Base;

public class UsaBase {
    public static void main(String[] args) {
        Base b = Base.getInstance();
        b.m();
        System.out.println("b.m() retorna void");
    }
}
