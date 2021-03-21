package com.pevolutiva.practica1.algoritmoGenetico.cruce;

import java.util.List;
import java.util.Random;

import com.pevolutiva.practica1.algoritmoGenetico.individuos.Individuo;

public class CruceBLXa extends Cruce {

	@Override
	public List<Individuo> run(List<Individuo> seleccionados) {
		Random rand = new Random();
		Double alfa = 0.5;
		for (int i = 0; i < seleccionados.size() - 1; i += 2) {
			
			Double[] c1 = (Double[]) seleccionados.get(i).getCromosoma();
			Double[] c2 = (Double[]) seleccionados.get(i + 1).getCromosoma();
			Double cMax = c1[i];
			Double cMin = c1[i];
			for (int j = 0; j < c1.length; j++) {
				if(cMax < c1[j]) {
					cMax = c1[j];
				}
				if(cMax < c2[j]) {
					cMax = c2[j];
				}
				if(cMin > c1[j]) {
					cMin = c1[j];
				}
				if(cMin > c2[j]) {
					cMin = c2[j];
				}
			}
			Double I = cMax - cMin;
			Double[] h1 = (Double[]) new Double[c1.length];
			Double[] h2 = (Double[]) new Double[c2.length];
			
			for(int j = 0; j < h1.length; ++j) {
				h1[j] = rand.nextDouble() * ((cMax + I * alfa) - (cMin - I * alfa));
				h2[j] = rand.nextDouble() * ((cMax + I * alfa) - (cMin - I * alfa));
			}
			
			seleccionados.get(i).setCromosoma(c1);
			seleccionados.get(i + 1).setCromosoma(c2);

		}
		return seleccionados;
	}

}
