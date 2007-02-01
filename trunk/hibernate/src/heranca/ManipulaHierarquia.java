package heranca;

public class ManipulaHierarquia {
    public static void main(String[] args) {
        HibernateUtils.start();
        
        Base b = new Base();
        b.setBase(0);
        
        D1 d1 = new D1();
        d1.setD1("d1");
        
        D2 d2 = new D2();
        d2.setD2(2.0);
        
        //HibernateUtils.persiste(b);
        HibernateUtils.persiste(d1);
        HibernateUtils.persiste(d2);
    }
}
