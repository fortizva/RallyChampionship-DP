package piloto;

import coche.Coche;

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
     * Devuelve si el piloto está descalificado.
     * 
     * @return Estado del piloto.
     */
    public boolean isDescalificado();
}