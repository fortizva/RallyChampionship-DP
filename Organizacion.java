import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Arrays;
import java.util.TreeSet;

import piloto.comparador.ComparadorAnidadoPiloto;
import piloto.comparador.ComparadorTiemposPiloto;
import piloto.comparador.ComparadorPuntosPiloto;
import piloto.Resultado;
import circuito.Circuito;
import circuito.comparador.ComparadorAnidadoCircuito;
import piloto.Piloto;

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
    private Organizacion(int limiteAbandonos, int limitePilotos, ComparadorAnidadoCircuito comparador){
        this.limiteAbandonos = limiteAbandonos;
        this.limitePilotos = limitePilotos;
        escuderias = new ArrayList <Escuderia>();
        circuitos = new TreeSet <Circuito>(comparador);
        pilotosCarrera = new TreeSet <Piloto>(new ComparadorAnidadoPiloto(new ComparadorPuntosPiloto().reversed()));

        pilotosDescalificados = new ArrayList <Piloto>();
    }

    /**
     * Inicializa los valores de la instancia Organizacion o crea una nueva con los valores dados si no existe.
     * 
     * @param limiteAbandonos Límite de abandonos por piloto.
     * @param limitePilotos Límite de pilotos que puede enviar una escudería.
     */
    public static void inicializar(int limiteAbandonos, int limitePilotos)
    {
        if(instancia == null)
            instancia = new Organizacion(limiteAbandonos, limitePilotos);
        else{
            instancia.setLimiteAbandonos(limiteAbandonos);
            instancia.setLimitePilotos(limitePilotos);
        }
    }
    
        /**
     * Inicializa los valores de la instancia Organizacion o crea una nueva con los valores dados si no existe.
     * 
     * @param limiteAbandonos Límite de abandonos por piloto.
     * @param limitePilotos Límite de pilotos que puede enviar una escudería.
     * @param comparador Comparador que se empleará para ordenar las carreras
     */
    public static void inicializar(int limiteAbandonos, int limitePilotos, ComparadorAnidadoCircuito comparador)
    {
        if(instancia == null)
            instancia = new Organizacion(limiteAbandonos, limitePilotos, comparador);
        else{
            instancia.setLimiteAbandonos(limiteAbandonos);
            instancia.setLimitePilotos(limitePilotos);
            TreeSet aux = new TreeSet(comparador);
            aux.addAll(instancia.circuitos);
            instancia.circuitos = aux;
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
        Collections.sort(this.escuderias);
    }

    /**
     * Permite a una escudería enviar a un piloto al campeonato.
     * 
     * @param p Piloto enviado al campeonato.
     */
    public void enviarPiloto(Piloto p){
        if(p.getCoche() != null){
            System.out.println("INTENTANDO ENVIAR A "+ p.getNombre());
            System.out.println("INSERTADO?" + pilotosCarrera.add(p));
        }
    }
    
    /**
     * Añade un o más circuitos al campeonato.
     * 
     * @param circuitos Circuitos a añadir.
     */
    public void addCircuitos(Circuito... circuitos){
        this.circuitos.addAll(Arrays.asList(circuitos));
    }
    
    /**
     * Elimina un circuito del campeonato.
     * 
     * @param circuito Circuito a eliminar.
     */
    public void removeCircuito(Circuito circuito){
        instancia.circuitos.remove(circuito);
    }

    /**
     * Ejecuta el campeonato celebrando las distintas carreras establecidas.
     * Requiere que todas las escuderías se hayan inscrito previamente y que los circuitos hayan sido introducidos.
     */
    public void competir(){
        // Mostramos por pantalla los circuitos en los que se correrá.
        mostrarCircuitos();
        // Mostramos por pantalla las escuderías que participan.
        mostrarEscuderias();

        // Celebramos cada carrera (Guardamos el número de la carrera para mostrarlo por pantalla).
        int numeroTurno = 1;
        boolean keep = true;
        for(Circuito c : this.circuitos){
            if(keep){
                System.out.println("********************************************************************************************************");
                System.out.println("*** CARRERA<" + numeroTurno + "> EN "+ c.toString() + " ***");
                System.out.println("********************************************************************************************************");

                // Llenamos la parrilla de salida
                llenarPista();

                System.out.println("********************************************************************************************************");
                System.out.println("******************************** Pilotos que van a competir en "+ c.getNombre() +" *******************************");
                System.out.println("**********************************************************************************************************");

                // Comprobamos que hay pilotos suficientes como para realizar la carrera.
                if(this.pilotosCarrera.size() <= 1){
                    System.out.println("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡");
                    System.out.println("¡¡¡ No se celebra esta carrera ni la(s) siguiente(s) por no haber pilotos para competir !!!!");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    keep = false;
                } else {
                    mostrarPilotos();

                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("+++++++++++++++++++++++++ Comienza la carrera en "+ c.getNombre() +" ++++++++++++++++++++++++++");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                    // Pedimos a los pilotos que corran en la carrera (Guardamos índice de piloto y número de pilotos al inicio para mostrarlo por pantalla).
                    int numPiloto = 1, numPilotos = this.pilotosCarrera.size();
                    for(Piloto p : this.pilotosCarrera){
                        System.out.println("@@ Piloto " + numPiloto + " de " + numPilotos);
                        System.out.println(p.toString());
                        System.out.println(p.getCoche().toString());
                        // Pedir al piloto que corra en el circuito
                        double tiempo = p.competir(c);
                        p.addResultado(c, tiempo);
                        System.out.println("@@@");
                        // Comprobar si el piloto está descalificado y marcarlo si es así para su posterior descalificación.
                        if(tiempo < 0 && p.getAbandonos() > this.limiteAbandonos){
                            System.out.println("@@@");
                            System.out.println("¡¡¡ " + p.getNombre() + " es DESCALIFICADO del campeonato por alcanzar el límite de abandonos(" + this.limiteAbandonos + ") !!!");
                            System.out.println("@@@");
                            p.setDescalificado(true);
                        }
                        numPiloto++;
                    }
                }
            }

            //Obtener clasificación de la carrera y asignar puntos
            clasificarCarrera(c);

            numeroTurno++;
        }

        System.out.println("****************************************************");
        System.out.println("**************** FIN DEL CAMPEONATO ****************");
        mostrarClasificacionFinalPilotos();        
        mostrarClasificacionFinalEscuderias();
    }

    /**
     * Pide a las escuderias que envien pilotos a la carrera.
     */
    public void llenarPista(){
        //this.pilotosCarrera = new TreeSet(this.pilotosCarrera.comparator());
        for(Escuderia e: this.escuderias){
            e.obtenerParticipantes(this.limitePilotos);
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
     * Envía piloto a la lista de descalificados
     * 
     * @return Piloto a descalificar.
     */
    public void descalificarPiloto(Piloto p){
        p.setDescalificado(true);
        this.pilotosDescalificados.add(p);
        this.pilotosCarrera.remove(p);
    }

    /**
     * Muestra los resultados de una carrera por pantalla y asigna los puntos correspondientes a cada piloto.
     * Además, envía a descalificar aquellos que lo precisen.
     * 
     * @param c Circuito en el que se ha disputado la carrera.
     */
    public void clasificarCarrera(Circuito c){
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++ Clasificación final de la carrera en "+ c.getNombre() + " ++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        // Obtener resultados
        ArrayList<Piloto> terminado = new ArrayList<Piloto>();
        ArrayList<Piloto> abandono = new ArrayList<Piloto>();
        for(Piloto p : this.pilotosCarrera){
            // Si el tiempo es negativo significa que ha abandonado
            if(p.getResultados().get(c.getNombre()).getMinutos() < 0){
                abandono.add(p);
            } else {
                terminado.add(p);
            }
        }

        terminado.sort(new ComparadorTiemposPiloto(c));
        abandono.sort(new ComparadorTiemposPiloto(c));

        // Mostrar resultados y añadir puntos
        int puntMax = 10, posicion = 1;
        for(Piloto p : terminado){
            p.addPuntos(c, puntMax);
            System.out.println("@@@ Posición(" + posicion + "): " + p.getNombre() + " - Tiempo: " + p.getResultados().get(c.getNombre()).getMinutos() + " minutos - Puntos: " + puntMax + " @@@");

            puntMax = (puntMax<=2) ? 2 : puntMax-2;
            posicion++;
        }

        for(Piloto p : abandono){
            String s = "¡¡¡ Ha abandonado " + p.getNombre() + " - Tiempo: - " + p.getResultados().get(c.getNombre()).getMinutos() + " - Puntos: 0";
            p.addPuntos(c, 0);
            if(p.isDescalificado()){
                s += " - Además ha sido descalificado para el resto del Campeonato !!!";
                descalificarPiloto(p);
            }
            System.out.println(s);
        }
    }

    /**
     * Muestra por pantalla los resultados finales del campeonato.
     */
    public void mostrarClasificacionFinalPilotos(){
        System.out.println("****************************************************");
        System.out.println("********** CLASIFICACIÓN FINAL DE PILOTOS **********");
        System.out.println("****************************************************");

        if(this.pilotosCarrera.size() == 0){
            System.out.println("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡");
            System.out.println("¡¡¡ Campeonato de pilotos queda desierto por haber sido descalificados todos los pilotos !!!!");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        } else {
            TreeSet<Piloto> ganadores = new TreeSet<Piloto>(new ComparadorPuntosPiloto());
            ganadores.addAll(this.pilotosCarrera);
            int posicion = 1;
            for(Piloto p : ganadores){
                System.out.println("@@@ Posición(" + posicion + "): " + p.getNombre() +" - Puntos Totales: " + p.getPuntos() + " @@@");
                posicion++;
                for(Resultado r : p.getResultados().values()){
                    System.out.println("Carrera(" + r.getCircuito().getNombre() + ") - Puntos:" + r.getPuntos() + " - Tiempo:" + r.getMinutos() + " minutos");
                }
            }

            System.out.println("****************************************************");
            System.out.println("************** PILOTOS DESCALIFICADOS **************");
            System.out.println("****************************************************");
            for(Piloto p : this.pilotosDescalificados){
                System.out.println("--- Piloto Descalificado: " + p.getNombre() + " - Puntos Totales Anulados: " + p.getPuntos() + " ---");
                for(Resultado r : p.getResultados().values()){
                    System.out.println("Carrera(" + r.getCircuito().getNombre() + ") - Puntos:" + r.getPuntos() + " - Tiempo:" + r.getMinutos() + " minutos");
                }
            }
        }
    }

    public void mostrarClasificacionFinalEscuderias(){
        System.out.println("****************************************************");
        System.out.println("******** CLASIFICACIÓN FINAL DE ESCUDERÍAS *********");
        System.out.println("****************************************************");
        if(this.pilotosCarrera.size() == 0){
            System.out.println("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡");
            System.out.println("¡¡¡ Campeonato de pilotos queda desierto por haber sido descalificados todos los pilotos !!!!");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        } else{
            TreeSet<Escuderia> ganadores = new TreeSet<Escuderia>(new ComparadorPuntosEscuderia());
            ArrayList<Escuderia> descalificadas = new ArrayList<Escuderia>();

            for(Escuderia e : this.escuderias){
                if(e.isDescalificada())
                    descalificadas.add(e);
                else                
                    ganadores.add(e);
            }

            int posicion = 1;
            for(Escuderia e : ganadores){
                System.out.println("@@@ Posición(" + posicion + ") " + e.getNombre() + " con " + e.getPuntos() + " puntos @@@");
                posicion++;
                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                System.out.println(e.toString());
                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            }

            System.out.println("****************************************************");
            System.out.println("************ ESCUDERIAS DESCALIFICADAS *************");
            System.out.println("****************************************************");

            for(Escuderia e : descalificadas){
                System.out.println("¡¡¡ Escudería Descalificada: " + e.getNombre() + " con 0.0 puntos !!!");
                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                System.out.println(e.toString());
                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            }
        }
    }

    /**
     * Muestra los circuitos.
     */
    public void mostrarCircuitos(){
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||| CIRCUITOS DEL CAMPEONATO |||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        for(Circuito c: this.circuitos){
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
        for(Escuderia e: this.escuderias){
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println(e.toString());
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }
    }

    /**
     * Muestra toda la información de los pilotos en la parrilla.
     */
    public void mostrarPilotos(){
        for(Piloto p : this.pilotosCarrera){
            System.out.println(p.toString());
        }
    }
}
