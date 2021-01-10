package piloto.comparador;

import piloto.Piloto;
import java.util.Comparator;

/**
 * Comparador de Pilotos por destreza.
 * 
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21
 */
public class ComparadorDestrezaPiloto implements Comparator<Piloto>
{
    /**
     * Compara las destrezas de los pilotos y devuelve el resultado según orden ascendente.
     * 
     * @param p1 Piloto a comparar destreza
     * @param p2 Piloto con el que comparar la destreza
     * 
     * @return Devuelve -1 si tiene más destreza, 1 si va después o 0 si son iguales.
     */
    @Override
    public int compare(Piloto p1, Piloto p2){
        return ((Double) p1.getDestreza()).compareTo((Double) p2.getDestreza());
    }
}
