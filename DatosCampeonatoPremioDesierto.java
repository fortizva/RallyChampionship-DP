import circuito.Circuito;
import circuito.CircuitoNocturno;
import circuito.CircuitoMojado;
import circuito.CircuitoFrio;
import circuito.CircuitoGravilla;
import circuito.Complejidad;
import circuito.Distancia;
import circuito.comparador.*;

import piloto.Concentracion;
import piloto.Piloto;
import piloto.PilotoNovato;
import piloto.PilotoExperimentado;
import piloto.PilotoEstrella;
import piloto.comparador.*;

import coche.Coche;
import coche.CocheNormal;
import coche.CocheRapido;
import coche.CocheResistente;
import coche.Velocidad;
import coche.Combustible;
import coche.comparador.*;

/**
 * Clase que inicializa la simulación con datos con los que 
 * el campeonato termina antes por tener un solo piloto sin descalificar
 * 
 * @author Pablo Rodriguez Mancha.
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21.
 */

public class DatosCampeonatoPremioDesierto
{
    public DatosCampeonatoPremioDesierto(){
	System.out.println("*********************************************************************************************************");
	System.out.println("****ESTA SIMULACIÓN CONCLUYE ANTES DE FINALIZAR EL CAMPEONATO CON TODOS LOS PILOTOS DESCALIFICADOS****");        
	System.out.println("*********************************************************************************************************\n");
        
        initData();
    }

    private void initData() {
        // Añadimos comparador invertido de nombre descendente para igualar la salida de ejemplo.
        Organizacion.inicializar(1, 3, (new ComparadorAnidadoCircuito(true, new ComparadorDistanciaActualCircuito(), new ComparadorNombreCircuito())));
        Organizacion organizacion = Organizacion.getInstance();

        Circuito circPortugal = new CircuitoNocturno(new CircuitoGravilla(new Circuito("Portugal", Complejidad.MEDIA, Distancia.INTERMEDIA)));
        Circuito circCerdena = new CircuitoMojado(new CircuitoGravilla(new Circuito("Cerdeña", Complejidad.ALTA, Distancia.CORTA)));
        Circuito circAustralia = new CircuitoGravilla(new Circuito("Australia", Complejidad.BAJA, Distancia.LARGA));
        Circuito circCorcega = new CircuitoNocturno(new CircuitoGravilla(new Circuito("Córcega", Complejidad.MEDIA, Distancia.INTERMEDIA)));
        Circuito circFinlandia = new CircuitoMojado(new CircuitoFrio(new CircuitoNocturno(new Circuito("Finlandia", Complejidad.ALTA, Distancia.CORTA))));
        Circuito circAlemania = new CircuitoMojado(new Circuito("Alemania", Complejidad.MEDIA, Distancia.INTERMEDIA));
        Circuito circChile = new CircuitoGravilla(new Circuito("Chile", Complejidad.ALTA, Distancia.CORTA));

        organizacion.addCircuitos(circPortugal, circCerdena, circAustralia, circCorcega, circFinlandia, circAlemania, circChile);
        
        Escuderia escPeugeot = new Escuderia("PEUGEOT", new ComparadorAnidadoPiloto(true, new ComparadorPuntosPiloto(), new ComparadorDestrezaPiloto(), new ComparadorNombrePiloto()), new ComparadorAnidadoCoche(new ComparadorCombustibleActualCoche(), new ComparadorNombreCoche()));
        escPeugeot.inscribirse();
        Escuderia escCitroen =new Escuderia("CITRÖEN", new ComparadorAnidadoPiloto(new ComparadorPuntosPiloto(), new ComparadorDestrezaPiloto(), new ComparadorNombrePiloto()), new ComparadorAnidadoCoche(new ComparadorCombustibleActualCoche(), new ComparadorNombreCoche()));
        escCitroen.inscribirse();
        Escuderia escSeat =new Escuderia("SEAT", new ComparadorAnidadoPiloto(true, new ComparadorPuntosPiloto(), new ComparadorDestrezaPiloto(), new ComparadorNombrePiloto()), new ComparadorAnidadoCoche(new ComparadorCombustibleActualCoche(), new ComparadorNombreCoche()));
        escSeat.inscribirse();
        
        escCitroen.addCoche(new CocheResistente("Citröen C5", Velocidad.RAPIDA, Combustible.ELEFANTE));
        escCitroen.addCoche(new CocheRapido("Citröen C4", Velocidad.RAPIDA, Combustible.ESCASO));
        escCitroen.addCoche(new CocheNormal("Citröen C3", Velocidad.RAPIDA, Combustible.ESCASO));

        escCitroen.addPiloto(new PilotoExperimentado("Loeb", Concentracion.NORMAL));
        escCitroen.addPiloto(new PilotoEstrella("Makinen", Concentracion.ZEN));
        escCitroen.addPiloto(new PilotoNovato("Auriol", Concentracion.NORMAL));

        escSeat.addCoche(new CocheResistente("Seat Tarraco", Velocidad.TORTUGA, Combustible.GENEROSO));
        escSeat.addCoche(new CocheRapido("Seat Ateca",Velocidad.GUEPARDO, Combustible.GENEROSO));
        escSeat.addCoche(new CocheNormal("Seat Arona",Velocidad.RAPIDA, Combustible.ESCASO));

        escSeat.addPiloto(new PilotoExperimentado("Ogier",Concentracion.NORMAL));
        escSeat.addPiloto(new PilotoEstrella("McRae",Concentracion.CONCENTRADO));
        escSeat.addPiloto(new PilotoNovato("Blomquist",Concentracion.DESPISTADO));

        escPeugeot.addCoche(new CocheResistente("Peugeot 5008", Velocidad.LENTA, Combustible.GENEROSO));
        escPeugeot.addCoche(new CocheRapido("Peugeot 3008",Velocidad.GUEPARDO, Combustible.NORMAL));
        escPeugeot.addCoche(new CocheNormal("Peugeot 2008",Velocidad.NORMAL, Combustible.ESCASO));

        escPeugeot.addPiloto(new PilotoExperimentado("Kankunnen", Concentracion.CONCENTRADO));
        escPeugeot.addPiloto(new PilotoEstrella("Sainz",Concentracion.ZEN));
        escPeugeot.addPiloto(new PilotoNovato("Sordo",Concentracion.DESPISTADO));

    }

}
