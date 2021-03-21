package com.pevolutiva.practica1.algoritmoGenetico.individuos;

public class IndividuoFuncion4Reales extends Individuo<Double> {

	
	
	public IndividuoFuncion4Reales(Double precision, int n) {
		this.tamGenes = new Integer[n];
		this.min = new Double[n];
		this.max = new Double[n];
        for(int i = 0; i < n; ++i){
            this.min[i] = 0.00;
            this.max[i] = Math.PI;          
        }
		int tamTotal = n;
		this.cromosoma = new Double[tamTotal];
		for (int i = 0; i < tamTotal; i++)
			this.cromosoma[i] = this.rand.nextDouble();
	}

	@Override
	public Double getValor() {
		Double suma = 0.0;
        for(int i = 1; i <= this.tamGenes.length; ++i){
            suma += Math.sin(this.cromosoma[i - 1]) * Math.pow(Math.sin((i + 1) * Math.pow(this.cromosoma[i - 1], 2) / Math.PI), 20) ;
            
        }
        
        return suma;
	}
	
	public String toString() { //Printea las caracteristicas del individuo
        String s = "";
        s += "Valor: " + -getValor();
        for(int i = 0; i < tamGenes.length; ++i){
            s += " Fenotipo " + i + ": " + this.cromosoma[i];
        }
        return s;
}

}
