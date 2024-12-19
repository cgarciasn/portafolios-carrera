 

import javax.swing.text.Style;

public class CocheRapido extends Coche {
    private Double nitro;

    /**
     * Constructor de la clase CocheRapido que extiende de la clase Coche, se encarga de llamar al constructor de la clase Coche
     * e inicializar el atributo nitro
     *
     * @param nombre, nombre del coche
     * @param velocidad, velocidad del coche
     * @param combustible, combustible del coche
     */
    public CocheRapido(String nombre, Velocidad velocidad, Combustible combustible){
        super(nombre,velocidad,combustible);
        this.nitro = 80.0;
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
        Double calculo = (this.getVelocidad().getValor()*destreza)/complejidad;
        calculo = Math.round(calculo*100.0)/100.0;

        if(this.getNitro()<= 0.0){
            return (distancia/calculo)*60.0;
        }else{
            if(calculo*0.2 <= this.getNitro()){
                Double nitroUsado = calculo*0.2;
                this.setNitro(this.getNitro()-nitroUsado);
                calculo += calculo*0.2;
                calculo = Math.round(calculo*100.0)/100.0;
                Double resultado = (distancia/calculo)*60.0;
                return resultado;
            }else{
                calculo+=this.getNitro();
                calculo = Math.round(calculo*100.0)/100.0;
                this.setNitro(0.0);
                return (distancia/calculo)*60.0;
            }
        }
    }

    /**
     * Este método se encarga de calcular el nitro que necesita, la velocidad que es capaz de alcanzar usando el nitro del coche
     * y el nitro que le quedará al coche
     *
     * @param destreza, destreza del piloto
     * @param complejidad, complejidad del circuito
     * @param distancia, distancia del circuito
     * @return devuelve el String s con toda la información del cocheRapido
     */

    @Override
    public String salidaCocheConExtras(Double destreza,Double complejidad,Double distancia) {
        String s = "";
        destreza = Math.round(destreza*100.0)/100.0;
        Double calculo = (this.getVelocidad().getValor()*destreza)/complejidad;
        calculo = Math.round(calculo*100.0)/100.0;

        if(this.getNitro()<= 0.0){
            //prosigue normal sin devolver nada
            return s;
        }else{
            if(calculo*0.2 <= this.getNitro()){
                Double nitroUsado = calculo*0.2;
                //this.setNitro(this.getNitro()-nitroUsado);
                calculo += calculo*0.2;
                calculo = Math.round(calculo*100.0)/100.0;
                return "+++ El "+this.getNombre()+" usa "+Math.round(nitroUsado*100.0)/100.0+" de nitro para alcanzar "+calculo+" km/hora y el nitro restante es "+Math.round((this.getNitro()-nitroUsado)*100.0)/100.0+" +++\n";
            }else{
                calculo+=this.getNitro();
                calculo = Math.round(calculo*100.0)/100.0;
                s = "+++ El "+this.getNombre()+" usa "+Math.round(this.getNitro()*100.0)/100.0+" de nitro para alcanzar "+calculo+" km/hora y el nitro restante es 0.0 +++\n";
                //this.setNitro(0.0);
                return s;
            }
        }
    }

    /**
     * Este método se encarga de poner el nitro pasado por parámetros en el atributo nitro
     *
     * @param nitro, nitro del coche
     */

    public void setNitro(Double nitro){
        this.nitro = nitro;
    }

    /**
     * Este método devuelve el nitro del coche
     *
     * @return nitro
     */
    public Double getNitro(){
        return this.nitro;
    }

    /**
     * Este método es el método mostrar de la clase CocheRapido que se encarga de mostrar por pantalla los atributos de la clase
     *
     * @return s, devuelve un string con toda la información de la clase CocheRapido
     */
    @Override
    public String toString(){
        String s = "<coche: "+this.getNombre()+"> <tipo: CocheRapido> <vel_teó: "+this.getVelocidad().getNombre();
        s+="("+this.getVelocidad().getValor()+")> <comb: "+this.getCombustibleInicial().getNombre()+"("+Math.round(this.getCombustibleInicial().getValor()*100.0)/100.0+")(actual:";
        s+= Math.round(this.getCombustible()*100.0)/100.0+")>> <nitroPendiente: "+Math.round(this.getNitro()*100.0)/100.0+">";
        return s;
    }
}
