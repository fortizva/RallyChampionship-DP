package circuito.comparador;

import circuito.Circuito;
import java.util.Comparator;

/**
 * Comparador de complejidad actual ascendentes de Circuito.
 * 
 * @author Pablo Rodriguez Mancha.
 * @author Francisco Javier Ortiz Valverde.
 * @version 20/21.
 */
public class ComparadorComplejidadActualCircuito implements Comparator<Circuito>
{
    /**
     * Compara las complejidad actual de los circuitos y devuelve el resultado según orden ascendente.
     * 
     * @param c1 Circuito a comparar complejidad actual.
     * @param c2 Circuito con el que comparar la complejidad actual.
     * 
     * @return Devuelve -1 si la complejidad actual del primer circuito va antes, 1 si va después o 0 si son iguales.
     */
    @Override
    public int compare(Circuito c1, Circuito c2){
        return ((Double)c1.getComplejidadActual()).compareTo((Double)c2.getComplejidadActual());
    }
}
