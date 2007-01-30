package progjava.array;

public class Assignment {
    char[] cArray = { 'a' };
    
    void atribuiArrays() {
        cArray = new char[1];
        cArray = new char[] { 'b' };
        char[] outroArray = cArray;
    }

}
