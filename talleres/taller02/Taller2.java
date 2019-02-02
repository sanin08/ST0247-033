
import java.util.LinkedList;

public class Taller2
{
    public static LinkedList<String> combinations(String str) {
	        LinkedList<String> respuesta = new LinkedList<String>();
		combinations("", str, respuesta);
               
                return respuesta;
	}
  
  	/**
	* Metodo que muestra el numero de posibles soluciones al problema
	* 
	* 
	* @param  n numero de reinas
	* @return numero de soluciones
	*/	
	
  
  
  
   
  
  
    private static void combinations(String respuesta, String pregunta, LinkedList<String> list) {
		  
        if (pregunta.length() == 0){
           // System.out.println(respuesta);
           list.add(respuesta);
             
                  }
        else {
           combinations(respuesta, pregunta.substring(1),list);
           combinations(respuesta+pregunta.substring(0,1), pregunta.substring(1),list);
        } 
                
	}
       
    

    
  public static LinkedList<String> permutations(String s) {
		LinkedList<String> respuesta = new LinkedList<String>();
		permutations("", s, respuesta);
                return respuesta;
	}
      private static void permutations(String respuesta, String pregunta, LinkedList<String> list)  {
         if (pregunta.length() == 0) {
            //System.out.println(respuesta);
       // System.out.println(AdvancedEncryptionStandard.desencriptarArchivo(respuesta));// para este solo es agregar el "abcd" y lo hace
        list.add(respuesta);
        }
        else {
           for (int i = 0; i < pregunta.length(); i++)
            permutations(respuesta+pregunta.charAt(i), pregunta.substring(0,i)+pregunta.substring(i+1),list);
        }
    }
    // Meme https://www.facebook.com/estructurasdedatos1/photos/a.482871115405556/482871185405549/?type=3&theater
    
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
   public static int queens(int n) {
	    return queens(n, 0, new int[n]);
	}
    private static int queens(int n, int columna, int[] tablero) {
	int i=1;
        int p = 0;
        if(i==n){
            return p;
        }
        else{
            if(esValido(tablero)==true){
                p++;
                queens(n,columna++,tablero);
            }
        }
         return p;           
	}
    public static boolean esValido(int[] tablero) {
		   for (int i = 0; i < tablero.length; i++){
          for (int j = i+1; j < tablero.length - 1; j++){
               //if ( tablero[i] - tablero[j] == i - j 
                //  || tablero[i] - tablero[j] == (i - j)*-1 )
                int a=tablero[i] - tablero[j];
             if (Math.abs(a)==Math.abs(i-j))  {               
                     return false;
                     
                    }
             if(tablero[i]-tablero[j]==0)return false;
             
      
    }
    }
            return true;
    }
}
//    public static void main(String[]args){
//        permutations("abcd");
//        int[] reinas={1,3,0,2,4};
//         
//        imprimirTablero(reinas);
//        System.out.println(esValido(reinas));
//    }
//}
