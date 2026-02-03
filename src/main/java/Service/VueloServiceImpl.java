package Service;

import DAO.VueloDAO;
import opp.Model.Vuelo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VueloServiceImpl implements VueloService {

    private VueloDAO vueloDAO;

    public VueloServiceImpl(VueloDAO vueloDAO) {
        this.vueloDAO = vueloDAO;
    }

    @Override
    public List<Vuelo> buscarVuelos(
            String origen,
            String destino,
            boolean soloIda,
            int pasajeros) {

        return vueloDAO.obtenerVuelos().stream()
                .filter(v -> v.getRuta().getOrigen().equalsIgnoreCase(origen))
                .filter(v -> v.getRuta().getDestino().equalsIgnoreCase(destino))
                .filter(v -> v.getAsientosDisponibles() >= pasajeros)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> filtrarCiudades(String texto) {
        return vueloDAO.obtenerVuelos().stream()
                .flatMap(v -> Stream.of(
                        v.getRuta().getOrigen(),
                        v.getRuta().getDestino()
                ))
                .distinct()
                .filter(c -> c.toLowerCase().contains(texto.toLowerCase()))
                .collect(Collectors.toList());
    }
}
