package algoritmoGenetico.mutacion;

import java.util.List;
import java.util.Random;

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
				System.out.println("mutacion por insercion antes");
				for(int a =0;a<c.length;a++)
					System.out.print(c[a]+" ");
				for(int j =0;j<posicionesACambiar;j++) {
					int posActual = rand.nextInt(25)+1;
					int posFinal = rand.nextInt(posActual)+1;
					System.out.println(" i "+i+ " posAct "+posActual+ " posfinal "+posFinal);
					int aux = c[posActual];

					for(int k = posActual;k>posFinal;k--) {
						c[k]=c[k-1];

					}
					
					
					c[posFinal]=aux;
					
				}
				System.out.println("mutacion por insercion");
				for(int a =0;a<c.length;a++)
					System.out.print(c[a]+" ");
				poblacion.get(i).setCromosoma(c);

			}

		}
		return poblacion;
	}

}
