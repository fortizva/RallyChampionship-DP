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
    private Concentracion concentracion;
    private Coche coche;
    private boolean descalificado;
    
    public PilotoAbstracto(String nombre, Concentracion concentracion){
        this.nombre = nombre;
        this.concentracion = concentracion;
        this.descalificado = false;
    }
    
    public PilotoAbstracto(String nombre, Concentracion concentracion, Coche coche){
        this(nombre, concentracion);
        this.coche = coche;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public abstract double getDestreza();
    
    public Concentracion getConcentracion(){
        return this.concentracion;
    }
    
    public void setConcentracion(Concentracion concentracion){
        this.concentracion = concentracion;
    }

    public Coche getCoche(){
        return this.coche;
    }
    
    public void setCoche(Coche coche){
        this.coche = coche;
    }
    
    public void setDescalificado(boolean descalificado){
        this.descalificado = descalificado;
    }
    
    public boolean isDescalificado(){
        return this.descalificado;
    }
    
    @Override
    public String toString(){
    String s = "<piloto:" + this.getNombre() + ">";
    s += " <tipo: " + this.getClass().getSimpleName() +">";
    s += " <dest: "+this.getDestreza() + ">";
    s += " <conc: " + this.getConcentracion().toString() + ">";
    s += " <descalificado: " + isDescalificado() + ">";
    return s;
    }
}