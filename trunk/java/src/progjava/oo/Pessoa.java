/*
 * Pessoa.java vers�o 1.0 07/10/2003 
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.oo;

public class Pessoa {}
class PessoaFisica extends Pessoa {}
class PessoaJuridica extends Pessoa {}

class TestePessoas {
    public static void fazUso(Pessoa p) {
        System.out.println("P");
    }

    public static void fazUso(PessoaFisica pf) {
        System.out.println("F");
    }

    public static void fazUso(PessoaJuridica pj) {
        System.out.println("J");
    }

    public static void main(String[] args) {
        Pessoa p1 = new PessoaFisica();
        Pessoa p2 = new PessoaJuridica();
        fazUso(new Pessoa());
        fazUso(p1);
        fazUso(p2);
    }
}
