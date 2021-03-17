/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pevolutiva.practica1.algoritmoGenetico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.pevolutiva.practica1.algoritmoGenetico.cruce.Cruce;
import com.pevolutiva.practica1.algoritmoGenetico.cruce.CruceMonoPunto;
import com.pevolutiva.practica1.algoritmoGenetico.cruce.CruceUniforme;
import com.pevolutiva.practica1.algoritmoGenetico.individuos.Individuo;
import com.pevolutiva.practica1.algoritmoGenetico.individuos.IndividuoFuncion1;
import com.pevolutiva.practica1.algoritmoGenetico.individuos.IndividuoFuncion2;
import com.pevolutiva.practica1.algoritmoGenetico.individuos.IndividuoFuncion3;
import com.pevolutiva.practica1.algoritmoGenetico.individuos.IndividuoFuncion4;
import com.pevolutiva.practica1.algoritmoGenetico.mutacion.Mutacion;
import com.pevolutiva.practica1.algoritmoGenetico.mutacion.MutacionBasica;
import com.pevolutiva.practica1.algoritmoGenetico.seleccion.Seleccion;
import com.pevolutiva.practica1.algoritmoGenetico.seleccion.SeleccionEstocasticoUniversal;
import com.pevolutiva.practica1.algoritmoGenetico.seleccion.SeleccionRestos;
import com.pevolutiva.practica1.algoritmoGenetico.seleccion.SeleccionRuleta;
import com.pevolutiva.practica1.algoritmoGenetico.seleccion.SeleccionTorneo;
import com.pevolutiva.practica1.algoritmoGenetico.seleccion.SeleccionTruncamiento;
import org.apache.commons.lang.SerializationUtils;

/**
 *
 * @author Diego
 */
public class AlgoritmoGenetico {

	private Integer tamPoblacion;
	private Integer numGeneraciones;
	private Double porcentCruces;
	private Double porcetMutaciones;
	private Double precision;
	private String metodoSeleccion;
	private String metodoCruce;
	private String metodoMutacion;
	private Double porcentElitismo;
	private List<Individuo> poblacion;
	private Seleccion seleccion;
	private Cruce cruce;
	private Mutacion mutacion;
	private Individuo mejorAbsoluto;
	private Double mediaGeneracion;
	private Individuo mejorGeneracion;
	private String problema;

	public AlgoritmoGenetico(Integer tamPoblacion, Integer numGeneraciones, Double porcentCruces,
			Double porcetMutaciones, Double porcentElitismo, Double precision, String metodoSeleccion,
			String metodoCruce, String metodoMutacion, String problema) {
		this.tamPoblacion = tamPoblacion;
		this.numGeneraciones = numGeneraciones;
		this.porcentCruces = porcentCruces;
		this.porcetMutaciones = porcetMutaciones;
		this.precision = precision;
		this.metodoSeleccion = metodoSeleccion;
		this.metodoCruce = metodoCruce;
		this.metodoMutacion = metodoMutacion;
		this.porcentElitismo = porcentElitismo;
		this.problema = problema;
		iniciarSeleccion();
		iniciarCruce();
		iniciarMutacion();

	}

	public void iniciarPoblacion() {
		System.out.print(problema);
		List<Individuo> poblacion = new ArrayList<Individuo>();
		if (problema.equals("Problema 1"))
			for (int i = 0; i < tamPoblacion; i++)
				poblacion.add(new IndividuoFuncion1(precision));

		else if (problema.equals("Problema 2"))
			for (int i = 0; i < tamPoblacion; i++)
				poblacion.add(new IndividuoFuncion2(precision));

		else if (problema.equals("Problema 3"))
			for (int i = 0; i < tamPoblacion; i++)
				poblacion.add(new IndividuoFuncion3(precision));

		else
			for (int i = 0; i < tamPoblacion; i++)
				poblacion.add(new IndividuoFuncion4(precision, 7));

		this.poblacion = poblacion;
	}

