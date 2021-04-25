package algoritmoGenetico.mutacion;

import java.util.List;
import java.util.Random;

import algoritmoGenetico.AlgoritmoGenetico;
import algoritmoGenetico.individuos.Individuo;

public class MutacionInsercion extends Mutacion {

	@Override
	public List<Individuo> run(List<Individuo> poblacion, Double porcentMut) {
		Random rand = new Random();
		int posicionesACambiar = rand.nextInt(5)+1;
		for (int i = 0; i < poblacion.size(); i++) {
			Integer[] c = (Integer[]) poblacion.get(i).getCromosoma();
			Double alt = rand.nextDouble();
			if (porcentMut > alt) { // mutamos
				AlgoritmoGenetico.totalMutaciones++;
				
				for(int j =0;j<posicionesACambiar;j++) {
					int posActual = rand.nextInt(25)+1;
					int posFinal = rand.nextInt(posActual)+1;
					int aux = c[posActual];

					for(int k = posActual;k>posFinal;k--) {
						c[k]=c[k-1];

					}
					
					
					c[posFinal]=aux;
					
				}
				
				poblacion.get(i).setCromosoma(c);

			}

		}
		return poblacion;
	}

}
