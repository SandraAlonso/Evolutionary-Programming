package algoritmoGenetico.mutacion;

import java.util.List;
import java.util.Random;

import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.individuos.Individuo1;
import algoritmoGenetico.individuos.TArbol;
import algoritmoGenetico.individuos.TArbol.Tipo;

public class MutacionPermutacion extends Mutacion {

	private Random rand = new Random();
	private Boolean salida = false;

	@Override
	public List<Individuo> run(List<Individuo> poblacion, Double porcentMut) {

		for (int i = 0; i < poblacion.size(); i++) {
			if (rand.nextDouble() < porcentMut) {
				salida = false;
				permutacion(poblacion.get(i).getArbol());
				poblacion.get(i).getArbol().actualizarArbol(poblacion.get(i).getArbol());
			}

		}

		return poblacion;
	}

	private void permutacion(TArbol a) {
		int i = 0;
		if(rand.nextBoolean() && (a.getTipo() == Tipo.PROGN2 || a.getTipo() == Tipo.PROGN3 || a.getTipo() == Tipo.SIC)) {
			TArbol aux = a.getHijos()[0];
			for(int j = 0; j < a.getHijos().length-1; ++j) {
				a.setHijo(j, a.getHijos()[j + 1]);
			}
			a.setHijo(a.getHijos().length - 1, aux);
			salida = true;
			return;
		}
		while (!salida && a.getHijos()!=null && i < a.getHijos().length  ) {
			permutacion(a.getHijos()[i]);
			
			i++;
		}
		return;
		
	}
}
