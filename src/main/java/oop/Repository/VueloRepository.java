
package oop.Repository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import opp.Model.Ciudad;
import opp.Model.Vuelo;


public class VueloRepository {
    private List<Vuelo> vuelos = new ArrayList<>();

    public VueloRepository(String archivo) {
        cargarVuelos(archivo);
    }

    private void cargarVuelos(String archivo) {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                    getClass().getClassLoader().getResourceAsStream("Repositorios/" + archivo)))) {
            
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 8) {
                    // Usamos nombre de ciudad como identificador real
                    Ciudad origen = new Ciudad(partes[0].trim(), partes[0].trim());   // Quito
                    Ciudad destino = new Ciudad(partes[2].trim(), partes[2].trim()); // Guayaquil
                    String horaSalida = partes[4].trim();
                    String horaLlegada = partes[5].trim();
                    String duracion = partes[6].trim();
                    double precio = Double.parseDouble(partes[7].trim());

                    vuelos.add(new Vuelo(origen, destino, horaSalida, horaLlegada, duracion, precio, null));
                }
            }
            System.out.println("Archivo cargado: " + archivo + " vuelos=" + vuelos.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }



}


    


