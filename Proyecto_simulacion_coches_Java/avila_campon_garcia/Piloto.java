 


import java.util.HashMap;
import java.util.Set;

public abstract class Piloto {

    protected String nombre;
    protected Coche coche;
    protected Concentracion concentracion;
    protected Boolean descalificado;
    protected HashMap<String, Puntuacion> listaPuntuacion;
    private Integer abandonos;
    private Double tiempoCarreraActual;
    private Boolean terminadaCarreraActual;
    protected Escuderia escuderiaPerteneciente;


    /**
     * Constructor de la clase Piloto, que se encarga de inicializar sus atributos
     *
     * @param nombre,  nombre del piloto
     * @param concentracion, concentración del piloto
     * @param escuderia, escuderia a la que pertenece el piloto
     */
    public Piloto(String nombre, Concentracion concentracion, Escuderia escuderia) {
        this.nombre = nombre;
        this.concentracion = concentracion;
        this.descalificado = false;
        this.listaPuntuacion = new HashMap<>();
        this.abandonos = 0;
        this.escuderiaPerteneciente = escuderia;
        this.tiempoCarreraActual = 0.0;
        this.terminadaCarreraActual = false;
    }


    /**
     * Este método devuelve el nombre del piloto
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Este método se encarga de poner el nombre del piloto pasado por parámetros en el atributo nombre
     *
     * @param nombre_p, nombre del piloto que queremos poner en el atributo nombre
     */
    public void setNombre(String nombre_p) {
        this.nombre = nombre_p;
    }

    /**
     * Este método devuelve el coche que tiene asociado el piloto
     *
     * @return coche
     */
    public Coche getCoche() {
        return coche;
    }

    /**
     * Este método se encarga de poner el coche pasado por parámetros en el atributo coche
     *
     * @param cocheDefault, coche que queremos poner en el atributo coche
     */
    public void setCoche(Coche cocheDefault) {
        this.coche = cocheDefault;
    }

    /**
     * Este método devuelve el enum de concentración con su nombre(String) y valor(Double)
     *
     * @return enum de Concentración
     */
    public Concentracion getConcentracion() {
        return this.concentracion;
    }

    /**
     * Este método se encarga de poner la concentración pasado por parámetros en el atributo concentración
     *
     * @param concentracion, concentración del piloto que queremos poner en el atributo concentración
     */
    public void setConcentracion(Concentracion concentracion) {
        this.concentracion = concentracion;
    }

    /**
     * Este método devuelve un boolean si el piloto esta descalificado o no
     *
     * @return true si esta descalificado, false en caso de no estar descalificado
     */
    public Boolean getDescalificado() {
        return descalificado;
    }

    /**
     * Este método se encarga de poner el boolean descalificado pasado por parámetros en el atributo descalificado
     *
     * @param descalificado, true o false dependiendo si esta descalificado o no para establecerlo en el atributo descalificado
     */
    public void setDescalificado(boolean descalificado) {
        this.descalificado = descalificado;
    }

    /**
     * Este método devuelve la destreza del piloto(abstact method)
     *
     * @return destreza
     */
    public abstract Double getDestreza();

    /**
     * Este método se encarga de establecer la puntuación del piloto en el circuito que ha competido, se introduce en el
     * HashMap el nombre del circuito y el enum de puntuación que tiene el tiempo que ha tardado y los puntos conseguidos
     *
     * @param ncircuito, circuito que ha corrido el piloto
     * @param puntuacion, tiempo y puntos que ha hecho el piloto
     */
    public void setPuntuacion(String ncircuito, Puntuacion puntuacion) {
        this.listaPuntuacion.put(ncircuito, puntuacion);
    }

    /**
     * Este método se encarga de devolver los puntos que ha conseguido el pilodo en el circuito pasado por parámetros
     *
     * @param ncircuito, circuito que ha corrido el piloto
     * @return los puntos que ha obtenido en el circuito
     */
    public Double getPuntuacionCarrera(String ncircuito){
        return this.listaPuntuacion.get(ncircuito).getPuntos();
    }

