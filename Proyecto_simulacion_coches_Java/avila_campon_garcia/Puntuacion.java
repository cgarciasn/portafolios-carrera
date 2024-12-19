 

public class Puntuacion {
    private Double tiempo;
    private Double puntos;

    /**
     * Constructor de la clase Puntuación de tipo enum que inicializa sus atributos tiempo(Double) y puntos(Double)
     *
     * @param tiempo, tiempo que ha hecho en la carrera
     * @param puntos, puntos que ha obtenido en la carrera
     */
    public Puntuacion(Double tiempo, Double puntos) {
        this.tiempo = tiempo;
        this.puntos = puntos;
    }

    /**
     * Devuelve el tiempo que ha hecho en la carrera
     *
     * @return tiempo
     */
    public double getTiempo() {
        return tiempo;
    }

    /**
     * Este método se encarga de poner el tiempo pasado por parámetros en el atributo tiempo
     *
     * @param tiempo, tiempo que ha hecho en la carrera
     */
    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    /**
     * Devuelve los puntos que ha obtenido en la carrera
     *
     * @return puntos
     */
    public double getPuntos() {
        return puntos;
    }

    /**
     * Este método se encarga de poner los puntos pasados por parámetros en el atributo puntos
     *
     * @param puntos
     */
    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }

}
