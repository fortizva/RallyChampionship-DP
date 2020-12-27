package piloto;


/**
 * Clase enumeracion de las concentraciones del Piloto.
 * 
 * @author Pablo Rodriguez Mancha.
 * @version (version number or date here)
 */
public enum Concentracion
{
    DESPISTADO("DESPISTADO", 90.0), NORMAL("NORMAL", 100.0), CONCENTRADO("CONCENTRADO", 110.0), ZEN("ZEN", 120.0);
    
    private final String nombre;
    private final double concentracion;
    
    private Concentracion(String nombre, double concentracion){
        this.nombre  = nombre;
        this.concentracion = concentracion;
    }
    
    /*
     * Devuelve el nombre de la concentracion.
     */
    public String getNombre(){
        return this.nombre;
    }
    /*
     * Devuelve el valor almacenado en la concentracion.
     */
    public double getPuntos(){
        return this.concentracion;
    }
    /*
     * Crea y devuelve una cadena de tipo String con los valores de una concentracion. 
     */
    @Override
    public String toString(){
        return this.getNombre() + "(original: "+ this.getPuntos() +")";
    }
    
}