    /**
     * Este método se encarga de devolver las carreras que ha realizado el piloto
     *
     * @return número de carreras realizadas por el piloto
     */
    public Integer getCarrerasRealizadas() {
        return this.listaPuntuacion.size();
    }

    /**
     * Este método se encarga de devolver el total de Puntos que ha conseguido el piloto entre todos los circuitos que ha corrido
     *
     * @return puntos obtenidos
     */
    public Double totalPuntos() {
        double puntos = 0.0;
        for (Puntuacion puntuacion : listaPuntuacion.values()) {
            puntos += puntuacion.getPuntos();
        }
        return puntos;
    }

    /**
     * Este método comprueba si el piloto tiene coche asignado para poder enviarlo a la carrera
     */
    public void comprobarCoche() {
        if (coche == null) {
            System.out.println("El piloto no puede ser enviado a la carrera porque no tiene coche disponible");
        }
    }

    /**
     * Este método comprueba si el piloto esta descalificado, en caso de estarlo saca un mensaje por pantalla
     * diciendo que el piloto esta descalificado
     */
    public void comprobarDescalificacion() {
        if (descalificado == true) {
            System.out.println("El piloto esta descalificado");
        }
    }

    /**
     * Este método devuelve la escuderia a la que pertenece el piloto
     */
    public Escuderia getEscuderiaPerteneciente(){
        return this.escuderiaPerteneciente;
    }

    /**
     * Este método se encarga de calcular la velocidad a la que es capaz de alcanzar el piloto con su coche asignado, dependiendo
     * de la destreza del piloto, la velocidad del coche y la complejidad del circuito
     *
     * @param complejidad, complejidad del circuito
     * @return la velocidad que es capaz de alcanzar el piloto
     */
    public Double getVelocidadEsCapaz(Double complejidad) {
        Double destreza = Math.round(this.getDestreza() * 100.0) / 100.0;;
        complejidad = Math.round(complejidad*100.0)/100.0;
        Double calculo = (this.getCoche().getVelocidad().getValor() * destreza) / complejidad;
        calculo = Math.round(calculo * 100.0) / 100.0;
        return calculo;
    }

