package piloto;


/**
 * Write a description of class Resultados here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Resultados
{
    private String nombre;
    private int minutos;
    private int puntos;
    
    /**
     * Constructor for objects of class Resultados
     */
    public Resultados(int minutos, String nombre){
        this.minutos = minutos;
        this.nombre = nombre;
    }
    /**
     * Devuelve los minutos en los que se ha completado la carrera
     * 
     * @return minutos en los que el piloto completo el circuito.
     */
    public int getMinutosCarrera(){
        return this.minutos;
    }
    /**
     * Asigna los minutos que se ha tardado en completar una carrera.
     * 
     * @param minutosCarrera minutos empleados en completar la carrera.
     */
    public void setMinutosCarrera(int minutos){
        this.minutos = minutos;
    }
    /**
     * Devuelve el nombre de la carrera.
     * 
     * @return nombreCarrera el nombre de la carrera.
     */
    public String getNombreCarrera(){
        return this.nombre;
    }
    /**
     * Asigna un nombre a una carrera.
     * 
     * @param nombreCarrera el nombre de la carrera.
     */
    public void setNombreCarrera(String nombre){
        this.nombre = nombre;
    }
    /**
     * Devuelve los puntos obtenidos en una carrera.
     * 
     * @return puntos obtenidos en la carrera.
     */
    public int getPuntos(){
        return this.puntos;
    }
    /**
     * Asigna una puntuacion a una carrera.
     * 
     * @param puntos de la carrera.
     */
    public void setPuntos(int puntos){
        this.puntos = puntos;
    }

}
