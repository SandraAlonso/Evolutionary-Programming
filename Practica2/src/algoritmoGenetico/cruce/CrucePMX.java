package algoritmoGenetico.cruce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import algoritmoGenetico.individuos.Individuo;

public class CrucePMX extends Cruce {
	@Override
	public List<Individuo> run(List<Individuo> poblacion) {
		for (int i = 0; i < poblacion.size(); i += 2) {
			// 9 8 9
			Integer[] cromosoma1 = new Integer[26];
			Integer[] cromosoma2 = new Integer[26];

			// Vectores de marcas
			List<Boolean> marcas1 = new ArrayList<Boolean>(Collections.nCopies(cromosoma1.length, false));
			List<Boolean> marcas2 = new ArrayList<Boolean>(Collections.nCopies(cromosoma1.length, false));

			// Cambiados valores centrales
			for (int j = 9; j < 17; j++) {
				cromosoma1[j] = (Integer) poblacion.get(i + 1).getCromosoma()[j];
				cromosoma2[j] = (Integer) poblacion.get(i).getCromosoma()[j];
				marcas1.set(cromosoma1[j], true);
				marcas2.set(cromosoma2[j], true);
			}
			// Cromosoma ult parte
			for (int j = 17; j < cromosoma1.length; j++) {
				if (!marcas1.get((int) poblacion.get(i).getCromosoma()[j])) {
					cromosoma1[j] = (Integer) poblacion.get(i).getCromosoma()[j];
					marcas1.set(cromosoma1[j], true);
				} else
					cromosoma1[j] = -1;
				if (!marcas2.get((int) poblacion.get(i + 1).getCromosoma()[j])) {
					cromosoma2[j] = (Integer) poblacion.get(i + 1).getCromosoma()[j];
					marcas2.set(cromosoma2[j], true);
				} else
					cromosoma2[j] = -1;

			}

			// Cromosoma pri parte

			for (int j = 0; j < 17; j++) {

				if (!marcas1.get((int) poblacion.get(i).getCromosoma()[j])) {
					cromosoma1[j] = (Integer) poblacion.get(i).getCromosoma()[j];
					marcas1.set(cromosoma1[j], true);
				} else
					cromosoma1[j] = -1;
				if (!marcas2.get((int) poblacion.get(i + 1).getCromosoma()[j])) {
					cromosoma2[j] = (Integer) poblacion.get(i + 1).getCromosoma()[j];
					marcas2.set(cromosoma2[j], true);
				} else
					cromosoma2[j] = -1;

			}

			// Relleno de cromosoma1
			for (int j = 0; j < cromosoma1.length; j++) {
				if (cromosoma1[j] == -1) {
					int num = (int) poblacion.get(i).getCromosoma()[j];
					for (int k = 0; k < cromosoma2.length; k++) {
						if (poblacion.get(i + 1).getCromosoma()[k].equals(num)) {
							cromosoma1[j] = (Integer) poblacion.get(i).getCromosoma()[j];
							break;
						}
					}
				}
			}
			// Relleno de cromosoma2
			for (int j = 0; j < cromosoma2.length; j++) {
				if (cromosoma2[j] == -1) {
					int num = (int) poblacion.get(i + 1).getCromosoma()[j];
					for (int k = 0; k < cromosoma1.length; k++) {
						if (poblacion.get(i).getCromosoma()[k].equals(num)) {
							cromosoma2[j] = (Integer) poblacion.get(i + 1).getCromosoma()[j];
							break;
						}
					}
				}
			}

			poblacion.get(i).setCromosoma(cromosoma1);
			poblacion.get(i + 1).setCromosoma(cromosoma2);
		}
		return poblacion;
	}
}
