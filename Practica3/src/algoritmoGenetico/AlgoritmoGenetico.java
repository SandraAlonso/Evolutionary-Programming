package algoritmoGenetico;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.lang.SerializationUtils;

import algoritmoGenetico.cruce.Cruce;
import algoritmoGenetico.cruce.CruceIntercambio;

import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.individuos.Individuo1;

import algoritmoGenetico.mutacion.Mutacion;
import algoritmoGenetico.mutacion.MutacionArbol;
import algoritmoGenetico.mutacion.MutacionContraccion;
import algoritmoGenetico.mutacion.MutacionExpansion;
import algoritmoGenetico.mutacion.MutacionFuncionalSimple;
import algoritmoGenetico.mutacion.MutacionHoist;

import algoritmoGenetico.mutacion.MutacionPermutacion;
import algoritmoGenetico.mutacion.MutacionTerminalSimple;
import algoritmoGenetico.seleccion.Seleccion;
import algoritmoGenetico.seleccion.SeleccionEstocasticoUniversal;
import algoritmoGenetico.seleccion.SeleccionRanking;
import algoritmoGenetico.seleccion.SeleccionRestos;
import algoritmoGenetico.seleccion.SeleccionRuleta;
import algoritmoGenetico.seleccion.SeleccionTorneoDeterministico;
import algoritmoGenetico.seleccion.SeleccionTorneoProbabilistico;
import algoritmoGenetico.seleccion.SeleccionTruncamiento;

public class AlgoritmoGenetico {
	Random rand = new Random();
	private List<Individuo> poblacion;
	private Integer tamPoblacion;
	private Integer numGeneraciones;
	private String metodoSeleccion;
	private String metodoCruce;
	private String metodoMutacion;
	private String metodoIni;

	private Cruce cruce;
	private Mutacion mutacion;
	private Seleccion seleccion;
	private Double porcentCruces;
	private Double porcetMutaciones;
	private Double porcentElitismo;
	private Individuo mejorAbsoluto;
	private Double mediaGeneracion;
	private Individuo mejorGeneracion;
	private Individuo peorIndividuo;
	private Double covarianza;
	private Double varianza;
	public static boolean[][] mapa = new boolean[32][32];
	private static int profMax;

	public static Double k;
	public static Double media_prof;

	public AlgoritmoGenetico(Integer tamPoblacion, Integer numGeneraciones, Double porcentCruces,
			Double porcetMutaciones, Double porcentElitismo, String metodoSeleccion, String metodoCruce,
			String metodoMutacion, String metodoIni, int profMax) {
		this.tamPoblacion = tamPoblacion;
		this.numGeneraciones = numGeneraciones;
		this.porcentCruces = porcentCruces;
		this.porcetMutaciones = porcetMutaciones;
		this.metodoSeleccion = metodoSeleccion;
		this.metodoCruce = metodoCruce;
		this.metodoMutacion = metodoMutacion;
		this.porcentElitismo = porcentElitismo;
		this.metodoIni = metodoIni;
		this.profMax = profMax;
		iniciarSeleccion();
		iniciarCruce();
		iniciarMutacion();
		leerMapa();

	}

