package algoritmoGenetico;

import algoritmoGenetico.individuos.Individuo;

public class Transfer {
	private double[] arrayMedias;
	private double[] arrayMejoresAbs;
	private double[] arrayMejorGene;
	private double[] arrayNumGene;
	private Individuo mejorIndividuo;
	private String textoDescifrado;

	public double[] getArrayMedias() {
		return arrayMedias;
	}

	public void setArrayMedias(double[] arrayMedias) {
		this.arrayMedias = arrayMedias;
	}

	public double[] getArrayMejoresAbs() {
		return arrayMejoresAbs;
	}

	public void setArrayMejoresAbs(double[] arrayMejoresAbs) {
		this.arrayMejoresAbs = arrayMejoresAbs;
	}

	public double[] getArrayMejorGene() {
		return arrayMejorGene;
	}

	public Individuo getMejorIndividuo() {
		return mejorIndividuo;
	}

	public void setArrayMejorGene(double[] arrayMejorGene) {
		this.arrayMejorGene = arrayMejorGene;
	}

	public double[] getArrayNumGene() {
		return arrayNumGene;
	}

	public void setArrayNumGene(double[] arrayNumGene) {
		this.arrayNumGene = arrayNumGene;
	}

	public Transfer(double[] arrayMedias, double[] arrayMejoresAbs, double[] arrayMejorGene, double[] arrayNumGene,
			Individuo mejorIndividuo, String textoDescifrado) {
		super();
		this.arrayMedias = arrayMedias;
		this.arrayMejoresAbs = arrayMejoresAbs;
		this.arrayMejorGene = arrayMejorGene;
		this.arrayNumGene = arrayNumGene;
		this.mejorIndividuo = mejorIndividuo;
		this.textoDescifrado= textoDescifrado;
	}

}
