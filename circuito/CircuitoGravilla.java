package circuito;

/**
 * Circuito con la complicación extra "Gravilla"
 * 
 * @author Francisco Javier Ortiz Valverde 
 * @version 20/21
 */
public class CircuitoGravilla extends CircuitoComplicado
{
    private final static String nombre = "Gravilla";
    private final static double factorComplejidad = 1.05;
    private final static double factorDistancia = 0.95;

    /**
     * Constructor de circuitos con gravilla
     * 
     * @param circuito Circuito al que agregar la condición
     */
    public CircuitoGravilla(Circuito circuito)
    {
        super(circuito);
    }
    
    @Override
    public double getComplejidadActual(){
        return Math.round((circuitoComplicado.getComplejidadActual() * factorComplejidad)*100d) / 100d;
    }
    
    @Override
    public double getDistanciaActual(){
        return Math.round((circuitoComplicado.getDistanciaActual() * factorDistancia)*100d) / 100d;
    }
    
    @Override
    public String getCondiciones(){
        return circuitoComplicado.getCondiciones() + " " +nombre;
    }

}
