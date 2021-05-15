package algoritmoGenetico.mutacion;

import java.util.List;
import java.util.Random;

import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.individuos.TArbol;
import algoritmoGenetico.individuos.TArbol.Tipo;

public class MutacionFuncionalSimple extends Mutacion {

	private Random rand = new Random();
	private Boolean salida = false;

	@Override
	public List<Individuo> run(List<Individuo> poblacion, Double porcentMut) {

		for (int i = 0; i < poblacion.size(); i++) {
			if (rand.nextDouble() < porcentMut) {
				salida = false;
				cambioFuncional(poblacion.get(i).getArbol());
				poblacion.get(i).getArbol().actualizarArbol(poblacion.get(i).getArbol());
			}

		}

		return poblacion;
	}

	private void cambioFuncional(TArbol a) {
		switch (a.getTipo()) {
		// operandos
		case SIC:
			if (rand.nextBoolean()) {
				a.setTipo(Tipo.PROGN2);
				salida = true;
				return;
			}
		case PROGN2:
			if (rand.nextBoolean()) {
				a.setTipo(Tipo.SIC);
				salida = true;
				return;
			}
			break;
		default:
			break;
		}
		int i = 0;
		if (a.getHijos() != null) {
			while (i < a.getHijos().length && !salida) {
				cambioFuncional(a.getHijos()[i]);
				++i;
			}
		}
		return;

	}

}