    /**
     * Este método devuelve si el piloto tiene la concetración suficiente para poder terminar la carrera
     *
     * @param tiempo, tiempo que tarda en terminar la carrera
     * @return boolean false si no le falta la concentración por lo que podrá terminar la carrera, y true en caso de que
     * si le false concetración y no podrá terminar la carrera
     */
    public Boolean getFaltaDeConcentracion(Double tiempo) {
        if (this.getConcentracion().getValor() < tiempo) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Este método se encarga de devolver el piloto a la escuderia después de terminar la carrera
     */
    public void volverAEscuderia() {
        this.coche.setAsignado(false);
        this.coche = null;
        this.escuderiaPerteneciente.recibirPilotoDeCarrera(this);
    }

    /**
     * Este método saca por pantalla si el piloto ha sido descalificado del campeonato por haber superado el limite de
     * abandonos
     *
     * @param abandonoscircuito, abandonos del piloto
     * @return string con la información de la descalificación del piloto
     */
    public String pilotoAbandona(Integer abandonoscircuito){
        if(this.abandonos >= abandonoscircuito){
            this.descalificado = true;
            return "¡¡¡ "+this.getNombre()+" es DESCALIFICADO del campeonato por alcanzar el límite de abandonos("+abandonoscircuito+") !!!\n" +
                    "@@@\n";
        }else{
            return "";
        }
    }

    /**
     * Devulve el tiempo de la carrera actual
     *
     * @return tiempoCarreraActual
     */
    public Double getTiempoCarreraActual() {
        return this.tiempoCarreraActual;
    }

    /**
     * Devuelve boolean si ha el piloto podido terminar la carrea o no
     *
     * @return boolean terminadaCarreraActual
     */
    public Boolean getTerminadaCarreraActual(){
        return this.terminadaCarreraActual;
    }

    /**
     * Este método se encarga de incrementar el número de abandonos del piloto
     */
    public void incAbandono(){
        this.abandonos++;
    }

    /**
     * Este método devuelve el número de carreras terminadas del piloto
     *
     * @return devuelve las carreras que ha terminado el piloto
     */
    public Integer getCarrerasTerminadas() {
        return this.listaPuntuacion.size() - abandonos;
    }

    /**
     * Este método es el encargado de ejecutar la conducción del coche, sacando por pantalla el tiempo que ha tardado en terminar
     * la carrera, si no ha podido terminar la concentracíón que le ha faltado o el combustible que le ha faltado
     *
     * @param circuito, circuito que ha corrido el piloto
     * @return string con toda la información de la conducción del piloto
     */
    //Mirar esto para ver si esta correcto
    public String conducirCoche(Circuito circuito) {
        String s;
        Double tiempoNecesario = coche.comprobarTiempoNecesarioTerminar(this.getDestreza(), circuito.getDistanciaActual(), circuito.getComplejidadActual());
        if (this.getConcentracion().getValor() > tiempoNecesario && tiempoNecesario < coche.getCombustible()) {
            s="+++ " + this.getNombre() + " termina la carrera en " +Math.round( tiempoNecesario*100d)/100d + " minutos +++";
            coche.setCombustible(coche.getCombustible()-tiempoNecesario);
            this.tiempoCarreraActual = tiempoNecesario;
            this.terminadaCarreraActual = true;
        } else {
            this.terminadaCarreraActual = false;
            incAbandono();
            if(tiempoNecesario - this.getConcentracion().getValor() > //Tiempo necesario para acabar la carrera 100 y mi concentracion 98
                    tiempoNecesario-coche.getCombustible()){//Tiempo necesario para acabar la carrera 100 y mi combustible es de 99
                s="¡¡¡ "+this.getNombre()+" perdió la concentración a falta de "+Math.round((tiempoNecesario - this.getConcentracion().getValor())*100d)/100d+" minutos para terminar !!! \n"+"¡¡¡ En el momento del despiste llevaba en carrera "+Math.round(this.getConcentracion().getValor()*100d)/100d+" minutos !!!";
                coche.setCombustible(coche.getCombustible()-this.getConcentracion().getValor());
                this.tiempoCarreraActual = this.getConcentracion().getValor()-tiempoNecesario;
            }
            else{
                s="¡¡¡ El "+coche.getNombre()+" se quedó sin combustible a falta de "+Math.round((tiempoNecesario-coche.getCombustible())*100d)/100d+" minutos para terminar !!! \n"+"¡¡¡ En el momento de quedarse sin combustible llevaba en carrera "+Math.round(coche.getCombustible()*100d)/100d+" minutos !!!";
                coche.setCombustible(coche.getCombustible()-tiempoNecesario);//Ver ahora
                this.tiempoCarreraActual = coche.getCombustible();
            }
        }
        return s;
    }

    /**
     * Devuelve la gasolina restando del coche del piloto
     *
     * @return gasolina del coche del piloto
     */
    public String GasolinaRestanteDelCoche(){
        return coche.GasolinaRestante();
    }

    /**
     * Este método saca por pantalla toda la información de los pilotos en cada circuito (nombre del circuito,
     * puntos y tiempo que ha hecho en el circuito)
     *
     * @param circuito, circuito en el que ha participado el piloto
     * @return devuelve un string con toda la información de los pilotos en cada circuito de la competicíon
     */
    public String podio(Circuito circuito){
        String s="";
        if (this.listaPuntuacion.containsKey(circuito.getNombre()))
        s="Carrera("+circuito.getNombre()+") - Puntos:"+String.format("%.0f",listaPuntuacion.get(circuito.getNombre()).getPuntos())+" - Tiempo:"+Math.round(listaPuntuacion.get(circuito.getNombre()).getTiempo()*100d)/100d+" minutos\n";
        return s;
    }

    /**
     * Este método muestra saca por pantalla la información de los pilotos(abstract mehod)
     *
     * @return devuelve un string con la información de los pilotos
     */
    public abstract String toString();
}
