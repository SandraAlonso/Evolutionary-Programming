package algoritmoGenetico.individuos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import algoritmoGenetico.AlgoritmoGenetico;

public class Individuo1 extends Individuo<Integer> {
	
	private String textoDescifrado;
	private int numMonogramas;
	
	public Individuo1() {
		numMonogramas = 0;
		textoDescifrado = "";
		int tamTotal = 26;
		List<Integer> numeros = new ArrayList<>();
		this.cromosoma = new Integer[tamTotal];
		for(int i = 0; i < tamTotal; ++i) {
			numeros.add(i);
		}
		
		for(int i = 0; i < tamTotal - 1; ++i) {
			int pos = this.rand.nextInt(numeros.size());
			this.cromosoma[i] = numeros.get(pos);
			numeros.remove(pos);
		}
		this.cromosoma[tamTotal - 1] = numeros.get(0);
		
	}
	
	private void descifrar() {
		String aux = AlgoritmoGenetico.textoCifrado;
		char[] listChar = aux.toCharArray();
		for(char c : listChar) {
			if(Character.isLetter(c)) {
				int pos = c - 97;
				textoDescifrado += this.cromosoma[pos];
			}
			else {
				textoDescifrado += c;
			}
		}
	}
	
	
	
	private Map<String,Long> unigramas() {
		Map<String,Long> sol = new HashMap();
		char[] listChar = textoDescifrado.toCharArray();
		
		for(char c : listChar) {
			if(Character.isLetter(c)) {
				if(sol.containsKey(String.valueOf(c))) {
					sol.put(String.valueOf(c), sol.get(String.valueOf(c)));
				}
				else {
					sol.put(String.valueOf(c), (long) 1);
				}
				numMonogramas++;
				
			}
			
		}	
		return sol;
		
	}
	
	private Double log2(Double x) {
		return (Math.log(x) / Math.log(2));
	}

	@Override
	public Double getValor() {
		Double fitness = 0.0;
		
		for(Map.Entry<String, Long> entry : unigramas().entrySet()) {
			fitness += (double)  (entry.getValue() / numMonogramas ) * this.log2(AlgoritmoGenetico.monogramas.get(entry.getKey()));
		}
		
		
		Map<String,Long> digramFrec = Arrays.stream(textoDescifrado.replaceAll("(?<!^| ).(?! |$)", "$0$0").
				split(" |(?<=\\G..)")).filter(s -> s.length() > 1).collect(Collectors.groupingBy(s -> s,
				Collectors.counting()));
		
		for(Map.Entry<String, Long> entry : digramFrec.entrySet()) {
			fitness += (double)  (entry.getValue() / numMonogramas ) * this.log2(AlgoritmoGenetico.bigramas.get(entry.getKey()));
		}
		
		
		return null;

	}

}
