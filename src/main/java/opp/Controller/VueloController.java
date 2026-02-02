
package opp.Controller;

import java.util.List;
import Repository.CiudadRepository;
import opp.Model.Ciudad;


public class VueloController {
    private CiudadRepository ciudadRepo;

    // Constructor: aquí se crea el repositorio y se carga el CSV
    public VueloController() {
        ciudadRepo = new CiudadRepository("ciudades.csv");

        // Prueba rápida: imprimir las ciudades cargadas
        for (Ciudad c : ciudadRepo.getCiudades()) {
            System.out.println("Ciudad cargada: " + c.getNombre());
        }
    }

    // Método para filtrar ciudades según el texto escrito
    public List<Ciudad> filtrarCiudades(String texto) {
        return ciudadRepo.filtrarPorNombre(texto);
    }

    // Método para obtener todas las ciudades (si lo necesitas en la vista)
    public List<Ciudad> getTodasCiudades() {
        return ciudadRepo.getCiudades();
    }


}

