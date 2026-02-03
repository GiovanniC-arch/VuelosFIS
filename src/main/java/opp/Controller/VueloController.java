package opp.Controller;

import Service.VueloService;
import opp.Model.Ciudad;
import opp.Model.Vuelo;
import java.util.List;

public class VueloController {

    private VueloService vueloService;

    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    public List<Vuelo> buscarVuelos(String origen, String destino, int pasajeros, boolean soloIda) {
        return vueloService.buscarVuelos(origen, destino, soloIda, pasajeros);
    }

    public List<Ciudad> filtrarCiudades(String texto) {
        return vueloService.filtrarCiudades(texto);
    }
}
