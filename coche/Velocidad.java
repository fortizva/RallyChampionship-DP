package coche;

/**
 * Clase de enumeración de velocidades de coches.
 * 
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21
 */
public enum Velocidad
{
    TORTUGA("TORTUGA", 200.0),
    LENTA("LENTA", 210.0),
    NORMAL("NORMAL", 220.0),    
    RAPIDA("RAPIDA", 230.0),    
    GUEPARDO("GUEPARDO", 240.0);

    private final String nombre;
    private final double velocidad;

    private Velocidad (String nombre, double velocidad){
        this.nombre = nombre;
        this.velocidad = velocidad;
    }

    /**
     * Devuelve el nombre de la velocidad.
     * 
     * @return Nombre de la velocidad.
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Devuelve el valor de la velocidad.
     * 
     * @return Valor de la velocidad.
     */
    public double getValor(){
        return this.velocidad;
    }

    @Override
    public String toString(){
        return getNombre()+"("+getValor()+")";
    }
}
