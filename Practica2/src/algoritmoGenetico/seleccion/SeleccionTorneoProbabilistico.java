package algoritmoGenetico.seleccion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.SerializationUtils;

import algoritmoGenetico.individuos.Individuo;

public class SeleccionTorneoProbabilistico extends Seleccion {

	@Override
	public List<Individuo> run(List<Individuo> poblacion) {
		List<Individuo> NuevaPoblacion = new ArrayList<Individuo>();
		Random rand = new Random();
		int muestra = 3;
		Double p = 0.6;
		for (int i = 0; i < poblacion.size(); ++i) {
			int posMejor = -1;
			int posPeor = -1;

			for (int j = 0; j < muestra; ++j) {
				int posAux = rand.nextInt(poblacion.size());
				if (posMejor == -1 || (poblacion.get(posAux).getValor() > poblacion.get(posMejor).getValor())) {
					posMejor = posAux;
				}
				if (posPeor == -1 || (poblacion.get(posAux).getValor() < poblacion.get(posMejor).getValor())) {
					posPeor = posAux;

				}
			}
			Double alt = rand.nextDouble();
			if (alt > p)
				NuevaPoblacion.add((Individuo) SerializationUtils.clone(poblacion.get(posPeor)));

			else
				NuevaPoblacion.add((Individuo) SerializationUtils.clone(poblacion.get(posMejor)));
		}
		return NuevaPoblacion;
	}

}
