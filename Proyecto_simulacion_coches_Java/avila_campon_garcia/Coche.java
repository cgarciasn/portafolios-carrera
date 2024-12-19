 

public abstract class Coche {
    protected String nombre;
    protected Velocidad velocidad;
    protected Combustible combustible;
    protected Double combustible_actual;
    private boolean asignado;

    /**
     * Constructor de la clase Coche, se encarga de inicializar los atributos de la clase
     *
     * @param nombre, nombre del coche
     * @param velocidad, velocidad del coche
     * @param combustible, combustible del coche
     */
    public Coche(String nombre, Velocidad velocidad, Combustible combustible) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.combustible = combustible;
        this.combustible_actual = this.combustible.getValor();
    }

    /**
     * Este método devuelve el nombre del coche
     *
     * @return nombre
     */

    public String getNombre() {

        return nombre;
    }

    /**
     * Este método se encarga de poner el nombre del coche pasado por parámetros en el atributo nombre
     *
     * @param nombre_co, nombre del coche que queremos poner en el atributo nombre
     */

    public void setNombre(String nombre_co) {

        this.nombre = nombre_co;
    }

    /**
     * Este método devuelve la velocidad del coche
     *
     * @return velocidad
     */
    public Velocidad getVelocidad() {

        return this.velocidad;
    }

    /**
     * Este método se encarga de poner la velocidad del coche pasada por parámetros en el atributo velocidad
     *
     * @param velocidad, velocidad del coche que queremos poner en el atributo velocidad
     */

    public void setVelocidad(Velocidad velocidad){
        this.velocidad = velocidad;
    }

    /**
     * Este método devuelve el combustible inicial del coche
     *
     * @return combustible
     */
    public Combustible getCombustibleInicial(){

        return this.combustible;
    }

    /**
     * Este método se encarga de poner el combustible inicial pasado por parámetros en el atributo combustible
     *
     * @param combustible, combustible del coche que queremos poner en el atributo combustible
     */
    public void setCombustibleInicial(Combustible combustible){
        this.combustible = combustible;
    }

    /**
     * Este método devuelve el combustible actual del coche
     *
     * @return combustible_actual
     */
    public Double getCombustible(){
        return this.combustible_actual;
    }

    /**
     * Este método se encarga de poner el combustible actual pasado por parámetros en el atributo combustible_actual
     *
     * @param combustible, combustible acual del coche que qeremos poner en el atributo combustible_acutal
     */

    public void setCombustible(Double combustible){
        this.combustible_actual = combustible;
    }

    /**
     * Este método devuelve si el coche ha sido asignado a algún piloto
     *
     * @return asigando
     */
    public boolean getAsignado(){
        return this.asignado;
    }

    /**
     * Este método se encarga de poner true en caso de que el coche haya sido asignado o false en el que caso de que
     * el coche no haya sido asignado en el atributo asignado
     *
     * @param asignado, boolean true o false
     */

    public void setAsignado(boolean asignado){
        this.asignado = asignado;
    }

    /**
     * Este método se encarga de comprobar el tiempo necesario que se necesita para terminar la carrera y depende de la
     * destreza del piloto, la distancia y la complejidad del circuito.
     *
     * @param destreza, destreza del piloto
     * @param distancia, distancia del circuito
     * @param complejidad, complejidad del circuito
     * @return tiempo necesario para terminar la carrera
     */

    public abstract Double comprobarTiempoNecesarioTerminar(Double destreza, Double distancia, Double complejidad);

    /**
     * Este método se encarga de calcular el nitro que necesita, la velocidad que es capaz de alcanzar usando el nitro del coche
     * y el nitro que le quedará al coche si es cocheRapido y en caso de que sea cocheResistente
     *
     * @param destreza, destreza del piloto
     * @param complejidad, complejidad del circuito
     * @param distancia, distancia del circuito
     * @return devuelve el String s con toda la información del coche
     */
    public String salidaCocheConExtras(Double destreza, Double complejidad,Double distancia) {
        return "";
    }

    /**
     * Este método es un método mostrar de la clase coche que muestra por pantalla el combustible que le queda al coche
     * después de realizar "x" carrera
     *
     * @return devuelve un string con la información del combustible que le queda al coche
     */
    public String GasolinaRestante(){
        String s;
        s="+++ El combustible del "+this.getNombre()+" tras la carrera es "+Math.round(this.getCombustible()*100.0)/100.0+" +++";
        return s;
    }

    /**
     * Este método muestra saca por pantalla la información de los coches(abstract mehod)
     *
     * @return devuelve un string con la información de los coches
     */
    public abstract String toString();
}
