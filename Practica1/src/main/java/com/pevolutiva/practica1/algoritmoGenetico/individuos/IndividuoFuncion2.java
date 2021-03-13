
package com.pevolutiva.practica1.algoritmoGenetico.individuos;


public class IndividuoFuncion2 extends Individuo<Boolean> {

	public IndividuoFuncion2() {
		this.tamGenes = new Integer[2];
		this.min = new Double[2];
		this.max = new Double[2];
		this.min[0] = -10.00;
		this.min[1] = -10.00;
		this.max[0] = 10.00;
		this.max[1] = 10.00;
		this.tamGenes[0] = this.tamGen( min[0], max[0], this.precision);
		this.tamGenes[1] = this.tamGen( min[1], max[1], this.precision);
		int tamTotal = tamGenes[0] + tamGenes[1];
		this.cromosoma = new Boolean[tamTotal];
		for (int i = 0; i < tamTotal; i++)
			this.cromosoma[i] = this.rand.nextBoolean();

	}
        
      

	public Double getValor() {//Funcion a maximizar
		Double x1 = this.getFenotipo(0), x2 = this.getFenotipo(1);
                Double part1 = 0.0,  part2 = 0.0;
                for(int i = 1; i <= 5; ++i){
                    part1 += i * Math.cos((i + 1)* x1 + i);
                }
                for(int i = 1; i <= 5; ++i){
                    part2 += i * Math.cos((i + 1)* x2 + i);
                }
		return - part1 * part2;
	}

	private Integer bin2dec(Boolean[] list, int range1, int range2) { //Convierte de binario a decimal para traducir de genotipo a fenotipo
		Integer result = 0;
		for (int i = range1; i < range2; ++i) {
			result = result * 2 + (list[i] ? 1 : 0);
		}
		return result;
	}

	public Double getFenotipo(Integer val) {
		int rang1 , rang2 ;
                if(val == 0){
                    rang1 = 0; 
                    rang2 = tamGenes[0];
                }
                else{
                    rang1 = tamGenes[0]; 
                    rang2 = tamGenes[0] + tamGenes[1];
                }
                
		return min[val]
				+ this.bin2dec(cromosoma, rang1, rang2) * (max[val] - min[val]) / (Math.pow(2, tamGenes[val]) - 1);
	}

	public String toString() { //Printea las caracteristicas del individuo
            /*
		return "max: " + Arrays.toString(max) + " min: " + Arrays.toString(min) + " cromosoma: "
				+ Arrays.toString(cromosoma) + " precision: " + precision + " tamGenes: " + Arrays.toString(tamGenes)
				;
            */   
            return "Valor: " + -getValor() + " Fenotipo1: " + getFenotipo(0) + 
                       " Fenotipo2: " + getFenotipo(1);
	}
        
        
        
}
