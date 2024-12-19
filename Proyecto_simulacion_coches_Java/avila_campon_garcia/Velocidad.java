 

public enum Velocidad {

    TORTUGA("TORTUGA",200.0),
    LENTA("LENTA",210.0),
    NORMAL("NORMAL",220.0),
    RAPIDA("RAPIDA",230.0),
    GUEPARDO("GUEPARDO",240.0);

    private final String nombre;
    private final Double valor;

    /**
     * Constructor de la clase Velocidad de tipo enum que inicializa sus atributos nombre(String) y valor(Double)
     *
     * @param nombre,nombre de la velocidad
     * @param valor,valor de la velocidad
     */
    Velocidad(String nombre,double valor){
        this.nombre = nombre;
        this.valor = valor;
    }

    /**
     * Devuelve el nombre de la velocidad
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el valor de la velocidad
     *
     * @return valor
     */
    public Double getValor() {
        return valor;
    }
}
