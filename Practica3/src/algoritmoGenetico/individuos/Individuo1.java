package algoritmoGenetico.individuos;

import java.util.Iterator;

import algoritmoGenetico.AlgoritmoGenetico;
import algoritmoGenetico.individuos.TArbol.Tipo;

public class Individuo1 extends Individuo {

	private TArbol arbol;
	private double adaptacion;
	private double puntuacion = 0.0;
	private double punt_acum;
	private boolean elite;
	private int pasos = 0, bocados = 0;
	private int posActX = 0, posActY = 0;
	private int[] direccion = { 0, 1 };
	private String metodoInicializacion;
	private int prof_min;
	private int prof_max;
	private boolean[][] pasosMapa = new boolean[32][32];

	@Override

	public Double getValor() {
		pasos = 0;
		bocados = 0;
		posActX = 0;
		posActY = 0;
		direccion[0] = 0;
		direccion[1] = 1;
		// TODO mirar mejor bloating
		for (int i = 0; i < pasosMapa.length; i++) {
			for (int j = 0; j < pasosMapa[i].length; j++) {
				pasosMapa[i][j] = false;

			}

		}
		while(pasos < 400 && bocados < 90)
			ejecutarArbol(arbol);
		return (double) bocados + AlgoritmoGenetico.k * this.arbol.getNum_nodos();

	}

	@Override
	public Double getValorSinK() {
		ejecutarArbol(arbol);
		return (double) bocados;
	}

	public Individuo1(String metodoIni, int profMin, int profMax) {
		metodoInicializacion = metodoIni;
		prof_min = profMin;
		prof_max = profMax;
		if (metodoInicializacion.equals("Creciente"))
			this.arbol = crearArbolCreciente(arbol, prof_min, prof_max);
		else
			this.arbol = crearArbolCompleto(arbol, prof_max);

	}

	@Override
	public boolean[][] solucion() {
		return pasosMapa;
	}

	@Override
	public String toString() {
		return "Individuo1 [pasos=" + pasos + ", bocados=" + bocados + ", prof_min=" + prof_min + ", prof_max="
				+ prof_max + ", prof_act=" + arbol.getProfundidad() + "]";
	}

	private void ejecutarArbol(TArbol arbol) {

		
			if (pasos == 400 || bocados == 90)
				return;

			if (arbol.getTipo() == Tipo.PROGN3 || arbol.getTipo() == Tipo.PROGN2) {
				for (TArbol a : arbol.getHijos()) {
					ejecutarArbol(a);
				}
			} else if (arbol.getTipo() == Tipo.SIC) {
				int posxMirar=posActX+ direccion[1];
				int posyMirar=posActY + direccion[0];

				if(posyMirar>31)
					posyMirar=0;
				else if(posyMirar<0)
					posyMirar=31;
				if(posxMirar>31)
					posxMirar=0;
				else if(posxMirar<0)
					posxMirar=31;
					
				if (AlgoritmoGenetico.mapa[posyMirar][posxMirar]) {
					ejecutarArbol(arbol.getHijos()[0]);
				} else {
					ejecutarArbol(arbol.getHijos()[1]);
				}
			} else if (arbol.getTipo() == Tipo.AVANZA) {
				avanzar();
			} else if (arbol.getTipo() == Tipo.GIRA_DERECHA) {
				derecha();
			} else {
				izquierda();
			}
		

	}

	private void avanzar() {
		if (posActY + direccion[0] >= 32)
			posActY = 0;
		else if (posActY + direccion[0] < 0)
			posActY = 31;
		else
			posActY = posActY + direccion[0];
		if (posActX + direccion[1] >= 32)
			posActX = 0;
		else if (posActX + direccion[1] < 0)
			posActX = 31;
		else
			posActX = posActX + direccion[1];

		if (!pasosMapa[posActX][posActY] && AlgoritmoGenetico.mapa[posActY][posActX]) {
			bocados++;
		}
		pasos++;
		pasosMapa[posActX][posActY] = true;
	}

	private void derecha() {
		if (direccion[0] == 0) {
			if (direccion[1] == 1) {
				direccion[0] = 1;
				direccion[1] = 0;
			} else {
				direccion[0] = -1;
				direccion[1] = 0;
			}
		} else {
			if (direccion[0] == 1) {
				direccion[0] = 0;
				direccion[1] = -1;
			} else {
				direccion[0] = 0;
				direccion[1] = 1;
			}
		}
		pasos++;
	}

