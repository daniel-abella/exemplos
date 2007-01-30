package progs.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsObject {
    public static void main(String[] args) {
        List<Object> l = new ArrayList<Object>();
        l.add("Uma string");
        l.add(23);
        System.out.println(l);
    }
}
