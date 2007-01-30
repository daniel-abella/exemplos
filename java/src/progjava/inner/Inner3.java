package progjava.inner;

public class Inner3 {
    public Interna i;

    private class Interna {
        Interna() {
            System.out.println("Interna ...");
        }

        public void fazAlgo() {
            System.out.printf("%s (%b)\n",i, i == this);
        }
    }

    public Inner3() {
    	System.out.println("Externa...");
        i = this.new Interna();
    }

    public static void main(String[] args) {
        Inner3 ref = new Inner3();
        Inner3.Interna refII = ref.i;
        refII.fazAlgo();
    }
}
