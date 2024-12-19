 

public class Circuito implements ICircuito {
    protected String nombre_ci;
    protected Complejidad complejidad;
    protected Distancia distancia;

    /**
     * Constructor de la clase circuito, se encarga de inicializar los atributos de la clase
     */
    public Circuito(String nombre_ci, Complejidad complejidad, Distancia distancia) {
        this.nombre_ci  =    nombre_ci;
        this.complejidad    =   complejidad;
        this.distancia  =   distancia;
    }

    /**
     * Devuelve el nombre del circuito
     *
     * @return nombre
     */
    public String getNombre() {

        return nombre_ci;
    }

    /**
    * Este método se encarga de poner el nombre del circuto pasado por parámetros en el atributo nombre_ci
     *
    * @param nombre_c del circuito que queremos poner en el atributo nombre_ci
    */

    public void setNombre(String nombre_c) {

        this.nombre_ci = nombre_c;
    }
    /**
     * Este método devuelve el enum complejidad con su nombre(String) y valor(Double)
     *
     * @return enum de complejidad
     */

    public Complejidad getComplejidad() {

        return complejidad;
    }

    /**
     * Este método se encarga de poner la complejidad pasado por parámetros en el atributo complejidad
     *
     * @param complejidad, el enum de complejidad que ponemos en el atributo complejidad
     */
    public void setComplejidad(Complejidad complejidad) {

        this.complejidad = complejidad;
    }


    /**
     * Este método devuelve el enum de distancia con su nombre(String) y valor(Double)
     *
     * @return enum de distancia
     */
    public Distancia getDistancia() {

        return distancia;
    }

    /**
     * Este método se encarga de poner la distancia pasada por parámetros en al atributo distancia
     *
     * @param distancia, el enum de distancia que ponemos en el atributo distancia
     */
    public void setDistancia(Distancia distancia) {

        this.distancia = distancia;
    }

    /**
     * Este método devuelve el valor de la complejidad actual que tiene el circuito
     *
     * @return valor de la complejidad actual del circuito
     */
    @Override
    public Double getComplejidadActual() {
        return this.complejidad.getValor();
    }

    /**
     * Este método devuelve el valor de la distancia actual que tiene el circuito
     *
     * @return valor de la distancia actual del circuito
     */
    @Override
    public Double getDistanciaActual() {
        return this.distancia.getValor();
    }


    /**
     * Este método se encarga de devolver la complicacion extra del circuito una vez se le han hecho todas las modificaciones
     *
     * @return la complicacion nueva del circuito
     */
    @Override
    public String ComplicacionExtra() {
        return "";
    }

    /**
     * Este método es el mostrar de la clase circuito que se encarga de mostrar por pantalla los atributos de la clase circuito
     *
     * @return s, devuelve el string que muestra toda la informacion del circuito
     */
   public String toString(){
        String s ="<circuito:" + this.nombre_ci + "> <";
        s+="cond:"+this.ComplicacionExtra()+"> <comp: " + this.getComplejidad().getNombre() +"(original:"+Math.round(this.getComplejidad().getValor()*100.0)/100.0+")(actual:";
        s+=Math.round(this.getComplejidadActual()*100.0)/100.0+")> <dist: "+this.getDistancia().getNombre()+"(original:"+Math.round(this.getDistancia().getValor()*100.0)/100.0+")(actual:"+Math.round(this.getDistanciaActual()*100.0)/100.0+")>";
        return s;
    }
}
