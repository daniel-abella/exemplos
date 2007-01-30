package progjava.clone;

public class SemClone {
    private int[] arrayInts = new int[2];
    
    public void setArray(int[] newArray) {
         arrayInts = newArray;        
    }
    
    public int[] getArray() {
        return (int[]) arrayInts.clone();
    }
    
    public String toString() {
        String s = "";
        for (int i = 0; i < arrayInts.length; i++) {
            s = s + " " + arrayInts[i];
        }
        
        return s;
    }
}