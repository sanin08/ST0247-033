import java.util.ArrayList;

/**
 *
 * @author Juan Pablo Peña F. - Juan Sebastián Sanín V.
 */
public class Taller6 {

    /**
    * Metodo que dado un entero n y un conjunto de denominciones de dinero
    * busque la manera optima de dar el cambio
    * @param n cantidad a devolver
    * @param denominaciones conjunto de denominaciones de dinero (monedas, billetes)
    * @return un conjunto de unidades por denominacion
    */   
    public static int[] cambioGreedy(int n, int[] denominaciones) {
        int[] devuelta = new int[11];
        for (int i = 0; i < denominaciones.length; i++) {
            devuelta[i] = n/denominaciones[i];
            n=n%denominaciones[i];
        }
        return devuelta;           
        
    }
    
    /**
    * Metodo que recorre todo el grafo con la intencion de buscar un
    * camino que represente el menor costo pasando por todos los vertices exactamente
    * una vez y vuelva al nodo inicial
    * @param g grafo dado 
    * @return cual es el costo que tiene
    */
    public static ArrayList recorrido(Digraph g) {
         boolean[] visitados= new boolean[g.size()+1];
        int v=0;
        int menorid=0;
        int menor=Integer.MAX_VALUE;
        ArrayList <Integer> respuesta= new ArrayList();
        respuesta.add(menorid); 
        for (int i = menorid; i < g.size(); i++) {
            visitados[v]=true;
            ArrayList<Integer>adyacentes=g.getSuccesor(i);
            for(Integer adyacente: adyacentes){
                int temporal=g.getWeight(v,adyacente);
                if(!visitados[adyacente]){
                    if(temporal < menor){
                        menor=temporal; 
                        menorid=adyacente;
                    }
                }
            }
            respuesta.add(menorid);
            v=menorid;
        }
        respuesta.add(0);
        return respuesta;
    }
}
