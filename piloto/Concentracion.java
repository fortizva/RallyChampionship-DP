package piloto;


/**
 * Clase enumeracion de las concentraciones del Piloto.
 * 
 * @author Pablo Rodriguez Mancha.
 * @version 20/21
 */
public enum Concentracion
{
    DESPISTADO("DESPISTADO", 90.0),
    NORMAL("NORMAL", 100.0),
    CONCENTRADO("CONCENTRADO", 110.0),
    ZEN("ZEN", 120.0);

    
    private final String nombre;
    private final double concentracion;
    
    private Concentracion(String nombre, double concentracion){
        this.nombre  = nombre;
        this.concentracion = concentracion;
    }

    /**
     * Devuelve el nombre de la concentración.
     * 
     * @return Nombre de la concentración.
     */
    public String getNombre(){
        return this.nombre;
    }
    
    /**
     * Devuelve el valor almacenado de la concentración.
     * 
     * @return Valor de la concentración.
     */
    public double getValor(){
        return this.concentracion;
    }

    @Override
    public String toString(){
        return this.getNombre() + "("+ this.getValor() +")";
    }
    
}
