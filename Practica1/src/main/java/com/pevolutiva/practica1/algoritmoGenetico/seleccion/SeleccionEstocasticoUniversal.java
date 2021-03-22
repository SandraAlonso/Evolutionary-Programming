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
		Double distanciaMarcas = (1 / (double) poblacion.size());

		Random rand = new Random();
		Double primeraMarca = rand.nextDouble() * distanciaMarcas; //para la primera marca entre el valor de cada distancia
		List<Individuo> NuevaPoblacion = new ArrayList<Individuo>();
		Integer numIndSelec = poblacion.size();

		// Repetimos el proceso tantas veces como individuos queramos seleccionar.
		
		Double acum = 0.0;
		int j = 0;
		for (int i = 0; i < numIndSelec; i++) {
			

			if( (primeraMarca + i * distanciaMarcas)  < 1) {
				Double aux = (primeraMarca + i * distanciaMarcas);
				Double aux2 = (acum + poblacion.get(j).getValor()) / suma;
				if((acum + poblacion.get(j).getValor()) / suma > primeraMarca + i * distanciaMarcas ) {
					NuevaPoblacion.add((Individuo) SerializationUtils.clone(poblacion.get(j)));
				}
				else {
					acum += poblacion.get(j).getValor();
					++j;
					NuevaPoblacion.add((Individuo) SerializationUtils.clone(poblacion.get(j)));
				}
			}
			else
				break;
			
		}
		System.out.println("Seleccion:");
		System.out.println(NuevaPoblacion);
		System.out.println("Nuevo de seleccionados:");
		System.out.println(NuevaPoblacion.size());

		return NuevaPoblacion;
	}

}
