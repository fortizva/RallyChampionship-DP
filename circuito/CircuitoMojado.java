package circuito;

/**
 * Circuito con la complicación extra "Mojado"
 * 
 * @author Francisco Javier Ortiz Valverde 
 * @version 20/21
 */
public class CircuitoMojado extends CircuitoComplicado
{
    private final static String nombre = "Mojado";
    private final static double factorComplejidad = 1.15;
    private final static double factorDistancia = 0.85;

    /**
     * Constructor de circuitos mojados
     * 
     * @param circuito Circuito al que agregar la condición
     */
    public CircuitoMojado(Circuito circuito)
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
