package progjava.pattern;

import java.util.regex.*;

public class Pattern1 {
    public static void main(String[] args) {
	System.out.format("pattern = \'%s\'\nmatcher = \'%s\'\n",args[0],args[1]);
	Pattern p = Pattern.compile(args[0]);
	Matcher m = p.matcher(args[1]);
	System.out.printf("find:    %b\n", m.find());
	System.out.printf("matches: %b\n", m.matches());
    }
}
