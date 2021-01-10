package coche;

import circuito.Circuito;

/**
 * Abstract class AbstractCoche - write a description of the class here
 * 
 * @author: Francisco Javier Ortiz Valverde
 * @version: 20/21 
 */
public abstract class AbstractCoche implements Coche, Comparable<Coche>
{
    private String nombre;
    private Velocidad velocidad;
    private Combustible combustible;
    private double combustibleActual;
    
    public AbstractCoche(String nombre, Velocidad velocidad, Combustible combustible){
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.combustible = combustible;
        this.combustibleActual = combustible.getValor();
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setVelocidad(Velocidad velocidad){
        this.velocidad = velocidad;
    }
    
    public Velocidad getVelocidad(){
        return this.velocidad;
    }
    
    public void setCombustible(Combustible combustible){
        this.combustible = combustible;
    }
    
    public Combustible getCombustible(){
        return this.combustible;
    }
    
    /**
     * Establece el nivel de combustible restante del coche.
     * 
     * @param combustibleActual Combustible restante del coche.
     */
    protected void setCombustibleActual(double combustibleActual){
        this.combustibleActual = combustibleActual;
    }
    
    public double getCombustibleActual(){
        return Math.round(this.combustibleActual*100d)/100d;
    }
    
    public double getVelocidadReal(double destreza, Circuito circuito){
        double velocidadReal = Math.round(((getVelocidad().getValor() * destreza) / circuito.getComplejidadActual())*100d) / 100d;
        System.out.println("+++ Con estas condiciones es capaz de correr a " + velocidadReal + " km/hora +++");
        return velocidadReal;
    }
    
    public double getTiempo(double destreza, Circuito circuito){
        return Math.round(((circuito.getDistanciaActual() / getVelocidadReal(destreza, circuito)) * 60)*100d) / 100d;
    }
    
    public void consumirCombustible(double minutos){
        combustibleActual -= minutos;
    }
    
    /**
     * Devuelve la información básica del coche.
     * 
     * @return Información básica del coche.
     */
    protected String toBaseString(){
        String s;
        s = "<coche: " + getNombre() +">";
        s += " <tipo: " + this.getClass().getSimpleName() + ">";
        s += " <vel_teó: " + getVelocidad().toString() + ">";
        s += " <comb: " + getCombustible().toString() + " (actual:" + getCombustibleActual() + ")>";
        return s;
    }
    
    @Override
    public int compareTo(Coche coche){
        return this.getNombre().compareTo(coche.getNombre());
    }
    
    @Override
    public String toString(){
        return toBaseString();
    }
}
