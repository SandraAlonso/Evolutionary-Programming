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

import com.pevolutiva.practica1.algoritmoGenetico.cruce.Cruce;
import com.pevolutiva.practica1.algoritmoGenetico.cruce.CruceMonoPunto;
import com.pevolutiva.practica1.algoritmoGenetico.cruce.CruceUniforme;
import com.pevolutiva.practica1.algoritmoGenetico.individuos.Individuo;
import com.pevolutiva.practica1.algoritmoGenetico.individuos.IndividuoFuncion1;
import com.pevolutiva.practica1.algoritmoGenetico.mutacion.Mutacion;
import com.pevolutiva.practica1.algoritmoGenetico.mutacion.MutacionBasica;
import com.pevolutiva.practica1.algoritmoGenetico.seleccion.Seleccion;
import com.pevolutiva.practica1.algoritmoGenetico.seleccion.SeleccionEstocasticoUniversal;
import com.pevolutiva.practica1.algoritmoGenetico.seleccion.SeleccionRuleta;
import com.pevolutiva.practica1.algoritmoGenetico.seleccion.SeleccionTorneo;
import com.pevolutiva.practica1.algoritmoGenetico.seleccion.SeleccionTruncamiento;

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
	private Seleccion seleccion;
	private Cruce cruce;
	private Mutacion mutacion;

	public void iniciarPoblacion() {
		tamPoblacion = 20;
		List<Individuo> poblacion = new ArrayList<Individuo>();
		for (int i = 0; i < tamPoblacion; i++)
			poblacion.add(new IndividuoFuncion1());
		this.poblacion = poblacion;
	}

	public void iniciarCruce() {
		cruce = new CruceUniforme();
		cruce = new CruceMonoPunto();
	}
	public void iniciarMutacion() {
		mutacion = new MutacionBasica();
	}
	
	public void iniciarSeleccion() {
		// switch(metodoSeleccion){
		/*
		 * case("Ruleta"): seleccion = new SeleccionRuleta(); break;
		 * case("Estocastico"): seleccion = new SeleccionEstocasticoUniversal(); break;
		 * case("Torneo"): seleccion = new SeleccionTorneo(); break;
		 * case("Truncamiento"): seleccion = new SeleccionTruncamiento(); break;
		 * case("Restos"): seleccion = new SeleccionRestos(); break;
		 */

		// }

		seleccion = new SeleccionTruncamiento();

	}

	private List<Individuo> seleccionadosCruce(List<Individuo> nuevaPoblacion) {
		Random rand = new Random();
		List<Individuo> seleccionadosCruce = new ArrayList<Individuo>();

		for (int i = 0; i < nuevaPoblacion.size(); ++i) {
			Double alt = rand.nextDouble();
			if (alt > 0.6) {
				Double alt2 = rand.nextDouble();
				if ( porcentCruces> alt) {
					seleccionadosCruce.add(nuevaPoblacion.get(i));
					nuevaPoblacion.remove(nuevaPoblacion.get(i));
				}

			}
		}
		if(seleccionadosCruce.size()%2!=0) {//si son impares eliminamos el ultimo.
			seleccionadosCruce.remove(seleccionadosCruce.get(seleccionadosCruce.size()-1));
		}

		return seleccionadosCruce;
	}

	public void run() {
		iniciarPoblacion();
		Integer generacionActual = 0;
		numGeneraciones = 1;
		iniciarSeleccion();
		while (generacionActual < this.numGeneraciones) {
			List<Individuo> nuevaPoblacion = new ArrayList<Individuo>();
			List<Individuo> seleccionados = new ArrayList<Individuo>();
			
			this.poblacion=seleccion.run(poblacion); //seleccion de Indivpiduos
			seleccionados = seleccionadosCruce(nuevaPoblacion);//Seleccionamos los individuos que vamos a cruzar
			seleccionados=cruce.run(seleccionados);//Elementos ya cruzados pendientes de añadirlos a la poblacion
			this.poblacion.addAll(seleccionados);
			this.poblacion=mutacion.run(poblacion, this.porcetMutaciones);
			// Siguiente generacion
			generacionActual++;
		}
	}
}
