 


import java.util.Collections;
import java.util.LinkedList;

public class EstrategiaCochesAsc implements EstrategiasCoches {
    /**
     * Este método se encarga de ejecutar la estrategia de ordenación de Coches de manera ascendente
     *
     * @param listacoches, lista de coches que se quiere ordenar
     */
    @Override
    public void EjecutarEstrategia(LinkedList<Coche> listacoches) {
        Collections.sort(listacoches,new ComparateCombustible());

    }
}
