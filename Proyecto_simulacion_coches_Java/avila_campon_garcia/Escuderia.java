 

import java.util.LinkedList;
import java.util.Locale;

public class Escuderia {
    protected String nombre;
    private LinkedList<Piloto> pilotos;
    private LinkedList<Coche> coches;
    private EstrategiasPilotos estrategiaPilotos;
    private EstrategiasCoches estrategiaCoches;

    /**
     * Constructor de la clase Escuderia, se encarga de inicializar sus atributos
     *
     * @param nombre_e, nombre de la escuderia
     */

    public Escuderia(String nombre_e) {
        this.nombre = nombre_e;
        this.pilotos = new LinkedList<>();
        this.coches = new LinkedList<>();
    }

    /**
     * Este método devuelve el nombre de la escuderia
     *
     * @return nombre
     */
    public String GetNombre() {
        return nombre;
    }

    /**
     * Este método se encarga de poner el nombre la escuderia pasado por parámetros en el atributo nombre
     *
     * @param nombre, nombre de la escuderia
     */

    public void SetNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Este método se encarga de crear una nueva instancia en la organizacion y de esta manera la escuderia se inscribe
     * en la organización
     */
    public void InscribirseEnOrganizacion() {
        Organizacion.getInstance().Inscripcion(this);
    }

    /**
     * Este método recorre la LinkedList de pilotos y devuelve el total de puntos de sus pilotos
     *
     * @return total de puntos de sus pilotos
     */
    public Double GetPuntuacionPilotos() {
        double acum = 0.0;
        for (Piloto aux : this.pilotos) {
            acum += aux.totalPuntos();
        }
        return acum;
    }

    public Double GetPuntuacionPilotosNoDescalificados() {
        double acum = 0.0;
        for (Piloto aux : this.pilotos) {
            if (aux.getDescalificado() == false)
                acum += aux.totalPuntos();
        }
        return acum;
    }
    /**
     * Este método se encarga de añadir el coche pasado por parámetros en la LinkedList de coches
     *
     * @param cocheDefault, coche se quiere añadir a la LinkedList de coches
     */
    public void addCoche(Coche cocheDefault) {
        this.coches.add(cocheDefault);
    }

    /**
     * Este método se encarga de añadir el piloto pasado por parámetros en la LinkedList de pilotos
     *
     * @param piloto, piloto que se quiere añadir a la LinkedList de pilotos
     */
    public void addPiloto(Piloto piloto) {
        this.pilotos.add(piloto);
    }

    /**
     * Este método se encarga de poner la estrategia de pilotos pasada por paramámetros en el atributo estrategiaPilotos
     *
     * @param estrategia, estrategia de ordenación de pilotos
     */
    public void SetEstrategiaPilotos(EstrategiasPilotos estrategia) {
        this.estrategiaPilotos = estrategia;
    }

    /**
     * Este método se encarga de poner la estrategia de coches pasada por parámetros en el atributo estrategiaCoches
     *
     * @param estrategia, estrategia de ordenación de coches
     */
    public void SetEstrategiaCoches(EstrategiasCoches estrategia) {
        this.estrategiaCoches = estrategia;
    }

    /**
     * Este método se encarga de ejecutar la estrategia de ordenación de pilotos
     */
    public void OrdenarPilotos() {
        this.estrategiaPilotos.EjecutarEstrategia(this.pilotos);
    }

    /**
     * Este método se encarga de ejecutar la estrategia de ordenación de coches
     */
    public void OrdenarCoches() {
        this.estrategiaCoches.EjecutarEstrategia(this.coches);
    }

    /**
     * Este método se encarga de que la escudería reciba el piloto una vez ha terminado la carrera
     *
     * @param piloto, piloto de la escuderia que ha terminado la carrera
     */
    public void recibirPilotoDeCarrera(Piloto piloto) {
        this.pilotos.add(piloto);
    }

    /**
     * Este método devuelve el número de carreras terminadas que han realizado entre los pilotos de la escudería
     *
     * @return terminadas
     */
    public Integer getTotalCarrerasTerminadas() {
        Integer terminadas = 0;
        for (Piloto piloto : pilotos) {
            terminadas += piloto.getCarrerasTerminadas();
        }
        return terminadas;
    }

