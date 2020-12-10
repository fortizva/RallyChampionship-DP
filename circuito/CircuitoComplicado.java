package circuito;

/**
 * Decorator de Circuito para incluir complicaciones extra.
 * 
 * @author: Francisco Javier Ortiz Valverde
 * @version: 20/21
 */
public abstract class CircuitoComplicado extends Circuito
{
    protected Circuito circuitoComplicado;

    public CircuitoComplicado(Circuito circuito){
        super(circuito.getNombre(), circuito.getComplejidadOriginal(), circuito.getDistanciaOriginal());
        this.circuitoComplicado = circuito;
    }

    public double getComplejidadActual(){
        return circuitoComplicado.getComplejidadActual();
    }

    public double getDistanciaActual(){
        return circuitoComplicado.getDistanciaActual();
    }

    public String getCondiciones(){
        return circuitoComplicado.getCondiciones();
    }
}
