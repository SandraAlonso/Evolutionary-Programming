package algoritmoGenetico.cruce;

import java.util.ArrayList;
import java.util.List;

import algoritmoGenetico.individuos.Individuo;

public class CruceCX extends Cruce {

	@Override
	public List<Individuo> run(List<Individuo> poblacion) {
		for (int i = 0; i < poblacion.size(); i += 2) {
			// 9 8 9
			Integer[] cromosoma1 = new Integer[26];
			Integer[] cromosoma2 = new Integer[26];

			// Vectores de marcas
			List<Boolean> marcas1 = new ArrayList(cromosoma1.length);
			List<Boolean> marcas2 = new ArrayList(cromosoma1.length);
			
			//Ciclo
			int pos=0;
			while(true) {
				
			}
			
		}
		return poblacion;
	}

}
