package piloto;


/**
 * Write a description of class PilotoEstrella here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PilotoEstrella extends PilotoAbstracto
{

    /**
     * Constructor for objects of class PilotoEstrella
     */
    public PilotoEstrella(Piloto piloto, String nombre_piloto)
    {
        super(piloto, nombre_piloto);
    }
    
    public double getDestreza(){
        return ((((this.getConcentracion().getValor()+6)/140)*1.06)+0.05);
    }

}
