package progjava.fim;

import java.io.*;

class AbstractAndStatic {    
    abstract static class X {	
	//X(int i) {}
    }

    class Y extends X {}

    Number[] ns = new Integer[3];
    Serializable[] ss = new Externalizable[3];
    Object a[] = { null };
    int x = 3;
    {  System.out.println(x); }
    public static void main(String ... ar) {
	new AbstractAndStatic();}
}
