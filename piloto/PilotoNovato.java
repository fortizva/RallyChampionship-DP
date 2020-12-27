package piloto;


/**
 * Write a description of class PilotoNovato here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PilotoNovato extends PilotoAbstracto
{

    /**
     * Constructor for objects of class PilotoNovato
     */
    public PilotoNovato(Piloto piloto, String nombre_piloto)
    {
        super(piloto, nombre_piloto);
    }
    
    public double getDestreza(){
        return ((super.getPuntosConcentracion()*0.97)/120 - 0.3);
    }

}
