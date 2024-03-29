package piloto;

import coche.Coche;

/**
 * Piloto con baja destreza.
 * 
 * @author Pablo Rodriguez Mancha
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21
 */
public class PilotoNovato extends PilotoAbstracto
{

    /**
     * Constructor de PilotoNovato
     */
    public PilotoNovato(String nombre, Concentracion concentracion)
    {
        super(nombre, concentracion);
    }
    
    /**
     * Constructor de PilotoNovato
     */
    public PilotoNovato(String nombre, Concentracion concentracion, Coche coche){
        super(nombre, concentracion, coche);
    }
    
    @Override
    public double getDestreza(){
        return Math.round(((this.getConcentracion().getValor()*0.97)/120 - 0.03)*100d)/100d;
    }

}
