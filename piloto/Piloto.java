package piloto;

import coche.Coche;

/**
 * Piloto que conducirá en las carreras
 * 
 * @author Pablo Rodriguez Mancha
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
     * Asigna un nombre al piloto.
     * 
     * @param nombre Nombre del piloto.
     */
    public void setNombre(String nombre);
    
    /**
     * Devuelve la destreza de un piloto.
     */
    public double getDestreza();
    
    /**
     * Devuelve la concentracion del piloto.
     */
    public Concentracion getConcentracion();
    
    /**
     * Asigna una concentracion al piloto.
     */
    public void setConcentracion(Concentracion concentracionPiloto);
    
    public void setCoche(Coche coche);
    
    public Coche getCoche();
    
    public void setDescalificado(boolean descalificado);
    
    public boolean isDescalificado();
}