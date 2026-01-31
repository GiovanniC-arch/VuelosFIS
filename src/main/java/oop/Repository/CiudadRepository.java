
package oop.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import opp.Model.Ciudad;

public class CiudadRepository {
    private List<Ciudad> ciudades = new ArrayList<>();

    public CiudadRepository(String nombreArchivo) {
        cargarCiudades(nombreArchivo);
    }

    private void cargarCiudades(String nombreArchivo) {
    try (InputStream is = getClass().getClassLoader()
            .getResourceAsStream("Repositorios/" + nombreArchivo);
         BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(",");
            if (partes.length == 2) {
                ciudades.add(new Ciudad(partes[0].trim(), partes[1].trim()));
            }
        }

        // Prueba rápida: imprimir lo que se cargó
        for (Ciudad c : ciudades) {
            System.out.println("Ciudad cargada: " + c.getNombre());
        }

    } catch (IOException | NullPointerException e) {
        System.err.println("Error al leer archivo en resources: " + nombreArchivo);
        e.printStackTrace();
      }
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public List<Ciudad> filtrarPorNombre(String texto) {
        texto = texto.toLowerCase();
        List<Ciudad> filtradas = new ArrayList<>();
        for (Ciudad c : ciudades) {
            if (c.getNombre().toLowerCase().startsWith(texto)) {
                filtradas.add(c);
            }
        }
        return filtradas;
    }
}
    
