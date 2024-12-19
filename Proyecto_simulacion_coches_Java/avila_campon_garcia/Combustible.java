 

public enum Combustible {

    ESCASO("ESCASO",350.0),
    NORMAL("NORMAL",440.0),
    GENEROSO("GENEROSO",460.0),
    ELEFANTE("ELEFANTE",480.0),
    ;

    private final String nombre;
    private final Double valor;

    /**
     * Constructor de la clase Combustible de tipo enum que inicializa sus atributos nombre(String) y valor(Double)
     *
     * @param nombre,nombre de la combustible
     * @param valor,valor de la combustible
     */
    Combustible(String nombre,Double valor){
        this.nombre = nombre;
        this.valor = valor;
    }

    /**
     * Devuelve el nombre del combustible
     *
     * @return nombre
     */
    public String getNombre() {

        return nombre;
    }

    /**
     * Devuelve el valor del combustible
     *
     * @return valor
     */
    public Double getValor() {

        return valor;
    }

}
