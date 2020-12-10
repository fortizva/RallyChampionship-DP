package circuito;
/**
 *  Pista sobre la que se disputan las carreras.
 * 
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21
 */

public interface ICircuito
{   
    /**
     * Devuelve la complejidad actual del circuito teniendo en cuenta sus condiciones (complicaciones extra).
     * 
     * @return Valor de la complejidad del circuito teniendo en cuenta las complicaciones extra.
     */
    public double getComplejidadActual();

    /**
     * Devuelve la distancia actual del circuito teniendo en cuenta sus condiciones (complicaciones extra).
     * 
     * @return Valor de la distancia del circuito teniendo en cuenta las complicaciones extra.
     */
    public double getDistanciaActual();

    /**
     * Devuelve la lista de condiciones (complicaciones extra) del circuito.
     * 
     * @return Texto con las condiciones del circuito.
     */
    public String getCondiciones();
}
