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
    private double concentracionActual;
    private Coche coche;
    private boolean descalificado;
    private ArrayList <Resultados> resultados;
    
    public PilotoAbstracto(String nombre, Concentracion concentracion){
        this.nombre = nombre;
        this.concentracion = concentracion;
        this.concentracionActual = concentracion.getValor();
        this.descalificado = false;
        resultados = new ArrayList<Resultados>();
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
    
    public double getConcentracionActual(){
        return this.concentracionActual;
    }
    
    public void setConcentracionActual(double puntos){
        this.concentracionActual = puntos;
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
        return (this.getCoche().getCombustibleActual() <= 0);
    }
    
    public boolean isSinConcentracion(){
        return (this.getConcentracionActual() <= 0);
    }
    
    public int getMinPos(int pos){
        return this.resultados.get(pos).getMinutosCarrera();
    }
    
    public double getPuntosPos(int pos){
        return this.resultados.get(pos).getPuntos();
    }
    
    public void setPuntosPos(int pos, int puntos){
        this.resultados.get(pos).setPuntos(puntos);
    }
    public double restarCombustible(int pos){
        return this.getCoche().getCombustibleActual() - getMinPos(pos);
    }
    
    public void carrera(Circuito circuito){        
       this.getCoche().consumirCombustible(this.getDestreza(), circuito); 
       this.setConcentracionActual(this.getConcentracionActual() - this.getCoche().getTiempo(this.getDestreza(), circuito));
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