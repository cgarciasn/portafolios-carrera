 

public class CocheResistente extends Coche {
    private Double reserva;
    private Boolean usada;


    /**
     * Constructor de la clase CocheResistente que extiende de la clase Coche, se encarga de llamar al constructor de la clase Coche
     * e inicializar el atributo reserva y el atributo boolean usada
     *
     * @param nombre, nombre del coche
     * @param velocidad, velocidad del coche
     * @param combustible, combustible del coche
     */
    public CocheResistente(String nombre, Velocidad velocidad, Combustible combustible){
            super(nombre,velocidad,combustible);
            this.reserva = 100.0;
            this.usada = false;
    }


    /**
     * Este método se encarga de calcular el combustible reserva que necesita para terminar la carrera en caso de quedarse
     * sin combustible y actualizar su combustible
     *
     * @param destreza, destreza del piloto
     * @param complejidad, complejidad del circuito
     * @param distancia, distancia del circuito
     * @return devuelve el String s con toda la información del cocheResistente
     */
    @Override
    public String salidaCocheConExtras(Double destreza,Double complejidad,Double distancia) {
        if(!usada){
            Double resultado = this.getCombustible()-this.comprobarTiempoNecesarioTerminar(destreza,complejidad,distancia);
            if(resultado < 0.0){
                usada = true;
                if(reserva > this.comprobarTiempoNecesarioTerminar(destreza,complejidad,distancia)){
                    Double aux = this.getCombustible();
                    this.setCombustible(this.getCombustible()-resultado);
                    this.setReserva(this.getReserva()+resultado);
                    return "+++ El "+this.getNombre()+" tiene que recurrir al depósito de reserva para poder correr +++\n";
                }else{
                    this.setCombustible(this.getCombustible()+this.getReserva());
                    this.setReserva(0.0);
                    return "+++ El "+this.getNombre()+" tiene que recurrir al depósito de reserva para poder correr +++\n";
                }
            }
        }
        return "";
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
    public Double comprobarTiempoNecesarioTerminar(Double destreza, Double distancia, Double complejidad) {
        destreza = Math.round(destreza*100.0)/100.0;
        Double velocidadReal = (this.getVelocidad().getValor()*destreza)/complejidad;
        velocidadReal = Math.round(velocidadReal*100.0)/100.0;
        return (distancia/velocidadReal)*60;
    }


    /**
     * Este método devuelve la reserva que tiene el coche
     *
     * @return reserva
     */
    private Double getReserva(){
        return this.reserva;
    }


    /**
     * Este método se encarga de poner la reserva pasada por parámetros en el atributo reserva
     *
     * @param reserva, reserva que tiene el cocheResistente
     */
    private void setReserva(Double reserva){
        this.reserva = reserva;
    }


    /**
     * Este método es el método mostrar de la clase CocheResistente que se encarga de mostrar por pantalla los atributos de la clase
     *
     * @return s, devuelve un string con toda la información de la clase CocheResistente
     */
    @Override
    public String toString(){
        String s = "<coche: "+this.getNombre()+"> <tipo: CocheResistente> <vel_teó: "+this.getVelocidad().getNombre();
        s+="("+this.getVelocidad().getValor()+")> <comb: "+this.getCombustibleInicial().getNombre()+"("+this.getCombustibleInicial().getValor()+")(actual:";
        s+= Math.round(this.getCombustible()*100d)/100d+")>> <reserva: "+this.getReserva()+">";
        return s;
    }
}
