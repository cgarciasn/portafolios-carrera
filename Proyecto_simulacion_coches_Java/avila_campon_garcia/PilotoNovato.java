 



public class PilotoNovato extends Piloto {
    private double destreza;

    /**
     * Constructor de la clase PilotoNovato que extiende de la clase Piloto, se encarga de llamar al constructor
     * de la clase Piloto
     *
     * @param nombre, nombre del pilotoNovato
     * @param concentracion, concentración del pilotoNovato
     * @param escuderia, escuderia a la que pertenece el pilotoNovato
     */
    public PilotoNovato(String nombre, Concentracion concentracion, Escuderia escuderia) {
        super(nombre,concentracion,escuderia);
    }

    /**
     * Este método devuelve la destreza del pilotoNovato
     *
     * @return destreza
     */
    public Double getDestreza() {
        return ((this.getConcentracion().getValor() * 0.97) / 120) - 0.03;
    }

    /**
     * Este método es el método mostrar de la clase PilotoNovato que saca por pantalla toda la información
     * del pilotoNovato
     *
     * @return devuelve un string con toda la información del pilotoNovato
     */
    @Override
    public String toString() {
        String s = "<piloto:"+this.getNombre()+"> <tipo: PilotoNovato> <dest: "+Math.round(this.getDestreza()*100.0)/100.0+"> <conc: "+this.getConcentracion().getNombre();
        s+="("+Math.round(this.getConcentracion().getValor()*100.0)/100.0+")> <descalificado:"+this.getDescalificado()+">";
        return s;
    }
}

