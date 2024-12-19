 

import java.util.*;

public class Organizacion {
    //Singleton
    private static Organizacion org = null;
    private int LimiteAbandonos;
    private int LimitePilotos;
    private TreeSet<Escuderia> Escuderias = new TreeSet<>(new Comparator<Escuderia>() {
        /**
         * Este método se encarga de comparar dos escuderias por la puntiación de sus pilotos, en caso de que sea igual,se compara
         * por el total de carreras terminadas y en caso de que también sea igual se comparará por los nombres alfabeticamente
         *
         * @param o1, primera escuderia {@code escuderia} a comparar
         * @param o2, segunda escuderia {@code escuderia} a comparar
         * @return el valor {@code 0} si {@code o1 == o2}
         *         el valor mayor a {@code 0} si {@code o1>o2}
         *         el valor menor a {@code 0} si {@code o1<o2}
         */
        @Override
        public int compare(Escuderia o1,Escuderia o2) {
            if(o1.GetPuntuacionPilotos().equals(o2.GetPuntuacionPilotos())){
                if(o1.getTotalCarrerasTerminadas().equals(o2.getTotalCarrerasTerminadas())){
                    return o1.GetNombre().compareTo(o2.GetNombre())*-1;
                }else{
                    return o1.getTotalCarrerasTerminadas().compareTo(o2.getTotalCarrerasTerminadas())*-1;
                }
            }else{
                return o1.GetPuntuacionPilotos().compareTo(o2.GetPuntuacionPilotos())*-1;
            }
        }
    });
    private LinkedList<Piloto> pilotosCarrera = new LinkedList<>(); //Cada carrera se llena de nuevo
    private LinkedList<Circuito> circuitos = new LinkedList<>();//Todos los circuitos que se van a usar
    private ComparateOfCircuitos ordenacionCircuitos;
    private Integer carrerasRealizadas = 1;

    /**
     * Método estático para obtener la instancia Singleton de Organización
     * 
     * @return organización
     */
    public static Organizacion getInstance(){
        if(org == null){
            return org = new Organizacion();
        }
        return org;
    }

    /**
     * Método que se encarga de comprobar si hay pilotos disponibles en cada escuderia
     *
     * @return false en caso de que no haya ningún piloto disponible y true en caso de que si haya algún piloto disponible
     */
    public Boolean PilotosDisponibles(){
        int comprobar=0;
        for (Escuderia escuderia:Escuderias){
            comprobar+=escuderia.PilotosCompetir();
        }
        return comprobar>1;
    }

    /**
     * Este método se encarga de establecer el comparador de circuito pasado por parámetros en el atributo ordenacionCircuitos
     *
     * @param organizacionCircuitos, es el comparate de circuitos que se quiere utilizar
     */
    public void setOrganizacionCircuitos(ComparateOfCircuitos organizacionCircuitos){
        this.ordenacionCircuitos = organizacionCircuitos;
    }

    /**
     * Este método se encarga de ordenadar los circuitos utilizando el collections.sort y el tipo de ordenación que es
     * el del propio atributo
     */
    public void ordenarCircuitos(){
        Collections.sort(this.circuitos,ordenacionCircuitos);
    }

