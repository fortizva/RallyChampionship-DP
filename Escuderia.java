import piloto.Piloto;
import coche.Coche;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.Iterator;

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
    private TreeSet<Piloto> pilotos;
    private TreeSet<Coche> coches;

    /**
     * Constructor de Escuderias.
     * 
     * @param nombre Nombre de la escudería.
     */
    public Escuderia(String nombre)
    {
        this.nombre = nombre;
        pilotos = new TreeSet<Piloto>();
        coches = new TreeSet<Coche>();
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
        TreeSet <Piloto> aux = new TreeSet<Piloto>(comparador);
        aux.addAll(this.pilotos);
        this.pilotos = aux;
    }

    /**
     * Ordena la lista de coches de la escudería según un comparador (o comparadores en caso de usar un comparador anidado).
     * 
     * @param comparador Comparador empleado para ordenar la lista.
     */
    public void ordenarCoches(Comparator<Coche> comparador){
        TreeSet <Coche> aux = new TreeSet<Coche>(comparador);
        aux.addAll(this.coches);
        this.coches = aux;
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
     * Devuelve una copia de la lista de pilotos de la escudería.
     * 
     * @return Lista de pilotos de la escudería.
     */
    public TreeSet<Piloto> getPilotos(){
        TreeSet<Piloto> copia = new TreeSet<Piloto>(this.pilotos.comparator());
        copia.addAll(this.pilotos);
        return copia;
    }

    /**
     * Añade un coche a la escudería.
     * 
     * @param coche Coche a añadir.
     */
    public void addCoche(Coche coche){
        this.coches.add(coche);
    }

    /**
     * Añade un piloto a la escudería.
     * 
     * @param piloto Piloto a añadir.
     */
    public void addPiloto(Piloto piloto){
        this.pilotos.add(piloto);
    }

    /**
     * Devuelve si todos los pilotos de la escudería están descalificados.
     * 
     * @return Devuelve true si todos los pilotos están descalificados.
     */
    public boolean isDescalificada(){
        for(Piloto p : this.pilotos){
            if(p.isDescalificado())
                return false;
        }
        return true;
    }

    /**
     * Inscribe a la escudería en el campeonato.
     */
    public void inscribirse(){
        Organizacion.getInstance().inscribir(this);
    }

    /**
     * Asigna al primer piloto de la lista sin descalificar el primer coche de la lista con combustible.
     * 
     * @return Devuelve true si envia un piloto.
     */
    public boolean obtenerParticipantes(){
        boolean enc = false;
        for(Piloto p : pilotos){
            if(!p.isDescalificado()){
                Iterator it = coches.iterator();
                while(it.hasNext() && !enc){
                    Coche c = (Coche)it.next();
                    if(c.getCombustibleActual() > 0){
                        p.setCoche(c);
                        enc = true;
                        Organizacion.getInstance().enviarPiloto(p);
                    }
                }
                if(!enc){
                    System.out.println("¡¡¡ " + p.getNombre() + " NO ES ENVIADO A LA CARRERA porque su escudería: " + this.getNombre() + " no tiene más coches con combustible disponibles !!! ");
                }
            }
        }
        return enc;
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
