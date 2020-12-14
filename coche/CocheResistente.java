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
    public void consumirCombustible(double destreza, Circuito circuito){
        double tiempo = getTiempo(destreza, circuito);
        if(Math.abs(this.reservaActual - 0.0d)>= 0.000001 && tiempo > getCombustibleActual()){
            setCombustibleActual(getCombustibleActual() + this.reservaActual);
            this.reservaActual = 0.0d;
        }
        
        setCombustibleActual(getCombustibleActual() - tiempo);
    }
    
    @Override
    public String toString(){
        return toBaseString() + "<reserva: "+ this.reservaActual + ">";
    }
}
