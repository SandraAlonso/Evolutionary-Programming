package algoritmoGenetico.cruce;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import algoritmoGenetico.individuos.Individuo;

public class CrucePorMezclaAleatoria extends Cruce {
	/*Nuevo cruce implementado: Cruce por mezcla aleatoria
	 * 
	 * Para cada elemento del individuo se obtiene un numero aleatorio. Si este es mayor a 0.5, se intercambiará con el de otrio progenitor.
	 * 1. Se obtiene un numero aleatorio.
	 * 2. Si este es mayor que 0.5 se intentará intercambiar ese elemento con el otro progenitor.
	 * 	2.a. Si ese elemento aun no está contenido en el individuo descendiente, se intercambia.
	 * 	2.b. Si ese elemento ya está contenido, dejamos el hueco.
	 * 3. Si el numero aleatorio es menor a 0.5 se deja igual.
	 * 	3.a. Si el elemento ya está contendio, dejamos el hueco.
	 * 4. Una vez rellenado todos los huecos posibles,s e colocan en los huecos vacios por orden, los elementos que aun no hemos colocado.
	 * Ejemplo:
	 * [2, 7, 9, 6, 10, 8, 1, 4, 3, 5] y [9, 4, 2, 5, 1, 3, 10, 7, 8, 6]  
	 *  -     -         -  -        -     -     -     -      -     -
	 *  Los elementos subrayados han obtenido un numero aleatorio mayor a 0.5 y po rlo tanto intentan intercambiarse.
	 * [9, 7, 2, 6, 10, 3, -, 4, -, -]
	 * [2, 4, 9, 5, 10, 3, 1, 7, -, 6]
	 * 
	 * Rellenamos los huecos
	 * 
	 * [9, 7, 2, 6, 10, 3, 1, 4, 5, 8]
	 * [2, 4, 9, 5, 10, 3, 1, 7, 8, 6]
	 * */
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
