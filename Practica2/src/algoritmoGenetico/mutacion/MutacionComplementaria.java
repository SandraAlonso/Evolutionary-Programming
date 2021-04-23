package algoritmoGenetico.mutacion;

import java.util.List;
import java.util.Random;

import algoritmoGenetico.individuos.Individuo;

public class MutacionComplementaria extends Mutacion {
	/*Nueva mutación implementada: Mutación complementaria
	 * 
	 * Se trata de hallar el complementario a todos los elementos del cromosoma del individuo e intercambiarlos
	 * 
	 * Ejemplo:
	 * [2, 7, 9, 6, 10, 8, 1, 4, 3, 5] -> [9, 4, 2, 5, 1, 3, 10, 7, 8, 6]  
	 * */

	@Override
	public List<Individuo> run(List<Individuo> poblacion, Double porcentMut) {
		Random rand = new Random();
		int posicionesACambiar = rand.nextInt(5) + 1;
		for (int i = 0; i < poblacion.size(); i++) {
			Integer[] c = (Integer[]) poblacion.get(i).getCromosoma();
			Double alt = rand.nextDouble();
			if (porcentMut > alt) { // mutamos
				for(int j =0;j<c.length;j++) {
					c[j]=25-c[j];
				}
			}
			poblacion.get(i).setCromosoma(c);

		}

		return poblacion;
	}

}
