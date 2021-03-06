package com.pevolutiva.practica1.algoritmoGenetico.cruce;

import java.util.List;
import java.util.Random;

import com.pevolutiva.practica1.algoritmoGenetico.individuos.Individuo;

public class CruceMonoPunto extends Cruce {

	@Override
	public List<Individuo> run(List<Individuo> seleccionados) {
		Random rand = new Random();
		for (int i = 0; i < seleccionados.size() - 1; i += 2) {
			Boolean[] c1 = (Boolean[]) seleccionados.get(i).getCromosoma();
			Boolean[] c2 = (Boolean[]) seleccionados.get(i + 1).getCromosoma();
			int alt = rand.nextInt(c1.length);

			for (int j = alt; j < c1.length; j++) {
				boolean datoc1 = c1[j];
				c1[j] = c2[j];
				c2[j] = datoc1;
			}
			seleccionados.get(i).setCromosoma(c1);
			seleccionados.get(i + 1).setCromosoma(c2);
		}

		return seleccionados;
	}

}
