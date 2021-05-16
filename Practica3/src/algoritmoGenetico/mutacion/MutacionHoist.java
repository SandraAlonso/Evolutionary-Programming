package algoritmoGenetico.mutacion;

import java.util.List;
import java.util.Random;

import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.individuos.Individuo1;
import algoritmoGenetico.individuos.TArbol;
import algoritmoGenetico.individuos.TArbol.Tipo;

public class MutacionHoist extends Mutacion {

	private Random rand = new Random();
	private Boolean salida = false;
	private TArbol nuevoArbol = null;

	@Override
	public List<Individuo> run(List<Individuo> poblacion, Double porcentMut) {
		for (int i = 0; i < poblacion.size(); i++) {
			if (rand.nextDouble() < porcentMut) {
				salida = false;
				hoist(poblacion.get(i).getArbol());
				if (nuevoArbol != null) {
					nuevoArbol.setPadre(null);
					
					poblacion.get(i).setArbol(nuevoArbol);
					poblacion.get(i).getArbol().actualizarArbol(poblacion.get(i).getArbol());
				}
				nuevoArbol = null;
			}

		}
		return poblacion;

	}

	private void hoist(TArbol a) {
		// TODO Auto-generated method stub
		int i = 0;
		if (a.getHijos() != null) {
			while (a.getHijos() != null &&i < a.getHijos().length && !salida) {
				if (rand.nextBoolean() && (a.getTipo() == Tipo.PROGN2 || a.getTipo() == Tipo.PROGN3 || a.getTipo() == Tipo.SIC)) {
					nuevoArbol = a.getHijos()[i];
					salida = true;
					return;
				} else {
					hoist(a.getHijos()[i]);
				}
				i++;
			}
		}
	}

}
