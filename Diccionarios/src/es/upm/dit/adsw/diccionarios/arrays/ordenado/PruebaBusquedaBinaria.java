package es.upm.dit.adsw.diccionarios.arrays.ordenado;

import java.util.ArrayList;

public class PruebaBusquedaBinaria {
	
	public static void main(String[] args) {
		DiccionarioPersonas dp = new DiccionarioPersonas();
		
		for(int i = 0; i < 20; i+=2) {
			dp.put(new Persona(i+"", "n"+i));
		}
		System.out.println(dp.get(new Persona("10", null)));
		
	}

}
