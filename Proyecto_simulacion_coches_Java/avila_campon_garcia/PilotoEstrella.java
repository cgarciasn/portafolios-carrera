 


public class PilotoEstrella extends Piloto {

    /**
     * Constructor de la clase PilotoEstrella que extiende de la clase Piloto, se encarga de llamar al constructor de la clase Piloto
     *
     * @param nombre, nombre del pilotoEstrella
     * @param concentracion, concentración del pilotoEstrella
     * @param escuderia, escuderia a la que pertenece el pilotoEstrella
     */
    public PilotoEstrella(String nombre, Concentracion concentracion, Escuderia escuderia) {
        super(nombre,concentracion,escuderia);
    }

    /**
     * Este método devuelve la destreza del pilotoEstrella
     *
     * @return destreza
     */
    public Double getDestreza() {
        return (((this.getConcentracion().getValor() + 6) / 140) * 1.06) + 0.05;
    }

    /**
     * Este método es el método mostrar de la clase PilotoEstrella que saca por pantalla toda la información del pilotoEstrella
     *
     * @return devuelve un string con toda la información del pilotoEstrella
     */
    @Override
    public String toString() {
        String s = "<piloto:"+this.getNombre()+"> <tipo: PilotoEstrella> <dest: "+Math.round(this.getDestreza()*100.0)/100.0+"> <conc: "+this.getConcentracion().getNombre();
        s+="("+Math.round(this.getConcentracion().getValor()*100.0)/100.0+")> <descalificado:"+this.getDescalificado()+">";
        return s;
    }
}
