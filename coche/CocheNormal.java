package coche;

import circuito.Circuito;

/**
 * Write a description of class CocheNormal here.
 * 
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21
 */
public class CocheNormal extends AbstractCoche
{
    /**
     * Constructor de coches normales.
     * 
     * @param nombre Nombre del coche.
     * @param velocidad Velocidad teórica del coche.
     * @param combustible Capacidad para combustible del coche.
     */
    public CocheNormal(String nombre, Velocidad velocidad, Combustible combustible)
    {
        super(nombre, velocidad, combustible);
    }
}
