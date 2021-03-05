/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pevolutiva.practica1.algoritmoGenetico.individuos;

import java.util.Arrays;

/**
 *
 * @author Diego
 */
public class IndividuoFuncion1 extends Individuo<Boolean> {

	public IndividuoFuncion1() {
		this.tamGenes = new Integer[2];
		this.min = new Double[2];
		this.max = new Double[2];
		this.min[0] = -3.000;
		this.min[1] = 4.100;
		this.max[0] = 12.100;
		this.max[1] = 5.800;
		this.tamGenes[0] = this.tamGen( min[0], max[0], this.precision);
		this.tamGenes[1] = this.tamGen( min[1], max[1], this.precision);
		int tamTotal = tamGenes[0] + tamGenes[1];
		this.cromosoma = new Boolean[tamTotal];
		for (int i = 0; i < tamTotal; i++)
			this.cromosoma[i] = this.rand.nextBoolean();

	}

	public Double getValor() {
		Double x1 = this.getFenotipo(0), x2 = this.getFenotipo(1);
		return (21.5 + x1 * Math.sin(4 * Math.PI * x1) + x2 * Math.sin(20 * Math.PI * x2));
	}

	private Integer bin2dec(Boolean[] list, int range1, int range2) {
		Integer result = 0;
		for (int i = range1; i < range2; ++i) {
			result = result * 2 + (list[i] ? 1 : 0);
		}
		return result;
	}

	public Double getFenotipo(Integer val) {
		int rang1 = 0, rang2 = 0;
                
		for (int i = 1; i < tamGenes.length; ++i) {
			rang2 += tamGenes[i];
			if (val == i) {
				break;
			}
			rang1 += tamGenes[i - 1];
		}
		return min[val]
				+ this.bin2dec(cromosoma, rang1, rang2) * (max[val] - min[val]) / (Math.pow(2, tamGenes[val]) - 1);
	}

	public String toString() {
		return "max: " + Arrays.toString(max) + " min: " + Arrays.toString(min) + " cromosoma: "
				+ Arrays.toString(cromosoma) + " precision: " + precision + " tamGenes: " + Arrays.toString(tamGenes)
				;
	}

}
