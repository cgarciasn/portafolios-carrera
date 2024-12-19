

/**
 * Clase que inicializa la simulación con datos con los que 
* el campeonato termina de forma normal
 * 
 * @author profesores DP 
 * @version 20/21
 */

public class DatosCampeonatoCompleto{
	DatosCampeonatoCompleto() {
		System.out.println("*********************************************************************************************************");
		System.out.println("*****************ESTA SIMULACIÓN CONCLUYE NORMALMENTE COMPLETÁNDOSE TODAS LAS CARRERAS*******************");
		System.out.println("*********************************************************************************************************\n");

		initData();
	}
     private void initData()
    {
		Organizacion organizacion = Organizacion.getInstance();
		organizacion.setLimiteAbandonos(3);
		organizacion.setLimitePilotos(2);
		//organizador debe ser una instancia única con la siguiente configuración:
		//LimiteAbandonos=3, LimitePilotos=2, 
		// Circuitos ordenados de forma descendente de acuerdo a su distancia
		organizacion.setOrganizacionCircuitos(new ComparateDistanciaDesc());

		//creamos y añadimos los circuitos del campeonato:

		//Crear circuito portugal con nombre:”Portugal" - complejidad:MEDIA - distancia:INTERMEDIA);
		//además, acciones necesarias para que portugal sea un circuito con:
		//Gravilla y Nocturno
		Circuito portugal = new Nocturno(new Gravilla(new Circuito("Portugal",Complejidad.MEDIA,Distancia.INTERMEDIA)));
		//añadir circuito portugal a circuitos de la organización
		organizacion.addCircuito(portugal);

		//Crear circuito cerdena con nombre:”Cerdeña" - complejidad:ALTA - distancia:CORTA);
		//además, acciones necesarias para que cerdena sea un circuito con:
		//Gravilla y Mojado
		Circuito cerdena = new Mojado(new Gravilla(new Circuito("Cerdeña",Complejidad.ALTA,Distancia.CORTA)));
		//añadir circuito cerdena a circuitos de la organización
		organizacion.addCircuito(cerdena);
			
		//Crear circuito australia con nombre:”Australia" - complejidad:BAJA - distancia:LARGA);
		//además, acciones necesarias para que australia sea un circuito con:
		//Gravilla
		Circuito australia = new Gravilla(new Circuito("Australia",Complejidad.BAJA,Distancia.LARGA));
		//añadir circuito australia a circuitos de la organización
		organizacion.addCircuito(australia);

		//Crear circuito corcega con nombre:”Córcega" - complejidad:MEDIA - distancia:INTERMEDIA);
		//además, acciones necesarias para que corcega sea un circuito con:
		//Nocturno y Gravilla
		Circuito corcega = new Gravilla(new Nocturno(new Circuito("Córcega",Complejidad.MEDIA,Distancia.INTERMEDIA)));
		//añadir circuito corcega a circuitos de la organización
		organizacion.addCircuito(corcega);

		//Crear circuito finlandia con nombre:”Finlandia" - complejidad:ALTA - distancia:CORTA);
		//además, acciones necesarias para que finlandia sea un circuito con:
		//Nocturno, Frío y Mojado
		Circuito finlandia = new Mojado(new Frio(new Nocturno(new Circuito("Finlandia",Complejidad.ALTA,Distancia.CORTA))));
		//añadir circuito finlandia a circuitos de la organización
		organizacion.addCircuito(finlandia);
		
		//Crear circuito alemania con nombre:”Alemania" - complejidad:MEDIA - distancia:INTERMEDIA);
		//además, acciones necesarias para que alemania sea un circuito con:
		//Mojado
		Circuito alemania = new Mojado(new Circuito("Alemania",Complejidad.MEDIA,Distancia.INTERMEDIA));
		//añadir circuito alemania a circuitos de la organización
		organizacion.addCircuito(alemania);

		//Crear circuito chile con nombre:”Chile" - complejidad:ALTA - distancia:CORTA);
		//además, acciones necesarias para que chile sea un circuito con:
		//Gravilla
		Circuito chile = new Gravilla(new Circuito("Chile",Complejidad.ALTA,Distancia.CORTA));
		//añadir circuito chile a circuitos de la organización
		organizacion.addCircuito(chile);
		organizacion.ordenarCircuitos();

		//creamos e inscribimos a las escuderías que participarán en el campeonato:    
		//Crear escuderia peugeot con nombre:"Peugeot"
		Escuderia peugeot = new Escuderia("Peugeot");
		//ordenaciónPilotos: ASCENDENTE por Puntos del Piloto, en caso de empate por Destreza, en caso de empate por nombre
		peugeot.SetEstrategiaPilotos(new EstrategiaPilotosAsc());
		//ordenaciónCoches: ASCENDENTE por Combustible restante del Coche , en caso de empate por nombre);
		peugeot.SetEstrategiaCoches(new EstrategiaCochesAsc());
		//peugeot se inscribe en campeonato
		peugeot.InscribirseEnOrganizacion();

		//escudería citroen 
		//Crear escuderia citroen con nombre:"Citroen"
		Escuderia citroen = new Escuderia("Citroen");
		//ordenaciónPilotos: DESCENDENTE por Puntos del Piloto, en caso de empate por Destreza, en caso de empate por nombre
		citroen.SetEstrategiaPilotos(new EstrategiaPilotosDesc());
		//ordenaciónCoches: DESCENDENTE por Combustible restante del Coche , en caso de empate por nombre);
		citroen.SetEstrategiaCoches(new EstrategiaCochesDesc());
		//citroen se inscribe en campeonato
		citroen.InscribirseEnOrganizacion();

		//escudería seat       
		//Crear escuderia seat con nombre:"Seat"
		Escuderia seat = new Escuderia("Seat");
		//ordenaciónPilotos: ASCENDENTE por Puntos del Piloto, en caso de empate por Destreza, en caso de empate por nombre
		seat.SetEstrategiaPilotos(new EstrategiaPilotosAsc());
		//ordenaciónCoches: ASCENDENTE por Combustible restante del Coche , en caso de empate por nombre);
		seat.SetEstrategiaCoches(new EstrategiaCochesAsc());
		//seat se inscribe en campeonato
		seat.InscribirseEnOrganizacion();

		//creamos los pilotos y los coches de cada escudería 
		//coches y pilotos de citroen
		//añadir a citroen un CocheResistente(nombre:"Citröen C5" - velocidad:RAPIDA - combustible:ELEFANTE);
		citroen.addCoche(new CocheResistente("Citröen C5", Velocidad.RAPIDA, Combustible.ELEFANTE));
		//añadir a citroen un CocheRapido(nombre:"Citröen C4" - velocidad:RAPIDA - combustible:ESCASO);
		citroen.addCoche(new CocheRapido("Citröen C4",Velocidad.RAPIDA,Combustible.ESCASO));
		//añadir a citroen un Coche(nombre:"Citröen C3" - velocidad:RAPIDA - combustible:ESCASO);
		citroen.addCoche(new CocheDefault("Citröen C3",Velocidad.RAPIDA,Combustible.ESCASO));
		//añadir a citroen un PilotoExperimentado(nombre:"Loeb" - concentración: NORMAL));
		citroen.addPiloto(new PilotoExperimentado("Loeb", Concentracion.NORMAL,citroen));
		//añadir a citroen un PilotoEstrella(nombre:"Makinen" - concentración: ZEN));
		citroen.addPiloto(new PilotoEstrella("Makinen",Concentracion.ZEN,citroen));
		//añadir a citroen un PilotoNovato(nombre:"Auriol" - concentración: NORMAL));
		citroen.addPiloto(new PilotoNovato("Auriol",Concentracion.NORMAL,citroen));
		citroen.OrdenarPilotos();
		citroen.OrdenarCoches();
			
		//coches y pilotos de seat
		//añadir a seat un CocheResistente(nombre:"Seat Tarraco" - velocidad:TORTUGA - combustible:GENEROSO);
		seat.addCoche(new CocheResistente("Seat Tarraco",Velocidad.TORTUGA,Combustible.GENEROSO));
		//añadir a seat un CocheRapido(nombre:"Seat Ateca" - velocidad:GUEPARDO - combustible:GENEROSO);
		seat.addCoche(new CocheRapido("Seat Ateca",Velocidad.GUEPARDO,Combustible.GENEROSO));
		//añadir a seat un Coche(nombre:"Seat Arona" - velocidad:RAPIDA - combustible:ESCASO);
		seat.addCoche(new CocheDefault("Seat Arona",Velocidad.RAPIDA,Combustible.ESCASO));
		//añadir a seat un PilotoExperimentado(nombre:"Ogier" - concentración: NORMAL));
		seat.addPiloto(new PilotoExperimentado("Ogier",Concentracion.NORMAL,seat));
		//añadir a seat un PilotoEstrella(nombre:"McRae" - concentración: CONCENTRADO));
		seat.addPiloto(new PilotoEstrella("McRae",Concentracion.CONCENTRADO,seat));
		//añadir a seat un PilotoNovato(nombre:"Blomquist" - concentración: DESPISTADO));
		seat.addPiloto(new PilotoNovato("Blomquist",Concentracion.DESPISTADO,seat));
		seat.OrdenarPilotos();
		seat.OrdenarCoches();
		 
		//coches y pilotos de peugeot
		//añadir a peugeot un CocheResistente(nombre:"Peugeot 5008" - velocidad:LENTA - combustible:GENEROSO);
		peugeot.addCoche(new CocheResistente("Peugeot 5008",Velocidad.LENTA,Combustible.GENEROSO));
		//añadir a peugeot un CocheRapido(nombre:"Peugeot 3008" - velocidad:GUEPARDO - combustible:NORMAL);
		peugeot.addCoche(new CocheRapido("Peugeot 3008",Velocidad.GUEPARDO,Combustible.NORMAL));
		//añadir a peugeot un Coche(nombre:"Peugeot 2008" - velocidad:NORMAL - combustible:ESCASO);
		peugeot.addCoche(new CocheDefault("Peugeot 2008",Velocidad.NORMAL,Combustible.ESCASO));
		//añadir a peugeot un PilotoExperimentado(nombre:"Kankunnen" - concentración: CONCENTRADO));
		peugeot.addPiloto(new PilotoExperimentado("Kankunnen",Concentracion.CONCENTRADO,peugeot));
		//añadir a peugeot un PilotoEstrella(nombre:"Sainz" - concentración: ZEN ));
		peugeot.addPiloto(new PilotoEstrella("Sainz",Concentracion.ZEN,peugeot));
		//añadir a peugeot un PilotoNovato(nombre:"Sordo" - concentración: DESPISTADO));
		peugeot.addPiloto(new PilotoNovato("Sordo",Concentracion.DESPISTADO,peugeot));
		peugeot.OrdenarPilotos();
		peugeot.OrdenarCoches();
    }

}
