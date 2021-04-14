package algoritmoGenetico.cruce;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import algoritmoGenetico.individuos.Individuo;

public class CruceERX extends Cruce {

	@Override
	public List<Individuo> run(List<Individuo> poblacion) {
		for (int i = 0; i < poblacion.size(); i += 2) {

			Integer[] cromosoma1 = new Integer[26];
			Integer[] cromosoma2 = new Integer[26];

			List<Set<Integer>> matriz = new ArrayList(cromosoma1.length);
			List<Boolean> marcas = new ArrayList(cromosoma1.length);

			for (Set<Integer> s : matriz) {
				s = new HashSet<Integer>();
			}

			// Primer caso
			matriz.get((int) poblacion.get(i).getCromosoma()[0]).add((Integer) poblacion.get(i).getCromosoma()[1]);
			matriz.get((int) poblacion.get(i).getCromosoma()[0])
					.add((Integer) poblacion.get(i).getCromosoma()[poblacion.get(i).getCromosoma().length - 1]);

			// Resto de casos
			for (int j = 1; j < poblacion.get(i).getCromosoma().length - 1; j++) {
				matriz.get((int) poblacion.get(i).getCromosoma()[j])
						.add((Integer) poblacion.get(i).getCromosoma()[j - 1]);
				matriz.get((int) poblacion.get(i).getCromosoma()[j])
						.add((Integer) poblacion.get(i).getCromosoma()[j + 1]);
				matriz.get((int) poblacion.get(i + 1).getCromosoma()[j])
						.add((Integer) poblacion.get(i + 1).getCromosoma()[j - 1]);
				matriz.get((int) poblacion.get(i + 1).getCromosoma()[j])
						.add((Integer) poblacion.get(i + 1).getCromosoma()[j + 1]);
			}
			// Ultimo caso
			matriz.get((int) poblacion.get(i).getCromosoma()[poblacion.get(i).getCromosoma().length - 1])
					.add((Integer) poblacion.get(i).getCromosoma()[0]);
			matriz.get((int) poblacion.get(i).getCromosoma()[poblacion.get(i).getCromosoma().length - 1])
					.add((Integer) poblacion.get(i).getCromosoma()[poblacion.get(i).getCromosoma().length - 2]);

			// Primer individuo
			cromosoma1[0] = (Integer) poblacion.get(i).getCromosoma()[0];

			for (int j = 1; j < cromosoma1.length; j++) {
				int max = 0, elem = 0;
				for (Integer k : matriz.get(cromosoma1[j - 1])) {
					if (max < matriz.get(k).size() && !marcas.get(k)) {
						elem = k;
						max = matriz.get(k).size();
					}
				}
				cromosoma1[j] = elem;
				marcas.set(elem, true);
			}

			marcas = new ArrayList(cromosoma2.length);

			// Segundo individuo
			cromosoma2[0] = (Integer) poblacion.get(i + 1).getCromosoma()[0];

			for (int j = 1; j < cromosoma2.length; j++) {
				int max = 0, elem = 0;
				for (Integer k : matriz.get(cromosoma2[j - 1])) {
					if (max < matriz.get(k).size() && !marcas.get(k)) {
						elem = k;
						max = matriz.get(k).size();
					}
				}
				cromosoma2[j] = elem;
				marcas.set(elem, true);
			}

			poblacion.get(i).setCromosoma(cromosoma1);
			poblacion.get(i + 1).setCromosoma(cromosoma2);
		}
		return poblacion;
	}

}
