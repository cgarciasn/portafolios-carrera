 


public class ComparateConcentracion extends ComparateOfPilotos {

    /**
     * Este método se encarga de realizar el comparador de dos pilotos por la concentración, en caso de que tengan la
     * misma concentración, se comparará por los nombres alfabeticamente
     *
     * @param p1, primer piloto {@code piloto} a comparar
     * @param p2, segundo piloto {@code piloto} a comparar
     * @return el valor {@code 0} si {@code p1 == p2} En este caso se compararía por la destreza de los pilotos
     *         el valor mayor a {@code 0} si {@code p1>p2}
     *         el valor menor a {@code 0} si {@code p1<p2}
     */
    @Override
    public int compare(Piloto p1, Piloto p2) {
        if(p1.getConcentracion().getValor().equals(p2.getConcentracion().getValor()))
            return new ComparateDestreza().compare(p1,p2);
        else{
            return p1.getConcentracion().getValor().compareTo(p2.getConcentracion().getValor());
        }
    }
}
