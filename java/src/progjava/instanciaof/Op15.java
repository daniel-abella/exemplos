package progjava.instanciaof;

interface IntAluno {}
class Aluno implements IntAluno {}

public class Op15 {
    public static void main(String[] args) {
        Aluno a = new Aluno();
        System.out.println(a instanceof IntAluno);
        Object obj = new Object();
        System.out.println(obj instanceof java.lang.Object);
    }
}
