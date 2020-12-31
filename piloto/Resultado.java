package piloto;

/**
 * Objeto que almacena el resultado de una carrera.
 * 
 * @author Pablo Rodriguez Mancha
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21
 */
public class Resultado
{
    private String nombre;
    private double minutos;
    private int puntos;

    /**
     * Constructor de Resultado
     * 
     * @param nombre Nombre del circuito en el que se ha competido.
     * @param minutos Minutos en los que se ha completado la carrera.
     * @param puntos Puntuación obtenida en la carrera
     */
    public Resultado(String nombre, double minutos, int puntos){
        this.minutos = minutos;
        this.nombre = nombre;
    }

    /**
     * Devuelve los minutos en los que se ha completado la carrera
     * 
     * @return minutos en los que el piloto completo el circuito.
     */
    public double getMinutos(){
        return this.minutos;
    }

    /**
     * Asigna los minutos que se ha tardado en completar la carrera.
     * 
     * @param minutos Minutos empleados en completar la carrera.
     */
    public void setMinutos(double minutos){
        this.minutos = minutos;
    }

    /**
     * Devuelve el nombre de la carrera.
     * 
     * @return Nombre de la carrera.
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Asigna un nombre a la carrera.
     * 
     * @param nombre Nombre de la carrera.
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * Devuelve los puntos obtenidos en la carrera.
     * 
     * @return Puntuación obtenida en la carrera.
     */
    public int getPuntos(){
        return this.puntos;
    }

    /**
     * Asigna una puntuación a la carrera.
     * 
     * @param puntos Puntuación de la carrera.
     */
    public void setPuntos(int puntos){
        this.puntos = puntos;
    }

}
