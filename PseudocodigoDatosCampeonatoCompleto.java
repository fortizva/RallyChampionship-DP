import circuito.Circuito;
import circuito.CircuitoNocturno;
import circuito.CircuitoMojado;
import circuito.CircuitoFrio;
import circuito.CircuitoGravilla;
import circuito.Complejidad;
import circuito.Distancia;
import piloto.Concentracion;

import piloto.Piloto;
import piloto.PilotoNovato;
import piloto.PilotoExperimentado;
import piloto.PilotoEstrella;

import coche.Coche;
import coche.CocheNormal;
import coche.CocheRapido;
import coche.CocheResistente;
import coche.Velocidad;
import coche.Combustible;

/**
 * Write a description of class InitData1 here.
 * 
 * @author Pablo Rodriguez Mancha.
 * @version 20/21.
 */

public class PseudocodigoDatosCampeonatoCompleto
{
     public static void main(String[] args){
         Organizacion.inicializar(2, 2);
         Organizacion.getInstance();
         
        Circuito circPortugal = new CircuitoNocturno(new CircuitoGravilla(new Circuito("Portugal", Complejidad.MEDIA, Distancia.INTERMEDIA)));
        Circuito circCerdena = new CircuitoMojado(new CircuitoGravilla(new Circuito("Cerdeña", Complejidad.ALTA, Distancia.CORTA)));
        Circuito circAustralia = new CircuitoGravilla(new Circuito("Australia", Complejidad.BAJA, Distancia.LARGA));
        Circuito circCorcega = new CircuitoNocturno(new CircuitoGravilla(new Circuito("Córcega", Complejidad.MEDIA, Distancia.INTERMEDIA)));
        Circuito circFinlandia = new CircuitoMojado(new CircuitoFrio(new CircuitoNocturno(new Circuito("Finlandia", Complejidad.ALTA, Distancia.CORTA))));
        Circuito circAlemania = new CircuitoMojado(new Circuito("Alemania", Complejidad.MEDIA, Distancia.INTERMEDIA));
        Circuito circChile = new CircuitoGravilla(new Circuito("Chile", Complejidad.ALTA, Distancia.CORTA));
         
        System.out.println(circPortugal.toString()); 
        System.out.println(circCerdena.toString());
        System.out.println(circAustralia.toString());
        System.out.println(circCorcega.toString());
        System.out.println(circFinlandia.toString());
        System.out.println(circAlemania.toString());
        System.out.println(circChile.toString());
        
        Escuderia escPeugeot = new Escuderia("Peugeot");
        Escuderia escCitroen =new Escuderia("Citröen");
        Escuderia escSeat =new Escuderia("Seat");
        
        escCitroen.addCoche(new CocheResistente("Citröen C5", Velocidad.RAPIDA, Combustible.ELEFANTE));
        escCitroen.addCoche(new CocheResistente("Citröen C4", Velocidad.RAPIDA, Combustible.ESCASO));
        escCitroen.addCoche(new CocheResistente("Citröen C3", Velocidad.RAPIDA, Combustible.ESCASO));
        
        escCitroen.addPiloto(new PilotoExperimentado("Loeb", Concentracion.NORMAL));
        escCitroen.addPiloto(new PilotoEstrella("Makinen", Concentracion.ZEN));
        escCitroen.addPiloto(new PilotoNovato("Auriol", Concentracion.NORMAL));
        
        escSeat.addCoche(new CocheResistente("Seat Tarraco", Velocidad.TORTUGA, Combustible.GENEROSO));
        escSeat.addCoche(new CocheRapido("Seat Ateca",Velocidad.GUEPARDO, Combustible.GENEROSO));
        escSeat.addCoche(new CocheNormal("Seat Arona",Velocidad.RAPIDA, Combustible.ESCASO));
        
        escSeat.addPiloto(new PilotoExperimentado("Ogier",Concentracion.NORMAL));
        escSeat.addPiloto(new PilotoExperimentado("McRae",Concentracion.CONCENTRADO));
        escSeat.addPiloto(new PilotoExperimentado("Blomquist",Concentracion.DESPISTADO));
        
        escPeugeot.addCoche(new CocheResistente("Peugeot 5008", Velocidad.LENTA, Combustible.GENEROSO));
        escPeugeot.addCoche(new CocheResistente("Peugeot 3008",Velocidad.GUEPARDO, Combustible.NORMAL));
        escPeugeot.addCoche(new CocheResistente("Peugeot 2008",Velocidad.NORMAL, Combustible.ESCASO));
        
        escPeugeot.addPiloto(new PilotoExperimentado("Kankunnen", Concentracion.CONCENTRADO));
        escPeugeot.addPiloto(new PilotoEstrella("Sainz",Concentracion.ZEN));
        escPeugeot.addPiloto(new PilotoNovato("Sordo",Concentracion.DESPISTADO));
        
     }
    
}