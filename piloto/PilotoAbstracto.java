package piloto;

import coche.Coche;

/**
 * Write a description of class PilotoAbstracto here.
 * 
 * @author Pablo Rodriguez Mancha
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21
 */

public abstract class PilotoAbstracto implements IPiloto
{
    private String nombre;
    private Coche coche;
    private Concentracion concentracion;
    private double concentracionActual;
    private boolean descalificado;
    
    public PilotoAbstracto(String nombre, Concentracion concentracion){
        this.nombre = nombre;
        this.concentracion = concentracion;
        this.concentracionActual = concentracion.getValor();
        this.descalificado = false;
    }
    
    public PilotoAbstracto(String nombre, Concentracion concentracion, Coche coche){
        this(nombre, concentracion);
        this.coche = coche;
    }
    
    /**
     * Devuelve el nombre del piloto.
     */
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setConcentracion(Concentracion concentracion){
        this.concentracion = concentracion;
    }
    
    /**
     * Devuelve la concentracion del piloto.
     */
    public Concentracion getConcentracion(){
        return this.concentracion;
    }

    /**
     * Devuelve la destreza de un piloto.
     */
    public abstract double getDestreza();
 
    public void setDescalificado(boolean descalificado){
        this.descalificado = descalificado;
    }
    
    public boolean isDescalificado(){
        return this.descalificado;
    }

    public Coche getCoche(){
        return this.coche;
    }
    
    public void setCoche(Coche coche){
        this.coche = coche;
    }
    
    @Override
    public String toString(){
        return "algo";
    }
}