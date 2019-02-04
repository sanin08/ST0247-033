package laboratorio1;


import java.io.File;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import javafx.util.Pair;

/*
 * 
 */

/**
 *
 * @author Juan Pablo Peña y Juan Sebastian Sanin
 */
public class Punto1 {

    public static void main(String[] args) {
        HashMap<String, LinkedList<Pair<String, Double>>> arcos = new HashMap<>();
  
        int h;        
        try{            
        int i=0;
        File f = new File("medellin_colombia-grande.txt");
        Scanner s = new Scanner(f);
        
        while(s.hasNextLine()){
        String line = s.nextLine();
        String cortar [] = line.split(" ");
       String vx=cortar[i];
      
      String vy=cortar[i+1];
          
                  

double vz = Double.parseDouble(cortar[i+2]);        
         

    if (arcos.get(vx) == null) {

    arcos.put(vx, new LinkedList<>() ); 

    arcos.get(vx).add(new Pair(vy, vz)); 
}

    else{ 

   arcos.get(vx).add(new Pair(vy, vz));
    }
            
       
         
        }
        
        }
        catch(Exception e){
       }
         System.out.println(arcos.get("287291920"));

        System.out.println(arcos.size());

    }
     
   
}