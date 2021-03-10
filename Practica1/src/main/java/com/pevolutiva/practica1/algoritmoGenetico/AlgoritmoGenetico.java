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
import com.pevolutiva.practica1.algoritmoGenetico.seleccion.Seleccion;
import com.pevolutiva.practica1.algoritmoGenetico.seleccion.SeleccionEstocasticoUniversal;
import com.pevolutiva.practica1.algoritmoGenetico.seleccion.SeleccionRuleta;

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

	public void iniciarPoblacion() {
		tamPoblacion= 5;
		List<Individuo> poblacion = new ArrayList<Individuo>();
		for (int i = 0; i < tamPoblacion; i++)
			poblacion.add(new IndividuoFuncion1());
		this.poblacion = poblacion;
	}
        
        public void iniciarSeleccion(){
            //if (metodoSeleccion == "Ruleta")
		//seleccion = new SeleccionRuleta();
		seleccion = new SeleccionEstocasticoUniversal();
        }

	public void run() {
		iniciarPoblacion();
		Integer generacionActual = 0;
		numGeneraciones=1;
                iniciarSeleccion();
		while (generacionActual < this.numGeneraciones) {
			seleccion.run(poblacion);
			// Siguiente generacion
			generacionActual++;
		}
	}
}
