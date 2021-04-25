package algoritmoGenetico.seleccion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.SerializationUtils;

import algoritmoGenetico.individuos.Individuo;

public class SeleccionRanking extends Seleccion {

	Double beta = 1.5;
	Double suma = 0.0;
	

	private List<Double> puntuacionesRanking(List<Individuo> poblacion) {

		List<Double> sol = new ArrayList<Double>();

		for (int i = 0; i < poblacion.size(); ++i) {
			double aux = (double) i / poblacion.size();
			aux *= 2 * (this.beta - 1);
			aux = beta - aux;
			aux = aux * (1 / (double)poblacion.size());
			//Caulculamos el acumulado
			suma += aux;
			sol.add(aux);
			
		}

		return sol;
	}

	@Override
	public List<Individuo> run(List<Individuo> poblacion) {
		List<Individuo> copyPoblacion = new ArrayList<Individuo>(poblacion);
		List<Individuo> nuevaPoblacion = new ArrayList<Individuo>();
		Collections.sort(copyPoblacion, (a, b) -> b.getValor().compareTo(a.getValor()));
		
		List<Double> ranking = new ArrayList<Double>();
		ranking = puntuacionesRanking(copyPoblacion);
		
		Integer numIndSelec = poblacion.size();
		Random rand = new Random();

		for (int i = 0; i < numIndSelec; i++) {
			Double alt = rand.nextDouble();
			Double acum = 0.0;
			for (int j = 0; j< ranking.size(); j++) {
				Double aux2 = (ranking.get(j) + acum) / suma;

				if ((ranking.get(j)  + acum) / suma >= alt) {
					nuevaPoblacion.add((Individuo) SerializationUtils.clone(copyPoblacion.get(j)));
					break;
				}
				acum += ranking.get(j);
			}
		}
		suma=0.0;
		return nuevaPoblacion;
	}

}
