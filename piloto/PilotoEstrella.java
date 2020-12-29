package piloto;

import coche.Coche;

/**
 * Piloto con mayor destreza.
 * 
 * @author Pablo Rodriguez Mancha
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21
 */
public class PilotoEstrella extends PilotoAbstracto
{

    /**
     * Constructor de PilotoEstrella
     */
    public PilotoEstrella(String nombre, Concentracion concentracion)
    {
        super(nombre, concentracion);
    }
    
    /**
     * Constructor de PilotoEstrella
     */
    public PilotoEstrella(String nombre, Concentracion concentracion, Coche coche){
        super(nombre, concentracion, coche);
    }
    
    @Override
    public double getDestreza(){
        return ((((this.getConcentracionActual().getValor()+6)/140)*1.06)+0.05);
    }

}
