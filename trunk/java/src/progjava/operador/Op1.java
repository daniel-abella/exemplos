package progjava.operador;

class Op1 {
    public static void main(String[] args) {

        byte b = (byte) 128;

        System.out.println(b);

        // Inverta todos os bits e some 1 o que resulta em ...
        // o mesmo padr�o de bits que se tinha em (byte) 128.
        b = (byte) (~b + 1);

        System.out.println(b);

        // Operador de atribui��o composto (faz casting impl�cito)
        b += (3 + 2) * 2l + 1.3e+12;
    }
}
