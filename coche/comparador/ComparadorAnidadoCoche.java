package coche.comparador;

import coche.Coche;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

/**
 * Comparador anidado de Coche para ordenar los coches empleado 1 o varios atributos de la clase.
 * 
 * @author Pablo Rodriguez Mancha. 
 * @version 20/21.
 */
public class ComparadorAnidadoCoche implements Comparator<Coche>
{  
   private List<Comparator<Coche>> comparadores;
   
   public ComparadorAnidadoCoche(Comparator<Coche>...comparadores){ 
        this.comparadores = Arrays.asList(comparadores);
    }
    
   /**
    * Recorre la lista de comparadores y emplea las comparaciones para encontrar una diferencia que determine un orden.
    * @param c1 Coche comparado.
    * @param c2 Coche comparado.
    */
   
   @Override
    public int compare(Coche c1, Coche c2){
        int result;
        for(Comparator<Coche> comparador : comparadores){
            result = comparador.compare(c1,c2);
            if(result != 0)
                return result;
        }
        return 0;
    }
}
