package algoritmoGenetico.cruce;

import java.util.List;
import java.util.Random;

import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.individuos.TArbol;

public class CruceIntercambio extends Cruce {

	private TArbol padre1;
	private TArbol padre2;
	private Integer hijo1;
	private Integer hijo2;
	private Double prob = 0.9;
	private Random rand = new Random();
	private Boolean salida = false;

	@Override
	public List<Individuo> run(List<Individuo> poblacion) {

		for (int i = 0; i < poblacion.size(); i += 2) {
			elegirSubArbol1(poblacion.get(i).getArbol());
			salida = false;
			elegirSubArbol2(poblacion.get(i + 1).getArbol());
			// Intercambio de hijos

			TArbol aux = padre1.getHijos()[hijo1];
			padre1.setHijo(hijo1, padre2.getHijos()[hijo2]);
			padre2.setHijo(hijo2, aux);

			poblacion.get(i).getArbol().actualizarArbol(poblacion.get(i).getArbol());
			poblacion.get(i+1).getArbol().actualizarArbol(poblacion.get(i+1).getArbol());

		}
		return poblacion;
	}

	private void elegirSubArbol1(TArbol padre) {
		Integer i = 0;
		while (i < padre.getHijos().length && !salida) {
			switch (padre.getHijos()[i].getTipo()) {
			// operandos
			case AVANZA:
			case GIRA_DERECHA:
			case GIRA_IZQUIERDA:
				if (rand.nextDouble() < 1 - prob) {
					hijo1 = i;
					padre1 = padre;
					salida = true;
				} else
					elegirSubArbol1(padre.getHijos()[i]);
				break;
			// operadores prob 0.9
			case SIC:
			case PROGN2:
			case PROGN3:
				if (rand.nextDouble() < prob) {
					hijo1 = i;
					padre1 = padre;
					salida = true;
				} else
					elegirSubArbol1(padre.getHijos()[i]);
				break;
			}
			i++;
		}

	}

	private void elegirSubArbol2(TArbol padre) {
		Integer i = 0;
		while (i < padre.getHijos().length && !salida) {
			switch (padre.getHijos()[i].getTipo()) {
			// operandos
			case AVANZA:
			case GIRA_DERECHA:
			case GIRA_IZQUIERDA:
				if (rand.nextDouble() < 1 - prob) {
					hijo2 = i;
					padre2 = padre;
					salida = true;
				} else
					elegirSubArbol1(padre.getHijos()[i]);
				break;
			// operadores prob 0.9
			case SIC:
			case PROGN2:
			case PROGN3:
				if (rand.nextDouble() < prob) {
					hijo2 = i;
					padre2 = padre;
					salida = true;
				} else
					elegirSubArbol1(padre.getHijos()[i]);
				break;
			}
			i++;
		}

	}

}
