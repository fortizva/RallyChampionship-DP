package coche.comparador;

import coche.Coche;
import java.util.Comparator;

/**
 * Comparador de nombres ascendentes de Coche.
 * 
 * @author Pablo Rodriguez Mancha. 
 * @version 20/21
 */
public class ComparadorNombreCoche implements Comparator<Coche>
{
   /**
    * Compara los nombres de los coches y los devuelve en orden alfabetico ascendente.
    * 
    * @param c1 Coche cuyo nombre se va a comparar.
    * @param c2 Coche con el nombre a comparar.
    * 
    * @return Devuelve -1 si el nombre del primer coche va antes en el alfabeto, 1 si va después o 0 si son iguales.
    */
   
   @Override
   public int compare (Coche c1, Coche c2){
       return c1.getNombre().compareTo(c2.getNombre());
    }
}
