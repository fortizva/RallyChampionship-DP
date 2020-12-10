package circuito;

/**
 * Circuito con la complicación extra "Frio"
 * 
 * @author Francisco Javier Ortiz Valverde 
 * @version 20/21
 */
public class CircuitoFrio extends CircuitoComplicado
{
    private final static String nombre = "Frio";
    private final static double factorComplejidad = 1.1;
    private final static double factorDistancia = 0.9;

    /**
     * Constructor de circuitos fríos
     * 
     * @param circuito Circuito al que agregar la condición
     */
    public CircuitoFrio(Circuito circuito)
    {
        super(circuito);
    }

    public double getComplejidadActual(){
        return Math.round((circuitoComplicado.getComplejidadActual() * factorComplejidad)*100d) / 100d;
    }

    public double getDistanciaActual(){
        return Math.round((circuitoComplicado.getDistanciaActual() * factorDistancia)*100d) / 100d;
    }

    public String getCondiciones(){
        return circuitoComplicado.getCondiciones() + " " +nombre;
    }

}
