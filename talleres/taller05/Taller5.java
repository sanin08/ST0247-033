/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller5;

import java.util.ArrayList;

/**
 *
 * @author Juan Pablo Peña, Juan Sebastian Sanin 
 */
public class Taller5 {
 public static void Cgrafo(int n,Digraph g) {
        CgrafoAux(g ,0,n, new int[n]);
    }
  // como recorrer el grafo para hacer la comparativa de los colores ya que tenemos que evaluar
 //los vertices con los cuales estan conexos y validar sus colores
    private static boolean CgrafoAux(Digraph g,int v,int n, int[] tablero) {
        if (v == g.size()-1) {
            imprimirTablero(tablero); 
            return true;
        }else{
                     
            for(int i=0;i<n;i++){
                tablero[v] = i;
                if (esValidoBK(tablero, v,g)==true){ // hacer una comparativa unicamente con los que estan conexos
                  boolean respuesta=  CgrafoAux(g,n, v+1, tablero);
                
                if(respuesta==true){
                    return true;
                }    
                }
            }
            
        }
        return false;
    }
  
    public static boolean esValidoBK(int[] tablero, int v,Digraph g) {
       int i=v;
           for(int j=0;j<tablero.length-1;j++)
               // se esta validando unicamente con el nodo siguiente
                if (g.getWeight(i, j )!=0&&tablero[i]==tablero[j]){                 
                    return false;                    
                }
            
        
        return true;   
    }
    
    public static void imprimirTablero(int[] tablero) {
        int n = tablero.length;
        System.out.print("    ");
        for (int i = 0; i < n; ++i)
            System.out.print(tablero[i] + " ");
          
    }
   
    public static void main(String[] args) {
        Cgrafo(3,g);
    }
}
