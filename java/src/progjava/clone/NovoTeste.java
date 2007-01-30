package progjava.clone;

class XYZ {
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

public class NovoTeste {
	public static void main(String[] args) throws Exception {
		new XYZ().clone();
	}
}
