package opp.Controller;

import opp.Repository.CiudadRepository;
import java.util.List;
import opp.Model.Ciudad;


public class VueloController {
    private CiudadRepository ciudadRepo;

    public VueloController() {
        ciudadRepo = new CiudadRepository("ciudades.csv");
    }

    public List<Ciudad> getTodasCiudades() {
        return ciudadRepo.getCiudades();
    }

    public List<Ciudad> filtrarCiudades(String texto) {
        return ciudadRepo.filtrarPorNombre(texto);
    }


}
