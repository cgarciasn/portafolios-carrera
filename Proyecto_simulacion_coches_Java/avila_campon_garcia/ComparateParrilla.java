 


public class ComparateParrilla extends ComparateOfPilotos{

    /**
     * Este método se encarga de realizar el comparador de dos pilotos para la colocación en la parrilla por el número de puntos,
     * en caso que tengan los mismos puntos se comparará por el numero de carreras terminadas de los pilotos, y en caso de que
     * tengan las mismas carreras terminadas, se comparará por los nombres alfabeticamente
     *
     * @param p1, primer piloto {@code piloto} a comparar
     * @param p2, segundo piloto {@code piloto} a comparar
     * @return el valor {@code 0} si {@code p1 == p2} En este caso se compararía por las carreras terminadas y en caso de
     * ser igual también se compararía por los nombres alfabeticamente
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
