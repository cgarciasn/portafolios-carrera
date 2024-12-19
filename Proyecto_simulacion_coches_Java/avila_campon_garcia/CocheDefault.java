 


public class CocheDefault extends Coche{

    /**
     * Constructor de la clase CocheDefault que extiende de la clase Coche,y llama al constructor de la clase CocheDefault
     *
     * @param nombre, nombre del coche
     * @param velocidad, velocidad del coche
     * @param combustible, combustible del coche
     */
    public CocheDefault(String nombre, Velocidad velocidad, Combustible combustible) {
        super(nombre,velocidad,combustible);
    }
    /**
     * Este método se encarga de comprobar el tiempo necesario que se necesita para terminar la carrera y depende de la
     * destreza del piloto, la distancia y la complejidad del circuito
     *
     * @param destreza, destreza del piloto
     * @param distancia, distancia del circuito
     * @param complejidad, complejidad del circuito
     * @return tiempo necesario para terminar la carrera
     */
    @Override
    public Double comprobarTiempoNecesarioTerminar(Double destreza, Double distancia, Double complejidad) {
        destreza = Math.round(destreza*100.0)/100.0;
        complejidad = Math.round(complejidad*100.0)/100.0;
        Double velocidadReal = (this.getVelocidad().getValor()*destreza)/complejidad;
        velocidadReal = Math.round(velocidadReal*100.0)/100.0;
        return (distancia/velocidadReal)*60.0;
    }

    /**
     * Este método es el método mostrar de la clase CocheDefault que se encarga de mostrar por pantalla los atributos de la clase
     *
     * @return s, devuelve el string que muestra toda la información de la clase CocheDefault
     */
    @Override
    public String toString(){
        String s = "<coche: "+this.getNombre()+"> <tipo: CocheNormal> <vel_teó: "+this.getVelocidad().getNombre();
        s+="("+this.getVelocidad().getValor()+")> <comb: "+this.getCombustibleInicial().getNombre()+"("+this.getCombustibleInicial().getValor()+")(actual:";
        s+=Math.round(this.getCombustible()*100d)/100d+")>";
        return s;
    }
}

