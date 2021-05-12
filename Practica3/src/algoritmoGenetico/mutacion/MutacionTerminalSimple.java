package algoritmoGenetico.mutacion;

import java.util.List;
import java.util.Random;

import algoritmoGenetico.AlgoritmoGenetico;
import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.individuos.TArbol;
import algoritmoGenetico.individuos.TArbol.Tipo;

public class MutacionTerminalSimple extends Mutacion {
	private Random rand = new Random();
	private Boolean salida = false;

	
	@Override
	public List<Individuo> run(List<Individuo> poblacion, Double porcentMut) {
		
		
		for (int i = 0; i < poblacion.size(); i++) {
			if(rand.nextDouble() < porcentMut) {
				salida = false;
				cambioTerminal(poblacion.get(i).getArbol());
				poblacion.get(i).getArbol().actualizarArbol(poblacion.get(i).getArbol());
			}

		}

		return poblacion;
	}
	
	private void cambioTerminal(TArbol a) {
		switch (a.getTipo()) {
		// operandos
		case AVANZA:
			if (rand.nextBoolean()) {
				a.setTipo(Tipo.values()[rand.nextInt(2) + 1]);
				salida = true;
				return;
			}
			break;
		case GIRA_DERECHA:
			if (rand.nextBoolean()) {
				Tipo aux = rand.nextBoolean() ? Tipo.AVANZA : Tipo.GIRA_IZQUIERDA;
				a.setTipo(aux);
				salida = true;
				return;
			}
			break;
		case GIRA_IZQUIERDA:
			if (rand.nextBoolean()) {
				a.setTipo(Tipo.values()[rand.nextInt(2)]);
				salida = true;
				return;
			}
			break;
		default:
			break; 	
		}
		int i = 0;
		while (i < a.getHijos().length && !salida) {
			cambioTerminal(a.getHijos()[i]);
			++i;
		}
		return;
	}
}
