package algoritmoGenetico.mutacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import algoritmoGenetico.individuos.Individuo;

public class MutacionHeuristica extends Mutacion {
	

	@Override
	public List<Individuo> run(List<Individuo> poblacion, Double porcentMut) {
		
		int n = 3;
		Random rand = new Random();
		
		for(int i =0; i < poblacion.size(); ++i) {
			if(rand.nextDouble() < porcentMut) {
				List<Integer> pos = new ArrayList<Integer>();
				for (int j = 0; j < poblacion.size(); j++) {
					while(true) {
						Integer aux = rand.nextInt(26);
						if(!pos.contains(aux)) {
							pos.add(aux);
							break;
						}
						
					}
					
				}
				
				
			}
		}
		
		// TODO Auto-generated method stub
		return null;
	}
	
	List<List<Integer>> permutar(int n, int sol){
		return null;
	}

}
