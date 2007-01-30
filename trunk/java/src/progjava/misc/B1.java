
package progjava.misc;
abstract public class B1 {
    abstract void m();
}

class B2 extends B1 {


    void m() {
        int i = 0;
        i = (i > 0) ? 1 : 0;
    }

    int j = 1;
}