	public void leerMapa() {
		try {
			int j = 0;
			File myObj = new File("mapa/SantaFe.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String key[] = data.split(" ");
				for (int i = 0; i < key.length; i++) {
					mapa[j][i] = (key[i].equals("0")) ? false : true;
				}
				j++;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	

	public static int getProfMax() {
		return profMax;
	}

	public void iniciarPoblacion() {
		this.poblacion = new ArrayList<Individuo>();
		if (metodoIni.equals("Ramped and Half")) {
			for(int i = 0; i < profMax - 1; ++i) {
				for(int j = 0; j < (int) ((tamPoblacion / (profMax - 1)) / 2); ++j) {
					poblacion.add(new Individuo1("Creciente", 1,  i + 2));
					poblacion.add(new Individuo1("Completa", 1, i + 2));
				}
			}
		} 
		else {
			for (int i = 0; i < tamPoblacion; i++)
				poblacion.add(new Individuo1(metodoIni, 1, profMax));
		}

	}

	public void calcularMedia() {
		Double media = 0.0;
		for (Individuo i : poblacion) {
			media += i.getArbol().getProfundidad();
		}
		media_prof = media / poblacion.size();
	}

	public void iniciarCruce() {

		switch (metodoCruce) {

		case ("Cruce por intercambio"):
			cruce = new CruceIntercambio();
			break;

		}

	}

	public void iniciarMutacion() {

		switch (metodoMutacion) {
		case ("Mutación árbol"):
			mutacion = new MutacionArbol();
			break;

		case ("Mutación por contracción"):
			mutacion = new MutacionContraccion();
			break;

		case ("Mutación por expansión"):
			mutacion = new MutacionExpansion();
			break;
		case ("Mutación funcional simple"):
			mutacion = new MutacionFuncionalSimple();
			break;
		case ("Mutación hoist"):
			mutacion = new MutacionHoist();
			break;
		case ("Mutación por permutación"):
			mutacion = new MutacionPermutacion();
			break;
		case ("Mutación terminal simple"):
			mutacion = new MutacionTerminalSimple();
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

	private void calcularCovarianza() {
		Double cov = 0.0;
		Double mediaFitness = 0.0;
		for (int i = 0; i < poblacion.size(); i++) {
			mediaFitness += poblacion.get(i).getValorSinK();
		}
		mediaFitness = mediaFitness / poblacion.size();
		for (int i = 0; i < poblacion.size(); i++) {
			
			cov += (double) (poblacion.get(i).getValorSinK() - mediaFitness)
					* (poblacion.get(i).getArbol().getProfundidad() - this.media_prof);
			

		}
		this.covarianza = cov / (double) poblacion.size() ;
	}

	private void calcularVarianza() {
		Double v = 0.0;
		for (int i = 0; i < poblacion.size(); i++) {
			v += Math.pow((double)poblacion.get(i).getArbol().getProfundidad() - this.media_prof, 2);

		}
		this.varianza = v / (double) poblacion.size();
	}

	private void calcularK() {
		calcularMedia();
		calcularVarianza();
		calcularCovarianza();
		
		if (varianza == 0.0)
			k = 0.0;
		else
			k = covarianza / varianza;
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
		this.peorIndividuo = this.poblacion.get(0);

		this.mejorAbsoluto = this.poblacion.get(0);
		Integer generacionActual = 0;
		while (generacionActual < this.numGeneraciones) {
			List<Individuo> nuevaPoblacion = new ArrayList<Individuo>();
			List<Individuo> seleccionados = new ArrayList<Individuo>();
			List<Individuo> elite = new ArrayList<Individuo>();
			System.out.println("generacionactual: " + generacionActual);
			calcularK();
			elite = generarElite(porcentElitismo);
			this.poblacion = seleccion.run(poblacion); // seleccion de Individuos
			System.out.println("k: " + this.k);
			seleccionados = seleccionadosCruce(this.poblacion);// Seleccionamos los individuos que vamos a cruzar
			// System.out.println("Seleccionados: " + seleccionados.size());

			// System.out.println("Cruce");
			seleccionados = cruce.run(seleccionados);// Elementos ya cruzados pendientes de aÃ±adirlos a la poblacion
			this.poblacion.addAll(seleccionados);

			// System.out.println("Mutacion");
			this.poblacion = mutacion.run(poblacion, this.porcetMutaciones);
			// Ordenamos y eliminamos a los peores

			Collections.sort(poblacion, (a, b) -> b.getValor().compareTo(a.getValor()));

			if (peorIndividuo.getValor() > poblacion.get(poblacion.size() - 1).getValor()) {
				peorIndividuo = poblacion.get(poblacion.size() - 1);
			}
			for (int i = 0; i < elite.size(); i++) {
				poblacion.remove(poblacion.size() - 1);
			}
			// Reañadimos en la poblacion
			this.poblacion.addAll(elite);

			this.evaluarPoblacion();
			// System.out.println("Poblacion: " + this.poblacion.size());

			arrayMedias[generacionActual] = mediaGeneracion;
			arrayMejorGene[generacionActual] = mejorGeneracion.getValor();
			arrayMejoresAbs[generacionActual] = mejorAbsoluto.getValor();

			System.out.println("Media generacion: " + this.mediaGeneracion);
			System.out.println("Mejor generacion: " + this.mejorGeneracion.toString());
			System.out.println("Mejor absoluto: " + this.mejorAbsoluto.toString());
			System.out.println("Mejor solucion: " + this.mejorAbsoluto.getValor());
			// Siguiente generacion
			generacionActual++;

		}
		return new Transfer(arrayMedias, arrayMejoresAbs, arrayMejorGene, arrayNumGene, mejorAbsoluto);
	}
}
