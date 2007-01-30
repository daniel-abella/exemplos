package progjava.interfaceexp;

// Interfaces does not need to be explicitly declared abstract
// Even when we use the unecessary modifier abstract for the
// operations declared (see the example below).
interface Qualquer1 {}
abstract interface X {}
interface Y { public abstract void faz(); }

// Instead of interfaces, if a class contains an abstract
// method, the class must be declared abstract. This is not
// an option, you have to declare the class abstract.
abstract class C1 {}
abstract class C2 { abstract void faz(); }

public class AbstractInterface {

}
