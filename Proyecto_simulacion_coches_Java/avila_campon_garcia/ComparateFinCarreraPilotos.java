 

public class ComparateFinCarreraPilotos extends ComparateOfPilotos{

    /**
     * Este método se encarga de realizar el comparador de dos pilotos por el total de puntos obtenidos, en caso de que
     * tengan los mismos puntos, se comparará por el número de carreras terminadas y en caso de que también sea igual, se
     * comparará por los nombres alfabeticamente
     *
     * @param p1, primer piloto {@code piloto} a comparar
     * @param p2, segundo piloto {@code piloto} a comparar
     * @return el valor {@code 0} si {@code p1 == p2} En este caso se compararía por el número de carreras terminadas, y
     * en caso de que tambíen sea igual, se comparará por los nombres alfabeticamente
     *         el valor mayor a {@code 0} si {@code p1>p2}
     *         el valor menor a {@code 0} si {@code p1<p2}
     */
    @Override
    public int compare(Piloto p1, Piloto p2){
        if(p1.totalPuntos().equals(p2.totalPuntos())){
            if(p1.getCarrerasTerminadas().equals(p2.getCarrerasTerminadas())){
                return p1.getNombre().compareTo(p2.getNombre());
            }else{
                return p1.getCarrerasTerminadas().compareTo(p2.getCarrerasTerminadas());
            }
        }else{
            return p1.totalPuntos().compareTo(p2.totalPuntos());
        }
    }
}
