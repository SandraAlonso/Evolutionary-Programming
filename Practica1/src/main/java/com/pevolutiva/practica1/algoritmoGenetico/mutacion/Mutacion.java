package com.pevolutiva.practica1.algoritmoGenetico.mutacion;

import java.util.List;

import com.pevolutiva.practica1.algoritmoGenetico.individuos.Individuo;

public abstract class Mutacion {
	public abstract List<Individuo> run(List<Individuo> poblacion, Double porcentMut);

}
