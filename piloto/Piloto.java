package piloto;

import java.util.HashMap;
import coche.Coche;
import circuito.Circuito;

/**
 * Piloto que conducirá durante las carreras.
 * 
 * @author Pablo Rodriguez Mancha
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21
 */

public interface Piloto
{
    /**
     * Devuelve el nombre del piloto.
     * 
     * @return Nombre del piloto.
     */
    public String getNombre();

    /**
     * Establece el nombre al piloto.
     * 
     * @param nombre Nombre del piloto.
     */
    public void setNombre(String nombre);

    /**
     * Devuelve la destreza de un piloto.
     * 
     * @return Destreza del piloto.
     */
    public double getDestreza();

    /**
     * Devuelve la concentracion del piloto.
     * 
     * @return Concentración del piloto.
     */
    public Concentracion getConcentracion();

    /**
     * Establece la concentracion al piloto.
     * 
     * @param concentracion Concentración del piloto.
     */
    public void setConcentracion(Concentracion concentracion);

    /**
     * Establece el coche del piloto
     * 
     * @param coche Coche del piloto
     */
    public void setCoche(Coche coche);

    /**
     * Devuelve el coche del piloto.
     * 
     * @return Coche del piloto.
     */
    public Coche getCoche();

    /**
     * Establece si el piloto está descalificado.
     * 
     * @param descalificado Estado del piloto.
     */
    public void setDescalificado(boolean descalificado);

    /**
     * Calcula el tiempo que ha hecho un piloto con un coche en un circuito.
     * 
     * @param circuito Circuito recorrido por el piloto.
     * @return tiempo que ha hecho el piloto en la carrera.
     */
    public double getTiempo(Circuito circuito);

    /**
     * Devuelve los puntos totales del piloto.
     * 
     * @return Puntuación total del piloto.
     */
    public int getPuntos();
    
    /**
     * Devuelve una lista con los resultados del piloto.

     * @return Historial de carreras del piloto.
     */
    public HashMap<String, Resultado> getResultados();

    /**
     * Añade un resultado de carrera al historial del piloto.
     * 
     * @param circuito Circuito en el que se ha disputado la carrera.
     * @param minutos Tiempo de carrera.
     */
    public void addResultado(Circuito circuito, double minutos);
    
    /**
     * Añade puntuación a un resultado de carrera del historial del piloto.
     * 
     * @param circuito Circuito en el que se han conseguido los puntos.
     * @param puntos Puntos conseguidos en la carrera.
     */
    public void addPuntos(Circuito circuito, int puntos);
    
    /**
     * Resta el combustible y la concentracion que consume cada carrera al coche y a su piloto respectivamente y devuelve el tiempo de carrera.
     * Si alguno del los valores es insuficiente para completar la carrera, se almacenará lo que faltó para terminar la carrera.
     * En caso de perder la concentración antes de finalizar, sólo se restará el combustible usado hasta entonces.
     * 
     * @param circuito Circuito que recorre el piloto.
     * 
     * @return Tiempo en terminar la carrera, si no finaliza la carrera devolverá el tiempo faltante como un valor negativo.
     */
    public double competir(Circuito circuito);

    /**
     * Devuelve si el piloto está descalificado.
     * 
     * @return Estado del piloto.
     */
    public boolean isDescalificado();
    
    /**
     * Devuelve el número de abandonos a lo largo del campeonato.
     * 
     * @return Número de abandonos.
     */
    public int getAbandonos();
}