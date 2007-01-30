package progjava.casting;

public class OperacoesComBytes {
	public static void main(String[] args) {
		// Converte inteiro 127 para byte (há espaço)
		byte b2 = 127;
		
		b2 += 1;
		System.out.println(b2);
		
		// Cannot convert from int to byte
		// byte b3 = 128;
		

		byte b4 = 5;
		b4 = (int) 2;
		b4 = (short) 3;
		b4 += (float) 1;
		b4 -= Float.MIN_VALUE;
		b4 += 1f;
		b4 += 1L;
		b4 += 3.;
		
		// Cannot convert from int to byte
		// b4 = b4 + 2;

		// Nenhum problema com a linha abaixo
		// Compilador implicitamente fornece o casting (byte)
		b4 += 2;
		
		// Casting explícito
		b4 += 1280;
		
		short s1 = 32767;
		// Cannot convert from int to short
		// s1 = s1 + 1;
		
		// Casting fornecido pelo compilador
		s1 += 1;
		System.out.println(s1);
		s1 += 40000;
		s1 += Double.MAX_VALUE;
		
		int i1 = Integer.MAX_VALUE;
		i1 = i1 + 1;
		System.out.println(i1 == Integer.MIN_VALUE);
		
		// Cannot convert from long to int
		// i1 = 1 + Long.MAX_VALUE;
		// i1 = 1l;
		
		// Cannot convert from float to int
		// i1 = 1F;
		// i1 = 1f;
		// i1 = (float) 0;
		// i1 = 100 / 1.2f;
		// i1 = 1.2F / 3;
		
		// Casting implícito
		i1 += Long.MAX_VALUE;
		i1 += Double.MAX_VALUE;
		i1 -= 2f;
		
		float f1 = (float) Double.MAX_VALUE;
		f1 += Double.MAX_VALUE;
		
		// Cannot convert from double to float
		// f1 = Double.MAX_VALUE;
		// f1 = 0.0;
		// f1 = .1;
		// f1 = 1.0;
		// f1 = 1d;
		// f1 = 0D;
	}
}
