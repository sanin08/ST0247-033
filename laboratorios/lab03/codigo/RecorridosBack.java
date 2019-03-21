
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * Juan Pablo Peña Juan Sebastian Sanin 
 */
public class RecorridosBack {
    public static int costoMinimo(Digraph g, int v, int w, boolean[] visitados) {
	  int menorRespuesta = Integer.MAX_VALUE; 
          visitados[v] = true;
          if (v == w){
              visitados[v] = false;
             return 0;
          }
          else{
              ArrayList<Integer> adyacentes = g.getSucessors(v);
              
           
              for (Integer adyacente: adyacentes)
                if (!visitados[adyacente]){
                     int respuesta = costoMinimo(g, adyacente, w, visitados);
                     int suma = respuesta + g.getWeight(v,adyacente);      
                     if (suma < menorRespuesta )
                       menorRespuesta = suma;
                  }
              }
              visitados[v] = false;
              return menorRespuesta; 
	}
        
 public static void queens(int n) {
         queensAux(n,0, new int[n]);
    }
  
    private static boolean queensAux(int n, int columna, int[] tablero) {
       
        if (columna == n) {
            imprimirTablero(tablero);
            return true;
         
        }
            for(int i=0;i<tablero.length;i++){
                tablero[columna] = i;
              
                if (esValidoBK(tablero, columna)==true){
                     
                  boolean  respuesta = queensAux(n, columna+1, tablero);
                   
                   if(respuesta==true){
                      return true;
                       
                       
                       
                   }
                }
              
            
        }
return false;
}

  
    public static boolean esValidoBK(int[] tablero, int hastaColumnaI) {
        for (int i = 0; i <= hastaColumnaI ; i++){
            for (int j = i+1; j <= hastaColumnaI; j++){
                if (Math.abs(tablero[i] - tablero[j]) == Math.abs(i-j) || tablero[i] == tablero[j] ) {                
                    return false;
                }
            }
        }
        return true;   
    }
  
   
   
    public static void imprimirTablero(int[] tablero) {
int n = tablero.length;
System.out.print("    ");
for (int i = 0; i < n; ++i)
            System.out.print(i + " ");
            System.out.println("\n");
            for (int i = 0; i < n; ++i) {
System.out.print(i + "   ");
for (int j = 0; j < n; ++j)
                    System.out.print((tablero[i] == j ? "Q" : "#") + " ");
System.out.println();
}
            System.out.println();
}

}