package algoritmoGenetico.mutacion;

import java.util.List;
import java.util.Random;

import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.individuos.Individuo1;
import algoritmoGenetico.individuos.TArbol;
import algoritmoGenetico.individuos.TArbol.Tipo;

public class MutacionContraccion extends Mutacion {

	private Random rand = new Random();
	private Boolean salida = false;

	@Override
	public List<Individuo> run(List<Individuo> poblacion, Double porcentMut) {
		for (int i = 0; i < poblacion.size(); i++) {
			if (rand.nextDouble() < porcentMut) {
				salida = false;
				contraccion(poblacion.get(i).getArbol());
				poblacion.get(i).getArbol().actualizarArbol(poblacion.get(i).getArbol());
			}

		}

		return poblacion;
	}

	private void contraccion(TArbol a) {
		int i = 0;
		if (a.getHijos() != null) {
		while (i < a.getHijos().length && !salida) {
			if(rand.nextBoolean() && (a.getTipo() == Tipo.PROGN2 || a.getTipo() == Tipo.PROGN3 || a.getTipo() == Tipo.SIC)) {
				Individuo1 aux = new Individuo1(null, 1, 3);
				a.setHijo(i, aux.crearArbolCreciente(null, 1, 3));
				salida = true;
				return;
			}
			else {
				contraccion(a.getHijos()[i]);
			}
			i++;
		}
		return;
		}
	}

}
