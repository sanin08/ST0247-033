package dya2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Esta clase contiene todo el proyecto de Estructura de Datos 2, en el cual se pretende hacer un carpool para
 * los estudiantes de la Universidad EAFIT..
 * @author Juan Sebastián Sanín V.
 * @author Juan Pablo Peña F.
 * @version 15 de Mayo de 2019
 */
public class carPoolEafit {
    static int numeroNodos = 205;
    static double p=1.3;
    static boolean visitados[]=new boolean[numeroNodos];
    static int indices[]=new int[numeroNodos];
    static int carros[]=new int[numeroNodos];

    /**
     * Este método lee un archivo donde se guardan las posiciones de los integrantes de la Universidad EAFIT
     * y el respectivo tiempo que se demoran en llegar a esta.
     * @param numeroDePuntos Recibe el número de personas que hay en el archivo.
     * @param p Recibe el valor máximo extra que un usuario puede tardarse hasta la Universidad. 
     * @return Retorna una matriz en la que se guardaron los datos del archivo leído.
     */
    public static int[][] leerArchivo(int numeroDePuntos, double p){
        final String nombreDelArchivo = "dataset-ejemplo-U="+numeroDePuntos+"-p="+p+".txt";
        int estructura[][]= new int[numeroDePuntos][numeroDePuntos];
        try {            
            BufferedReader br = new BufferedReader(new FileReader(nombreDelArchivo));
            String lineaActual = br.readLine();
            for (int i = 1; i <= 3; i++) // Descarta las primeras 3 lineas
                lineaActual = br.readLine();
                lineaActual = br.readLine(); 
            for (int i = 1; i <= numeroDePuntos; i++){ //Descarta los nombres y coordenadas de los vertices
                lineaActual = br.readLine();
            }          
            for (int i = 1; i <= 3; i++) // Descarta las siguientes 3 lineas
                lineaActual = br.readLine();             
            while (lineaActual != null){ // Mientras no llegue al fin del archivo. Lee la informacion de las aristas
                String [] cadenaParticionada = lineaActual.split(" ");
                estructura[Integer.parseInt(cadenaParticionada[0])-1] [Integer.parseInt(cadenaParticionada[1])-1]= Integer.parseInt(cadenaParticionada[2]);
                lineaActual = br.readLine();
            }
        } catch(IOException ioe) {
            System.out.println("Error leyendo el archivo de entrada: " + ioe.getMessage());
        }
        return estructura;
    }
   
    /**
     * Este método organiza de mayor a menor los valores de la matriz ingresada.
     * @param m Recibe una matriz. 
     * @return Retorna la matriz ordenda.
     */
    public static int[][] ordenarMatriz(int m[][]){
        int [][] eafit = new int[m.length][m.length];
        
        for(int i = 0; i < eafit.length; i++){
            for (int j = 0; j < eafit.length; j++) {
                eafit[i][j]=m[i][j];   
            }
        }
        
        for(int k = 0; k < eafit.length; k++){
            for (int i = 0; i < eafit.length; i++) {
                for (int j = 0; j < eafit.length-i-1; j++) {
                    if(eafit[k][j]<eafit[k][j+1]){
                        int tmp = eafit[k][j+1];
                        eafit[k][j+1] = eafit[k][j];
                        eafit[k][j] = tmp;
                    }   
                }
            }
        }
        return eafit;
    }
   
    //Si desea imprimir la matriz descomente esta parte del código.
    /*public static void imprimirMatriz(int m[][]){
        System.out.print("  ");
        for (int x = 0; x < m.length; x++) {
            System.out.print("["+(x+1)+"]");
        }
        System.out.println(" ");
        for (int i = 0; i < m.length; i++) {
            System.out.print("["+(i+1)+"]"+ " ");   
            for (int j = 0; j < m.length; j++) {
                System.out.print(+m[i][j] +" " );
            }
            System.out.println(" ");
        }
    }*/
   
    /**
     * Este método busca identificar a las personas que se encuentran más lejos de la Universidad EAFIT.
     * @param minimoCarros Recibe el número mínimo de carros que se deben tener en el recorrido.
     * @param eafit Recibe la matriz ordenada.
     * @param visitados Recibe un arreglo donde se van a ir registrando las personas visitadas.
     * @param estructura Recibe la matriz original, es decir la que no está ordenada.
     * @return Retorna las personas que están más alejadas de la Universidad EAFIT.
     */
    public static int[] masLejanos(int minimoCarros, int eafit[][],boolean visitados[],int estructura[][]){
        int [] lejanos= new int[minimoCarros]; 
        for (int i = 0; i < minimoCarros; i++) {
            lejanos[i]=eafit[0][i];
        }
        
        for (int i = 0; i < lejanos.length; i++) { // numero de lejano en i                               
            for(int j=0; j<estructura.length;j++){// buscamos el indice y lo guardamos en el arreglo indice, lo mismo buscamos en visitados para poner true
                if(lejanos[i]==estructura[0][j]){
                    visitados[j]=true;            
                    indices[i]=j;
                }
            }
        }
        return lejanos;
    }   

