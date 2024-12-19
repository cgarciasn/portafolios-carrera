 


public class PilotoExperimentado extends Piloto {

    /**
     * Constructor de la clase PilotoExperimentado que extiende de la clase Piloto, se encarga de llamar al constructor
     * de la clase Piloto
     *
     * @param nombre, nombre del pilotoExperimentado
     * @param concentracion, concentración del pilotoExperimentado
     * @param escuderia, escuderia a la que pertenece el pilotoExperimentado
     */
    public PilotoExperimentado(String nombre, Concentracion concentracion, Escuderia escuderia) {
        super(nombre,concentracion,escuderia);
    }

    /**
     * Este método devuelve la destreza del pilotoExperimentado
     *
     * @return destreza
     */
    public Double getDestreza() {
        return ((this.getConcentracion().getValor() + 3) / 130) * 1.03;
    }

    /**
     * Este método es el método mostrar de la clase PilotoExperimentado que saca por pantalla toda la información
     * del pilotoExperimentado
     *
     * @return devuelve un string con toda la información del pilotoExperimentado
     */
    @Override
    public String toString() {
        String s = "<piloto:"+this.getNombre()+"> <tipo: PilotoExperimentado> <dest: "+Math.round(this.getDestreza()*100.0)/100.0+"> <conc: "+this.getConcentracion().getNombre();
        s+="("+Math.round(this.getConcentracion().getValor()*100.0)/100.0+")> <descalificado:"+this.getDescalificado()+">";
        return s;
    }
}
