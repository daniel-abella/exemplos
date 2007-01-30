package progjava.inner;

interface X { public abstract void fazendo() throws Exception; }
abstract class A { abstract void faz(); } 
abstract class B extends A implements X {}
public class Inner18 {
	B b = new B() { public void fazendo() {} public void faz() {} };
}
