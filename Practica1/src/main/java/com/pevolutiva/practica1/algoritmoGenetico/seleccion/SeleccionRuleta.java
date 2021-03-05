/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pevolutiva.practica1.algoritmoGenetico.seleccion;

import com.pevolutiva.practica1.algoritmoGenetico.individuos.Individuo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Diego
 */
public class SeleccionRuleta extends Seleccion{

    @Override
    public void run(List<Individuo> poblacion) {
        Double suma = 0.0;
        for (Individuo ind : poblacion) {
                suma += ind.getValor();
        }
        Integer numIndSelec = 3;
        Random rand = new Random();
        List<Individuo> NuevaPoblacion = new ArrayList<Individuo>();

        for (int i = 0; i < numIndSelec; i++) {
                Double alt = rand.nextDouble();
                Double acum = 0.0;
                for (Individuo ind : poblacion) {

                        if (ind.getValor() + acum / suma >= alt) {
                                NuevaPoblacion.add(ind);
                                break;
                        }
                        acum += ind.getValor();
                }
        }
        System.out.println(NuevaPoblacion);
        
        //TODO toca devolver la poblacion elegida
    }
    
}
