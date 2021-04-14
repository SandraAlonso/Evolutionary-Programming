package algoritmoGenetico.cruce;

import java.util.ArrayList;
import java.util.List;

import algoritmoGenetico.individuos.Individuo;

public class CruceCX extends Cruce {

	@Override
	public List<Individuo> run(List<Individuo> poblacion) {
		for (int j = 0; j < poblacion.size(); j += 2) {
			// 9 8 9
			Integer[] cromosoma1 = new Integer[26];
			Integer[] cromosoma2 = new Integer[26];
			cromosoma1= (Integer[]) poblacion.get(j).getCromosoma();
			cromosoma2= (Integer[]) poblacion.get(j+1).getCromosoma();

			// Vectores de marcas
			List<Boolean> marcas1 = new ArrayList(cromosoma1.length);
			List<Boolean> marcas2 = new ArrayList(cromosoma1.length);
			
			//Ciclo
			int i =0;
			Integer dato= cromosoma2[0];
			while(dato!=cromosoma1[0]) {
				while(dato!=cromosoma1[i])
					i++;
				dato=cromosoma2[i];
				//Marcamos los utillizados
				marcas2.set(i, true);
				i=0;
			}
			i=0;
			//Intercambiamos los no utilizados
			while(i<marcas2.size()) {
				if(!marcas2.get(i)) {
					int aux = cromosoma1[i];
					cromosoma1[i]=cromosoma2[i];
					cromosoma2[i]=aux;	
				}
				i++;
			}
			
			
		}
		return poblacion;
	}

}
