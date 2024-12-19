import java.io.FileWriter;
import java.io.PrintWriter;

public class RallyDemo {
    public static void main(String[] args) {
        //Descomentar el conjunto de datos de los 3 siguientes que se quiera probar
        //Descomentar el siguiente conjunto de datos si se quiere probar simulación del campeonato que termina de forma normal disputándose todas las carreras
        DatosCampeonatoCompleto initdata = new DatosCampeonatoCompleto();
        //Descomentar el siguiente conjunto de datos si se quiere probar simulación del campeonato que termina antes de que se realicen todas las carreras con el único piloto superviviente y su escudería declarados como campeones
        //DatosCampeonatoPremioDesierto initdata = new DatosCampeonatoPremioDesierto();
        //Descomentar el siguiente conjunto de datos si se quiere probar simulación del campeonato que termina antes de que se realicen todas las carreras sin ningún piloto superviviente y declarándose el campeonato como desierto
        //DatosCampeonatoPremioDesierto initdata = new DatosCampeonatoPremioDesierto();
        StringBuilder Competicion = new StringBuilder();
        Competicion.append(Organizacion.getInstance().mostrarCircuitosOrdenados());
        Competicion.append(Organizacion.getInstance().mostrarEscuderias());
        Competicion.append(Organizacion.getInstance().CelebrarCompeticion());
        System.out.print(Competicion.toString());
        //llamada al método de Organización que gestiona el desarrollo del campeonato
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("output.log");
            pw = new PrintWriter(fichero);
            pw.print(Competicion.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
