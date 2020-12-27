package piloto;

import coche.Coche;

/**
 * Piloto con cierta destreza.
 * 
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21
 */
public class PilotoExperimentado extends PilotoAbstracto
{
    /**
     * Constructor de PilotoExperimentado
     */
    public PilotoExperimentado(String nombre, Concentracion concentracion)
    {
        super(nombre, concentracion);
    }
    
    /**
     * Constructor de PilotoExperimentado
     */
    public PilotoExperimentado(String nombre, Concentracion concentracion, Coche coche){
        super(nombre, concentracion, coche);
    }
    
    @Override
    public double getDestreza(){
        return (((this.getConcentracion().getValor()+3)/130)*1.03);
    }
}
