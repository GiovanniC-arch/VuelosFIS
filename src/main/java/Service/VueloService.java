
package Service;

import opp.Model.Vuelo;
import Repository.VueloRepository;
import java.util.List;

public class VueloService {

    private final VueloRepository vueloRepository;

    public VueloService(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    public List<Vuelo> listarVuelos() {
        return vueloRepository.obtenerTodos();
    }

    public Vuelo buscarVuelo(String codigo) {
        return vueloRepository.buscarPorCodigo(codigo);
    }
}
