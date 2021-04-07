package algoritmoGenetico.individuos;

import java.util.ArrayList;
import java.util.List;

public class Individuo1 extends Individuo<Integer> {
	
	
	public Individuo1() {
		int tamTotal = 26;
		List<Integer> numeros = new ArrayList<>();
		this.cromosoma = new Integer[tamTotal];
		for(int i = 0; i < tamTotal; ++i) {
			numeros.add(i);
		}
		
		for(int i = 0; i < tamTotal - 1; ++i) {
			int pos = this.rand.nextInt(numeros.size());
			this.cromosoma[i] = numeros.get(pos);
			numeros.remove(pos);
		}
		this.cromosoma[tamTotal - 1] = numeros.get(0);
		
	}
	

	@Override
	public Double getValor() {
		return null;

	}

}
