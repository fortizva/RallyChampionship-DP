package piloto; 
import java.io.IOException;

/**
 * Write a description of class PilotoAbstracto here.
 * 
 * @author Pablo Rodriguez Mancha
 * @version (a version number or a date)
 */

public abstract class PilotoAbstracto extends Piloto
{
    protected Piloto PilotoAbstracto;
    private String nombre_piloto;
    
    public PilotoAbstracto(Piloto piloto, String nombre_piloto){
        super(piloto.getNombre(), piloto.getDestreza(), piloto.getConcentracion());
        this.nombre_piloto = nombre_piloto;
        
        this.PilotoAbstracto = piloto;
    }
    /*
     * Devuelve el nombre del piloto.
     */
    public String getNombre(){
        return PilotoAbstracto.getNombre();
    }
    /*
     * Devuelve la concentracion del piloto.
     */
    public Concentracion getConcentracion(){
        return PilotoAbstracto.getConcentracion();
    }
    /*
     * Devuelve los puntos de concentracion de un piloto.
     */
     public double getPuntosConcentracion(){
        return PilotoAbstracto.getConcentracion().getPuntos();
    }
    /*
     * Devuelve la destreza de un piloto.
     */
    public double getDestreza(){
        return PilotoAbstracto.getDestreza();
    }
 


}