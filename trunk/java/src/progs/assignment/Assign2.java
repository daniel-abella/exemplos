package progs.assignment;

class Ponto {
    public int x = 0;
    public int y = 0;
}

public class Assign2 {
    public static void main(String[] args) {
        Ponto p1 = new Ponto();
        Ponto p2 = new Ponto();
        p2.x = 10;
        System.out.println("p1.x = " + p1.x + " p2.x = " + p2.x);
        Ponto p3 = p1;
        p3.x = 10;
        System.out.println("p1.x = " + p1.x + " p2.x = " + p2.x);
    }
}
