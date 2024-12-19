 


public class ComparateCombustible extends ComparateOfCoches{

    /**
     * Este método se encarga de realizar el comparador de dos coches por el combustible, en caso de que tengan el
     * mismo combustible, se comparará por los nombres alfabeticamente
     *
     * @param c1, primer coche {@code coche} a comparar
     * @param c2, segundo coche {@code coche} a comparar
     * @return el valor {@code 0} si {@code c1 == p2} En este caso se compararía por los nombres alfabeticamente
     *         el valor mayor a {@code 0} si {@code c1>c2}
     *         el valor menor a {@code 0} si {@code c1<c2}
     */
    @Override
    public int compare(Coche c1, Coche c2){
        if(c1.getCombustible().equals(c2.getCombustible()))
            return(c1.getNombre().compareTo(c2.getNombre()));
        else{
            return c1.getCombustible().compareTo(c2.getCombustible());
        }
    }
}
