 


public class ComparateComplejidad extends ComparateOfCircuitos {

    /**
     * Este método se encarga de realizar el comparador de dos circuitos por la complejidad, en caso de que tengan la
     * misma complejidad, se comparará por los nombres alfabeticamente
     *
     * @param cir1, primer circuito {@code circuito} a comparar
     * @param cir2, segundo circuito {@code circuito} a comparar
     * @return el valor {@code 0} si {@code cir1 == cir2} En este caso se compararía por los nombres alfabeticamente
     *         el valor mayor a {@code 0} si {@code cir1>cir2}
     *         el valor menor a {@code 0} si {@code cir1<cir2}
     */
    @Override
    public int compare(Circuito cir1, Circuito cir2){
        if(cir1.getComplejidadActual().equals(cir2.getComplejidadActual()))
            return (cir1.getNombre().compareTo(cir2.getNombre()));
        else{
            return cir1.getDistanciaActual().compareTo(cir2.getComplejidadActual());
        }
    }
}
