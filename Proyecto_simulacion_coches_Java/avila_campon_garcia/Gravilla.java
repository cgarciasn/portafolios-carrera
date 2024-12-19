 

public class Gravilla extends CircuitoExtra {

    /**
     * Constructor de la clase Gravilla que extiende de la clase CircuitoExtra
     *
     * @param cir, circuito al que se le quiere añadir la complicaciónExtra "GRAVILLA"
     */
    public Gravilla(Circuito cir) {
        super(cir);
    }

    /**
     * Este método se encarga de devolver la complejidad actual del circuito una vez se le ha modificado la complejidad
     * de la complicación "GRAVILLA"
     *
     * @return la complejidad nueva del circuito
     */
    @Override
    public Double getComplejidadActual() {
        return Math.round((decoratedCircuito.getComplejidadActual()*1.05)*100d)/100d;
    }

    /**
     * Este método se encarga de devolver la distancia actual del circuito una vez se le ha modificado la distancia
     * de la complicación "GRAVILLA"
     *
     * @return la distancia nueva del circuito
     */
    @Override
    public Double getDistanciaActual() {
        return Math.round((decoratedCircuito.getDistanciaActual()*0.95)*100d)/100d;
    }

    /**
     * Este método se encarga de devolver la complicacion extra del circuito una vez se le han hecho todas las modificaciones
     * de la complicación "GRAVILLA"
     *
     * @return la complicación nueva del circuito
     */
    @Override
    public String ComplicacionExtra() {
        return decoratedCircuito.ComplicacionExtra()+" Gravilla";
    }
}
