package progjava.arrays;

import java.util.Arrays;
import java.util.List;

public class ArraysAsList {
    public static void main(String... args) {
        List<Float> fs = Arrays.asList(1f,2f,3f);
        System.out.println(fs);
        
        List<Double> ds = Arrays.asList(new Double[] {1d,2.5,3D});
        System.out.println(ds);
        
        Object[] afs = fs.toArray(new Float[]{});
        System.out.println(Arrays.toString(afs));
        
        Float[] an = (Float[]) afs;
        System.out.println(Arrays.toString(an));
        
        Object[] oa = afs; 
    }
}
