import piloto.Piloto;
import piloto.comparador.ComparadorAnidadoPiloto;
import coche.Coche;
import coche.comparador.ComparadorAnidadoCoche;

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
public class Escuderia implements Comparable<Escuderia>
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
     * Constructor de Escuderias.
     * 
     * @param nombre Nombre de la escudería.
     * @param compPilotos Comparador de pilotos.
     * @param compCoches Comparador de coches.
     */
    public Escuderia(String nombre, ComparadorAnidadoPiloto compPilotos, ComparadorAnidadoCoche compCoches)
    {
        this.nombre = nombre;
        pilotos = new TreeSet<Piloto>(compPilotos);
        coches = new TreeSet<Coche>(compCoches);
    }

    /**
     * Devuelve el nombre de la escudería.
     * 
     * @return el nombre de la escudería.
     */
    public String getNombre(){
        return this.nombre;
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
    public void ordenarPilotos(ComparadorAnidadoPiloto comparador){
        TreeSet <Piloto> aux = new TreeSet<Piloto>(comparador);
        aux.addAll(this.pilotos);
        this.pilotos = aux;
    }

    /**
     * Ordena la lista de coches de la escudería según un comparador (o comparadores en caso de usar un comparador anidado).
     * 
     * @param comparador Comparador empleado para ordenar la lista.
     */
    public void ordenarCoches(ComparadorAnidadoCoche comparador){
        TreeSet <Coche> aux = new TreeSet<Coche>(comparador);
        aux.addAll(this.coches);
        this.coches = aux;
    }

    /**
     * Actualiza el orden de la lista de pilotos.
     */
    public void actualizarPilotos(){
        TreeSet <Piloto> aux = new TreeSet<Piloto>(this.pilotos.comparator());
        aux.addAll(this.pilotos);
        this.pilotos = aux;
        System.out.println("DEBUG: MOSTRANDO ESCUDERÍA "+ this.getNombre() +"PILOTOS");
        System.out.println(this.pilotos);
    }
    
      /**
     * Actualiza el orden de la lista de coches.
     */
        public void actualizarCoches(){
        TreeSet <Coche> aux = new TreeSet<Coche>(this.coches.comparator());
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
     * Envía a competir tantos pilotos como tenga disponible dentro del límite establecido.
     * 
     * @param limite Número de pilotos máximos a enviar.
     */
    public void obtenerParticipantes(int limite){
        // Actualizamos las listas de pilotos y coches
        actualizarPilotos();
        actualizarCoches();
        
        Iterator itPiloto = this.pilotos.iterator();
        Iterator itCoche = coches.iterator();
        Piloto piloto = (Piloto) itPiloto.next();;
        Coche coche;
        boolean asignado = false;
        for(int i = 0; i<limite; i++){
            while((piloto.isDescalificado() || asignado) && itPiloto.hasNext()){
                piloto = (Piloto) itPiloto.next();
                asignado = false;
            }
            if(!piloto.isDescalificado()){
                asignado = false;
                while(itCoche.hasNext() && !asignado){
                    coche = (Coche) itCoche.next();
                    if(coche.getCombustibleActual() > 0){
                        piloto.setCoche(coche);
                        asignado = true;
                        Organizacion.getInstance().enviarPiloto(piloto);
                    }
                } 
                if(!asignado){
                    System.out.println("¡¡¡ " + piloto.getNombre() + " NO ES ENVIADO A LA CARRERA porque su escudería: " + this.getNombre() + " no tiene más coches con combustible disponibles !!! ");
                }
            }
        }
    }

    @Override
    public int compareTo(Escuderia e){
        return this.nombre.compareTo(e.getNombre())*(-1);
    }

    @Override
    public String toString(){
        String s = "%%% "+ this.getNombre() +" %%%\n";
        for(Piloto p : pilotos){
            s += p.toString() + "\n";
        }
        for(Coche c : coches){
            s += c.toString() + "\n";
        }
        return s;
    }
}
