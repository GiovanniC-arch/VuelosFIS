
package opp.Repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import opp.Model.Vuelo;


public class OcupacionAsientosRepository {
    private Map<String, Set<String>> ocupados = new HashMap<>();
    private final String archivo = "src/main/java/RepoDinamicos/ocupacion.csv";

    public OcupacionAsientosRepository() {
        // Al iniciar, cargamos ocupación desde CSV
        cargarOcupacionDesdeCSV();
    }

    // Genera clave única por vuelo (ida/vuelta diferenciados)
    private String generarClaveVuelo(Vuelo vuelo, boolean esVuelta) {
        return vuelo.getOrigen().getNombre() + "-" +
               vuelo.getDestino().getNombre() + "-" +
               vuelo.getFecha().toString() + "-" +
               vuelo.getHoraSalida() + "-" +
               vuelo.getHoraLlegada() + "-" +
               (esVuelta ? "VUELTA" : "IDA");
    }

    // Marcar asiento como ocupado
    public void ocuparAsiento(Vuelo vuelo, String codigoAsiento, boolean esVuelta) {
        String clave = generarClaveVuelo(vuelo, esVuelta);
        ocupados.putIfAbsent(clave, new HashSet<>());
        ocupados.get(clave).add(codigoAsiento);
        guardarOcupacionEnCSV(); // Guardamos inmediatamente
    }

    // Verificar si un asiento está ocupado
    public boolean estaOcupado(Vuelo vuelo, String codigoAsiento, boolean esVuelta) {
        String clave = generarClaveVuelo(vuelo, esVuelta);
        return ocupados.containsKey(clave) && ocupados.get(clave).contains(codigoAsiento);
    }

    // Guardar ocupación en CSV dinámico
    private void guardarOcupacionEnCSV() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Map.Entry<String, Set<String>> entry : ocupados.entrySet()) {
                String clave = entry.getKey();
                for (String asiento : entry.getValue()) {
                    pw.println(clave + "," + asiento);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Cargar ocupación desde CSV dinámico
    private void cargarOcupacionDesdeCSV() {
        File file = new File(archivo);
        if (!file.exists()) {
            return; // Si no existe, no hacemos nada
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    String clave = partes[0];
                    String asiento = partes[1];
                    ocupados.putIfAbsent(clave, new HashSet<>());
                    ocupados.get(clave).add(asiento);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



