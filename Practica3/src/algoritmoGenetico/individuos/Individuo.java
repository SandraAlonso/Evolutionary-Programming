/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoGenetico.individuos;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author Diego
 */
public abstract class Individuo<T> implements Serializable {

   
    protected T[] cromosoma;

    protected Random rand = new Random();

    
    

    public T[] getCromosoma() {
        return cromosoma;
    }
    public T[] setCromosoma(T[]c) {
        return cromosoma=c;
    }

  
    public abstract Double getValor();
    public abstract Double getValorSinK();

    public int tamGen(Double min, Double max, Double precision) {
    	
        return (int) (Math.log10(((max - min) / precision) + 1) / Math.log10(2));
    }
    
	public  abstract boolean[][] solucion() ;
    public abstract TArbol getArbol();
    public abstract void setArbol(TArbol a);
	public abstract int getBocados();

}
