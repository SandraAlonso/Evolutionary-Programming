package algoritmoGenetico.cruce;

import java.util.ArrayList;
import java.util.List;

import algoritmoGenetico.individuos.Individuo;

public class CruceOXPP extends Cruce {

	@Override
	public List<Individuo> run(List<Individuo> poblacion) {
		int pos1= 9;
		int pos2= 16;
		
		for (int i = 0; i < poblacion.size(); i += 2) {
			// 9 8 9
			Integer[] cromosoma1 = new Integer[26];
			Integer[] cromosoma2 = new Integer[26];

			// Vectores de marcas
			List<Boolean> marcas1 = new ArrayList(cromosoma1.length);
			List<Boolean> marcas2 = new ArrayList(cromosoma1.length);
			
			//Intercambio de posiciones prioritarias
			Integer aux = cromosoma1[pos1];
			cromosoma1[pos1]= cromosoma2[pos1];
			cromosoma2[pos1] = aux;
			
			aux = cromosoma1[pos2];
			cromosoma1[pos2]= cromosoma2[pos2];
			cromosoma2[pos2] = aux;

			//Relleno de cromosomas
			//Cromosoma 1
			int k = 17;
			for (int j = 17; j < cromosoma1.length; j++) {
				if (!marcas1.get((int) poblacion.get(i).getCromosoma()[j])) {
					cromosoma1[k] = (Integer) poblacion.get(i).getCromosoma()[j];
					marcas1.set(cromosoma1[j], true);
					k++;
				}
			}
			for (int j = 0; j < 17; j++) {
				if (k >= cromosoma1.length) {
					k = 0;
				}
				if (!marcas1.get((int) poblacion.get(i).getCromosoma()[j])) {
					cromosoma1[k] = (Integer) poblacion.get(i).getCromosoma()[j];
					marcas1.set(cromosoma1[j], true);
					k++;
				}
				if(k == pos1 || k == pos2)
					k++;

			}
			//Cromosoma 2
			k = 17;
			for (int j = 17; j < cromosoma2.length; j++) {
				if (!marcas2.get((int) poblacion.get(i+1).getCromosoma()[j])) {
					cromosoma2[k] = (Integer) poblacion.get(i+1).getCromosoma()[j];
					marcas2.set(cromosoma2[j], true);
					k++;
				}
			}
			for (int j = 0; j < 17; j++) {
				if (k >= cromosoma2.length) {
					k = 0;
				}
				if (!marcas2.get((int) poblacion.get(i+1).getCromosoma()[j])) {
					cromosoma2[k] = (Integer) poblacion.get(i+1).getCromosoma()[j];
					marcas2.set(cromosoma2[j], true);
					k++;
				}
				if(k == pos1 || k == pos2)
					k++;

			}
			poblacion.get(i).setCromosoma(cromosoma1);
			poblacion.get(i+1).setCromosoma(cromosoma2);

		}
		
		return poblacion;
	}

}
