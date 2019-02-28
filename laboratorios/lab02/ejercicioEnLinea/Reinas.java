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
  public static int total = 0;
    
    public static void queens(int n, String tab[][]) {
        queensAux(n,0, new int[n], tab);
    }
  
    private static void queensAux(int n, int columna, int[] tablero, String tab[][]) {
        if (columna == n) {
            total+=1;
            System.out.println("Soluciones: "+total);
        }else{
            for(int i=0;i<tablero.length;i++){
               
                tablero[columna] = i;
                
                if (esValidoBK(tablero, columna, tab)==true){
                    queensAux(n, columna+1, tablero, tab);
                }
            }
            
        }
    }
  
    public static boolean esValidoBK(int[] tablero, int hastaColumnaI, String tab[][]) {
        for (int i = 0; i <= hastaColumnaI; i++){
            for (int j = i+1; j <= hastaColumnaI; j++){
                if (Math.abs(tablero[i] - tablero[j]) == Math.abs(i-j)|| tablero[i] == tablero[j]||tab[i][hastaColumnaI].contains("*")){                 
                        return false;                   
                }
            }
        }
        return true;   
    }
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Escriba el número de reinas: ");
        int numReinas = sc.nextInt();
        System.out.println("Escriba el tablero: ");
        
            String tab[][] = new String[numReinas][numReinas];
            for (int i = 0; i < tab.length; i++) {
                String t = sc.next(); 
                for (int j = 0; j < tab.length; j++) {                  
                    tab[i][j] = t.substring(j, j+1);
                }                
            }       
        queens(numReinas, tab);
    }
}
