 

public abstract class CircuitoExtra extends Circuito {
    protected Circuito decoratedCircuito;

    /**
     * Constructor de la clase circuitoExtra que extiende de la clase Circuito, se encarga de llamar al constructor de la clase Circuito
     * e inicializar el decorator.
     *
     * @param cir, se trata del circuito que queremos añadirle la complejidad y la distancia extra
     */
    public CircuitoExtra(Circuito cir) {
        super(cir.getNombre(), cir.getComplejidad(), cir.getDistancia());
        decoratedCircuito = cir;
    }

    /**
     * Este método se encarga de devolver la complejidad actual del circuito una vez se le ha modificado la complejidad
     *
     * @return la complejidad nueva del circuito
     */
    @Override
    public Double getComplejidadActual() {
        return Math.round((this.decoratedCircuito.getComplejidadActual())*100d)/100d;
    }

    /**
     * Este método se encarga de devolver la distancia actual del circuito una vez se le ha modificado la distancia
     *
     * @return la distancia nueva del circuito
     */
    @Override
    public Double getDistanciaActual() {
        return  Math.round((this.decoratedCircuito.getDistanciaActual())*100d)/100d;
    }

    /**
     * Este método se encarga de devolver la complicacion extra del circuito una vez se le han hecho todas las modificaciones
     *
     * @return la complicacion nueva del circuito
     */
    @Override
    public String ComplicacionExtra() {
        return this.decoratedCircuito.ComplicacionExtra();
    }

}