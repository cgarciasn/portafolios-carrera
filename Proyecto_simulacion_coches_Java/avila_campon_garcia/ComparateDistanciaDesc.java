 


public class ComparateDistanciaDesc extends ComparateOfCircuitos{
    /**
     * Este método se encarga de realizar el comparador de dos circuitos por la distancia, en caso de que tengan la misma
     * distancia, se comparará por los nombres alfabeticamente
     *
     * @param cir1, primer circuito {@code circuito} a comparar
     * @param cir2, segundo circuito {@code circuito} a comparar
     * @return el valor {@code 0} si {@code cir1 == cir2} En este caso se compararía por los nombres alfabeticamente
     *         el valor mayor a {@code 0} si {@code cir1>cir2}
     *         el valor menor a {@code 0} si {@code cir1<cir2}
     */
    public int compare(Circuito cir1, Circuito cir2){
        if(cir1.getDistanciaActual() == cir2.getDistanciaActual()){
            return cir1.getNombre().compareTo(cir2.getNombre())*-1;
        }else{
            return cir1.getDistanciaActual().compareTo(cir2.getDistanciaActual())*-1;
        }
    }
}
