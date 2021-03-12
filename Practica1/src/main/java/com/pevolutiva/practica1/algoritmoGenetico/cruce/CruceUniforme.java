package com.pevolutiva.practica1.algoritmoGenetico.cruce;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.pevolutiva.practica1.algoritmoGenetico.individuos.Individuo;

public class CruceUniforme extends Cruce {

	@Override
	public List<Individuo> run(List<Individuo> seleccionados) {
		Random rand = new Random();
		for (int i = 0; i < seleccionados.size() - 1; i += 2) {
			Boolean[] c1 = (Boolean[]) seleccionados.get(i).getCromosoma();
			Boolean[] c2 = (Boolean[]) seleccionados.get(i + 1).getCromosoma();

			for (int j = 0; j < c1.length; i++) {
				Double alt = rand.nextDouble();
				if (alt > 0.5) { // intercambias
					boolean datoc1 = c1[i];
					c1[i] = c2[i];
					c2[i] = datoc1;
				}
			}

		}
		return seleccionados;

	}

}
