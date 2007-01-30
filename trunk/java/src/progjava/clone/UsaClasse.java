
package progjava.clone;

public class UsaClasse {
    
    public static void main(String[] args) {
        SemClone sc = new SemClone();
        int[] aInt = new int[] { 1, 2 }; 
        sc.setArray(aInt);
        
        System.out.println(sc); // 1 2
        aInt[0] = 99;
        aInt[1] = -4;
        System.out.println(sc); // 99 -4
        
        ComClone cc = new ComClone();
        cc.setArray(aInt);
        
        System.out.println(cc); // 99 -4
        aInt[0] = 0;
        aInt[1] = 5;
        System.out.println(cc); // 99 -4
        
    }

}
