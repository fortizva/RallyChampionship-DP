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
    private boolean reversed = false;

    /**
     * Constructor de ComparadorAnidadoPiloto
     * 
     * @param comparadores Comparadores que se tomarán en cuenta para ordenar la lista en orden de prioridad.
     */
    public ComparadorAnidadoPiloto(Comparator<Piloto>... comparadores)
    {
        this.comparadores = Arrays.asList(comparadores);
        reversed = false;
    }

    /**
     * Constructor de ComparadorAnidadoPiloto
     * 
     * @param reversed Si es verdadero, devolverá un orden descendente.
     * @param comparadores Comparadores que se tomarán en cuenta para ordenar la lista en orden de prioridad.
     */
    public ComparadorAnidadoPiloto(boolean reversed, Comparator<Piloto>... comparadores){
        this(comparadores);
        this.reversed = reversed;
    }

    /**
     * Recorre la lista de comparadores y emplea las comparaciones para encontrar una diferencia que determine un orden.
     * En caso de no existir ninguna diferencia, devuelve el resultado de comparar los nombres de ambos.
     * Esto evita que sean considerados iguales sin tener en cuenta el nombre a la hora de insertarlos en un set.
     * 
     * @param p1 Piloto a ser comparado
     * @param p2 Piloto con el que comparar
     * 
     * @return Devuelve -1 si el primer piloto va antes, 1 si va después o 0 si son completamente iguales en las comparaciones realizadas, además del nombre.
     */
    @Override
    public int compare(Piloto p1, Piloto p2){
        int result;
        for(Comparator<Piloto> comparador : comparadores){
            result = comparador.compare(p1,p2);
            if(result != 0){
                return (reversed) ? result*(-1) : result;
            }
        }
        return (reversed) ? p1.getNombre().compareTo(p2.getNombre()) * (-1) : p1.getNombre().compareTo(p2.getNombre());
    }
}
