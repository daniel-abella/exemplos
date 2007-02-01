package p04;

public class ProgramaTrivial {
	private int x;

	public static void main(String[] args) {
		new ProgramaTrivial().x = 2; // Jamais será recuperado!
	}
}
