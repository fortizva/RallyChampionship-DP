import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import circuito.Circuito;
import piloto.Piloto;

/**
 * Clase Organizacion que gestionara la competicion.
 * 
 * @author Pablo Rodriguez Mancha
 * @version 20/21
 */
public class Organizacion
{
    private int limiteAbandonos;
    private int limitePilotos;
    private ArrayList <Escuderia> escuderias;
    private ArrayList <Circuito> circuitos;
    private ArrayList <Piloto> pilotosCarrera;
    
    public Organizacion(int limiteAbandonos, int limitePilotos)
    {
        this.limiteAbandonos = limiteAbandonos;
        this.limitePilotos = limitePilotos;
    }
    
    /**
     * Muestra las escuderias del ArrayList escuderias.
     */
    public void mostrarEscuderias(){
        for(Escuderia e: escuderias){
            System.out.println(e.toString());
        }
    }
    
    /**
     * Muestra los circuitos del ArrayList circuitos.
     */
     public void mostrarCircuitos(){
        for(Circuito c: circuitos){
            System.out.println(c.toString());
        }
    }
    
    /**
     * Muestra los pilotos con sus respectivos coches del ArrayList pilotosCarrera.
     */
     public void mostrarPilotosCarrera(){
        for(Piloto p: pilotosCarrera){
            System.out.println(p.toString()); System.out.println("\n"); 
            p.getCoche().toString();   
        }
    }
    
    /**
     * Muestra toda la informacion de las escuderias del ArrayList escuderias.
     */
    public void mostrarInfoEscuderias(){
        for(Escuderia e: escuderias){
            System.out.println("La escuderia: ");
            System.out.println(e.toString());
            System.out.println("\n"); System.out.println("Formada por los pilotos: ");
            e.mostrarPilotos();
            System.out.println("\n"); System.out.println("Formada por los coches: ");
            e.mostrarCoches();
            System.out.println("\n"); System.out.println("\n");
        }
    }
    
    /**
     * 
     */
    public void mostrarTodo(){
        System.out.println("Informacion de las escuderias: "); System.out.println("\n");
        this.mostrarInfoEscuderias();
        System.out.println("Lista de los circuitos: "); System.out.println("\n");
        this.mostrarCircuitos();
        System.out.println("Pilotos que van a competir en la carrera: "); System.out.println("\n");
        this.mostrarPilotosCarrera();
        
        }
    
}
