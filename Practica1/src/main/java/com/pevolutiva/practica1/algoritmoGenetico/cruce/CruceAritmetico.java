package com.pevolutiva.practica1.algoritmoGenetico.cruce;

import java.util.List;

import com.pevolutiva.practica1.algoritmoGenetico.individuos.Individuo;

public class CruceAritmetico extends Cruce {

	@Override
	public List<Individuo> run(List<Individuo> seleccionados) {
		// TODO Auto-generated method stub
		Double alfa = 0.5;
		for (int i = 0; i < seleccionados.size() - 1; i += 2) {
			Double[] c1 = (Double[]) seleccionados.get(i).getCromosoma();
			Double[] c2 = (Double[]) seleccionados.get(i + 1).getCromosoma();

			for (int j = 0; j < c1.length; j++) {
				Double auxC1 = c1[j] * alfa + c2[j] * (1 - alfa);
				Double auxC2 = c2[j] * alfa + c1[j] * (1 - alfa);
				c1[j] = auxC1;
				c2[j] = auxC2;
			}
			seleccionados.get(i).setCromosoma(c1);
			seleccionados.get(i + 1).setCromosoma(c2);

		}
		
		return seleccionados;
	}

}
