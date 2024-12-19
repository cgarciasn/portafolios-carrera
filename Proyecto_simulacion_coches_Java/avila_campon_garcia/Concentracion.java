 

public enum Concentracion {

    DESPISTADO("DESPISTADO",90.0),
    NORMAL("NORMAL",100.0),
    CONCENTRADO("CONCENTRADO",110.0),
    ZEN("ZEN",120.0);

    private final String nombre;
    private final Double valor;

    /**
     * Constructor de la clase Concentración de tipo enum que inicializa sus atributos nombre(String) y valor(Double)
     *
     * @param nombre,nombre de la concentración
     * @param valor,valor de la concentración
     */

    Concentracion(String nombre,double valor){
        this.nombre = nombre;
        this.valor = valor;
    }

    /**
     * Devuelve el nombre de la concentración
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el valor de la concentración
     *
     * @return valor
     */
    public Double getValor() {
        return valor;
    }
}
