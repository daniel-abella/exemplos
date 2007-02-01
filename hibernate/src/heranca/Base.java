package heranca;

public class Base {
    private Long id;
    private int base;
    
    public int getBase() {
        return base;
    }
    
    public void setBase(int base) {
        this.base = base;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String toString() {
    	return id + " " + base;
    }
}
