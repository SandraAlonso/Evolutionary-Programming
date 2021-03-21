package com.pevolutiva.practica1.algoritmoGenetico.cruce;

import java.util.List;
import java.util.Random;

import com.pevolutiva.practica1.algoritmoGenetico.individuos.Individuo;

class CruceUniformeReal extends Cruce {

	@Override
	public List<Individuo> run(List<Individuo> seleccionados) {
		Random rand = new Random();
		for (int i = 0; i < seleccionados.size() - 1; i += 2) {
			Double[] c1 = (Double[]) seleccionados.get(i).getCromosoma();
			Double[] c2 = (Double[]) seleccionados.get(i + 1).getCromosoma();

			for (int j = 0; j < c1.length; j++) {
				Double alt = rand.nextDouble();
				if (alt > 0.5) { // intercambias
					Double datoc1 = c1[j];
					c1[j] = c2[j];
					c2[j] = datoc1;
				}
			}
			seleccionados.get(i).setCromosoma(c1);
			seleccionados.get(i + 1).setCromosoma(c2);

		}
		return seleccionados;

	}

}
