 



public class ComparateCarrerasRealizadas extends ComparateOfPilotos{
    /**
     * Este método se encarga de realizar el comparador de dos pilotos por el número de carreras realizadas
     * en caso de que hayan realizado el mismo número de tareas, se comparará por los nombres alfabeticamente
     *
     * @param p1, primer piloto {@code piloto} a comparar
     * @param p2, segundo piloto {@code piloto} a comparar
     * @return el valor {@code 0} si {@code p1 == p2} En este caso se compararía por los nombres alfabeticamente
     *         el valor mayor a {@code 0} si {@code p1>p2}
     *         el valor menor a {@code 0} si {@code p1<p2}
     */
    @Override
    public int compare(Piloto p1, Piloto p2){
        if(p1.getCarrerasRealizadas().equals(p2.getCarrerasRealizadas())){
            return (p1.getNombre().compareTo(p2.getNombre()));
        }else{
            return p1.getCarrerasRealizadas().compareTo(p2.getCarrerasRealizadas());
        }
    }
}