	private void izquierda() {
		if (direccion[0] == 0) {
			if (direccion[1] == 1) {
				direccion[0] = -1;
				direccion[1] = 0;
			} else {
				direccion[0] = 1;
				direccion[1] = 0;
			}
		} else {
			if (direccion[0] == 1) {
				direccion[0] = 0;
				direccion[1] = 1;
			} else {
				direccion[0] = 0;
				direccion[1] = -1;
			}
		}
		pasos++;
	}

	public TArbol crearArbolCompleto(TArbol arbol, Integer prof_max) {
		arbol = new TArbol();
		TArbol[] hijos;
		if (prof_max > 0) {// operador
			Tipo operador = TArbol.Tipo.values()[rand.nextInt(3) + 3];
			arbol.setTipo(operador);
			if (operador == Tipo.PROGN3) {
				hijos = new TArbol[3];
			} else
				hijos = new TArbol[2];
			int prof = 0;
			for (int i = 0; i < hijos.length; i++) {
				TArbol HI = crearArbolCompleto(hijos[i], prof_max - 1);
				HI.setPadre(arbol);
				if (HI.getProfundidad() > prof)
					prof = HI.getProfundidad();
				arbol.setNum_nodos(arbol.getNum_nodos() + HI.getNum_nodos());
				hijos[i] = HI;

			}
			arbol.setNum_nodos(1 + arbol.getNum_nodos());
			arbol.setProfundidad(prof + 1);
			arbol.setHijos(hijos);

		} else { // operando
			Tipo operador = TArbol.Tipo.values()[rand.nextInt(3)];
			arbol.setTipo(operador);
			arbol.setNum_nodos(arbol.getNum_nodos() + 1);
		}

		return arbol;

	}

	public TArbol crearArbolCreciente(TArbol arbol, Integer prof_min, Integer prof_max) {
		arbol = new TArbol();
		TArbol[] hijos;

		if (prof_min > 0) {// operador
			Tipo operador = TArbol.Tipo.values()[rand.nextInt(3) + 3];
			arbol.setTipo(operador);
			if (operador == Tipo.PROGN3) {
				hijos = new TArbol[3];
			} else
				hijos = new TArbol[2];

			int prof = 0;
			for (int i = 0; i < hijos.length; i++) {
				TArbol HI = crearArbolCreciente(hijos[i], prof_min - 1, prof_max - 1);
				HI.setPadre(arbol);
				if (HI.getProfundidad() > prof)
					prof = HI.getProfundidad();
				arbol.setNum_nodos(arbol.getNum_nodos() + HI.getNum_nodos());
				hijos[i] = HI;

			}
			arbol.setNum_nodos(1 + arbol.getNum_nodos());
			arbol.setProfundidad(prof + 1);
			arbol.setHijos(hijos);
		} else if (prof_max == 0) {// hoja
			Tipo operador = TArbol.Tipo.values()[rand.nextInt(3)];
			arbol.setTipo(operador);
			arbol.setNum_nodos(arbol.getNum_nodos() + 1);

		} else {// operando u operador
			int alt = rand.nextInt(6);
			Tipo operador = TArbol.Tipo.values()[alt];
			arbol.setTipo(operador);

			if (alt < 3) {// operando
				arbol.setNum_nodos(arbol.getNum_nodos() + 1);
			} else {// operador
				if (operador == Tipo.PROGN3)
					hijos = new TArbol[3];
				else
					hijos = new TArbol[2];
				int prof = 0;
				for (int i = 0; i < hijos.length; i++) {
					TArbol HI = crearArbolCreciente(hijos[i], prof_min - 1, prof_max - 1);
					HI.setPadre(arbol);
					if (HI.getProfundidad() > prof)
						prof = HI.getProfundidad();
					arbol.setNum_nodos(arbol.getNum_nodos() + HI.getNum_nodos());
					hijos[i] = HI;

				}
				arbol.setNum_nodos(1 + arbol.getNum_nodos());
				arbol.setProfundidad(prof + 1);
				arbol.setHijos(hijos);
			}

		}

		return arbol;
	}

	@Override
	public TArbol getArbol() {
		return this.arbol;
	}

	@Override
	public void setArbol(TArbol a) {
		this.arbol = a;
	}

}
