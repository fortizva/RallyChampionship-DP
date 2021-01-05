package circuito.comparador;

import circuito.Circuito;
import java.util.Comparator;

/**
 * Comparador de nombres ascendentes de Circuito.
 * 
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21
 */
public class ComparadorNombreCircuito implements Comparator<Circuito>
{
    /**
     * Compara los nombres de los circuitos y devuelve el resultado según el orden alfabético ascendente.
     * 
     * @param p1 Circuito a comparar nombre
     * @param p2 Circuito con el que comparar el nombre
     * 
     * @return Devuelve -1 si el nombre del primer circuito va antes en el alfabeto, 1 si va después o 0 si son iguales.
     */
    @Override
    public int compare(Circuito c1, Circuito c2){
        return c1.getNombre().compareTo(c2.getNombre());
    }
}