/**
 * Clase principal de RallyChampionship.
 * Permite ejecutar las distintas simulaciones.
 * 
 * @author Francisco Javier Ortiz Valverde
 * @version 20/21
 */
public class RallyChampionship
{
   public static void main(String[] args) {
		//Descomentar el conjunto de datos de los 3 siguientes que se quiera probar
		//Descomentar el siguiente conjunto de datos si se quiere probar simulación del campeonato que termina de forma normal disputándose todas las carreras
	DatosCampeonatoCompleto initdata = new DatosCampeonatoCompleto();
		//Descomentar el siguiente conjunto de datos si se quiere probar simulación del campeonato que termina antes de que se realicen todas las carreras con el único piloto superviviente y su escudería declarados como campeones
	//DatosCampeonatoFinPrematuro initdata = new DatosCampeonatoFinPrematuro();
		//Descomentar el siguiente conjunto de datos si se quiere probar simulación del campeonato que termina antes de que se realicen todas las carreras sin ningún piloto superviviente y declarándose el campeonato como desierto
	//DatosCampeonatoPremioDesierto initdata = new DatosCampeonatoPremioDesierto();        

        //llamada al método de Organización que gestiona el desarrollo del campeonato
	Organizacion.getInstance().competir();
    }   
}