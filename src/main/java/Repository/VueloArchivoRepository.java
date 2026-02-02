package Repository;

import opp.Model.*;
import java.util.ArrayList;
import java.util.List;

public class VueloArchivoRepository implements VueloRepository {

    @Override
    public List<Vuelo> obtenerTodos() {
        List<Vuelo> vuelos = new ArrayList<>();

        vuelos.add(new Vuelo(
                "VF-101",
                new Ruta("Quito", "Guayaquil"),
                new Avion("Boeing 737", 180),
                java.time.LocalDateTime.now().plusDays(1),
                120.0
        ));

        return vuelos;
    }

    @Override
    public Vuelo buscarPorCodigo(String codigo) {
        return obtenerTodos()
                .stream()
                .filter(v -> v.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }
}
