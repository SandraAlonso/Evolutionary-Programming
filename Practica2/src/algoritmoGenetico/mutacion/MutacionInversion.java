package algoritmoGenetico.mutacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import algoritmoGenetico.individuos.Individuo;



public class MutacionInversion extends Mutacion {

	@Override
	public List<Individuo> run(List<Individuo> poblacion, Double porcentMut) {
		Random rand = new Random();
		int posicionesACambiar = rand.nextInt(5) + 1;
		for (int i = 0; i < poblacion.size(); i++) {
			Integer[] c = (Integer[]) poblacion.get(i).getCromosoma();
			Double alt = rand.nextDouble();
			if (porcentMut > alt) { // mutamos
				int pos1= rand.nextInt(26);
				int pos2= rand.nextInt(26);
				List<Integer> elems = new ArrayList<Integer>();
				if(pos2>pos1) {
					for(int j =pos1;j<pos2;j++) {
						elems.add(c[j]);
					}
					for(int j =pos1;j<pos2;j++) {
						c[j]= elems.get(elems.size()-1);
						elems.remove(elems.size()-1);
					}
				}
				else if(pos2>pos1) {
					for(int j =pos2;j<pos1;j++) {
						elems.add(c[j]);
					}
					for(int j =pos2;j<pos1;j++) {
						c[j]= elems.get(elems.size()-1);
						elems.remove(elems.size()-1);
					}
				}
			}
			poblacion.get(i).setCromosoma(c);

		}

		return poblacion;
	}
}
