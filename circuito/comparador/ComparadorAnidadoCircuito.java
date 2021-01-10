package circuito.comparador;

import circuito.Circuito;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

/**
 * Comparador anidado de Circuito que permite unir varios comparadores para ordenar listas por múltiples atributos.
 * 
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21
 */
public class ComparadorAnidadoCircuito implements Comparator<Circuito>
{
    private List<Comparator<Circuito>> comparadores;
    private boolean reversed = false;
    
    /**
     * Constructor de ComparadorAnidadoCircuito
     * 
     * @param comparadores Comparadores que se tomarán en cuenta para ordenar la lista en orden de prioridad.
     */
    public ComparadorAnidadoCircuito(Comparator<Circuito>... comparadores)
    {
        this.comparadores = Arrays.asList(comparadores);
        reversed = false;
    }
    
    /**
     * Constructor de ComparadorAnidadoCircuito
     * 
     * @param reversed Si es verdadero, devolverá un orden descendente.
     * @param comparadores Comparadores que se tomarán en cuenta para ordenar la lista en orden de prioridad.
     */
    public ComparadorAnidadoCircuito(boolean reversed, Comparator<Circuito>... comparadores){
        this(comparadores);
        this.reversed = reversed;
    }
    
    /**
     * Recorre la lista de comparadores y emplea las comparaciones para encontrar una diferencia que determine un orden.
     * En caso de no existir ninguna diferencia, devuelve el resultado de comparar los nombres de ambos.
     * Esto evita que sean considerados iguales sin tener en cuenta el nombre a la hora de insertarlos en un set.
     * 
     * @param c1 Circuito a ser comparado
     * @param c2 Circuito con el que comparar
     * 
     * @return Devuelve -1 si el primer circuito va antes, 1 si va después o 0 si son completamente iguales en las comparaciones realizadas, además del nombre.
     */
    @Override
    public int compare(Circuito c1, Circuito c2){
        int result;
        for(Comparator<Circuito> comparador : comparadores){
            result = comparador.compare(c1,c2);
            if(result != 0)
                return (reversed) ? result * (-1) : result;
        }
        return (reversed) ? c1.getNombre().compareTo(c2.getNombre()) * (-1) : c1.getNombre().compareTo(c2.getNombre());
    }
}
