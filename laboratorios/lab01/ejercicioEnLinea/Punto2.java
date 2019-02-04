package punto2;

import java.util.Scanner;

/**
 *
 * @author Peña
 */
public class Punto2 {

    public static void conexiones(){
        Scanner num = new Scanner(System.in);
        System.out.print("Escriba el número de nodos: ");
        int numNodos = num.nextInt();
        System.out.print("Escriba el número de arcos: ");
        int numArcos = num.nextInt();
        
        String nodos[] = new String[numNodos];
        int mat[][] = new int[numNodos][numNodos];
        int respuesta = 0; //Variable para saber si el grafo es bicoloreable
        
        nodos[0] = "color1"; //El primer nodo siempre va a tener un color
        
        //Color auxiliar
        for (int i = 1; i < nodos.length; i++) {
            nodos[i] = "color3";
            //System.out.println(nodos[i]);
        }
        
        //Se le asigna el número uno en la matriz donde haya conexion
        for (int i = 0; i < numArcos; i++) {
            int arco1 = num.nextInt();
            int arco2 = num.nextInt();
            if(arco1==arco2){
                System.out.println("No se puede la recursión, vuelva a escribir");
                arco1 = num.nextInt();
                arco2 = num.nextInt();
            }
            mat[arco1][arco2] = 1;
            System.out.println("Arco: "+arco1+" "+arco2);
        }
        
        //Se asignan colores y se verifica que sea bicoloreable
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if(mat[i][j]==1){
                    if((nodos[i]!=nodos[j])&&(nodos[i]=="color1")){
                        nodos[j] = "color2";
                    }else if((nodos[i]!=nodos[j])&&(nodos[i]=="color2")){
                        nodos[j] = "color1";
                    }else{
                        respuesta = 1;
                        break;
                    }
                }
            }
        }
        
        respuesta(respuesta); 
    }
    
    public static void respuesta(int a){
        Scanner sc = new Scanner(System.in);  
        
        if(a==1){
            System.out.println("No es bicoloreable");
        }else{
            System.out.println("Bicoloreable");
        }
        
        System.out.println("\nPara continuar escriba 1\nPara terminar escriba 0");
        int cont = sc.nextInt();
        if(cont!=0){
            conexiones();
        }
    }
  
    public static void main(String[] args) {
        conexiones();
    }
}
