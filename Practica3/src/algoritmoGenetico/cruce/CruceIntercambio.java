package algoritmoGenetico.cruce;

import java.util.List;
import java.util.Random;

import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.individuos.TArbol;

public class CruceIntercambio extends Cruce {
	
	private TArbol padre1;
	private TArbol padre2;
	private Integer hijo1;
	private Integer hijo2;
	private Double prob = 0.9;
	private Random rand = new Random();

	@Override
	public List<Individuo> run(List<Individuo> poblacion) {
		
		
		
		
		for (int i = 0; i < poblacion.size(); i += 2) {
			
			
			
		}
		
		// TODO Auto-generated method stub
		return poblacion;
	}
	
	private void elegirSubArbol(TArbol padre) {
		
	}

}
