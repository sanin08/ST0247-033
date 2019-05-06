
package lab5;

/**
 *
 * @author Juan Pablo Peña, Juan Sebastian Sanin
 */
public class Lab5 {
//Solucion planteada por el profesor
 /**
 * Clase en la cual se implementan los metodos del Taller de Clase #11
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
public static int heldKarp(Digraph g) {
		
		int n = g.size;
		int m = 1 << n;
		int[][] dp = new int[n][m];
		for (int i = 0; i < n; ++i)
			for (int j = 0; j < m; ++j)
				dp[i][j] = -1;
		BitmaskSet set = new BitmaskSet(n);
		set.add(0);
		return heldKarp(g, dp, 0, set);
	}

	private static int heldKarp(Digraph g, int[][] dp, int v, BitmaskSet set) {
		if (set.isFull())
			return g.getWeight(v, 0);
		int m = set.mask();
		if (dp[v][m] != -1)
			return dp[v][m];
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < g.size; ++i)
			if (i != v && !set.contains(i)) {
				BitmaskSet t = new BitmaskSet(set);
				t.add(i);
				ans = Math.min(ans, g.getWeight(v, i) + heldKarp(g, dp, i, t));
			}
		return dp[v][m] = ans;
	}
 // solucion con nuestro planteamiento antes de ver la respuesta( Se vieron los errores con respecto al codigo del profesor) no sirve el codigo planteado por nosotros
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
