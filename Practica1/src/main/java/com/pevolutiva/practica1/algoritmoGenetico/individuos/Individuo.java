/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pevolutiva.practica1.algoritmoGenetico.individuos;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author Diego
 */
public abstract class Individuo<T> implements Serializable {

    protected Double[] min;

    protected Double[] max;

    protected T[] cromosoma;

    protected Integer[] tamGenes;

    protected Double precision;

    protected Random rand = new Random();

    
    
    

    public Double[] getMin() {
        return min;
    }

    public Double[] getMax() {
        return max;
    }

    public T[] getCromosoma() {
        return cromosoma;
    }
    public T[] setCromosoma(T[]c) {
        return cromosoma=c;
    }

    public Integer[] getTamGenes() {
        return tamGenes;
    }

    public abstract Double getValor();

    public int tamGen(Double min, Double max, Double precision) {
    	
        return (int) (Math.log10(((max - min) / precision) + 1) / Math.log10(2));
    }
    
    
}
