package progjava.colecao;

public class Equals6 {
    private int valor;

    Equals6(final int valor) {
        this.valor = valor;
    }

    @Override
	public boolean equals(final Object o) {
        return (o instanceof Equals6) && (valor == ((Equals6) o).valor);
    }
    
    @Override
	public int hashCode() {
        return super.hashCode();
    }

    public static void main(final String[] args) {
        final Equals6 a = new Equals6(5);
        final Equals6 b = new Equals6(5);

        System.out.println(a.equals(b));
    }
}