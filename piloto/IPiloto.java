package piloto;

import coche.Coche;
import circuito.Circuito;

/**
 * Piloto que conducirá durante las carreras.
 * 
 * @author Pablo Rodriguez Mancha
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21
 */

public interface IPiloto
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
     * Devuelve la concentracion actual de un piloto.
     * 
     * @return concentracionActual Concentracion actual del piloto.
     */
    public Concentracion getConcentracionActual();
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
     public int getTiempoCarrera(Circuito circuito);
    /**
     * Devuelve si una carrera fue completada o no.
     * 
     * @param circuito Circuito recorrido.
     * @return true en caso de que la carrera se completara, false en caso contrario.
     */
     public boolean isCompletaCarrera(Circuito circuito);
     /**
      * Nos indica si un coche tiene suficiente combustible para terminar una carrera.
      * 
      * @return True si no hay combustible para terminar la carrera/ False si si queda combustible para acabarla.
      */
     public boolean isSinCombustible();
     
     /**
      *Devuelve el tiempo que ha hecho un piloto en una carrera.
      *
      *@return minutos de la carrera de un piloto.
      */
     public int getMinPos(int pos);
        
     
     /**
      * Resta al combustible de un coche, el tiempo que hizo en una carrera.
      * 
      * @param coche Coche que realizo la carrera.
      * @return el combustible que le queda al coche tras la carrera.
      */
     public double restarCombustible(int pos);
    /**
     * Devuelve si el piloto está descalificado.
     * 
     * @return Estado del piloto.
     */
    public boolean isDescalificado();
}