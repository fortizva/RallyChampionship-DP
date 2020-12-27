package piloto;


/**
 * Write a description of class PilotoExperimentado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PilotoExperimentado extends PilotoAbstracto
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class PilotoExperimentado
     */
    public PilotoExperimentado(Piloto piloto, String nombre_piloto)
    {
        super(piloto, nombre_piloto);
    }
    
    public double getDestreza(){
        return (((this.getConcentracion().getValor()+3)/130)*1.03);
    }
}
