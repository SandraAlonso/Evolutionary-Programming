package com.pevolutiva.practica1.algoritmoGenetico.mutacion;

import java.util.List;
import java.util.Random;

import com.pevolutiva.practica1.algoritmoGenetico.individuos.Individuo;

public class MutacionBasica extends Mutacion {

	@Override
	public List<Individuo> run(List<Individuo> poblacion, Double porcentMut) {
		Random rand = new Random();
		for (int i = 0; i < poblacion.size(); i++) {
			Boolean[] c = (Boolean[]) poblacion.get(i).getCromosoma();
			for (int j = 0; j < poblacion.get(i).getCromosoma().length; j++) {
				Double alt = rand.nextDouble();
				if (porcentMut > alt) { // mutamos
					c[j] = !c[j];
				}
			}
			poblacion.get(i).setCromosoma(c);
		}
		return poblacion;
	}

}
