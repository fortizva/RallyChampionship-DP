package circuito;
/**
 * Clase de enumeración de distancias de circuito.
 * 
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21
 */
public enum Distancia
{
    CORTA("CORTA", 250),
    INTERMEDIA("INTERMEDIA", 275),
    LARGA("LARGA", 300);

    private final String nombre;
    private final double distancia;

    private Distancia(String nombre, double distancia){
        this.nombre = nombre;
        this.distancia = distancia;
    }

    /**
     * Devuelve el nombre de la distancia.
     * 
     * @return Nombre de la distancia.
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Devuelve el valor de la distancia.
     * 
     * @return Valor de la distancia.
     */
    public double getValor(){
        return this.distancia;
    }

    @Override
    public String toString(){
        return getNombre()+"(original:"+getValor()+")";
    }
}
