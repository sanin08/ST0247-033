/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio2;

import java.util.LinkedList;

/**
 *
 * @author ASUS
 */
public class Laboratorio2 {

    
     public int costo(Digraph g){
         LinkedList<String> permutaciones = perm1("0123");
         int costo = 0;
         for (String permutation : permutaciones){
            for (int i = 0; i < permutation.length() - 1; i++)
               costo += g.getWeight(permutation.charAt(i), permutation.charAt(i+1) );
            costo += g.getWeight(permutation.charAt(permutation.length()-1), permutation.charAt(0));   
             }
           return costo;
     }
    // print n! permutation of the characters of the string s (in order)
    public  static  LinkedList<String> perm1(String s) 
    {   LinkedList<String> l = new LinkedList<String>();
        perm1("", s, l); 
        return l;
    
    }
    private static void perm1(String prefix, String s, LinkedList<String> resp) {
        int n = s.length();
        if (n == 0) { resp.add(prefix); System.out.println(prefix);}
        else {
            for (int i = 0; i < n; i++)
               perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n), resp);
        }

    }
}
    

