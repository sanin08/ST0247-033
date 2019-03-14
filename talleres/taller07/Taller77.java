/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller8;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * Juan Pablo Peñas Juan Sebastian Sanin 
 */
public class Taller77 {

private static int[] crearUnaTablaConInfinitosYConCeroEnV(int n, int v){
  int[] tabla = new int[n];
  Arrays.fill(tabla, Integer.MAX_VALUE);//llena la tabla con infinitos
  tabla[v] = 0;
  return tabla;
}

private static int encontrarElIndiceDeMenorPesoEnLaTablaQueNoEsteVisitado(int[] tabla, boolean[] visitados){
  int elDeMenorPesoNoVisitado = Integer.MAX_VALUE;
  int unIndiceQueSeReasigneCadaVezQueEsoSeCumpla = 0;
  int i;
  for(i = 0; i < tabla.length; i++ ) {// recorremos toda la tabla. 
     int elPesoDelQueEstamosParadosEnElMomento = tabla[i];
     if (!visitados[i]){ // Pueden haber varios no visitados
         if(elPesoDelQueEstamosParadosEnElMomento < elDeMenorPesoNoVisitado){
            elDeMenorPesoNoVisitado = elPesoDelQueEstamosParadosEnElMomento;
            unIndiceQueSeReasigneCadaVezQueEsoSeCumpla = i;
         }
     }
  }
  return unIndiceQueSeReasigneCadaVezQueEsoSeCumpla; 
}

private static void actualizarLaTablaConLosAdyacentesDelActual(Digraph g, int[] tabla, int actual){
  // Recorrer la tabla
  ArrayList<Integer> adyacentesDelActual = g.getSuccessors(actual);
  for (Integer unAdyacenteDelActual : adyacentesDelActual ){
     int cuantoMeDemoroDesdeElInicioHastaElActual = tabla[actual];
     int cuantoMeDemoroDesdeElActualHastaElAdyacente = g.getWeight(actual,unAdyacenteDelActual);
     int cuantoMeDemoroEnTotal = cuantoMeDemoroDesdeElInicioHastaElActual +  cuantoMeDemoroDesdeElActualHastaElAdyacente;
     tabla[unAdyacenteDelActual] = Math.min( tabla[unAdyacenteDelActual] , cuantoMeDemoroEnTotal);
  }
}

public static int[] dijkstra(Digraph g, int v){
   int[] tabla = crearUnaTablaConInfinitosYConCeroEnV(g.size(), v);
   int actual = v;
   boolean[] visitados = new boolean[g.size()];
   for (int i = 1; i <= g.size(); i++) {
     actualizarLaTablaConLosAdyacentesDelActual(g, tabla, actual);
     visitados[actual] = true;
     actual = encontrarElIndiceDeMenorPesoEnLaTablaQueNoEsteVisitado(tabla, visitados);
   } 
   return tabla;
}
}