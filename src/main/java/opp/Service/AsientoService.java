
package opp.Service;

import opp.Model.Asiento;
import opp.Model.Pasajero;

public class AsientoService {
    public boolean asignarAsiento(Pasajero pasajero, Asiento asiento) {
        if (!asiento.isOcupado()) {
            asiento.ocupar();
            pasajero.asignarAsiento(asiento);
            return true;
        }
        return false;
    }

    public double calcularPrecio(Pasajero pasajero) {
        return pasajero.getAsiento() != null ? pasajero.getAsiento().getPrecio() : 0;
    }

    
}
