package algoritmoGenetico.cruce;

import java.util.ArrayList;
import java.util.List;

import algoritmoGenetico.individuos.Individuo;

public class CruceCO extends Cruce {

	@Override
	public List<Individuo> run(List<Individuo> poblacion) {

		for (int i = 0; i < poblacion.size(); i += 2) {
			Integer[] cromosoma1 = new Integer[26];
			Integer[] cromosoma2 = new Integer[26];

			List<Integer> posiciones = new ArrayList(cromosoma1.length);

			for(int j =0;j<posiciones.size();j++) {
				posiciones.set(j, j);
			}
			int k =1;
			for(int j =0;j<cromosoma1.length;j++) {
				while(posiciones.get(k)!=poblacion.get(i).getCromosoma()[j] )
					k++;
				posiciones.remove(k);
				cromosoma1[j]=k;
				k=1;
			}
			
			k =1;
			for(int j =0;j<posiciones.size();j++) {
				posiciones.set(j, j);
			}
			for(int j =0;j<cromosoma2.length;j++) {
				while(posiciones.get(k)!=poblacion.get(i+1).getCromosoma()[j] )
					k++;
				posiciones.remove(k);
				cromosoma1[j]=k;
				k=1;
			}
			poblacion.get(i).setCromosoma(cromosoma1);
			poblacion.get(i + 1).setCromosoma(cromosoma2);
		}
		return poblacion;
	}

}
