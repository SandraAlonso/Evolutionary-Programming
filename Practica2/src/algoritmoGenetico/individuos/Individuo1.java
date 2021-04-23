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
	private int numTrigramas = 0;
	private String[] letras= { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
			"s", "t", "u", "v", "w", "x", "y", "z" };

	public Individuo1() {
		numMonogramas = 0;
		textoDescifrado = "";
		int tamTotal = 26;
		List<Integer> numeros = new ArrayList<>();
		this.cromosoma = new Integer[tamTotal];
		for (int i = 0; i < tamTotal; ++i) {
			numeros.add(i);
		}

		for (int i = 0; i < tamTotal - 1; ++i) {
			int pos = this.rand.nextInt(numeros.size());
			this.cromosoma[i] = numeros.get(pos);
			numeros.remove(pos);
		}
		this.cromosoma[tamTotal - 1] = numeros.get(0);

	}

	private void descifrar() {
		String aux = AlgoritmoGenetico.textoCifrado;
		char[] listChar = aux.toCharArray();
		for (char c : listChar) {
			if (Character.isLetter(c)) {
				int pos = Character.getNumericValue(c) - 10;
				textoDescifrado += letras[this.cromosoma[pos]];
			} else {
				textoDescifrado += c;
			}
		}
	}

	private Map<String, Long> unigramas() {
		char[] listChar = textoDescifrado.toCharArray();
		Map<String, Long> sol = new HashMap();

		for (char c : listChar) {
			if (Character.isLetter(c)) {
				if (sol.containsKey(String.valueOf(c))) {
					sol.put(String.valueOf(c), sol.get(String.valueOf(c)) + 1);
				} else {
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

	private Map<String, Long> trigramas() {
		Map<String, Long> sol = new HashMap();
		String[] palabras = textoDescifrado.split(" ");
		for (String s : palabras) {
			if (s.length() >= 3) {
				for (int i = 1; i < s.length() - 1; i++) {
					String a = s.substring(i - 1, i + 2);
					if (sol.containsKey(a)) {
						sol.put(s, sol.get(a) + 1);
					} else {
						sol.put(a, (long) 1);
					}
					numTrigramas++;
				}
			}
		}
		return sol;
	}

	@Override
	public Double getValor() {
		Double fitness = 0.0;
		numMonogramas = 0;
		int numBigramas = 0;
		numTrigramas = 0;
		descifrar();
		// Monogramas
		for (Map.Entry<String, Long> entry : unigramas().entrySet()) {
			if (AlgoritmoGenetico.monogramas.containsKey(entry.getKey())) {
				Double a = (double) (entry.getValue() / (double)numMonogramas);
				Double b =this.log2(AlgoritmoGenetico.monogramas.get(entry.getKey()));
				fitness+=(a*b);
			}
		}
		// Bigramas
		Map<String, Long> digramFrec = Arrays
				.stream(textoDescifrado.replaceAll("(?<!^| ).(?! |$)", "$0$0").split(" |(?<=\\G..)"))
				.filter(s -> s.length() > 1).collect(Collectors.groupingBy(s -> s, Collectors.counting()));

		// Contar numero de bigramas
		for (Map.Entry<String, Long> entry : digramFrec.entrySet()) {
			numBigramas += entry.getValue();
		}

		for (Map.Entry<String, Long> entry : digramFrec.entrySet()) {
			if (AlgoritmoGenetico.bigramas.containsKey(entry.getKey()))
				fitness += (double) (entry.getValue() / numBigramas)
						* this.log2(AlgoritmoGenetico.bigramas.get(entry.getKey()));
		}
		// Trigramas;
		for (Map.Entry<String, Long> entry : trigramas().entrySet()) {
			if (AlgoritmoGenetico.trigramas.containsKey(entry.getKey()))
				fitness += (double) (entry.getValue() / numTrigramas)
						* this.log2(AlgoritmoGenetico.trigramas.get(entry.getKey()));
		}
		return fitness;

	}

	@Override
	public String devolverTexto() {
		return textoDescifrado;
	}

}
