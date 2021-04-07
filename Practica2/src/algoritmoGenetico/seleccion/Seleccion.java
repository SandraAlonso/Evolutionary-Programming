/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoGenetico.seleccion;

import java.util.List;

import algoritmoGenetico.individuos.Individuo;

/**
 *
 * @author Diego
 */
public abstract class Seleccion {
    
    
    public abstract List<Individuo> run(List<Individuo> poblacion);
}
