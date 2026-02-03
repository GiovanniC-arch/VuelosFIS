package DAO;

import opp.Model.*;
import java.util.*;

public class VueloArchivoDAO implements VueloDAO {

    @Override
    public List<Vuelo> obtenerVuelos() {

        List<Vuelo> vuelos = new ArrayList<>();

        Ciudad quito = new Ciudad("Quito");
        Ciudad guayaquil = new Ciudad("Guayaquil");
        Ciudad cuenca = new Ciudad("Cuenca");

        vuelos.add(new Vuelo(
                "VF101",
                new Ruta(quito, guayaquil),
                "08:00",
                30,
                120.0
        ));

        vuelos.add(new Vuelo(
                "VF202",
                new Ruta(quito, cuenca),
                "14:30",
                20,
                95.0
        ));

        return vuelos;
    }
}
