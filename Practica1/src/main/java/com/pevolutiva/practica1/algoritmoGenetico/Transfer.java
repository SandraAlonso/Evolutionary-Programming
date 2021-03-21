package com.pevolutiva.practica1.algoritmoGenetico;



public class Transfer {

	private double[] arrayMedias;
	private double[] arrayMejoresAbs;
	private double[] arrayMejorGene;
	private double[] arrayNumGene;
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
	public void setArrayMejorGene(double[] arrayMejorGene) {
		this.arrayMejorGene = arrayMejorGene;
	}
	public double[] getArrayNumGene() {
		return arrayNumGene;
	}
	public void setArrayNumGene(double[] arrayNumGene) {
		this.arrayNumGene = arrayNumGene;
	}
	public Transfer(double[] arrayMedias, double[] arrayMejoresAbs, double[] arrayMejorGene, double[] arrayNumGene) {
		super();
		this.arrayMedias = arrayMedias;
		this.arrayMejoresAbs = arrayMejoresAbs;
		this.arrayMejorGene = arrayMejorGene;
		this.arrayNumGene = arrayNumGene;
	}

	
}
