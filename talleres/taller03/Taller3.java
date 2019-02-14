/**
 *
 * @author Juan Sebastián Sanín - Juan Pablo Peña
 */
public class Taller3 {
    public static void queens(int n) {
        queensAux(n,0, new int[n]);
    }
  
    private static void queensAux(int n, int columna, int[] tablero) {
        if (columna == n) {
            imprimirTablero(tablero); 
        }else{
            for(int i=0;i<tablero.length;i++){
                tablero[columna] = i;
                if (esValidoBK(tablero, columna)==true){
                    queensAux(n, columna+1, tablero);
                }
            }
            
        }
    }
  
    public static boolean esValidoBK(int[] tablero, int hastaColumnaI) {
        for (int i = 0; i <= hastaColumnaI; i++){
            for (int j = i+1; j <= hastaColumnaI; j++){
                if (Math.abs(tablero[i] - tablero[j]) == Math.abs(i-j)|| tablero[i] == tablero[j] ){                 
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
   
    public static void main(String[] args) {
        queens(4);
    }
}
