import java.util.Comparator;

/**
 * Write a description of class ComparadorPuntosEscuderia here.
 * 
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21
 */
public class ComparadorPuntosEscuderia implements Comparator<Escuderia>
{

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    @Override
    public int compare(Escuderia e1, Escuderia e2){
        return ((Integer)e1.getPuntos()).compareTo((Integer)e2.getPuntos());
    }
}
