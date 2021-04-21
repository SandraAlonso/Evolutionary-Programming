/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoGenetico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang.SerializationUtils;

import algoritmoGenetico.cruce.Cruce;
import algoritmoGenetico.cruce.CruceCO;
import algoritmoGenetico.cruce.CruceCX;
import algoritmoGenetico.cruce.CruceERX;
import algoritmoGenetico.cruce.CruceInventado;
import algoritmoGenetico.cruce.CruceOX;
import algoritmoGenetico.cruce.CruceOXPP;
import algoritmoGenetico.cruce.CrucePMX;
import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.individuos.Individuo1;
import algoritmoGenetico.mutacion.Mutacion;
import algoritmoGenetico.mutacion.MutacionHeuristica;
import algoritmoGenetico.mutacion.MutacionInsercion;
import algoritmoGenetico.seleccion.Seleccion;
import algoritmoGenetico.seleccion.SeleccionEstocasticoUniversal;
import algoritmoGenetico.seleccion.SeleccionRanking;
import algoritmoGenetico.seleccion.SeleccionRestos;
import algoritmoGenetico.seleccion.SeleccionRuleta;
import algoritmoGenetico.seleccion.SeleccionTorneoDeterministico;
import algoritmoGenetico.seleccion.SeleccionTorneoProbabilistico;
import algoritmoGenetico.seleccion.SeleccionTruncamiento;

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
	private Integer signo;

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
//		iniciarSeleccion();
//		iniciarCruce();
//		iniciarMutacion();

	}

	public void iniciarPoblacion() {
		List<Individuo> poblacion = new ArrayList<Individuo>();
		for (int i = 0; i < tamPoblacion; i++)
			poblacion.add(new Individuo1());
	}

	public void iniciarCruce() {

		switch (metodoCruce) {

		case ("Cruce CO"):
			cruce = new CruceCO();
			break;
		case ("Cruce CX"):
			cruce = new CruceCX();
			break;
		case ("Cruce ERX"):
			cruce = new CruceERX();
			break;
		case ("Cruce OX"):
			cruce = new CruceOX();
			break;
		case ("Cruce OXPP"):
			cruce = new CruceOXPP();
			break;
		case ("Cruce PMX"):
			cruce = new CrucePMX();
			break;
		case ("Cruce nuevo"):
			cruce = new CruceInventado();
			break;
		}

	}

	public void iniciarMutacion() {

		/*switch (metodoMutacion) {
		case ("Mutación heurística"):
			mutacion = new MutacionHeuristica();
			break;

		case ("MutaciÃ³n por inserción"):
			mutacion = new MutacionInsercion();
			break;

		case ("MutaciÃ³n nueva"):
			mutacion = new MuatcionInventada();
			break;
		}*/

	}

	public void iniciarSeleccion() {
		switch (metodoSeleccion) {

		case ("Ruleta"):
			seleccion = new SeleccionRuleta();
			break;
		case ("EstocÃ¡stico universal"):
			seleccion = new SeleccionEstocasticoUniversal();
			break;
		case ("Torneo determinístico"):
			seleccion = new SeleccionTorneoDeterministico();
			break;
		case ("Truncamiento"):
			seleccion = new SeleccionTruncamiento();
			break;
		case ("Restos"):
			seleccion = new SeleccionRestos();
			break;
		case ("Ranking"):
			seleccion = new SeleccionRanking();
			break;
		case ("Torneo probabilístico"):
			seleccion = new SeleccionTorneoProbabilistico();
			break;
		}

	}

	private List<Individuo> seleccionadosCruce(List<Individuo> nuevaPoblacion) {
		Random rand = new Random();
		List<Individuo> seleccionadosCruce = new ArrayList<Individuo>();
		int tope = nuevaPoblacion.size();
		int i = 0;
		while (true) {
			if (i >= nuevaPoblacion.size()) {
				break;
			}
			Double alt = rand.nextDouble();
			if (porcentCruces > alt) {
				seleccionadosCruce.add(nuevaPoblacion.get(i));
				nuevaPoblacion.remove(nuevaPoblacion.get(i));
			} else {
				++i;
			}
		}

		if (seleccionadosCruce.size() % 2 != 0) {// si son impares eliminamos el ultimo.
			nuevaPoblacion.add(seleccionadosCruce.get(seleccionadosCruce.size() - 1));
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
			elite.add((Individuo) SerializationUtils.clone(poblacion.get(i)));
			i++;
		}
		return elite;

	}

	public Transfer run() {
		double[] arrayMedias = new double[numGeneraciones];
		double[] arrayMejoresAbs = new double[numGeneraciones];
		double[] arrayMejorGene = new double[numGeneraciones];
		double[] arrayNumGene = new double[numGeneraciones];
		for (int i = 1; i < numGeneraciones + 1; i++) {
			arrayNumGene[i - 1] = i;
		}
		iniciarPoblacion();

		this.mejorAbsoluto = this.poblacion.get(0);
		Integer generacionActual = 0;
		while (generacionActual < this.numGeneraciones) {
			List<Individuo> nuevaPoblacion = new ArrayList<Individuo>();
			List<Individuo> seleccionados = new ArrayList<Individuo>();
			List<Individuo> elite = new ArrayList<Individuo>();

			elite = generarElite(porcentElitismo);
			this.poblacion = seleccion.run(poblacion); // seleccion de Individuos
			System.out.println("Poblacion: " + this.poblacion.size());
			seleccionados = seleccionadosCruce(this.poblacion);// Seleccionamos los individuos que vamos a cruzar
			System.out.println("Seleccionados: " + seleccionados.size());
			seleccionados = cruce.run(seleccionados);// Elementos ya cruzados pendientes de aÃ±adirlos a la poblacion
			this.poblacion.addAll(seleccionados);
			this.poblacion = mutacion.run(poblacion, this.porcetMutaciones);
			// Ordenamos y eliminamos a los peores
			Collections.sort(poblacion, (a, b) -> b.getValor().compareTo(a.getValor()));
			for (int i = 0; i < elite.size(); i++) {
				poblacion.remove(poblacion.size() - 1);
			}
			// Reañadimos en la popblacion
			this.poblacion.addAll(elite);
			this.evaluarPoblacion();
			System.out.println("Poblacion: " + this.poblacion.size());

			arrayMedias[generacionActual] = mediaGeneracion * signo;
			arrayMejorGene[generacionActual] = mejorGeneracion.getValor() * signo;
			arrayMejoresAbs[generacionActual] = mejorAbsoluto.getValor() * signo;

			System.out.println("Media generacion: " + this.mediaGeneracion);
			System.out.println("Mejor generacion: " + this.mejorGeneracion);
			System.out.println("Mejor absoluto: " + this.mejorAbsoluto);
			// Siguiente generacion
			generacionActual++;
		}

		return null;
		// return new Transfer(arrayMedias, arrayMejoresAbs, arrayMejorGene,
		// arrayNumGene, mejorAbsoluto);
	}
}
