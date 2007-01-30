package progjava.misc;

public class TesteProgramaTrivial {
    public static void main(String args[]) {
        ProgramaTrivial pt = new ProgramaTrivial();
        pt.setX(-234);
        pt.setX(-1);
        pt.setX(234);
        System.out.println(pt.getX());
    }
}
