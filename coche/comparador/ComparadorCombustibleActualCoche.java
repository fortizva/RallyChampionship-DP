package coche.comparador;

import coche.Coche;
import java.util.Comparator;

/**
 * Comparador de combustible actual ascendente de Coche.
 * 
 * @author Francisco Javier Ortiz Valverde. 
 * @version 20/21
 */
public class ComparadorCombustibleActualCoche implements Comparator<Coche>
{
   /**
    * Compara el combustible actual de los coches y los devuelve en orden ascendente.
    * 
    * @param c1 Coche cuyo combustible actual se va a comparar.
    * @param c2 Coche con el combustible actual a comparar.
    * 
    * @return Devuelve -1 si el primer coche tiene más combustible, 1 si va después o 0 si son iguales.
    */
   
   @Override
   public int compare (Coche c1, Coche c2){
       return ((Double) c1.getCombustibleActual()).compareTo((Double) c2.getCombustibleActual());
    }
}
