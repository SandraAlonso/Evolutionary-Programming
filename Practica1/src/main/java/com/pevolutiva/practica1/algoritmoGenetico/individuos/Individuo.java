/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pevolutiva.practica1.algoritmoGenetico.individuos;

import java.util.Random;

/**
 *
 * @author Diego
 */
public abstract class Individuo<T> {

    protected Double[] min;

    protected Double[] max;

    protected T[] cromosoma;

    protected Integer[] tamGenes;

    protected Double valorError;

    protected Double precision;

    protected Random rand;

    public Double[] getMin() {
        return min;
    }

    public Double[] getMax() {
        return max;
    }

    public T[] getCromosoma() {
        return cromosoma;
    }

    public Integer[] getTamGenes() {
        return tamGenes;
    }

    

    public int tamGen(Double valorError, Double min, Double max) {
        return (int) (Math.log10(((max - min) / precision) + 1) / Math.log10(2));
    }

}
