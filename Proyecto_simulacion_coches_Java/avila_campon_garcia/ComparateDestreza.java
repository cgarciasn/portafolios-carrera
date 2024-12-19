 


public class ComparateDestreza extends ComparateOfPilotos {

    /**
     * Este método se encarga de realizar el comparador de dos pilotos por la destreza, en caso de que tengan la misma
     * destreza, se comparará por los nombres alfabeticamente
     *
     * @param p1, primer piloto {@code piloto} a comparar
     * @param p2, segundo piloto {@code piloto} a comparar
     * @return el valor {@code 0} si {@code p1 == p2} En este caso se compararía por los nombres alfabeticamente
     *         el valor mayor a {@code 0} si {@code p1>p2}
     *         el valor menor a {@code 0} si {@code p1<p2}
     */
    @Override
    public int compare(Piloto p1, Piloto p2){
        if(p1.getDestreza().equals(p2.getDestreza()))
            return (p1.getNombre().compareTo(p2.getNombre()));
        else{
            return p1.getDestreza().compareTo(p2.getDestreza());
        }
    }
}
