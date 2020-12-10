package circuito;

import java.util.Set;
import java.util.HashSet;

/**
 * Circuito base
 * 
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21
 */
public class Circuito implements ICircuito
{
    private String nombre;
    private Complejidad complejidadOriginal;
    private Distancia distanciaOriginal;

    public Circuito(String nombre, Complejidad complejidad, Distancia distancia){
        this.nombre = nombre;
        this.complejidadOriginal = complejidad;
        this.distanciaOriginal = distancia;
    }

    /**
     * Establece el nombre del circuito.
     * 
     * @param nombre Nombre del circuito.
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * Devuelve el nombre del circuito.
     * 
     * @return Nombre del circuito.
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Establece la complejidad original del circuito.
     * 
     * @param complejidad Complejidad del circuito sin complicaciones extra.
     */
    public void setComplejidadOriginal(Complejidad complejidad){
        this.complejidadOriginal = complejidad;
    }

    /**
     * Devuelve la complejidad del circuito sin tener en cuenta las condiciones actuales.
     * 
     * @return Complejidad del circuito teniendo en cuenta las complicaciones extra.
     */
    public Complejidad getComplejidadOriginal(){
        return this.complejidadOriginal;
    }

    /**
     * Establece la distancia original del circuito.
     * 
     * @param distancia Distancia del circuito sin complicaciones extra.
     */
    public void setDistanciaOriginal(Distancia distancia){
        this.distanciaOriginal = distancia;
    }

    /**
     * Devuelve la distancia del circuito sin tener en cuenta las condiciones actuales.
     * 
     * @return Distancia del circuito sin complicaciones extra.
     */
    public Distancia getDistanciaOriginal(){
        return this.distanciaOriginal;
    }

    public double getComplejidadActual(){
        return getComplejidadOriginal().getValor();
    }

    public double getDistanciaActual(){
        return getDistanciaOriginal().getValor();
    }

    public String getCondiciones(){
        return "";
    }

    @Override
    public String toString(){
        String s;
        s = "<circuito:" + getNombre() + ">";
        s += " <cond:"+ getCondiciones() + ">";
        s += " <comp:" + getComplejidadOriginal().toString();
        s += " (actual:" + getComplejidadActual() + ")>";
        s += " <dist:" + getDistanciaOriginal().toString();
        s += " (actual:" + getDistanciaActual() + ")>";
        return s;
    }
}
