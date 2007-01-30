package progjava.enumeration;


public enum Metrica {
    GunningFog, 
    ColemanLiau, 
    AutomatedReadability, 
    FleschKincaidReadability, 
    Smog, 
    FryReadability;

    public static Metrica getMetrica(String nome) {
    	Metrica metrica = null;
    	for (Metrica m : Metrica.values()) {
    		if (m.name().equals(nome))
    			return m;
    	}
    	return null;
    }
    
    public static void main(String[] args) {
    		System.out.println(Metrica.getMetrica("GunningFog"));
	}
}
