package piloto;

/**
 * Write a description of class Piloto here.
 * 
 * @author Pablo Rodriguez Mancha
 * @version (a version number or a date)
 */

public abstract class Piloto
{
    private String nombre;
    private double destreza;
    private Concentracion concentracionPiloto;
    //private Coche cochePiloto;
   

    public Piloto(String nombre, double destreza, Concentracion concentracionPiloto)
    {
    this.nombre = nombre;
    this.concentracionPiloto = concentracionPiloto;
    //this.CochePiloto = CochePiloto;
    this.destreza = destreza;
    }
    /*
     * Devuelve el nombre del piloto.
     */
    public String getNombre(){
        return this.nombre;
    }
    /*
     * Asigna un nombre al piloto.
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    /*
     * Devuelve la destreza de un piloto.
     */
    public double getDestreza(){
        return this.destreza;
    }
    /*
     * Asigna una destreza a un piloto.
     */
    public void setDestreza(double destreza){
        this.destreza = destreza;
    }
    /*
     * Devuelve la concentracion del piloto.
     */
    public Concentracion getConcentracion(){
        return this.concentracionPiloto;
    }
    /*
     * Asigna una concentracion al piloto.
     */
    public void setConcentracion(Concentracion concentracionPiloto){
        this.concentracionPiloto = concentracionPiloto;
    }


}