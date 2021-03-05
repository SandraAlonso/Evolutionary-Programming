/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pevolutiva.practica1.main;

import java.util.Arrays;

import com.pevolutiva.practica1.algoritmoGenetico.AlgoritmoGenetico;
import com.pevolutiva.practica1.algoritmoGenetico.individuos.IndividuoFuncion1;

/**
 *
 * @author Diego
 */
public class Main {
    public static void main(String[] args){
        System.out.println("Hellow world");
        IndividuoFuncion1 ind= new IndividuoFuncion1();
        Boolean [] list = ind.getCromosoma();
       // System.out.println(Arrays.toString(list));
        //Para ver toda la información de un individuo
        System.out.println(ind.toString());
        
        AlgoritmoGenetico alg = new AlgoritmoGenetico();
        alg.run();
    }
}
