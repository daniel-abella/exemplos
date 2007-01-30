package progjava.misc;
public class Static {
    static int count = 0;

    public int getCount() {
        return count;
    }

    public Static() {
        count++;
    }
}
