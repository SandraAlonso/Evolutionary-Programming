package algoritmoGenetico.mutacion;

import java.util.List;
import java.util.Random;

import algoritmoGenetico.AlgoritmoGenetico;
import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.individuos.Individuo1;
import algoritmoGenetico.individuos.TArbol;
import algoritmoGenetico.individuos.TArbol.Tipo;

public class MutacionExpansion extends Mutacion {
	
	private Random rand = new Random();
	private Boolean salida = false;
	
	@Override
	public List<Individuo> run(List<Individuo> poblacion, Double porcentMut) {
		for (int i = 0; i < poblacion.size(); i++) {
			if (rand.nextDouble() < porcentMut) {
				salida = false;
				expansion(poblacion.get(i).getArbol());
				poblacion.get(i).getArbol().actualizarArbol(poblacion.get(i).getArbol());
			}

		}

		return poblacion;
	}

	private void expansion(TArbol a) {
		int i = 0;
		while (a.getHijos()!=null && i < a.getHijos().length && !salida) {
			if(rand.nextBoolean() && !(a.getHijos()[i].getTipo() == Tipo.PROGN2 || a.getHijos()[i].getTipo() == Tipo.PROGN3 || a.getHijos()[i].getTipo() == Tipo.SIC)) {
				Individuo1 aux = new Individuo1("Completa", 1, AlgoritmoGenetico.getProfMax());
				a.setHijo(i, aux.crearArbolCompleto(null, 3));
				salida = true;
				return;
			}
			else {
				expansion(a.getHijos()[i]);
			}
			i++;
		}
		return;
	}

}
