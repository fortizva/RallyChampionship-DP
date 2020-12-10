import circuito.*;

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
    }
}
