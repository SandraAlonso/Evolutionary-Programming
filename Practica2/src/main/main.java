package main;


import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import algoritmoGenetico.AlgoritmoGenetico;
import vista.VistaPrincipal;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*AlgoritmoGenetico alg = new AlgoritmoGenetico(100, 100, 0.6, 0.1, 0.01, 0.0, null, null, null, null);
		alg.iniciarPoblacion();*/
		

		String prueba = "In the code snippet below you will also learn how to use the toCharArray method to covert a string into an array of char. Here we use the method so that we can check every character in the for-each loop to see is the character is a letter or not.";
		
		Map<String,Long> digramFrec = Arrays.stream(prueba.replaceAll("(?<!^| ).(?! |$)", "$0$0").
				split(" |(?<=\\G..)")).filter(s -> s.length() > 1).collect(Collectors.groupingBy(s -> s,
				Collectors.counting()));
		System.out.println(digramFrec);
		//VistaPrincipal v = new VistaPrincipal();
		//v.open();
	}

}
