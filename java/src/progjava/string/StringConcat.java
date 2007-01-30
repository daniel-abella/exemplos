package progjava.string;

/**
 * O método String.concat(String) não é sobrecarregado. Ou seja,
 * "#".concat(1) não compila, assim como "#".concat('1'), por exemplo.
 * @author Kyriosdata
 *
 */
public class StringConcat {
	public static void main(String[] args) {
		System.out.println("ok".concat(", você venceu!"));
		"a".concat("1");
	}
}
