package algoritmoGenetico.cruce;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import algoritmoGenetico.individuos.Individuo;

public class CruceInventado extends Cruce {

	@Override
	public List<Individuo> run(List<Individuo> poblacion) {
		for (int i = 0; i < poblacion.size(); i += 2) {
			Random rand = new Random();
			Integer[] cromosoma1 = new Integer[26];
			Integer[] cromosoma2 = new Integer[26];
			List<Boolean> marcas1 = new ArrayList(cromosoma1.length);
			List<Boolean> marcas2 = new ArrayList(cromosoma2.length);

			cromosoma1[0] = (Integer) poblacion.get(i + 1).getCromosoma()[0];
			marcas1.set(cromosoma1[0], true);
			for (int j = 1; j < cromosoma1.length; j++) {
				Double alt = rand.nextDouble();
				if (alt > 0.5 && !marcas1.get(j)) {
					cromosoma1[j] = (Integer) poblacion.get(i + 1).getCromosoma()[j];
					marcas1.set(cromosoma1[j], true);
				} else if (!marcas1.get(j)) {// lo dejamos igual
					cromosoma1[j] = (Integer) poblacion.get(i).getCromosoma()[j];
					marcas1.set(cromosoma1[j], true);
				} else {
					cromosoma1[j] = -1;

				}
			}
			cromosoma2[0] = (Integer) poblacion.get(i).getCromosoma()[0];
			marcas2.set(cromosoma2[0], true);
			for (int j = 1; j < cromosoma2.length; j++) {
				Double alt = rand.nextDouble();
				if (alt > 0.5 && !marcas2.get(j)) {
					cromosoma2[j] = (Integer) poblacion.get(i).getCromosoma()[j];
					marcas2.set(cromosoma2[j], true);
				} else if (!marcas2.get(j)) {// lo dejamos igual
					cromosoma2[j] = (Integer) poblacion.get(i + 1).getCromosoma()[j];
					marcas2.set(cromosoma2[j], true);
				} else {
					cromosoma2[j] = -1;

				}
			}
			for (int j = 0; j < cromosoma1.length; j++) {
				if(cromosoma1[j]==-1) {
					for(int k = 0; k < marcas1.size(); k++) {
						if(!marcas1.get(k)) {
							cromosoma1[j]=k;
							marcas1.set(k, true);
						}
					}
				}
					
			}
			for (int j = 0; j < cromosoma2.length; j++) {
				if(cromosoma2[j]==-1) {
					for(int k = 0; k < marcas2.size(); k++) {
						if(!marcas2.get(k)) {
							cromosoma2[j]=k;
							marcas2.set(k, true);
						}
					}
				}
					
			}
				
			}

		
		return poblacion;
	}

}
