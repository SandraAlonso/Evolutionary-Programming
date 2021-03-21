package com.pevolutiva.practica1.algoritmoGenetico.mutacion;

import java.util.List;
import java.util.Random;

import com.pevolutiva.practica1.algoritmoGenetico.individuos.Individuo;

public class MutacionUniforme extends Mutacion {

	@Override
	public List<Individuo> run(List<Individuo> poblacion, Double porcentMut) {
		Random rand = new Random();
		for (int i = 0; i < poblacion.size(); i++) {
			Double[] c = (Double[]) poblacion.get(i).getCromosoma();
			for (int j = 0; j < poblacion.get(i).getCromosoma().length; j++) {
				Double alt = rand.nextDouble();
				if (porcentMut > alt) { // mutamos
					c[j] = rand.nextDouble() * (poblacion.get(i).getMax()[j] - poblacion.get(i).getMin()[j]);
				}
			}
			poblacion.get(i).setCromosoma(c);
		}
		return poblacion;
	}

}
