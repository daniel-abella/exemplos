package p08;

public class B {
    private Long id;
    
    //  Para cada instância de B, há uma de A
    private A a;     
    
	public A getA() {
		return a;
	}

	public void setA(A a) {
		this.a = a;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String toString() {
		return "B: " + id.toString() + " (" + a + ")";
	}
}
