 


public class ComparateVelocidad extends ComparateOfCoches {

    /**
     * Este método se encarga de realizar el comparador de dos coche por la velocidad, en caso de que tengan la misma velocidad
     * se comparará por el combustible de los coches.
     *
     * @param c1, primer coche {@code coche} a comparar
     * @param c2, segundo piloto {@code coche} a comparar
     * @return el valor {@code 0} si {@code c1 == c2} En este caso se compararía por la cantidad de combustible
     *         el valor mayor a {@code 0} si {@code c1>c2}
     *         el valor menor a {@code 0} si {@code c1<c2}
     */
    @Override
    public int compare(Coche c1, Coche c2) {
        if (c1.getVelocidad().getValor().equals(c2.getVelocidad().getValor()))
            return new ComparateCombustible().compare(c1, c2);
        else{
            return c1.getVelocidad().getValor().compareTo(c2.getVelocidad().getValor());
        }
    }
}
