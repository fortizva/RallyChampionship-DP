package piloto.comparador;

import piloto.Piloto;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

/**
 * Comparador anidado de Pilotos que permite unir varios comparadores para ordenar listas por múltiples atributos.
 * 
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21
 */
public class ComparadorAnidadoPiloto implements Comparator<Piloto>
{
    private List<Comparator<Piloto>> comparadores;
    
    /**
     * Constructor de ComparadorAnidadoPiloto
     * 
     * @param comparadores Comparadores que se tomarán en cuenta para ordenar la lista en orden de prioridad.
     */
    public ComparadorAnidadoPiloto(Comparator<Piloto>... comparadores)
    {
        this.comparadores = Arrays.asList(comparadores);
    }

    /**
     * Recorre la lista de comparadores y emplea las comparaciones para encontrar una diferencia que determine un orden.
     * 
     * @param p1 Piloto a ser comparado
     * @param p2 Piloto con el que comparar
     * 
     * @return Devuelve -1 si el primer piloto va antes, 1 si va después o 0 si son completamente iguales en las comparaciones realizadas.
     */
    @Override
    public int compare(Piloto p1, Piloto p2){
        int result;
        for(Comparator<Piloto> comparador : comparadores){
            result = comparador.compare(p1,p2);
            if(result != 0)
                return result;
        }
        return 0;
    }
}
