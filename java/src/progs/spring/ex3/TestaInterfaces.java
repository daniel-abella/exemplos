package ex3;

public class TestaInterfaces {
    public static void main(String[] args) {
        IA ia = (IA) Aplicacao.bf.getBean("IA");
        ia.fazA();
        
        IGeral ig = (IGeral) Aplicacao.bf.getBean("IC");
        ig.faz();
        
        IB ib = (IB) Aplicacao.bf.getBean("IB1");
        ib.faz();
        
        ib = (IB) Aplicacao.bf.getBean("IB2");
        ib.faz();
    }

}
