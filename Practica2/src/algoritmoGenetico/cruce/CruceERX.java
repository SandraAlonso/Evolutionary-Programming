package algoritmoGenetico.cruce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import algoritmoGenetico.individuos.Individuo;

public class CruceERX extends Cruce {

	@Override
	public List<Individuo> run(List<Individuo> poblacion) {
		for (int i = 0; i < poblacion.size(); i += 2) {

			Integer[] cromosoma1 = new Integer[26];
			Integer[] cromosoma2 = new Integer[26];
			
			Random rand = new Random();

			List<Set<Integer>> matriz = new ArrayList();
			List<Boolean> marcas = new ArrayList(Collections.nCopies(cromosoma1.length, false));

			for (int j = 0; j < cromosoma2.length; j++) {
				matriz.add(new HashSet<Integer>());
				
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
			
			int contadorBloqueo = 0;
			while(true) {
				// Primer individuo
				
				cromosoma1[0] =  rand.nextBoolean() ? (Integer) poblacion.get(i).getCromosoma()[0]: (Integer) poblacion.get(i + 1).getCromosoma()[0];
				if(contadorBloqueo >= 10) {
					cromosoma1[0] = rand.nextInt(25);
				}
				marcas = new ArrayList(Collections.nCopies(cromosoma1.length, false));
				marcas.set(cromosoma1[0], true);
				boolean bloqueo = true;
				for (int j = 1; j < cromosoma1.length; j++) {
					int min = 5, elem = 0;
					bloqueo = true;
					for (Integer k : matriz.get(cromosoma1[j - 1])) {
						if (!marcas.get(k)) {
							if(min > matriz.get(k).size() || (min == matriz.get(k).size() && rand.nextBoolean())) {
								bloqueo = false;
								elem = k;
								min = matriz.get(k).size();
							}
						}
					}
					if(bloqueo)
						break;
					cromosoma1[j] = elem;
					marcas.set(elem, true);
				}
				if(!bloqueo) {
					break;
				}
				++contadorBloqueo;
				if(contadorBloqueo >= 100) {
					cromosoma1 = (Integer[]) poblacion.get(i).getCromosoma();
					break;
				}
				
			}
			
			contadorBloqueo = 0;
			while(true) {
				// Primer individuo
				
				cromosoma2[0] = rand.nextBoolean() ? (Integer) poblacion.get(i).getCromosoma()[0]: (Integer) poblacion.get(i + 1).getCromosoma()[0];
				if(contadorBloqueo >= 10) {
					cromosoma1[0] = rand.nextInt(25);
				}
				marcas = new ArrayList(Collections.nCopies(cromosoma1.length, false));
				marcas.set(cromosoma2[0], true);
				boolean bloqueo = true;
				for (int j = 1; j < cromosoma2.length; j++) {
					int min = 5, elem = 0;
					bloqueo = true;
					for (Integer k : matriz.get(cromosoma2[j - 1])) {
						if (!marcas.get(k)) {
							if(min > matriz.get(k).size() || (min == matriz.get(k).size() && rand.nextBoolean())) {
								bloqueo = false;
								elem = k;
								min = matriz.get(k).size();
							}
						}
					}
					if(bloqueo)
						break;
					cromosoma2[j] = elem;
					marcas.set(elem, true);
				}
				if(!bloqueo) {
					break;
				}
				++contadorBloqueo;
				if(contadorBloqueo >= 100) {
					cromosoma2 = (Integer[]) poblacion.get(i + 1).getCromosoma();
					break;
				}
			}
			

			poblacion.get(i).setCromosoma(cromosoma1);
			poblacion.get(i + 1).setCromosoma(cromosoma2);
		}
		return poblacion;
	}

}
