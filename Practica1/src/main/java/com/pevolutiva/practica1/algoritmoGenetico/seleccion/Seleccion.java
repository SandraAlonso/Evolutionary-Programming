/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pevolutiva.practica1.algoritmoGenetico.seleccion;

import com.pevolutiva.practica1.algoritmoGenetico.individuos.Individuo;
import java.util.List;

/**
 *
 * @author Diego
 */
public abstract class Seleccion {
    
    
    public abstract List<Individuo> run(List<Individuo> poblacion);
}
