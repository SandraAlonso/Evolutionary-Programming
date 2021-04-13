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
import org.apache.commons.lang.SerializationUtils;


/**
 *
 * @author Diego
 */
public class SeleccionTorneo extends Seleccion {

	@Override
	public List<Individuo> run(List<Individuo> poblacion) {
            
            List<Individuo> NuevaPoblacion = new ArrayList<Individuo>();
            Random rand = new Random();
            int muestra = 3;
            for(int i = 0; i < poblacion.size(); ++i){
                int posMejor = -1;
                for(int j = 0; j < muestra; ++j){
                    int posAux = rand.nextInt(poblacion.size());
                    if(posMejor == -1 || (poblacion.get(posAux).getValor() > poblacion.get(posMejor).getValor())){
                        posMejor = posAux;
                    }
                }
                NuevaPoblacion.add((Individuo) SerializationUtils.clone(poblacion.get(posMejor)));
            }
            return NuevaPoblacion;
	}

}