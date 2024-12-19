 

public class Frio extends CircuitoExtra {
    /**
     * Constructor de la clase Frio que extiende de la clase CircuitoExtra y llama a su constructor
     *
     * @param cir, circuito al que se le añade la complicaciónExtra "FRIO"
     */
    public Frio(Circuito cir) {
        super(cir);
    }

    /**
     * Este método se encarga de devolver la complejidad actual del circuito una vez se le ha modificado la complejidad
     * de la complicación "FRIO"
     *
     * @return la complejidad nueva del circuito
     */
    @Override
    public Double getComplejidadActual() {
        return Math.round((decoratedCircuito.getComplejidadActual()*1.1)*100d)/100d ;
    }

    /**
     * Este método se encarga de devolver la distancia actual del circuito una vez se le ha modificado la distancia
     * de la complicación "FRIO"
     *
     * @return la distancia nueva del circuito
     */
    @Override
    public Double getDistanciaActual() {
        return Math.round((decoratedCircuito.getDistanciaActual()*0.9)*100d)/100d;
    }

    /**
     * Este método se encarga de devolver la complicacion extra del circuito una vez se le han hecho todas las modificaciones
     * de la complicación "FRIO"
     *
     * @return la complicación nueva del circuito
     */
    @Override
    public String ComplicacionExtra() {
        return decoratedCircuito.ComplicacionExtra()+" Frio";
    }
}