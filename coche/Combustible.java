package coche;

/**
 * Clase de enumeración de cantidades de combustible para coches.
 * 
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21
 */
public enum Combustible
{
    ESCASO("ESCASO", 350.0),
    NORMAL("NORMAL", 440.0),
    GENEROSO("GENEROSO", 460.0),    
    ELEFANTE("ELEFANTE", 480.0);

    private final String nombre;
    private final double combustible;

    private Combustible (String nombre, double combustible){
        this.nombre = nombre;
        this.combustible = combustible;
    }

    /**
     * Devuelve el nombre de la cantidad de combustible.
     * 
     * @return Nombre de la cantidad de combustible.
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Devuelve el valor de la cantidad de combustible.
     * 
     * @return Valor de la cantidad de combustible.
     */
    public double getValor(){
        return this.combustible;
    }

    @Override
    public String toString(){
        return getNombre()+"("+getValor()+")";
    }
}
