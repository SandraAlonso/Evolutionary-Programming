/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pevolutiva.practica1.algoritmoGenetico.seleccion;

import com.pevolutiva.practica1.algoritmoGenetico.individuos.Individuo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.SerializationUtils;

/**
 *
 * @author Diego
 */
public class SeleccionRestos extends Seleccion {

	@Override
	public List<Individuo> run(List<Individuo> poblacion) {

		Double suma = 0.0;

		for (Individuo ind : poblacion) {
			suma += ind.getValor();
		}

		Integer numIndSelec = poblacion.size();
		Random rand = new Random();

		List<Individuo> NuevaPoblacion = new ArrayList<Individuo>();

		for (int i = 0; i < poblacion.size(); ++i) {
			if ((poblacion.get(i).getValor() / suma) * poblacion.size() > 1) {
				// Redondeamos hacia arriba
				int nuevosInd = (int) Math.ceil(poblacion.get(i).getValor() / suma);
				for (int j = 0; j < nuevosInd; j++) {
					NuevaPoblacion.add((Individuo) SerializationUtils.clone(poblacion.get(j)));
				}
			}
		}
		if (NuevaPoblacion.size() < poblacion.size()) {// Tenemos que rellenar por otro metodo
			SeleccionTorneo s = new SeleccionTorneo(); // Escogemos torneo porque así nos aseguramos que quedan los
														// mejores y además nos proporciona copias repetidas
			List<Individuo> poblacionExtra = s.run(poblacion);
			int diferencia = poblacion.size() - NuevaPoblacion.size();
			for (int i = 0; i < diferencia; i++) {
				NuevaPoblacion.add((Individuo) SerializationUtils.clone(poblacion.get(i)));
			}
		}

		return NuevaPoblacion;
	}

}