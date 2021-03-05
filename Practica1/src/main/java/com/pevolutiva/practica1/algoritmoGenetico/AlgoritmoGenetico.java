/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pevolutiva.practica1.algoritmoGenetico;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.pevolutiva.practica1.algoritmoGenetico.individuos.Individuo;
import com.pevolutiva.practica1.algoritmoGenetico.individuos.IndividuoFuncion1;

/**
 *
 * @author Diego
 */
public class AlgoritmoGenetico {
	private Integer tamPoblacion;
	private Integer numGeneraciones;
	private Double porcentCruces;
	private Double porcetMutaciones;
	private Integer precision;
	private String metodoSeleccion;
	private String metodoCruce;
	private String metodoMutacion;
	private Double porcentElitismo;
	private List<Individuo> poblacion;

	public void iniciarPoblacion() {
		tamPoblacion= 100;
		List<Individuo> poblacion = new ArrayList<Individuo>();
		for (int i = 0; i < tamPoblacion; i++)
			poblacion.add(new IndividuoFuncion1());
		this.poblacion = poblacion;
	}

	public void seleccionRuleta() {
		Double suma = 0.0;
		for (Individuo ind : poblacion) {
			suma += ind.getValor();
		}
		Integer numIndSelec = 50;
		Random rand = new Random();
		List<Individuo> NuevaPoblacion = new ArrayList<Individuo>();

		for (int i = 0; i < numIndSelec; i++) {
			Double alt = rand.nextDouble();

			for (Individuo ind : poblacion) {

				if (ind.getValor() / suma >= alt) {
					NuevaPoblacion.add(ind);
					break;
				}
			}
		}
		System.out.println(NuevaPoblacion);
	}

	public void seleccion() {
		//if (metodoSeleccion == "Ruleta")
			seleccionRuleta();
	}

	public void run() {
		iniciarPoblacion();
		Integer generacionActual = 0;
		numGeneraciones=1;
		while (generacionActual < this.numGeneraciones) {
			seleccion();
			// Siguiente generacion
			generacionActual++;
		}
	}
}
