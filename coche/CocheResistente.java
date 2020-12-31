package coche;

import circuito.Circuito;
/**
 * Coche que emplea un tanque adicional de combustible para aumentar su resistencia.
 * 
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21
 */
public class CocheResistente extends AbstractCoche
{
    /**
     * Litros de combustible del tanque adicional.
     */
    private final static double RESERVA = 100.0;
    
    private double reservaActual;
    /**
     * Constructor de coches resistentes.
     */
    public CocheResistente(String nombre, Velocidad velocidad, Combustible combustible)
    {
        super(nombre, velocidad, combustible);
        this.reservaActual = RESERVA;
    }
    
    @Override
    public void consumirCombustible(double minutos){
        if(Math.abs(this.reservaActual - 0.0d)>= 0.000001 && minutos > getCombustibleActual()){
            setCombustibleActual(getCombustibleActual() + this.reservaActual);
            this.reservaActual = 0.0d;
        }
        
        setCombustibleActual(getCombustibleActual() - minutos);
    }
    
    @Override
    public String toString(){
        return toBaseString() + "<reserva: "+ this.reservaActual + ">";
    }
}
