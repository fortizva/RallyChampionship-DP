package circuito;
/**
 * Clase de enumeración de complejidades de circuito.
 * 
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21
 */
public enum Complejidad
{
    BAJA("BAJA", 1.0),
    MEDIA("MEDIA", 1.25),
    ALTA("ALTA", 1.5);
    
    private final String nombre;
    private final double complejidad;
    
    private Complejidad(String nombre, double complejidad){
        this.nombre = nombre;
        this.complejidad = complejidad;
    }
     
    /**
     * Devuelve el nombre de la complejidad.
     * 
     * @return Nombre de la complejidad.
     */
    public String getNombre(){
        return this.nombre;
    }
    
    /**
     * Devuelve el valor de la complejidad.
     * 
     * @return Valor de la complejidad.
     */
    public double getValor(){
        return this.complejidad;
    }
    
    @Override
    public String toString(){
        return getNombre()+"(original:"+getValor()+")";
    }
}
