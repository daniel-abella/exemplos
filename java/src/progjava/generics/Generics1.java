package progjava.generics;

public class Generics1<T> {
    // Static member can not use type parameter!
    // static T x;
    T x;
    Object faz() { return x; }

    // It is not permitted to create an instance of type parameter
    // Object faz(int i) { return new T(); }
}
	
