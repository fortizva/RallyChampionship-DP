package coche.comparador;

import coche.Coche;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

/**
 * Comparador anidado de Coche para ordenar los coches empleado 1 o varios atributos de la clase.
 * 
 * @author Pablo Rodriguez Mancha. 
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21.
 */
public class ComparadorAnidadoCoche implements Comparator<Coche>
{  
    private List<Comparator<Coche>> comparadores;
    private boolean reversed = false;
    
    public ComparadorAnidadoCoche(Comparator<Coche>...comparadores){ 
        this.comparadores = Arrays.asList(comparadores);
        reversed = false;
    }

    /**
     * Constructor de ComparadorAnidadoCoche
     * 
     * @param reversed Si es verdadero, devolverá un orden descendente.
     * @param comparadores Comparadores que se tomarán en cuenta para ordenar la lista en orden de prioridad.
     */
    public ComparadorAnidadoCoche(boolean reversed, Comparator<Coche>... comparadores){
        this(comparadores);
        this.reversed = reversed;
    }

    /**
     * Recorre la lista de comparadores y emplea las comparaciones para encontrar una diferencia que determine un orden.
     * En caso de no existir ninguna diferencia, devuelve el resultado de comparar los nombres de ambos.
     * Esto evita que sean considerados iguales sin tener en cuenta el nombre a la hora de insertarlos en un set.
     * 
     * @param c1 Coche comparado.
     * @param c2 Coche comparado.
     */

    @Override
    public int compare(Coche c1, Coche c2){
        int result;
        for(Comparator<Coche> comparador : comparadores){
            result = comparador.compare(c1,c2);
            if(result != 0)
                return (reversed) ? result * (-1) : result;
        }
        return (reversed) ? c1.getNombre().compareTo(c2.getNombre()) * (-1) : c1.getNombre().compareTo(c2.getNombre());
    }
}
