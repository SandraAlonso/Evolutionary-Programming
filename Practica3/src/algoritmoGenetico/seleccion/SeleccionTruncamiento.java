/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoGenetico.seleccion;

import algoritmoGenetico.individuos.Individuo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.SerializationUtils;

/**
 *
 * @author Diego
 */
public class SeleccionTruncamiento extends Seleccion {

	@Override
	public List<Individuo> run(List<Individuo> poblacion) {

		List<Individuo> copyPoblacion = new ArrayList<Individuo>(poblacion);
		List<Individuo> NuevaPoblacion = new ArrayList<Individuo>();
		Collections.sort(copyPoblacion, (a, b) -> b.getValor().compareTo(a.getValor()));

		Double trunc = 0.5;
		Integer selec = (int) (1 / trunc);
		Integer numSelec = poblacion.size() / selec;

		// Nos aseguramos de que sea un numero par la seleccion
		if (numSelec % 2 != 0) {
			numSelec += 1;
		}

		for (int i = 0; i < numSelec; ++i) {
			for (int j = 0; j < selec; ++j) {
				NuevaPoblacion.add((Individuo) SerializationUtils.clone(copyPoblacion.get(i)));
			}
		}

		return NuevaPoblacion;
	}

}