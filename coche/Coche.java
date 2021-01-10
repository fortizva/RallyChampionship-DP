package coche;

import circuito.Circuito;

/**
 * Vehículo que correrá en los circuitos durante las carreras.
 * 
 * @author Francisco Javier Ortiz Valverde 
 * @version 20/21
 */

public interface Coche
{
    /**
     * Establece el nombre del coche.
     * 
     * @param nombre Nombre del coche.
     */
    public void setNombre(String nombre);

    /**
     * Devuelve el nombre del coche.
     * 
     * @return Nombre del coche.
     */
    public String getNombre();

    /**
     * Establece la velocidad teórica del coche.
     * 
     * @param velocidad Velocidad teórica del coche.
     */
    public void setVelocidad(Velocidad velocidad);

    /**
     * Devuelve la velocidad teórica del coche.
     * 
     * @return Velocidad teórica del coche.
     */
    public Velocidad getVelocidad();

    /**
     * Establece la cantidad de combustible del coche.
     * 
     * @param combustible Cantidad de combustible del coche.
     */
    public void setCombustible(Combustible combustible);
    
    /**
     * Devuelve la capacidad de combustible del coche.
     * 
     * @return Capacidad para combustible del coche.
     */
    public Combustible getCombustible();
    
    /**
     * Devuelve el nivel de combusible restante del coche.
     * 
     * @return Combustible restante del coche.
     */
    public double getCombustibleActual();
    
    /**
     * Devuelve y muestra por pantalla la velocidad del coche teniendo en cuenta la complejidad del ciruito y la desteza de su piloto.
     * 
     * @param destreza Destreza del piloto que conduce el coche.
     * @param circuito Circuito en el que está corriendo el coche.
     * @return Velocidad real del coche.
     */
    public double getVelocidadReal(double destreza, Circuito circuito);

    /**
     * Devuelve el tiempo necesario para completar la carrera teniendo en cuenta la velocidad real del coche y la distancia del circuito.
     * 
     * @param destreza Destreza del piloto que conduce el coche.
     * @param circuito Circuito en el que está corriendo el coche.
     * @return Tiempo en minutos para completar la carrera actual.
     */
    public double getTiempo(double destreza, Circuito circuito);

    /**
     * Reduce el nivel de combustible del coche en función de los minutos que haya estado compitiendo.
     * 
     * @param minutos Tiempo en minutos que ha estado corriendo el coche.
     */
    public void consumirCombustible(double minutos);
}