    /**
     * Este método encuentra el valor del índice en el que se encuentra ubicado el recorrido de la matriz,
     * es decir, el número de la columna en el que estamos parados.
     * @param actual Recibe el índice actual en el que está el recorrido de la matriz (Fila).
     * @param peso Recibe el valor de la posición en donde se encuentra el índice actual. 
     * @param eafit Recibe la matriz ordenada.
     * @param estructura Recibe la matriz original, es decir la que no está ordenada.
     * @return Retorna el valor del índice que se deseaba buscar (Columna).
     */
    public static int buscarIndice(int actual, int peso,int eafit[][],int estructura[][]){
        int indice=-1;
        for (int i = 0; i < eafit[0].length; i++) {     
            if(estructura[actual][i]==peso){   
                indice=i;
                break; 
            }  
        }
        return indice;   
    }

    /**
     * Este método busca el valor menor de los adyacentes de la persona actual teniendo en cuenta también su
     * distancia hasta la Universidad EAFIT.
     * @param eafit Recibe la matriz ordenada.
     * @param estructura Recibe la matriz original, es decir la que no está ordenada.
     * @param actual Recibe el índice actual en el que está el recorrido de la matriz (Fila).
     * @param visitados Recibe un arreglo donde se van a ir registrando las personas visitadas.
     * @return Retorna el valor del menor de los adyacentes de la persona actual teniendo en cuenta su distancia
     * hasta la Universidad EAFIT.
     */
    public static int menor(int eafit[][],int estructura[][],int actual, boolean visitados[]){
        int menor=Integer.MAX_VALUE;           
        for (int i = eafit[0].length-2; i >=0; i--) {
            int indice =buscarIndice(actual,eafit[actual][i],eafit,estructura);                                    
            if(indice==-1)return -1;
            if(visitados[indice]==false){
                int total=eafit[actual][indice]+estructura[0][indice];
                if(total<menor &&total<p*estructura[0][indice]){ //Modificar el P
                    menor = estructura[actual][indice];
                    return menor;      
                }
            }
        }
        
        if(menor==Integer.MAX_VALUE) menor = 0;
        return menor;              
    }
           
    /**
     * Este método calcula el número de carros que deben ser utilizados para todos los recorridos.
     * @param minCarros Recibe el número mínimo de carros que se deben tener en el recorrido.
     */       
    public static void numeroTotalCarros(int minCarros){
        for (int i = 0; i < visitados.length; i++) {
            if(visitados[i]==false) minCarros++;          
        }              
        System.out.println("Numero de carros: "+minCarros);
    }
    
    /**
     * Este es el método principal donde se va a ejecutar el código y además se hacen algunas operaciones extra.
     * @param args 
     */
    public static void main(String[] args) {                
        int minimoCarros=numeroNodos/5;
        int []lejanos=new int[numeroNodos]; // se crea un arreglo para los pesos de casa carro lejano
        int actual=0;
        visitados[0]=true;     
        
        int [][] matrizOrganizada= new int[numeroNodos][numeroNodos];// organizamos la matriz       
        int [][]estructura=leerArchivo(numeroNodos,p);// guardamos la lectura del archivo en una matriz
           
        matrizOrganizada =ordenarMatriz(leerArchivo(numeroNodos,p));// organizamos la matriz estructura    
        lejanos =masLejanos(minimoCarros,matrizOrganizada,visitados,estructura);
         
        for(int k=minimoCarros; k<numeroNodos;k++){
            for  (int i = 1; i <= 5; i++) { // LLenar puestos
                for (int j = 0; j < minimoCarros; j++) { // Carro numero j
                    actual=indices[j];            
                    lejanos[j]=menor( matrizOrganizada, estructura, actual, visitados);
                    int indice =buscarIndice(actual,lejanos[j],matrizOrganizada,estructura);
                    if(indice == -1) continue;
                    indices[j] = indice;
                    visitados[indice] = true;
                }
            }
            visitados[k]=true;
        }
        numeroTotalCarros(minimoCarros);
    }
}
