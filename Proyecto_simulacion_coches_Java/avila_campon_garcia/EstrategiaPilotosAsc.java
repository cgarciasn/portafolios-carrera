 



import java.util.Collections;
import java.util.LinkedList;

public class EstrategiaPilotosAsc implements EstrategiasPilotos {
    /**
     * Este método se encarga de ejecutar la estrategia de ordenación de Pilotos de manera ascendente
     *
     * @param listapilotos, lista de pilotos que se quiere ordenar
     */
    @Override
    public void EjecutarEstrategia(LinkedList<Piloto> listapilotos) {
        listapilotos.sort(new ComparatePuntos());
    }
}
