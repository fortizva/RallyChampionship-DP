package coche;

import circuito.Circuito;

/**
 * Coche que emplea un tanque de nitro para aumentar su velocidad.
 * 
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21
 */
public class CocheRapido extends AbstractCoche
{
    /**
     * Litros de nitro que contiene el coche.
     */
    private final static double NITRO = 80.0;
    /**
     * Porcentaje máximo a aumentar
     */
    private final static double AUMENTO_MAXIMO = 20;
    private double nitroActual;

    /**
     * Constructor de coches rápidos (con nitro).
     */
    public CocheRapido(String nombre, Velocidad velocidad, Combustible combustible)
    {
        super(nombre, velocidad, combustible);
        nitroActual = NITRO;
    }
    
    @Override
    public double getVelocidadReal(double destreza, Circuito circuito){
        double velocidadReal = Math.round(((getVelocidad().getValor() * destreza) / circuito.getComplejidadActual())*100d) / 100d;
        double porcentaje = Math.round((velocidadReal * (AUMENTO_MAXIMO/100d))*100d)/100d;
        
        System.out.println("+++ Con estas condiciones es capaz de correr a " + velocidadReal + " km/hora +++");
        if(nitroActual >= 0){
            if (porcentaje >= this.nitroActual) {
                porcentaje = this.nitroActual;
            }
            velocidadReal += porcentaje;
            this.nitroActual -= porcentaje;
        }
        System.out.println("+++ El " + this.getNombre() +" usa " + porcentaje + " de nitro para alcanzar " + Math.round(velocidadReal*100d)/100d + " km/hora y el nitro restante es " + Math.round(this.nitroActual*100d)/100d + " +++");
        return Math.round(velocidadReal*100d)/100d;
    } 
    
    @Override
    public String toString(){
        return toBaseString() + "<nitroPendiente: "+ Math.round(this.nitroActual*100d)/100d + ">";
    }
}
