package progjava.misc;

interface UsaSequencia {

    public void usaSequencia(int[] seq);
}

class Gerador {

    UsaSequencia us = null;
    int szSeq = 0;
    int szDom = 0;
    int[] v = null;

    public Gerador(UsaSequencia us, int szSeq, int szDom) {
        super();
        this.us = us;
        this.szSeq = szSeq;
        this.szDom = szDom;
        v = new int[szSeq + 1];
        v[0] = 0;
    }

    public void gerador() {
        gera(1);
    }

    private void gera(int k) {
        for (v[k] = v[k - 1] + 1; v[k] <= szDom; v[k]++) {
            if (k == szSeq) {
                us.usaSequencia(v);
            } else {
                gera(k + 1);
            }
        }
        v[k]--;
    }
}

public class RecursaoV3 implements UsaSequencia {

    static int contador = 0;

    public void usaSequencia(int[] v) {
        System.out.print("\n" + (++contador));
        for (int i = 1; i <= 15; i++) {
            System.out.print(" " + v[i]);
        }
    }

    public static void main(String[] args) {
        Gerador grd = new Gerador(new RecursaoV3(), 15, 18);
        grd.gerador();
    }
}