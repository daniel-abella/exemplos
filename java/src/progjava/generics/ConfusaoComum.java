package progjava.generics;


public class ConfusaoComum {
	public static void main(String[] args) {
		// Um array de Integer é moldado em uma referência para array de object
		// Este casting não causa nenhum problema e é válido em Java
		// Posteriormente tenta-se atribuir uma String a um array de Object
		// A atribuição é possível, exceto quando a referência é para um
		// array de Integer, onde não há espaço para Strings.
		// Resultado: ArrayStoreException
		((Object[]) (new Long[] { Long.valueOf(1) }))[0] = "ok";
		
	}

}
