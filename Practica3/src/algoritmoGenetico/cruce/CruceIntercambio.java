package algoritmoGenetico.cruce;

import java.util.List;
import java.util.Random;

import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.individuos.TArbol;
import algoritmoGenetico.individuos.TArbol.Tipo;

public class CruceIntercambio extends Cruce {

	private TArbol padre1 = null;
	private TArbol padre2 = null;
	private Integer hijo1;
	private Integer hijo2;
	private Double prob = 0.9;
	private Random rand = new Random();
	private Boolean salida = false;
	private List<Individuo> copia_poblacion;
	private Integer i_copy;

	@Override
	public List<Individuo> run(List<Individuo> poblacion) {

		for (int i = 0; i < poblacion.size(); i += 2) {
			copia_poblacion = poblacion;
			i_copy = i;
			padre1 = null;
			padre2 = null;

			while (padre1 == null) {
				salida = false;
				elegirSubArbol1(poblacion.get(i).getArbol());
				// prob -= (prob > 0.1) ? 0.1 : 0;
			}
			prob = 0.9;
			salida = false;
			while (padre2 == null) {
				salida = false;
				elegirSubArbol2(poblacion.get(i + 1).getArbol());
				// prob -= (prob > 0.1) ? 0.1 : 0;
			}
			prob = 0.9;
			// Intercambio de hijos

			TArbol aux = padre1.getHijos()[hijo1];
			padre1.setHijo(hijo1, padre2.getHijos()[hijo2]);
			padre2.setHijo(hijo2, aux);
			
//			if(padre1.getHijos()[hijo1].getProfundidad() <= 1 || padre2.getHijos()[hijo2].getProfundidad() <= 1) {
//				System.out.println("Error");
//			}

			poblacion.get(i).getArbol().actualizarArbol(poblacion.get(i).getArbol());
			poblacion.get(i + 1).getArbol().actualizarArbol(poblacion.get(i + 1).getArbol());

		}
		return poblacion;
	}

	private void elegirSubArbol1(TArbol padre) {
		int i = 0;
		//System.out.println(padre.getTipo());
		while (i < padre.getHijos().length && !salida) {
			if (!(padre.getHijos()[i].getTipo() == Tipo.PROGN2 || padre.getHijos()[i].getTipo() == Tipo.PROGN3
					|| padre.getHijos()[i].getTipo() == Tipo.SIC)) {
				// operandos

				if (rand.nextDouble() < 1 - prob) {
					hijo1 = i;
					padre1 = padre;
					salida = true;
				}

			}
			// operadores prob 0.9
			else {
				if (rand.nextDouble() < prob) {
					hijo1 = i;
					padre1 = padre;
					salida = true;
				}
				else {
					elegirSubArbol1(padre.getHijos()[i]);
				}

			}
			i++;
		}
		
	}

	

	private void elegirSubArbol2(TArbol padre) {
		int i = 0;
		//System.out.println(padre.getTipo());
		while (i < padre.getHijos().length && !salida) {
			if (!(padre.getHijos()[i].getTipo() == Tipo.PROGN2 || padre.getHijos()[i].getTipo() == Tipo.PROGN3
					|| padre.getHijos()[i].getTipo() == Tipo.SIC)) {
				// operandos

				if (rand.nextDouble() < 1 - prob) {
					hijo2 = i;
					padre2 = padre;
					salida = true;
				}

			}
			// operadores prob 0.9
			else {
				if (rand.nextDouble() < prob) {
					hijo2 = i;
					padre2 = padre;
					salida = true;
				} 
				else {
					elegirSubArbol2(padre.getHijos()[i]);
				}

			}
			i++;
		}
		
	}

}


