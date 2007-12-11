package progjava.enumeration;

public enum Metrica {
    GunningFog, 
    ColemanLiau, 
    AutomatedReadability, 
    FleschKincaidReadability, 
    Smog, 
    FryReadability;

    public static Metrica getMetrica(String nome) {
    	for (Metrica m : Metrica.values()) {
    		if (m.name().equalsIgnoreCase(nome))
    			return m;
    	}
    	return null;
    }
    
    public static Metrica getMetrica2(String nome) {
    	Metrica retorno = null;
    	try {
    		return Metrica.valueOf(nome);
    	} catch (IllegalArgumentException iae) {
    	}
    	return null;
    }
    
    public static void main(String[] args) {
    		System.out.println(Metrica.getMetrica("gunningfog"));
    		System.out.println(Metrica.getMetrica2("GunningFog"));
    		System.out.println(Metrica.GunningFog == Metrica.Smog);
    		System.out.println(Metrica.Smog.ordinal());
	}
}