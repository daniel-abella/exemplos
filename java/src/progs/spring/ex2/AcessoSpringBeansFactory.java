package ex2;

public class AcessoSpringBeansFactory {
    public static void main(String[] args) {
        TiposBasicos tb = null;
        tb = (TiposBasicos) Aplicacao.bf.getBean("ex2");
        
        System.out.println(tb);
    }
}
