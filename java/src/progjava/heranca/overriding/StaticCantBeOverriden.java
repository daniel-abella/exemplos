package progjava.heranca.overriding;

// Compiler error if ...
// Any static below is removed. If both are removed, then
// we have a classical case of overriding and everything 
// works fine.

class Super {
	static void faz() {
		System.out.println(Super.class.getName());
	}
}
public class StaticCantBeOverriden extends Super {
	static void faz() {
		System.out.println(StaticCantBeOverriden.class.getName());
	}
	
	public static void main(String... args) {
		StaticCantBeOverriden.faz();
		Super.faz();
		
		StaticCantBeOverriden scb = new StaticCantBeOverriden();
		scb.faz(); // Same as StaticCantBeoverriden.faz()
		Super sup = scb;
		
		// Same as Super.faz() (the reference type matters)
		// The object is the same, but the reference type is Super.
		// Remember that statics can not be overriden as well.
		sup.faz(); 
	}
}
