package piloto.comparador;

import piloto.Piloto;
import java.util.Comparator;

/**
 * Comparador por puntos de Piloto.
 * 
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21
 */
public class ComparadorPuntosPiloto implements Comparator<Piloto>
{
    /**
     * Compara los nombres de los pilotos y devuelve el resultado según el orden alfabético ascendente.
     * 
     * @param p1 Piloto a comparar nombre
     * @param p2 Piloto con el que comparar el nombre
     * 
     * @return Devuelve -1 si el nombre del primer piloto va antes en el alfabeto, 1 si va después o 0 si son iguales.
     */
    @Override
    public int compare(Piloto p1, Piloto p2){
        return ((Integer) p1.getPuntos()).compareTo((Integer) p2.getPuntos());
    }
}