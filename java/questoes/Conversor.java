package xml;

public class Conversor {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("USO: java Conversor <xml> <xsl> <saida>");
            System.exit(1);
        }
    }
}