package algoritmoGenetico.mutacion;

import java.util.List;

import algoritmoGenetico.individuos.Individuo;



public abstract class Mutacion {
	public abstract List<Individuo> run(List<Individuo> poblacion, Double porcentMut);

}
