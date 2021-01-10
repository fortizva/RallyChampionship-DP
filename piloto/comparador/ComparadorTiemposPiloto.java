package piloto.comparador;

import circuito.Circuito;
import piloto.Piloto;
import java.util.Comparator;

/**
 * Comparador de Pilotos por tiempo de carrera.
 * 
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21
 */
public class ComparadorTiemposPiloto implements Comparator<Piloto>
{
    private Circuito circuito;

    /**
     * Constructor de ComparadorTiemposPiloto
     * 
     * @param circuito Circuito cuyo resultado va a ser comparado.
     */
    public ComparadorTiemposPiloto(Circuito circuito)
    {
        this.circuito = circuito;
    }

    public int compare(Piloto p1, Piloto p2){
        return ((Double) p1.getTiempo(circuito)).compareTo((Double) p2.getTiempo(circuito));
    }
}
