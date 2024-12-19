 

public enum Complejidad {

    BAJA("BAJA",1.0),
    MEDIA("MEDIA",1.25),
    ALTA("ALTA",1.5);

    private final String nombre;
    private final Double valor;

    /**
     * Constructor de la clase Complejidad de tipo enum que inicializa sus atributos nombre(String) y valor(Double)
     *
     * @param nombre,nombre de la complejidad
     * @param valor,valor de la complejidad
     */
    Complejidad(String nombre,Double valor){
        this.nombre = nombre;
        this.valor = valor;
    }

    /**
     * Devuelve el nombre de la complejidad
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el valor de la complejidad
     *
     * @return valor
     */
    public Double getValor() {

        return valor;
    }
}