    /**
     * Método que se encarga de asginar al piloto pasado por parámetros el siguiente coche disponible en la LinkedList de coches
     *
     * @param piloto, piloto al que se le quiere asignar el coche
     * @return devuelve true si se ha podido asignar el coche al piloto y false en caso de que no haya sido sido posible por
     * falta de coches disponibles
     */
    //Metodo que asigna el siguiente coche disponible de la lista de coches al piloto pasado
    private boolean AsignarCochePiloto(Piloto piloto) {
        for (Coche cocheDefault : coches) {
            if (!cocheDefault.getAsignado() && cocheDefault.getCombustible() > 0) {
                cocheDefault.setAsignado(true);
                piloto.setCoche(cocheDefault);
                return true;
            }
        }
        return false; //No se le ha podido asignar el coche porque no hay mas coches disponibles
    }

    /**
     * Método que se encarga de comprobar si la escuderia tiene pilotos disponibles para la carrera
     *
     * @return devuelve true si hay pilotos disponibles y false en caso de que no los haya
     */
    //Metodo que antes de pedir pilotos dice si tiene o no disponibles
    public Boolean PilotosDisponibles() {
        for (Piloto piloto : pilotos) {
            if (!piloto.getDescalificado()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Este método se encarga de devolver el número de pilotos que no están descalificados por lo que pueden competir
     *
     * @return número de pilotos aptos para competir
     */
    public Integer PilotosCompetir() {
        int cuantos=0;
        for (Piloto piloto : pilotos) {
            if (!piloto.getDescalificado()) {
                cuantos++;
            }
        }
        return cuantos;
    }

    /**
     * Este método se encarga de devolver el piloto disponible de la escuderia y en caso de que no hay ninguno disponible devuelve null
     *
     * @return devuelve el piloto disponible de la escuderia y en caso de que no hay ninguno devuelve null
     */

    //Devuelve piloto si tiene coches para darle si no devuelve null con lo cual pasamos a la siguiente escuderia
    public Piloto DevolverPilotoDisponible() {
        for (int i = 0; i < pilotos.size(); i++) {
            if (!pilotos.get(i).getDescalificado()) {
                if (AsignarCochePiloto(pilotos.get(i))) {
                    return pilotos.remove(i);
                } else {
                    return pilotos.get(i);
                }
            }
        }
        return null;
    }

    /**
     * Devuelve el piloto de la LinkedList en la posición pasada por parámetros
     */

    public Piloto DevolverPiloto(int i) {
            return pilotos.get(i);
    }

    /**
     * Devuelve el número de pilotos que hay en la LinkedList de pilotos
     *
     * @return tamaño de la LinkedList de pilotos
     */
   public int NumeroPilotos() {
        return pilotos.size();
    }

    /**
     * Este método saca por pantalla los pilotos que están descalificados y cuáles no, y también los coches que tienen
     * combustibles y los coches que se han quedado sin combustible
     *
     * @return String con toda la información de la situación final de la carrera(descalificación y combustible)
     */
    public String MostrarSituacionFinal() {
        this.OrdenarCoches();
        this.OrdenarPilotos();
        StringBuilder stringBuilderr = new StringBuilder();
        for (Piloto piloto : pilotos) {
            if (piloto.getDescalificado() == false) {
                stringBuilderr.append(piloto.toString() + "\n");
            }

        }
        for (Piloto piloto : pilotos) {
            if (piloto.getDescalificado() == true) {
                stringBuilderr.append(piloto.toString() + "\n");
            }
        }

        for (Coche coche:coches) {
            if(coche.getCombustible()>0)
            stringBuilderr.append(coche.toString()+"\n");
        }
        for (Coche coche:coches) {
            if(coche.getCombustible()<=0)
            stringBuilderr.append(coche.toString()+"\n");
        }


        return stringBuilderr.toString();
    }

    /**
     * Método mostrar de la clase Escuderia que se encarga de mostrar por pantalla toda la información de la escudería
     *
     * @return devuelve un string con la información de la escuderia
     */
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
        stringBuilder.append("%%% "+this.GetNombre().toUpperCase(Locale.ROOT)+" %%%\n");
        for (Piloto piloto:pilotos) {
            stringBuilder.append(piloto.toString()+"\n");
        }
        for (Coche coche:coches) {
            stringBuilder.append(coche.toString()+"\n");
        }
        stringBuilder.append("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        return stringBuilder.toString();
    }
}
