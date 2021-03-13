/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pevolutiva.practica1.algoritmoGenetico.individuos;

/**
 *
 * @author Diego
 */
public class IndividuoFuncion4 extends Individuo<Boolean> {

	public IndividuoFuncion4(int n) {
		this.tamGenes = new Integer[n];
		this.min = new Double[n];
		this.max = new Double[n];
                int auxTotal = 0;
                for(int i = 0; i < n; ++i){
                    this.min[i] = 0.00;
                    this.max[i] = Math.PI;
                    this.tamGenes[i] = this.tamGen( min[i], max[i], this.precision);
                    auxTotal += this.tamGenes[i];
                }
		int tamTotal = auxTotal;
		this.cromosoma = new Boolean[tamTotal];
		for (int i = 0; i < tamTotal; i++)
			this.cromosoma[i] = this.rand.nextBoolean();

	}
        
      

	public Double getValor() {//Funcion a maximizar
            Double suma = 0.0;
            for(int i = 1; i <= this.tamGenes.length; ++i){
                suma += Math.sin(this.getFenotipo(i - 1)) * Math.pow(Math.sin((i + 1) * Math.pow(this.getFenotipo(i - 1), 2) / Math.PI), 20) ;
                
            }
            
            return suma;
	}

	private Integer bin2dec(Boolean[] list, int range1, int range2) { //Convierte de binario a decimal para traducir de genotipo a fenotipo
		Integer result = 0;
		for (int i = range1; i < range2; ++i) {
			result = result * 2 + (list[i] ? 1 : 0);
		}
		return result;
	}

	public Double getFenotipo(int val) {
		int rang1 = 0, rang2 = tamGenes[0];
                if (val != 0){
                    for(int i = 1; i < tamGenes.length; ++i){
                        rang1 += tamGenes[i - 1];
                        rang2 += tamGenes[i - 1];
                        if(i == val) break;
                    }
                }
                
		return min[val]
				+ this.bin2dec(cromosoma, rang1, rang2) * (max[val] - min[val]) / (Math.pow(2, tamGenes[val]) - 1);
	}

	public String toString() { //Printea las caracteristicas del individuo
            String s = "";
            s += "Valor: " + -getValor();
            for(int i = 0; i < tamGenes.length; ++i){
                s += " Fenotipo" + i + ": " + getFenotipo(i);
            }
            return s;
	}
        
        
        
}