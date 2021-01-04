import piloto.Piloto;
import coche.Coche;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Escuderías que organizarán sus coches y pilotos.
 * 
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21
 */
public class Escuderia
{
    private String nombre;
    private ArrayList<Piloto> pilotos;
    private ArrayList<Coche> coches;

    /**
     * Constructor de Escuderias.
     * 
     * @param nombre Nombre de la escudería.
     */
    public Escuderia(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * Ordena la lista de pilotos de la escudería según un comparador (o comparadores en caso de usar un comparador anidado).
     * 
     * @param comparador Comparador empleado para ordenar la lista.
     */
    public void ordenarPilotos(Comparator<Piloto> comparador){
        Collections.sort(this.pilotos, comparador);
    }

    /**
     * Ordena la lista de coches de la escudería según un comparador (o comparadores en caso de usar un comparador anidado).
     * 
     * @param comparador Comparador empleado para ordenar la lista.
     */
    public void ordenarCoches(Comparator<Coche> comparador){
        Collections.sort(this.coches, comparador);
    }
    
    /**
     * Devuelve la puntuación total de la escudería.
     * 
     * @param Suma de puntos de los pilotos de la escudería.
     */
    public int getPuntos(){
        int puntos = 0;
        for(Piloto p : pilotos){
            puntos += p.getPuntos();
        }
        
        return puntos;
    }
    
    /**
     * Inscribe a la escudería en el torneo.
     */
    public void inscribirse(){
        // TODO: Inscribir escuderías.
        System.out.println("DEBUG: Organización aún no implementada, en un futuro se podrá inscribir esta escudería y este mensaje será eliminado.");
        //Organizacion.getInstance().inscribirEscuderia(this);
    }
}
