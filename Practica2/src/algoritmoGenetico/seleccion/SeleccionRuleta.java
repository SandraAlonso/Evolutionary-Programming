/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoGenetico.seleccion;

import algoritmoGenetico.individuos.Individuo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.SerializationUtils;

/**
 *
 * @author Diego
 */
public class SeleccionRuleta extends Seleccion {

	@Override
	public List<Individuo> run(List<Individuo> poblacion) {
		Double suma = 0.0;
		for (Individuo ind : poblacion) {
			suma += ind.getValor();
		}
		Integer numIndSelec = poblacion.size();
		Random rand = new Random();
		List<Individuo> NuevaPoblacion = new ArrayList<Individuo>();

		for (int i = 0; i < numIndSelec; i++) {
			Double alt = rand.nextDouble();
			Double acum = 0.0;
			for (Individuo ind : poblacion) {
				Double aux2 = (ind.getValor() + acum) / suma;

				if ((ind.getValor() + acum) / suma >= alt) {
					NuevaPoblacion.add((Individuo) SerializationUtils.clone(ind));
					break;
				}
				acum += ind.getValor();
			}
		}
		return NuevaPoblacion;
	}

}
