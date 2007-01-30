package progjava.fim;

import java.io.Serializable;

class Call {
    static void faz(CharSequence s) { System.out.println("string"); }
    static void faz(Serializable s) { System.out.println("Serializable"); }
    static void faz(Object o) {}
    public static void main(String[] args) {
	faz((Serializable)new String());
	faz((Object)null);
    }
}
