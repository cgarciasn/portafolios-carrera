 

public enum Distancia {

    CORTA ("CORTA",250.0),
    INTERMEDIA("INTERMEDIA",275.0),
    LARGA("LARGA",300.0);

    private final String nombre;
    private final Double valor;

    /**
     * Constructor de la clase Distancia de tipo enum que inicializa sus atributos nombre(String) y valor(Double)
     *
     * @param nombre, nombre de la distancia
     * @param valor, valor de la distancia
     */
    Distancia(String nombre,Double valor){
        this.nombre = nombre;
        this.valor = valor;
    }

    /**
     * Devuelve el nombre de la distancia
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el valor de la distancia
     *
     * @return valor
     */
    public Double getValor() {
        return valor;
    }
}
