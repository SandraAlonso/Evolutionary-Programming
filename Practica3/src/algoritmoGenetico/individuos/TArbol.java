package algoritmoGenetico.individuos;

public class TArbol {

	private TArbol padre;
	private TArbol[]hijos;
	private Tipo tipo;
	private Integer num_nodos=0;
	private int profundidad;
	
	
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

	
}
