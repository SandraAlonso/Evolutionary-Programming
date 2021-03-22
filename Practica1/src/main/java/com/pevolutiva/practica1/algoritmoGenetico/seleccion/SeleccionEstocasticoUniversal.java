package com.pevolutiva.practica1.algoritmoGenetico.seleccion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.SerializationUtils;

import com.pevolutiva.practica1.algoritmoGenetico.individuos.Individuo;

public class SeleccionEstocasticoUniversal extends Seleccion {

	@Override
	public List<Individuo> run(List<Individuo> poblacion) {

		Double suma = 0.0;
		for (Individuo ind : poblacion) {
			suma += ind.getValor();
		}

		// Establecer una marcas equidistantes entre 0 y tamPoblacion;
		int a = 1 / poblacion.size();
		int p = poblacion.size();
		double distanciaMarcas = (1 / (double) poblacion.size());

		List<Individuo> NuevaPoblacion = new ArrayList<Individuo>();
		Integer numIndSelec = poblacion.size();

		// Repetimos el proceso tantas veces como individuos queramos seleccionar.
		for (int i = 0; i < numIndSelec; i++) {
			Double acum = 0.0;

			// Recorremos toda la poblacion hasta encontrar el individuo que encaja
			for (int j = 0; j < poblacion.size(); j++) {

				Double posIndividuo = (distanciaMarcas + j - 1) / numIndSelec;
				if ((poblacion.get(j).getValor() + acum) / suma >= posIndividuo) {
					NuevaPoblacion.add((Individuo) SerializationUtils.clone(poblacion.get(j)));
					break;
				}
				acum += poblacion.get(j).getValor();
			}
		}
		System.out.println("Seleccion:");
		System.out.println(NuevaPoblacion);
		System.out.println("Nuevo de seleccionados:");
		System.out.println(NuevaPoblacion.size());

		return NuevaPoblacion;
	}

}
