package piloto;
import java.util.ArrayList;

import coche.Coche;
import circuito.Circuito;

/**
 * Clase abstracta de Piloto
 * 
 * @author Pablo Rodriguez Mancha
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21
 */

public abstract class PilotoAbstracto implements Piloto
{
    private String nombre;
    private Concentracion concentracion;
    private double concentracionActual;
    private Coche coche;
    private boolean descalificado;
    private ArrayList <Resultado> resultados;

    public PilotoAbstracto(String nombre, Concentracion concentracion){
        this.nombre = nombre;
        this.concentracion = concentracion;
        this.concentracionActual = concentracion.getValor();
        this.descalificado = false;
        resultados = new ArrayList<Resultado>();
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

    /**
     * Actualiza la puntuacion de concentracion de un piloto.
     * 
     * @param puntos Puntos que sobreescribiran el valor de la concentracion de un piloto.
     */
    protected void setConcentracionActual(double puntos){
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

    public double getTiempo(Circuito circuito){
        return this.coche.getTiempo(this.getDestreza(), circuito);
    }

    public ArrayList<Resultado> getResultados(){
        return new ArrayList<Resultado>(this.resultados);
    }

    public void addResultado(Circuito circuito, int puntos){
        this.resultados.add(new Resultado(circuito.getNombre(), this.coche.getTiempo(this.getDestreza(), circuito), puntos));
    }

    public void competir(Circuito circuito){
        double tiempo = this.getCoche().getTiempo(this.getDestreza(), circuito);
        this.setConcentracionActual(this.getConcentracionActual() - tiempo);
        // Si la concentración actual es menor o igual a 0 significa que ha terminado la carrera antes de tiempo, por lo que el tiempo que ha gastado combustible es igual al tiempo de la carrera menos lo que le ha faltado de concentración.
        this.getCoche().consumirCombustible((this.getConcentracionActual()<=0.0) ? (tiempo + this.getConcentracionActual()) : tiempo);

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