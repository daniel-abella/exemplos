package progjava.scjp.ch6;

import static java.lang.System.out;

class Strings {
    public static void main(String... args) {
	String s = "ab";
	out.println(s);
	s = "ok";
	out.println(s);
	s = "fabio nogueira de lucena";
        System.out.println("nogueira".equals(s.substring(6,14)));
	s = "   entre espacos   ";
	System.out.println(s.length()+" "+s);
	System.out.println(s.trim().length()+" "+s.trim());
	s = "F�bio Nogueira de Lucena";
	System.out.print("f�bio nogueira de lucena".equalsIgnoreCase(s));
	System.out.println("f�bio nogueira de lucena".equals(s));
	System.out.println(s.trim().concat(" sem espacos"));
	System.out.println(s.concat(Integer.toString(3)));	
	System.out.println((s = "teste").concat(Float.toString(1f)));
	int i = 4;
	float f = i;
	System.out.println(s.concat(Float.toString(i)));
	System.out.println(s.substring(i));
	byte b = 3;
	System.out.println(s.substring(b).toString() );
    }
}
