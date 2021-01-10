package circuito.comparador;

import circuito.Circuito;
import java.util.Comparator;

/**
 * Comparador de distancia actual ascendentes de Circuito.
 * 
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21
 */
public class ComparadorDistanciaActualCircuito implements Comparator<Circuito>
{
    /**
     * Compara las distancia actual de los circuitos y devuelve el resultado según orden ascendente.
     * 
     * @param c1 Circuito a comparar distancia actual
     * @param c2 Circuito con el que comparar la distancia actual
     * 
     * @return Devuelve -1 si la distancia actual del primer circuito va antes, 1 si va después o 0 si son iguales.
     */
    @Override
    public int compare(Circuito c1, Circuito c2){
        return ((Double)c1.getDistanciaActual()).compareTo((Double)c2.getDistanciaActual());
    }
}
