package piloto;
import java.util.ArrayList;

import coche.Coche;
import circuito.Circuito;

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
    private Concentracion concentracionActual;
    private Coche coche;
    private boolean descalificado;
    private ArrayList <Resultados> resultados;
    
    public PilotoAbstracto(String nombre, Concentracion concentracion){
        this.nombre = nombre;
        this.concentracion = concentracion;
        this.concentracionActual = concentracion;
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
    
    public Concentracion getConcentracionActual(){
        return this.concentracionActual;
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
    
     public int getTiempoCarrera(Circuito circuito){
         int tiempo = 0;
         
         
         return tiempo;
    }
    public boolean isCompletaCarrera(Circuito circuito){
        return false;
    }
    
    public boolean isSinCombustible(){
        if(this.getCoche().getCombustibleActual() <= 0)
            return false;
        else{
            return true;
        }
    }
    
    public int getMinPos(int pos){
        return this.resultados.get(pos).getMinutosCarrera();
    }
    
    public double restarCombustible(int pos){
        return this.getCoche().getCombustibleActual() - getMinPos(pos);
    }
    
    /*
    public double restarCombustible(){
        
        double comb = this.getCoche().getCombustibleActual();
        boolean tieneComb = true;
        
        for(int i = 0; i<resultados.size() && tieneComb; i++){
            comb = this.getCoche().getCombustibleActual() - getMinPos(i);
                if(comb <= 0)
                tieneComb = false;
        }  
        return comb;
    }
    */
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