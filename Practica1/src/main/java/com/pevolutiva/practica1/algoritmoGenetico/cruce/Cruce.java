package com.pevolutiva.practica1.algoritmoGenetico.cruce;

import java.util.List;

import com.pevolutiva.practica1.algoritmoGenetico.individuos.Individuo;


public abstract class Cruce {

	
    public abstract List<Individuo> run(List<Individuo> poblacion);

}