	public void iniciarCruce() {

		switch (metodoCruce) {

		case ("Cruce monopunto"):
			cruce = new CruceUniforme();
			break;
		case ("Cruce uniforme"):
			cruce = new CruceMonoPunto();
			break;
		}
	}

	public void iniciarMutacion() {
		switch (metodoMutacion) {
		case ("Mutación básica"):
			mutacion = new MutacionBasica();
			break;
		}
	}

	public void iniciarSeleccion() {
		switch (metodoSeleccion) {

		case ("Ruleta"):
			seleccion = new SeleccionRuleta();
			break;
		case ("Estocástico universal"):
			seleccion = new SeleccionEstocasticoUniversal();
			break;
		case ("Torneo"):
			seleccion = new SeleccionTorneo();
			break;
		case ("Truncamiento"):
			seleccion = new SeleccionTruncamiento();
			break;
		case ("Restos"):
			seleccion = new SeleccionRestos();
			break;
		}

	}

	private List<Individuo> seleccionadosCruce(List<Individuo> nuevaPoblacion) {
		Random rand = new Random();
		List<Individuo> seleccionadosCruce = new ArrayList<Individuo>();

		for (int i = 0; i < nuevaPoblacion.size(); ++i) {
			Double alt = rand.nextDouble();
			if (porcentCruces > alt) {
				seleccionadosCruce.add(nuevaPoblacion.get(i));
				nuevaPoblacion.remove(nuevaPoblacion.get(i));
			}

		}
		if (seleccionadosCruce.size() % 2 != 0) {// si son impares eliminamos el ultimo.
			seleccionadosCruce.remove(seleccionadosCruce.get(seleccionadosCruce.size() - 1));
		}

		return seleccionadosCruce;
	}

	private void evaluarPoblacion() {
		Individuo mejorTemp = this.poblacion.get(0);
		Double total = 0.0;
		for (Individuo ind : this.poblacion) {
			total += ind.getValor();
			if (mejorTemp.getValor() < ind.getValor()) {
				mejorTemp = ind;
			}
		}
		this.mediaGeneracion = total / this.poblacion.size();
		this.mejorGeneracion = mejorTemp;
		if (this.mejorAbsoluto.getValor() < this.mejorGeneracion.getValor()) {
			this.mejorAbsoluto = (Individuo) SerializationUtils.clone(this.mejorGeneracion);
		}
	}

	private List<Individuo> generarElite(Double porcent) {
		int numIndividuos = (int) (porcent * this.poblacion.size());
		int i = 0;
		List<Individuo> elite = new ArrayList<Individuo>();
		Collections.sort(poblacion, (a, b) -> b.getValor().compareTo(a.getValor()));
		while (numIndividuos > i) {
			elite.add(poblacion.get(i));
			poblacion.remove(poblacion.get(i));
			i++;
		}

		return elite;

	}

	public String run() {
		iniciarPoblacion();
		this.mejorAbsoluto = this.poblacion.get(0);
		Integer generacionActual = 0;
		while (generacionActual < this.numGeneraciones) {
			List<Individuo> nuevaPoblacion = new ArrayList<Individuo>();
			List<Individuo> seleccionados = new ArrayList<Individuo>();
			List<Individuo> elite = new ArrayList<Individuo>();

			elite = generarElite(porcentElitismo);
			this.poblacion = seleccion.run(poblacion); // seleccion de Indivpiduos
			seleccionados = seleccionadosCruce(nuevaPoblacion);// Seleccionamos los individuos que vamos a cruzar
			seleccionados = cruce.run(seleccionados);// Elementos ya cruzados pendientes de añadirlos a la poblacion
			this.poblacion.addAll(seleccionados);
			this.poblacion = mutacion.run(poblacion, this.porcetMutaciones);
			this.poblacion.addAll(elite);
			this.evaluarPoblacion();

			System.out.println("Media generacion: " + this.mediaGeneracion);
			System.out.println("Mejor generacion: " + this.mejorGeneracion);
			System.out.println("Mejor absoluto: " + this.mejorAbsoluto);
			// Siguiente generacion
			generacionActual++;
		}
		return this.mejorAbsoluto.toString();
	}
}
