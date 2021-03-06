package algoritmoGenetico.individuos;

import java.io.Serializable;

public class TArbol implements Serializable{

	private TArbol padre;
	private TArbol[] hijos;
	private Tipo tipo;
	private Integer num_nodos = 0;
	private int profundidad = 0;

	public static enum Tipo {
		AVANZA, GIRA_DERECHA, GIRA_IZQUIERDA, SIC, PROGN2, PROGN3
	}

	public TArbol getPadre() {
		return padre;
	}

	public void setPadre(TArbol padre) {
		this.padre = padre;
	}

	public TArbol[] getHijos() {
		return hijos;
	}

	public void setHijos(TArbol[] hijos) {
		this.hijos = hijos;
		for(TArbol a : this.hijos) {
			a.padre = this;
		}
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Integer getNum_nodos() {
		return num_nodos;
	}

	public void setNum_nodos(Integer num_nodos) {
		this.num_nodos = num_nodos;
	}

	public int getProfundidad() {
		return profundidad;
	}

	public void setProfundidad(int profundidad) {
		this.profundidad = profundidad;
	}

	public void actualizarArbol(TArbol a) {
		Integer profMax = 0;
		Integer numNodosTotal = 0;
		if(a.getHijos()!=null) {
		for (int i = 0; i < a.getHijos().length; i++) {
			actualizarArbol(a.getHijos()[i]);
			numNodosTotal+=a.getHijos()[i].getNum_nodos();
			if (profMax < a.getHijos()[i].getProfundidad())
				profMax = a.getHijos()[i].getProfundidad();

		}
		}
		setNum_nodos(++numNodosTotal);
		setProfundidad(++profMax);
	}

	public void setHijo(Integer i, TArbol hi) {
		hijos[i] = hi;
		hijos[i].setPadre(hi);
	}

}
