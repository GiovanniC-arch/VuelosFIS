package Repository;

import opp.Model.Ciudad;
import java.util.List;

public class CiudadRepository {

    public List<Ciudad> obtenerCiudades() {
        return List.of(
                new Ciudad("Quito"),
                new Ciudad("Guayaquil"),
                new Ciudad("Cuenca")
        );
    }
}

    
