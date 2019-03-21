package laboratorio3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Juan Pablo Peña F. - Juan Sebastián Sanín V.
 */
public class Prueba {
    
    public static void user(){   
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nodos: ");
        int n = sc.nextInt();
        while(n<2||n>105){
            n = sc.nextInt();
        }
        
        DigraphAL grafo = new DigraphAL(n+1);
        
        System.out.print("Arcos: ");
        int m = sc.nextInt();
        while(m<0||m>105){
            m = sc.nextInt();
        }
        
        //Se le asigna el peso a dos nodos
        for(int i=0;i<m;i++){
            int ai = sc.nextInt();
            while(1>ai){
                ai = sc.nextInt();
            }
            int bi = sc.nextInt();
            while(bi>n){
                bi = sc.nextInt();
            }
            int wi = sc.nextInt();
            while(wi>106){
                wi = sc.nextInt();
            }
            grafo.addArc(ai, bi, wi);
        }
        System.out.print(" "+costoMinimo(grafo,1,n));      
    }
   
    public static int costoMinimo(Digraph g, int inicio, int fin) {
        int n = g.size;
        int[] minimo = new int[n];
        for (int i = 1; i < n; ++i)
            minimo[i] = Integer.MAX_VALUE;
            minimo[inicio] = 0;
            dfs(g, inicio, minimo);
        return minimo[fin] == Integer.MAX_VALUE ? -1 : minimo[fin];
    }

    private static void dfs(Digraph g, int v, int[] costo) {
	ArrayList<Integer> succesors = g.getSuccessors(v);
        if (succesors != null) {
            int peso;
            for (Integer u : succesors)
		if ((peso = costo[v] + g.getWeight(v, u)) < costo[u]) {
                    costo[u] = peso;
                    System.out.print(v+" -->: "+u+" ");
                    if(u==5){System.out.println("");}
                    dfs(g, u, costo);
		}
	}
    }
    
    public static void main(String[] args) {
        user();
    }
}
