
package Repository;

import opp.Model.Vuelo;
import java.util.List;

public interface VueloRepository {

    List<Vuelo> obtenerTodos();

    Vuelo buscarPorCodigo(String codigo);
}
