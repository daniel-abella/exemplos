package progjava.object;

public class O4 {
    int v = 0;

    public int hashCode() {
        return v;
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String[] args) {
        O4 o = new O4();
        System.out.println(o);
        System.out.println(o.getClass().getName() + '@' + o.hashCode());
    }
}