
package oop.Service;

import opp.Model.Reserva;
import opp.Model.Vuelo;

public class ReservaService {
    public double calcularPrecioBase(String tipoVuelo, double precioVuelo) {
        if (tipoVuelo.equalsIgnoreCase("Clase premium")) {
            return precioVuelo * 1.4; // 40% más caro
        }
        return precioVuelo; // Clase económica
    }

    
    public boolean validarFechas(String fechaIda, String fechaVuelta, boolean esIdaVuelta) {
        if (fechaIda == null || fechaIda.isEmpty()) {
            return false;
        }
        if (esIdaVuelta) {
            return fechaVuelta != null && !fechaVuelta.isEmpty();
        }
        return true;
    }

    
    public double calcularTotal(Reserva reserva) {
        double total = 0;

        Vuelo vueloIda = reserva.getVueloIda();
        Vuelo vueloVuelta = reserva.getVueloVuelta();

        if (vueloIda != null) {
            total += calcularPrecioBase(reserva.getTipoVuelo(), vueloIda.getPrecio());
        }
        if (reserva.isEsIdaVuelta() && vueloVuelta != null) {
            total += calcularPrecioBase(reserva.getTipoVuelo(), vueloVuelta.getPrecio());
        }

        // Multiplicar por número de pasajeros
        total *= reserva.getPasajeros();

        return total;
    }

}
