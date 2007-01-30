package progjava.excecao;

public class ArrayStoreExceptionExample {
	public static void main(String[] args) {
		Object[] aobjs = new String[] { "A" };
		aobjs[0] = new Byte((byte) 1);
	}
}
