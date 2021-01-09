import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import circuito.Circuito;
import piloto.Piloto;
import java.util.TreeSet;

/**
 * Singleton Organizacion que gestionara la competición.
 * 
 * @author Pablo Rodriguez Mancha
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21
 */
public final class Organizacion
{
    private static Organizacion instancia;

    private int limiteAbandonos;
    private int limitePilotos;
    private ArrayList <Escuderia> escuderias;
    private TreeSet <Circuito> circuitos;
    private TreeSet <Piloto> pilotosCarrera;
    private ArrayList <Piloto> pilotosDescalificados;

    /**
     * Constructor de una Organizacion vacía.
     * Por defecto, las reglas de la organización son:
     * Límite de abandonos: 1
     * Límite de pilotos: 1
     */
    private Organizacion(){
        this(1, 1);
    }

    /**
     * Constructor de Organizacion.
     * 
     * @param limiteAbandonos Límite de abandonos por piloto.
     * @param limitePilotos Límite de pilotos que puede enviar una escudería.
     */
    private Organizacion(int limiteAbandonos, int limitePilotos){
        this.limiteAbandonos = limiteAbandonos;
        this.limitePilotos = limitePilotos;
        escuderias = new ArrayList <Escuderia>();
        circuitos = new TreeSet <Circuito>();
        pilotosCarrera = new TreeSet <Piloto>();
        pilotosDescalificados = new ArrayList <Piloto>(); 
    }
    
    /**
     * Constructor de Organizacion.
     * 
     * @param limiteAbandonos Límite de abandonos por piloto.
     * @param limitePilotos Límite de pilotos que puede enviar una escudería.
     */
    private Organizacion(int limiteAbandonos, int limitePilotos, Comparator<Circuito> comparador){
        this.limiteAbandonos = limiteAbandonos;
        this.limitePilotos = limitePilotos;
        escuderias = new ArrayList <Escuderia>();
        circuitos = new TreeSet <Circuito>(comparador);
        pilotosCarrera = new TreeSet <Piloto>(new Comparator <Piloto>()
        {
            @Override
            public int compare(Piloto p1, Piloto p2){
                return ((Integer)p1.getPuntos()).compareTo(p2.getPuntos()) * (-1);
            }
        });
            
        pilotosDescalificados = new ArrayList <Piloto>();
    }

    /**
     * Inicializa los valores de la instancia Organizacion o crea una nueva con los valores dados si no existe.
     * 
     * @param limiteAbandonos Límite de abandonos por piloto.
     * @param limitePilotos Límite de pilotos que puede enviar una escudería.
     */
    private static void inicializar(int limiteAbandonos, int limitePilotos)
    {
        if(instancia == null)
            instancia = new Organizacion(limiteAbandonos, limitePilotos);
        else{
            instancia.setLimiteAbandonos(limiteAbandonos);
            instancia.setLimitePilotos(limitePilotos);
        }
    }

    /**
     * Devuelve la instancia de Organizacion si existe, en caso contrario, crea una vacía.
     * 
     * @return Instancia de Organizacion
     */
    public static  Organizacion getInstance(){
        if(instancia == null)
            instancia = new Organizacion();
        return instancia;
    }

    /**
     * Permite a una escudería inscribirse al campeonato.
     * 
     * @param escuderia Escuderia a inscribir en el campeonato.
     */
    public void inscribir(Escuderia escuderia){
        this.escuderias.add(escuderia);
    }
    
    /**
     * Permite a una escudería enviar a un piloto al campeonato.
     * 
     * @param p Piloto enviado al campeonato.
     */
    public void enviarPiloto(Piloto p){
        if(p.getCoche() != null && limitePilotos < pilotosCarrera.size()){
          pilotosCarrera.add(p);
        }
    }
    
    /**
     * Pide a las escuderias que envien pilotos a la carrera.
     */
    public void llenarPista(){
        for(Escuderia e: this.escuderias){
            e.obtenerParticipantes();
        }
    }
    /**
     * Establece el límite de abandonos por piloto.
     * 
     * @param limiteAbandonos Límite de abandonos.
     */
    private void setLimiteAbandonos(int limiteAbandonos){
        this.limiteAbandonos = limiteAbandonos;
    } 

    /**
     * Devuelve el límite actual de abandonos por piloto.
     * 
     * @return Límite de abandonos por piloto.
     */
    public int getLimiteAbandonos(){
        return this.limiteAbandonos;
    }

    /**
     * Establece el límite de pilotos por escudería.
     * 
     * @param limitePilotos Límite de pilotos.
     */
    private void setLimitePilotos(int limitePilotos){
        this.limitePilotos = limitePilotos;
    } 

    /**
     * Devuelve el límite actual pilotos por escudería.
     * 
     * @return Límite de pilotos.
     */
    public int getLimitePilotos(){
        return this.limitePilotos;
    }

    /**
     * Muestra los circuitos.
     */
    public void mostrarCircuitos(){
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||| CIRCUITOS DEL CAMPEONATO |||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        for(Circuito c: circuitos){
            System.out.println(c.toString());
        }
    }

    /**
     * Muestra toda la informacion de las escuderias inscritas.
     */
    public void mostrarEscuderias(){
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%% ESCUDERÍAS DEL CAMPEONATO %%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        for(Escuderia e: escuderias){
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println(e.toString());
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }
    }
}
