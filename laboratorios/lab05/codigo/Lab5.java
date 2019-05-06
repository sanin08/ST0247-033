/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 *
 * @author Juan Pablo Peña, Juan Sebastian Sanin
 */
public class Lab5 {


 
    public int heldCarp(Digraph g){
  final int vacio = 0;
  int n = g.size();
  int[][] costos = new int[n][(int) Math.pow(2,n)];
  int[][] papas = new int[n][(int) Math.pow(2,n)];
  for (int i = 0; i < n-1; i++){
      costos[i][vacio] = g.getWeight(0,i);
      papas[i][vacio] = 0;
  }
  for(int j =1; j < n-1; j++){
     papas[j][vacio] = j;
        
      for (int i = 1; i < n; i++)  {
          if(j < costos[0].length-1&&(i==0||i==j)){
          costos[i][j]=Integer.MAX_VALUE;
          }
      else{
      costos[i][j]=g.getWeight(0,j)+g.getWeight(j,i);
              }
      }
      
  }
//En estos siguiente cilos aninadados se quiere hacer las combinaciones de [n,{x,y}]


//        for (int i = 0; i < costos[0].length; i++) {
//            
//            for (int j = 0; j < n; j++) {
//              if(j < costos[0].length-1&&(i==0||i==j)){
//          costos[i][j]=Integer.MAX_VALUE;
//          }
//                costos[j][i]= Math.min(g.getWeight(?,?)+costos[?][?], g.getWeight(?,?)+costos[?][?]);
//            }
//        }

// Y en un ultima linea se haria la combinacion de [0,{1,2,3}]
      //costos[0][costos[0].length-1]= Math.min(g.getWeight(?,?)+costos[?][?], g.getWeight(?,?)+costos[?][?],g.getWeight(?,?)+costos[?][?]);
  return costos[0][costos[0].length-1];
}
    
    
}
