package algoritmoGenetico.mutacion;

import java.util.List;
import java.util.Random;

import algoritmoGenetico.AlgoritmoGenetico;
import algoritmoGenetico.individuos.Individuo;

public class MutacionIntercambio extends Mutacion {

	@Override
	public List<Individuo> run(List<Individuo> poblacion, Double porcentMut) {
		Random rand = new Random();
		int posicionesACambiar = rand.nextInt(5) + 1;
		for (int i = 0; i < poblacion.size(); i++) {
			Integer[] c = (Integer[]) poblacion.get(i).getCromosoma();
			Double alt = rand.nextDouble();
			if (porcentMut > alt) { // mutamos 
				AlgoritmoGenetico.totalMutaciones++;
				int pos1= rand.nextInt(26);
				int pos2= rand.nextInt(26);
				Integer aux = c[pos1];
				c[pos1]=c[pos2];
				c[pos2]=aux;
			}
			poblacion.get(i).setCromosoma(c);

		}

		return poblacion;
	}

	
}