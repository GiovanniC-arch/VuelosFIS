
package opp.Controller;

import opp.Repository.VueloRepository;
import java.util.List;
import java.util.stream.Collectors;
import opp.Model.Vuelo;


public class BusquedaController {
    private VueloRepository vueloRepo;

    public BusquedaController() {
        // Aquí pasamos el nombre del archivo dentro de Repositorios
        vueloRepo = new VueloRepository("vuelos.csv");
    }

    public List<Vuelo> buscarVuelos(String origenNombre, String destinoNombre) {
        return vueloRepo.getVuelos().stream()
            .filter(v -> v.getOrigen().getNombre().equalsIgnoreCase(origenNombre)
                      && v.getDestino().getNombre().equalsIgnoreCase(destinoNombre))
            .collect(Collectors.toList());
    }


}
