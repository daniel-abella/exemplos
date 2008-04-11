package com.example.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeerExpert {
	private static String[] light = { "l1" };
	private static String[] amber = { "a1", "a2" };
	private static String[] brown = { "b1", "b2", "b3" };
	private static String[] dark = { "d1", "d2", "d3", "d4" };
	
	private static Map<String,List<String>> dicionario;
	
	public BeerExpert() {
		dicionario = new HashMap<String,List<String>>();
		dicionario.put("light", Arrays.asList(light));
		dicionario.put("amber", Arrays.asList(amber));
		dicionario.put("brown", Arrays.asList(brown));
		dicionario.put("dark", Arrays.asList(dark));
	}
	
	public List<String> getBrands(String color) {
		List<String> retorno = dicionario.get(color);
		if (retorno == null) {
			return Arrays.asList(new String[] { "cor inválida" });
		}
		
		return retorno;
	}
}
