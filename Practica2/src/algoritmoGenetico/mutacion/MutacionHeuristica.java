package algoritmoGenetico.mutacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.SerializationUtils;

import algoritmoGenetico.AlgoritmoGenetico;
import algoritmoGenetico.individuos.Individuo;

public class MutacionHeuristica extends Mutacion {

	@Override
	public List<Individuo> run(List<Individuo> poblacion, Double porcentMut) {

		int n = 3;
		Random rand = new Random();

		for (int i = 0; i < poblacion.size(); ++i) {
			if (rand.nextDouble() < porcentMut) {
				AlgoritmoGenetico.totalMutaciones++;
				List<Integer> pos = new ArrayList<Integer>();
				for (int j = 0; j < n; j++) {
					while (true) {
						Integer aux = rand.nextInt(26);
						if (!pos.contains(aux)) {
							pos.add(aux);
							break;
						}

					}

				}
				List<Integer> perm = new ArrayList<>();
				for (Integer k : pos) {
					perm.add((Integer) poblacion.get(i).getCromosoma()[k]);
				}
				List<List<Integer>> posiblesPermutaciones = new ArrayList<>(perm.size());

				permutar(perm, 0, new ArrayList<Integer>(Collections.nCopies(n, -1)), posiblesPermutaciones,
						new ArrayList<Boolean>(Collections.nCopies(n, false)));

				Integer[] cromosomaAux = (Integer[]) poblacion.get(i).getCromosoma();

				int mejorVal = 0;
				for (int l = 0; l < posiblesPermutaciones.get(0).size(); l++) {
					cromosomaAux[pos.get(l)] = posiblesPermutaciones.get(0).get(l);
				}
				poblacion.get(i).setCromosoma(cromosomaAux);
				Double mejorPerm = poblacion.get(i).getValor();
				for (int k = 1; k < posiblesPermutaciones.size(); k++) {
					for (int l = 0; l < posiblesPermutaciones.get(k).size(); l++) {
						cromosomaAux[pos.get(l)] = posiblesPermutaciones.get(k).get(l);
					}
					poblacion.get(i).setCromosoma(cromosomaAux);
					if (mejorPerm < poblacion.get(i).getValor()) {
						mejorPerm = poblacion.get(i).getValor();
						mejorVal = k;
					}
				}

				for (int l = 0; l < posiblesPermutaciones.get(mejorVal).size(); l++) {
					cromosomaAux[pos.get(l)] = posiblesPermutaciones.get(mejorVal).get(l);
				}
				poblacion.get(i).setCromosoma(cromosomaAux);

			}
		}

		// TODO Auto-generated method stub
		return poblacion;
	}

	/*
	 * Funcion que dado un array de numeros, saca todas las posibles convinaciones
	 * 
	 * perm: lista a permutar ej: [1, 2, 3, 4] (el orden no es importante) n: entero
	 * que lleva la posicion actual. Debe empezar en 0 solAct: la solucion actual.
	 * Empieza siendo una lista vacia con el tama?o definido a perm.size() sol: la
	 * solucion final. Lista de lista de las posibles permutaciones marcas: una
	 * lista de booleanos que sirve para saber que numeros se estan usando
	 * 
	 */
	void permutar(List<Integer> perm, int n, List<Integer> solAct, List<List<Integer>> sol, List<Boolean> marcas) {
		if (n == perm.size() - 2) {
			Integer aux1 = -1, aux2 = -1;
			for (int i = 0; i < marcas.size(); ++i) {
				if (!marcas.get(i)) {
					if (aux1 == -1)
						aux1 = perm.get(i);
					else
						aux2 = perm.get(i);

				}

			}

			solAct.set(n, aux1);
			solAct.set(n + 1, aux2);
			sol.add(new ArrayList<>(solAct));
			solAct.set(n, aux2);
			solAct.set(n + 1, aux1);
			sol.add(new ArrayList<>(solAct));

		} else {
			for (int i = 0; i < marcas.size(); ++i) {
				if (!marcas.get(i)) {
					solAct.set(n, perm.get(i));
					marcas.set(i, true);
					permutar(perm, n + 1, solAct, sol, marcas);
					marcas.set(i, false);
				}

			}
		}
	}

}
