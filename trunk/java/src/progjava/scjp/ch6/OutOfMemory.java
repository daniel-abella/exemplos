package progjava.scjp.ch6;

class OutOfMemory {
    static public void main(String ... args) {
	String str = "oXo";
	for (long l = 0; l < 1000 * 1000 * 1000; l++)
	    str = new String(str = str.replace('X', 'Y'));
    }
}
