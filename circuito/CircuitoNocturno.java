package circuito;

/**
 * Circuito con la complicación extra "Nocturno"
 * 
 * @author Francisco Javier Ortiz Valverde 
 * @version 20/21
 */
public class CircuitoNocturno extends CircuitoComplicado
{
    private final static String nombre = "Nocturno";
    private final static double factorComplejidad = 1.2;
    private final static double factorDistancia = 0.8;

    /**
     * Constructor de circuitos nocturnos
     * 
     * @param circuito Circuito al que agregar la condición
     */
    public CircuitoNocturno(Circuito circuito)
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
