/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;
import java.util.Scanner;

/**
 *
 * @author Juan Sebastian Sanin y Juan Pablo Peña
 */
public class Reinas {
  public static void queens(int n, int x, int y) {
        queensAux(n,0, new int[n],  x ,  y);
    }
  
    private static void queensAux(int n, int columna, int[] tablero, int x, int y) {
        if (columna == n) {
            imprimirTablero(tablero,x,y); 
        }else{
            for(int i=0;i<tablero.length;i++){
               
                tablero[columna] = i;
                
                if (esValidoBK(tablero, columna,x,y)==true){
                    queensAux(n, columna+1, tablero,x,y);
                }
            }
            
        }
    }
  
    public static boolean esValidoBK(int[] tablero, int hastaColumnaI,int x, int y) {
        for (int i = 0; i <= hastaColumnaI; i++){
            for (int j = i+1; j <= hastaColumnaI; j++){
                if (Math.abs(tablero[i] - tablero[j]) == Math.abs(i-j)|| tablero[i] == tablero[j]||i==y&&j==x ){                 
                    return false;                    
                }
            }
        }
        return true;   
    }
    
    public static void imprimirTablero(int[] tablero,int x, int y) {
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
   
    public static void main(String[] args) {
        int m=1;
        Scanner n= new Scanner(System.in);
        
        while(m!=0){
        System.out.println("Escriba el numero de reinas");
        int p= n.nextInt();
        
        System.out.println("Escriba las coordenadas de los muros");
        System.out.print("x: ");
        int x=n.nextInt();
         System.out.print("y: ");
         int y=n.nextInt();
        queens(p,x,y);
        System.out.println("Escriba 0 para terminas");
        m= n.nextInt();
        }
    }  
}
