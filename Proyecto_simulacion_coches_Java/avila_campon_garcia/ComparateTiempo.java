 


public class ComparateTiempo extends ComparateOfPilotos{

    /**
     * Este método se encarga de realizar el comparador de dos pilotos por el tiempo de la carrera actual, en caso de que tengan
     * el mismo tiempo, se comparará por el número de carreras realizadas
     *
     * @param p1, primer piloto {@code piloto} a comparar
     * @param p2, segundo piloto {@code piloto} a comparar
     * @return el valor {@code 0} si {@code p1 == p2} En este caso se compararía por el número de las carreras realizadas
     *         el valor mayor a {@code 0} si {@code p1>p2}
     *         el valor menor a {@code 0} si {@code p1<p2}
     */
    @Override
    public int compare(Piloto p1, Piloto p2){
        if(p1.getTiempoCarreraActual().equals(p2.getTiempoCarreraActual())){
            return new ComparateCarrerasRealizadas().compare(p1,p2);
        }else{
            return p1.getTiempoCarreraActual().compareTo(p2.getTiempoCarreraActual());
        }
    }
}
