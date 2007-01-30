package progjava.retorno;

public class RetornoSimples {
	byte m1() {
		return 127;
	}
	
	byte m2() {
		// Apenas o que cabe em um byte
		// return 128;
		return (byte) 128;
	}
	
	short m3() {
		return Short.MAX_VALUE;
	}
	
	short m4() {
		// Sentença abaixo gera um int (exige cast)
		return (byte) (Short.MAX_VALUE - Short.MIN_VALUE);
	}
	
	int m5() {
		short s = 3;
		return s;
	}
	
	int m6() {
		return 'x';
	}
	
	long m7() {
		return Integer.MAX_VALUE + Integer.MAX_VALUE;
	}
	
	long m8() {
		return 'y';
	}
	
	float m9() {
		return Long.MAX_VALUE;
	}
	
	double m10() {
		return 2.3F;
	}
	
	double m11() {
		return Long.MAX_VALUE;
	}
}
