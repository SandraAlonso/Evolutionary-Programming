package algoritmoGenetico.cruce;

import java.util.List;

import algoritmoGenetico.individuos.Individuo;





public abstract class Cruce {

	
    public abstract List<Individuo> run(List<Individuo> poblacion);

}