    /**
     * Este método es un mostrar de los circuitos ya ordenados
     *
     * @return devuelve el string con la cabecera de los circuitos de campeonato y los circuitos ordenados
     */
    public String mostrarCircuitosOrdenados(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
        stringBuilder.append("||||||||||||||||||| CIRCUITOS DEL CAMPEONATO |||||||||||||||||||\n");
        stringBuilder.append("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
        for (Circuito circuito:circuitos) {
            stringBuilder.append(circuito.toString()+"\n");
        }
        stringBuilder.append("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
        return stringBuilder.toString();
    }

    /**
     * Este método se encarga de mostrar las escuderias
     *
     * @return devuelve el string con la cabecera de las escuderias del campeonato y las escuderias
     */
    public String mostrarEscuderias(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
        stringBuilder.append("%%%%%%%% ESCUDER�?AS DEL CAMPEONATO %%%%%%%%\n");
        stringBuilder.append("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
        for (Escuderia escuderia:Escuderias) {
            stringBuilder.append(escuderia.toString()+"\n");
        }
        return stringBuilder.toString();
    }

    /**
     * Este método se encarga de poner el número de abandonos que se ha pasado por parámetros al atributo LimiteAbandonos
     *
     * @param abandonos, número de abandonos realizados
     */
    public void setLimiteAbandonos(int abandonos){
        this.LimiteAbandonos = abandonos;
    }

    /**
     * Este método se encarga de poner el número de pilotos que se ha pasado por parámetros en el atributo LimitePilotos
     *
     * @param pilotos, número de pilotos
     */
    public void setLimitePilotos(int pilotos){
        this.LimitePilotos = pilotos;
    }

    /**
     * Este método devuelve el límite de abandonos que hay
     *
     * @return LimiteAbandonos
     */
    public int getLimiteAbandonos(){
        return this.LimiteAbandonos;
    }

    /**
     * Este método devuelve el límite de pilotos que hay
     *
     * @return LimitePilotos
     */
    public int getLimitePilotos(){
        return this.LimitePilotos;
    }

    /**
     * Este método se encarga de inscribir la escuderia pasada por parámetros en la organización, añandiéndola al TreeSet de Escuderías
     *
     * @param escuderia, escuderia que se va a inscribir en la competición
     */
    public void Inscripcion(Escuderia escuderia){
        this.Escuderias.add(escuderia);
    }

    /**
     * Este método se encarga de añadir el circuito pasado por parámetros a la LinkedList de Circuitos
     *
     * @param circuito, circuito que quiere añadir
     */

    public void addCircuito(Circuito circuito){
        this.circuitos.add(circuito);
    }

    /**
     * Este método se encarga de realizar toda la ejecución de la competición
     *
     * @return devuelve el string con toda la información de la competición
     */
    public String CelebrarCompeticion(){
        StringBuilder s = new StringBuilder();
        for (Circuito circuito:circuitos) {
            s.append("\n********************************************************************************************************\n");
            s.append("*** CARRERA<"+this.carrerasRealizadas+"> EN "+circuito.toString()+" ***\n");
            if(PilotosDisponibles()) {
                s.append(CelebracionDeCarrera(circuito));
                this.carrerasRealizadas++;
            }else{
                s.append("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡\n" +
                        "¡¡¡ No se celebra esta carrera ni la(s) siguiente(s) por no haber pilotos para competir !!!!\n" +
                        "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
                break;
            }
        }
        s.append("****************************************************\n" +
                "**************** FIN DEL CAMPEONATO ****************\n" +
                "****************************************************\n" +
                "********** CLASIFICACIÓN FINAL DE PILOTOS **********\n" +
                "****************************************************\n");

        LinkedList<Piloto> fin = new LinkedList<>();
        int contador=0;
        for (Escuderia escuderia: Escuderias) {
            for(int i=0;i<escuderia.NumeroPilotos();i++){
                if(escuderia.DevolverPiloto(i).getDescalificado()==false){
                    contador++;
                }
                fin.add(escuderia.DevolverPiloto(i));
            }
        }
        fin.sort(new ComparateFinCarreraPilotos().reversed());
        if(contador==0){
            s.append("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡\n" +
                    "¡¡¡ Campeonato de pilotos queda desierto por haber sido descalificados todos los pilotos !!!\n" +
                    "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
        }else {
            int posicion = 1;
            for (Piloto piloto : fin) {
                if (piloto.getDescalificado() == false) {
                    s.append("@@@ Posición(" + posicion + "): " + piloto.getNombre() + " - Puntos Totales: " +String.format("%.0f",piloto.totalPuntos()) + " @@@\n");
                    posicion++;
                    for (Circuito circuito : circuitos) {
                        s.append(piloto.podio(circuito));
                    }
                    s.append("\n");
                }
            }

        }
        s.append("****************************************************\n" +
                "************** PILOTOS DESCALIFICADOS **************\n" +
                "****************************************************\n");
        for (Piloto piloto : fin) {
            if (piloto.getDescalificado() == true) {
                s.append("--- Piloto Descalificado: "+piloto.getNombre()+" - Puntos Totales Anulados: "+String.format("%.0f",piloto.totalPuntos())+" ---\n");
                for (Circuito circuito : circuitos) {
                    s.append(piloto.podio(circuito));
                }
                s.append("\n");
            }
        }

        s.append("****************************************************\n" +
                "******** CLASIFICACIÓN FINAL DE ESCUDER�?AS *********\n" +
                "****************************************************\n");
        int i =1;
        Boolean todosDescalificados = false;
        for (Escuderia escuderia:Escuderias) {
                if(escuderia.GetPuntuacionPilotosNoDescalificados()>0) {
                    s.append("@@@ Posición(" + i + ") " + escuderia.GetNombre() + " con " + escuderia.GetPuntuacionPilotosNoDescalificados() + " puntos @@@\n");
                    s.append("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
                    s.append("%%% "+escuderia.GetNombre().toUpperCase(Locale.ROOT)+" %%%\n");
                    s.append(escuderia.MostrarSituacionFinal()+"\n");
                    s.append("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
                    i++;
                    todosDescalificados = true;
                }
        }

        if (!todosDescalificados){
            s.append("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡\n" +
                    "¡¡¡ Campeonato de escuderías queda desierto por haber sido descalificados todos los pilotos !!!\n" +
                    "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
        }

        s.append("****************************************************\n" +
                "************ ESCUDERIAS DESCALIFICADAS *************\n" +
                "****************************************************\n");
        for (Escuderia escuderia:Escuderias) {
            if(escuderia.GetPuntuacionPilotosNoDescalificados()==0.0) {
                s.append("¡¡¡ Escudería Descalificada: "+escuderia.GetNombre()+" con "+escuderia.GetPuntuacionPilotosNoDescalificados()+" puntos !!!\n");
                s.append("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
                s.append("%%% "+escuderia.GetNombre().toUpperCase(Locale.ROOT)+" %%%\n");
                s.append(escuderia.MostrarSituacionFinal()+"\n");
                s.append("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
            }
        }


        return s.toString();
    }

    /**
     * Este método es el encargado de realizar toda la ejecución de la carrera de cada circuito
     *
     * @param circuitoActual, circuito donde se esta realizando la carrera
     * @return devuelve el string con toda la información de la carrera que se ha realizado
     */
    public String CelebracionDeCarrera(Circuito circuitoActual){
        Boolean noCoches = false;
        StringBuilder stringBuilder = new StringBuilder();
        //stringBuilder.append("\n********************************************************************************************************\n");
        //stringBuilder.append("*** CARRERA<"+this.carrerasRealizadas+"> EN "+circuitoActual.toString()+" ***\n");

        for (Escuderia escuderia:Escuderias) {
            if(escuderia.PilotosDisponibles()){
                for(int i = 0;i<LimitePilotos;i++){
                    Piloto pilotoaux = escuderia.DevolverPilotoDisponible();
                    if( pilotoaux == null){
                        break;
                    }else{
                        if(pilotoaux.getCoche() == null){
                            stringBuilder.append("********************************************************************************************************\n" +
                                    "¡¡¡ "+pilotoaux.getNombre()+" NO ES ENVIADO A LA CARRERA porque su escudería("+escuderia.GetNombre()+") no tiene más coches con combustible disponibles !!!\n");
                            noCoches = true;
                        }else{
                            this.pilotosCarrera.add(pilotoaux);
                        }

                    }
                }
            }
        }
        if(noCoches){
            stringBuilder.append("********************************************************************************************************\n" +
                    "******************************** Pilotos que van a competir en "+circuitoActual.getNombre()+" *******************************\n" +
                    "**********************************************************************************************************\n");

        }else{
            stringBuilder.append("********************************************************************************************************\n" +
                    "********************************************************************************************************\n" +
                    "******************************** Pilotos que van a competir en "+circuitoActual.getNombre()+" *******************************\n" +
                    "**********************************************************************************************************\n");
        }

        pilotosCarrera.sort(new ComparateParrilla());
        for (Piloto piloto:pilotosCarrera) {
            stringBuilder.append(piloto.toString()+"\n");
        }
        stringBuilder.append("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
                "+++++++++++++++++++++++++ Comienza la carrera en "+circuitoActual.getNombre()+" ++++++++++++++++++++++++++\n" +
                "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        String aux = "";
        for(int i = 0;i<pilotosCarrera.size();i++){
            int pilotoactual = i+1;
            stringBuilder.append("@@@ Piloto "+pilotoactual+" de "+pilotosCarrera.size()+"\n");
            stringBuilder.append(pilotosCarrera.get(i).toString()+" con\n");
            stringBuilder.append(pilotosCarrera.get(i).getCoche().toString()+"\n");
            stringBuilder.append("+++ Con estas condiciones es capaz de correr a "+pilotosCarrera.get(i).getVelocidadEsCapaz(circuitoActual.getComplejidadActual())+" km/hora +++\n");
            //stringBuilder.append("Destreza :"+pilotosCarrera.get(i).getDestreza()+" complejidad :"+circuitoActual.getComplejidadActual()+" distancia: "+circuitoActual.getDistanciaActual()+"\n");
            stringBuilder.append(pilotosCarrera.get(i).getCoche().salidaCocheConExtras(pilotosCarrera.get(i).getDestreza(),circuitoActual.getComplejidadActual(),circuitoActual.getDistanciaActual()));
            stringBuilder.append(pilotosCarrera.get(i).conducirCoche(circuitoActual)+"\n");
            stringBuilder.append(pilotosCarrera.get(i).GasolinaRestanteDelCoche()+"\n");
            stringBuilder.append("@@@\n");
            stringBuilder.append(pilotosCarrera.get(i).pilotoAbandona(LimiteAbandonos));
        }
        stringBuilder.append("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
                "+++++++++++++++++ Clasificación final de la carrera en "+circuitoActual.getNombre()+" ++++++++++++++++++\n" +
                "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

        //pilotosCarrera.sort(new ComparateTiempo());
        LinkedList<Piloto> auxClasificado = new LinkedList<>();
        LinkedList<Piloto> auxDesclasificado = new LinkedList<>();

        for (Piloto piloto:pilotosCarrera) {
            if(piloto.getTerminadaCarreraActual()){
                auxClasificado.add(piloto);
            }else {
                auxDesclasificado.add(piloto);
            }
        }
        auxClasificado.sort(new ComparateTiempo());
        auxDesclasificado.sort(new ComparateTiempo());
        for (Piloto piloto:auxDesclasificado) {
            auxClasificado.addLast(piloto);
        }
        this.pilotosCarrera = new LinkedList<>(auxClasificado);
        auxClasificado.clear();
        auxDesclasificado.clear();

        int premioADar = 1;
        for(int i = 0;i<pilotosCarrera.size();i++){
            if(pilotosCarrera.get(i).getTerminadaCarreraActual()){
                switch (premioADar){
                    case 1:
                        pilotosCarrera.get(i).setPuntuacion(circuitoActual.getNombre(),new Puntuacion(pilotosCarrera.get(i).getTiempoCarreraActual(),10.0));
                        break;
                    case 2:
                        pilotosCarrera.get(i).setPuntuacion(circuitoActual.getNombre(),new Puntuacion(pilotosCarrera.get(i).getTiempoCarreraActual(),8.0));
                        break;
                    case 3:
                        pilotosCarrera.get(i).setPuntuacion(circuitoActual.getNombre(),new Puntuacion(pilotosCarrera.get(i).getTiempoCarreraActual(),6.0));
                        break;
                    case 4:
                        pilotosCarrera.get(i).setPuntuacion(circuitoActual.getNombre(),new Puntuacion(pilotosCarrera.get(i).getTiempoCarreraActual(),4.0));
                        break;
                    default:
                        pilotosCarrera.get(i).setPuntuacion(circuitoActual.getNombre(),new Puntuacion(pilotosCarrera.get(i).getTiempoCarreraActual(),2.0));
                        break;
                }
                premioADar++;
            }else{
                pilotosCarrera.get(i).setPuntuacion(circuitoActual.getNombre(),new Puntuacion(pilotosCarrera.get(i).getTiempoCarreraActual(),0.0));
            }
        }

        premioADar = 1;
        for (Piloto piloto:pilotosCarrera) {
            if(piloto.getTerminadaCarreraActual()){
                stringBuilder.append("@@@ Posición("+premioADar+"): "+piloto.getNombre()+" - Tiempo: "+Math.round(piloto.getTiempoCarreraActual()*100.0)/100.0+" minutos - Puntos: "+String.format("%.0f", piloto.getPuntuacionCarrera(circuitoActual.getNombre())).toString()+" @@@\n");
                premioADar++;
            }else{
                if(piloto.getDescalificado()){
                    stringBuilder.append("¡¡¡ Ha abandonado "+piloto.getNombre()+" - Tiempo: "+Math.round(piloto.getTiempoCarreraActual()*100.0)/100.0+" - Puntos: 0 - Además ha sido descalificado para el resto del Campeonato !!!\n");
                }else{
                    stringBuilder.append("¡¡¡ Ha abandonado "+piloto.getNombre()+" - Tiempo: "+Math.round(piloto.getTiempoCarreraActual()*100.0)/100.0+" - Puntos: 0 !!!\n");
                }

            }
        }

        for (Piloto piloto:pilotosCarrera) {
            piloto.volverAEscuderia();
        }
        pilotosCarrera.clear();

        for (Escuderia escuderia:Escuderias) {
            escuderia.OrdenarPilotos();
            escuderia.OrdenarCoches();
        }

        return stringBuilder.toString();

    }
}
