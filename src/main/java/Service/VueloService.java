package Service;

import opp.Model.Vuelo;
import java.util.List;

public interface VueloService {

    List<Vuelo> buscarVuelos(
        String origen,
        String destino,
        boolean soloIda,
        int pasajeros
    );

    List<String> filtrarCiudades(String texto);
}
