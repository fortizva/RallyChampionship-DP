import piloto.Piloto;
import coche.Coche;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Escuderías que organizarán sus coches y pilotos.
 * 
 * @autor Pablo Rodriguez Mancha.
 * @author Francisco Javier Ortiz Valverde.
 * @version 20/21.
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
     * Devuelve el nombre de la escudería.
     * 
     * @return el nombre de la escudería.
     */
    public String getNombre(){
        return this.getNombre();
    }

    /**
     * Asigna un nombre a la escudería.
     * 
     * @param nombre Nombre de la escudería.
     */
    public void setNombre(String nombre){
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
     * Inscribe a la escudería en el campeonato.
     */
    public void inscribirse(){
        Organizacion.getInstance().inscribir(this);
    }

    /**
     * Asigna al primer piloto de la lista sin descalificar el primer coche de la lista con combustible.
     */
    public void obtenerParticipantes(){
        boolean enc = false;
        for(Piloto p : pilotos){
            if(!p.isDescalificado()){
                for(int i = 0; i < coches.size() && !enc; i++ ){
                    if(coches.get(i).getCombustibleActual() > 0){
                        p.setCoche(coches.get(i));
                        enc = true;
                    }
                }
                if (!enc)
                    System.out.println("El piloto no tiene ningun coche con combustible para competir. ");
            }
            enc = false;
        }
    }

    @Override
    public String toString(){
        String s = "%%% "+ this.getNombre() +" %%%";
        for(Piloto p : pilotos){
            s += p.toString();
        }
        for(Coche c : coches){
            s += c.toString();
        }
        return s;
    }
}
