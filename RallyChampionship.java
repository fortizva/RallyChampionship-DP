import circuito.Circuito;
import circuito.CircuitoNocturno;
import circuito.CircuitoMojado;
import circuito.CircuitoFrio;
import circuito.CircuitoGravilla;
import circuito.Complejidad;
import circuito.Distancia;

import coche.Coche;
import coche.CocheNormal;
import coche.CocheRapido;
import coche.CocheResistente;
import coche.Velocidad;
import coche.Combustible;

/**
 * Clase principal temporal de RallyChampionship hasta implementar RallyDemo y demás pseudocódigos
 * 
 * (Eliminar en la versión definitiva)
 */
public class RallyChampionship
{
    public static void main(String[] args){
        System.out.println("Hello World!");
        Circuito circAustralia = new CircuitoGravilla(new Circuito("Australia", Complejidad.BAJA, Distancia.LARGA));
        Circuito circChile = new CircuitoGravilla(new Circuito("Chile", Complejidad.ALTA, Distancia.CORTA));
        Circuito circAlemania = new CircuitoMojado(new Circuito("Alemania", Complejidad.MEDIA, Distancia.INTERMEDIA));
        Circuito circPortugal = new CircuitoNocturno(new CircuitoGravilla(new Circuito("Portugal", Complejidad.MEDIA, Distancia.INTERMEDIA)));
        Circuito circCorcega = new CircuitoNocturno(new CircuitoGravilla(new Circuito("Córcega", Complejidad.MEDIA, Distancia.INTERMEDIA)));
        Circuito circCerdena = new CircuitoMojado(new CircuitoGravilla(new Circuito("Cerdeña", Complejidad.ALTA, Distancia.CORTA)));
        Circuito circFinlandia = new CircuitoMojado(new CircuitoFrio(new CircuitoNocturno(new Circuito("Finlandia", Complejidad.ALTA, Distancia.CORTA))));
        System.out.println(circAustralia.toString());
        System.out.println(circChile.toString());
        System.out.println(circAlemania.toString());
        System.out.println(circPortugal.toString());
        System.out.println(circCorcega.toString());
        System.out.println(circCerdena.toString());
        System.out.println(circFinlandia.toString());

        // Introduzco manualmente las destrezas para probar el código hasta que Piloto sea implementado.
        Coche citroenC3 = new CocheNormal("Citröen C3", Velocidad.RAPIDA, Combustible.ESCASO);
        double destrezaAuriol = 0.78;
        System.out.println(citroenC3.toString());
        citroenC3.consumirCombustible(destrezaAuriol, circAustralia);

        Coche seatAteca = new CocheRapido("Seat Ateca", Velocidad.GUEPARDO, Combustible.GENEROSO);
        double destrezaOgier = 0.82;
        System.out.println(seatAteca.toString());
        seatAteca.consumirCombustible(destrezaOgier, circAustralia);
        
        Coche seatTarraco = new CocheResistente("Seat Tarraco", Velocidad.TORTUGA, Combustible.GENEROSO);
        double destrezaMcRae = 0.93;
        System.out.println(seatTarraco.toString());
        seatTarraco.consumirCombustible(destrezaMcRae, circAustralia);
        
    }

    /**
     * Método para mostrar por pantalla el final de la carrera para un piloto
     * 
     * @param coche Coche a mostrar
     * @param destreza Destreza del piloto
     * @param circuito Circuito en el que correrá
     */
    // Tras implementar Piloto este método usará únicamente los parámetros de tipo Piloto y Circuito
    private static void printMetaPiloto (Coche coche, double destreza, Circuito circuito){
        System.out.println(coche.toString());
        System.out.println("+++ En estas condiciones es capaz de correr a " + coche.getVelocidadReal(destreza, circuito) + " km/hora +++");
        System.out.println("+++ <piloto> termina la carrera en " + coche.getTiempo(destreza, circuito) + " minutos +++");
        System.out.println("+++ El combustible del " + coche.getNombre() + " tras la carrera es " + coche.getCombustibleActual());
    }
}
