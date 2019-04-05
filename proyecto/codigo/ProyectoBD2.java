/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobd2;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;
import javafx.util.Pair;

/**
 *
 * @author ASUS
 */
public class ProyectoBD2 {
 static String Orden[][] = new String[205][205];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int h;   
        int count =0;
        try{            
        int i=0;
        File f = new File("data.txt");
        Scanner s = new Scanner(f);
        
        while(s.hasNextLine()){
         
        String line = s.nextLine();
        String cortar [] = line.split(" ");
        
       String vx=cortar[i];
    
      String vy=cortar[i+1];
            
             String vz=cortar[i+2];
            System.out.println(vx);
//   int Vx= Integer.parseInt(cortar[i]);
//              int Vy= Integer.parseInt(cortar[i+1]);
//              int Vz= Integer.parseInt(cortar[i+2]);
            // Orden[vx][vy]=vz;
             matriz(vx,vy,vz);

            }
   
            
           // }
         
       // }
        
        }
        catch(Exception e){
       }
       
            

    }
    
   public static  void matriz (String vx, String vy, String vz){
       int Vx= Integer.parseInt(vx);
              int Vy= Integer.parseInt(vy);
      Orden[Vx][Vy]=vz;
       
   }
}
