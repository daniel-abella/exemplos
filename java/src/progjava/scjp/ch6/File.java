package progjava.scjp.ch6;

import java.io.PrintWriter;
import java.io.IOException;

public class File {
    static public void main(String ... args) throws IOException {
	PrintWriter fw = new PrintWriter("c:/tmp/teste.txt");
	fw.println("ok");
	fw.print("ok again");
	fw.flush();
	fw.close();
    }
}
