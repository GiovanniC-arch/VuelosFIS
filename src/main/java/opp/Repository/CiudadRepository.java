package opp.Repository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import opp.Model.Ciudad;

public class CiudadRepository {
    private List<Ciudad> ciudades;

    public CiudadRepository(String archivo) {
        ciudades = new ArrayList<>();
        cargarCiudades(archivo);
    }

    private void cargarCiudades(String archivo) {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream("Repositorios/" + archivo)))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    ciudades.add(new Ciudad(partes[0].trim(), partes[1].trim()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public List<Ciudad> filtrarPorNombre(String texto) {
        return ciudades.stream()
                .filter(c -> c.getNombre().toLowerCase().contains(texto.toLowerCase())
                          || c.getCodigo().toLowerCase().contains(texto.toLowerCase()))
                .collect(Collectors.toList());
    }

}

    
