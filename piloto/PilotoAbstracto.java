package piloto;

import java.util.HashMap;
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

public abstract class PilotoAbstracto implements Piloto, Comparable<Piloto>
{
    private String nombre;
    private Concentracion concentracion;
    private Coche coche;
    private boolean descalificado;
    private HashMap <String,Resultado> resultados;

    public PilotoAbstracto(String nombre, Concentracion concentracion){
        this.nombre = nombre;
        this.concentracion = concentracion;
        this.descalificado = false;
        resultados = new HashMap <String,Resultado>();
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

    public double getTiempo(Circuito circuito){
        return this.coche.getTiempo(this.getDestreza(), circuito);
    }

    public int getPuntos(){
        int puntos = 0;
        for(Resultado r : this.resultados.values()){
            puntos += r.getPuntos();
        }
        return puntos;
    }

    public HashMap <String, Resultado> getResultados(){
        return new HashMap<String, Resultado>(this.resultados);
    }

    public void addResultado(Circuito circuito, double tiempo){
        this.resultados.put(circuito.getNombre(), new Resultado(circuito, tiempo));
    }

    public void addPuntos(Circuito circuito, int puntos){
        this.resultados.get(circuito.getNombre()).setPuntos(puntos);
    }

    public double competir(Circuito circuito){
        double tiempo = this.getCoche().getTiempo(this.getDestreza(), circuito);
        double combustible = tiempo;
        double resultado = tiempo;
        // Si la concentración es menor que el tiempo de carrera sólo consumir el combustible usado hasta el abandono.
        if(this.getConcentracion().getValor() < tiempo){
            combustible = this.getConcentracion().getValor();
            resultado = this.getConcentracion().getValor() - tiempo;
            System.out.println("¡¡¡ " + this.getNombre() + " perdió la concentración a falta de " + Math.round((tiempo - this.getConcentracion().getValor())*100d)/100d + " minutos para terminar !!!");
            System.out.println("¡¡¡ En el momento del despiste llevaba en carrera " + this.getConcentracion().getValor() + " minutos !!!");
        }

        this.getCoche().consumirCombustible(combustible);
        if(this.getCoche().getCombustibleActual() <= 0){
            resultado = this.getCoche().getCombustibleActual();
            System.out.println("¡¡¡ El " + this.getCoche().getNombre() + " se quedó sin combustible a falta de " + Math.abs(this.getCoche().getCombustibleActual()) + " minutos para terminar !!!");
            System.out.println("¡¡¡ En el momento de quedarse sin combustible llevaba en carrera " + (tiempo + this.getCoche().getCombustibleActual()) + " minutos !!!");
        }

        if(resultado >= 0)
            System.out.println("+++ " + this.getNombre() + " termina la carrera en " + Math.round(resultado*100d)/100d + " minutos +++");

        System.out.println("+++ El combustible del " + this.getCoche().getNombre() + " tras la carrera es " + this.getCoche().getCombustibleActual() + " +++");
        return Math.round(resultado*100d)/100d;
    }

    public boolean isDescalificado(){
        return this.descalificado;
    }

    public int getAbandonos(){
        int abandonos = 0;
        for(Resultado r : this.resultados.values()){
            if(r.getMinutos()<0)
                abandonos++;
        }
        return abandonos;
    }

    @Override
    public int compareTo(Piloto piloto){
        if(this.equals(piloto))
            return 0;
        return this.getNombre().compareTo(piloto.getNombre());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Piloto && ((Piloto) obj).getNombre().equals(this.getNombre())) {
            return true;
        }
        return false;
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