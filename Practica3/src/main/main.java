package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import algoritmoGenetico.AlgoritmoGenetico;
import algoritmoGenetico.cruce.Cruce;
import algoritmoGenetico.cruce.CruceIntercambio;
import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.individuos.Individuo1;
import algoritmoGenetico.individuos.TArbol;
import vista.VistaPrincipal;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * AlgoritmoGenetico alg = new AlgoritmoGenetico(100, 100, 0.6, 0.1, 0.01, 0.0,
		 * null, null, null, null); alg.iniciarPoblacion();
		 */

		/*
		 * String prueba =
		 * "In the code snippet below you will also learn how to use the toCharArray method to covert a string into an array of char. Here we use the method so that we can check every character in the for-each loop to see is the character is a letter or not."
		 * ;
		 * 
		 * Map<String,Long> digramFrec =
		 * Arrays.stream(prueba.replaceAll("(?<!^| ).(?! |$)", "$0$0").
		 * split(" |(?<=\\G..)")).filter(s -> s.length() >
		 * 1).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
		 * System.out.println(digramFrec);
		 */
		/*
		 * VistaPrincipal v = new VistaPrincipal(); v.open();
		 */
		/*
		 * AlgoritmoGenetico alg = new AlgoritmoGenetico(100, 100, 0.6, 0.02, 0.02,
		 * "Truncamiento", "Cruce OX", "Mutación por intercambio"); alg.run();
		 */
		/*Individuo1 a = new Individuo1();
		Individuo1 c = new Individuo1();

		TArbol j = a.crearArbolCompleto(null, 4);
		a.setArbol(j);
		TArbol b = c.crearArbolCompleto(null, 4);
		c.setArbol(b);
		List<Individuo> poblacion = new ArrayList<Individuo>();
		poblacion.add(a);
		poblacion.add(c);
		Cruce cr = new CruceIntercambio();
		cr.run(poblacion);
		System.out.print(c);
		return;*/
		AlgoritmoGenetico alg = new AlgoritmoGenetico(100, 100, 0.6, 0.02, 0.02,
				  "Truncamiento", "Cruce por intercambio", "Mutación funcional simple", "creciente"); 
		alg.run();
	}

}
