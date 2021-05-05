package algoritmoGenetico.individuos;

import algoritmoGenetico.individuos.TArbol.Tipo;

public class Individuo1 extends Individuo {

	TArbol arbol;
	double adaptacion;
	double puntuacion;
	double punt_acum;
	boolean elite;
	@Override
	public Double getValor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String devolverTexto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String solucion() {
		// TODO Auto-generated method stub
		return null;
	}
	public TArbol crearArbol(TArbol arbol, Integer prof_min, Integer prof_max) {
		arbol = new TArbol();
		TArbol[] hijos;

		if (prof_min > 0) {// operador
			Tipo operador = TArbol.Tipo.values()[rand.nextInt(3) + 3];
			arbol.setTipo(operador);
			if (operador == Tipo.PROGN3) {
				hijos = new TArbol[3];
			} else
				hijos = new TArbol[2];

			for (int i = 0; i < hijos.length; i++) {
				TArbol HI = crearArbol(hijos[i], prof_min - 1, prof_max - 1);
				HI.setPadre(arbol);
				arbol.setNum_nodos(arbol.getNum_nodos() + HI.getNum_nodos());
				hijos[i] = HI;

			}
			arbol.setHijos(hijos);
		}
		if (prof_max == 0) {// hoja
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
				if (operador==Tipo.PROGN3) 
					hijos = new TArbol[3];
				 else
					hijos = new TArbol[2];

				for (int i = 0; i < hijos.length; i++) {
					TArbol HI = crearArbol(hijos[i], prof_min - 1, prof_max - 1);
					HI.setPadre(arbol);
			
					arbol.setNum_nodos(arbol.getNum_nodos() + HI.getNum_nodos());
					hijos[i] = HI;

				}
				arbol.setHijos(hijos);
			}

		}
		
		return arbol;
	}

}
