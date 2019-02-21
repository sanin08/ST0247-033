/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4;

import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller 4
 * 
 * @author Juan Sebastian Sanin, Juan Pablo Peña, Mauricio Toro, Andres Paez
 */
public class Taller4 {

	/**
	* Metodo auxiliar para llamar el metodo hayCaminoDFS posterior
	* @param g grafo dado 
	* @param v vertices 
	* @param w vertice
	* @return true si hay camino, false de lo contrario
	*/
    public static boolean hayCaminoDFS(Digraph g, int v, int w) {
        boolean[] visitados = new boolean[g.size()];
        return hayCaminoDFS(g, v, w, visitados);
    }

    /**
	* Metodo que recorre el grafo por medio de dfs 
	* @param g grafo dado 
	* @param v vertices 
	* @param w vertice
	* @param visitados ayuda a tener un conteo acerca de que nodos han sido
	* o no visitados
	* @return true si hay camino, false de lo contrario
	*/
    private static boolean hayCaminoDFS(Digraph g, int v, int w, boolean[] visitados) {
         visitados[v] = true;
          if (v == w)
             return true;
          else{
              ArrayList<Integer> adyacentes = g.getSucessors(v);
              if (adyacentes.contains(w))
                 return true;
              for (Integer adyacente: adyacentes){
                if (!visitados[adyacente]){
                     boolean respuesta = hayCaminoDFS(g, adyacente, w, visitados);
                     if (respuesta)
                      return respuesta;
                  }
              }
              return false;   
            }		
    }

    /**
	* Metodo que recorre el grafo por medio de dfs teniendo en cuenta que
	* se quiere encontrar el de menor costo
	* @param g grafo dado 
	* @param v nodo desde el cual empieza el recorrido 
	* @param w nodo donde termina el recorrido
	* @return cual es el costo que tiene ir desde inicio a fin
	*/
	public static int costoMinimo(Digraph g, int v, int w, boolean[] visitados) {
		  visitados[v] = true;
          if (v == w)
             return 0;
          else{
              ArrayList<Integer> adyacentes = g.getSucessors(v);
              if (adyacentes.contains(w))
                 return g.getWeight(v,w);
              for (Integer adyacente: adyacentes){
                if (!visitados[adyacente]){
                     int respuesta = costoMinimo(g, adyacente, w, visitados);
                     int respuestaConLoQueYaTengo = respuesta + g.getWeight(v,adyacente);
                     
                     if (respuestaConLoQueYaTengo <costoMinimo(g, adyacente, w, visitados) )
                       return respuestaConLoQueYaTengo;
                  }
              }
              return Integer.MAX_VALUE; //infinito 
	}
        }
	


	


	

}