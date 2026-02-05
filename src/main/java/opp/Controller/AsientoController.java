
package opp.Controller;

import javax.swing.table.DefaultTableModel;
import oop.Service.AsientoService;
import opp.Model.Asiento;
import opp.Model.Pasajero;


public class AsientoController {
    private AsientoService asientoService;

    public AsientoController() {
        this.asientoService = new AsientoService();
    }

    public void seleccionarAsiento(Pasajero pasajero, Asiento asiento, DefaultTableModel modelo) {
        if (asientoService.asignarAsiento(pasajero, asiento)) {
            modelo.addRow(new Object[]{
                pasajero.getNombre(),
                asiento.getCodigo(),
                asiento.getPrecio()
            });
        }
    }

    
}
