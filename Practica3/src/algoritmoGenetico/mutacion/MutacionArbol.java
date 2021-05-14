package algoritmoGenetico.mutacion;

import java.util.List;
import java.util.Random;

import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.individuos.Individuo1;
import algoritmoGenetico.individuos.TArbol;

public class MutacionArbol extends Mutacion {
	
	private Random rand = new Random();
	private Boolean salida = false;

	@Override
	public List<Individuo> run(List<Individuo> poblacion, Double porcentMut) {
		for (int i = 0; i < poblacion.size(); i++) {
			if (rand.nextDouble() < porcentMut) {
				salida = false;
				subArbol(poblacion.get(i).getArbol());
				poblacion.get(i).getArbol().actualizarArbol(poblacion.get(i).getArbol());
			}

		}

		return poblacion;
	}

	private void subArbol(TArbol a) {
		// TODO Auto-generated method stub
		int i = 0;
		while (i < a.getHijos().length && !salida) {
			if(rand.nextBoolean()) {
				Individuo1 aux = new Individuo1(null, 1, 3);
				a.setHijo(i, aux.crearArbolCreciente(null, 1, 3));
				salida = true;
				return;
			}
			else {
				subArbol(a.getHijos()[i]);
			}
			i++;
		}
		return;
	}

}
