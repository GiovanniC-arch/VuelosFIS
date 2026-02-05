
package opp.Controller;

import oop.Repository.CiudadRepository;
import oop.Service.ReservaService;
import java.util.List;
import opp.Model.Ciudad;
import opp.Model.Reserva;
import opp.Model.Vuelo;

public class ReservaController {
    private CiudadRepository ciudadRepo;
    private ReservaService reservaService;

    public ReservaController() {
        ciudadRepo = new CiudadRepository("ciudades.csv");
        reservaService = new ReservaService();
    }

    public List<Ciudad> filtrarCiudades(String texto) {
        return ciudadRepo.filtrarPorNombre(texto);
    }

    public Reserva crearReserva(Ciudad origen, Ciudad destino, String tipoVuelo,
                                String fechaIda, String fechaVuelta, int pasajeros) {
        boolean esIdaVuelta = (fechaVuelta != null && !fechaVuelta.isEmpty());

        if (!reservaService.validarFechas(fechaIda, fechaVuelta, esIdaVuelta)) {
            throw new IllegalArgumentException("Fechas inválidas");
        }

        return new Reserva(origen, destino, tipoVuelo, fechaIda, fechaVuelta, pasajeros);
    }

    public void asignarVueloIda(Reserva reserva, Vuelo vueloIda) {
        reserva.setVueloIda(vueloIda);
    }

    public void asignarVueloVuelta(Reserva reserva, Vuelo vueloVuelta) {
        reserva.setVueloVuelta(vueloVuelta);
    }

    public void asignarAsientoIda(Reserva reserva, String asiento) {
        reserva.addAsientoIda(asiento);
    }

    public void asignarAsientoVuelta(Reserva reserva, String asiento) {
        reserva.addAsientoVuelta(asiento);
    }

    // Calcular total de vuelos + asientos
    public double calcularTotal(Reserva reserva) {
        double total = 0;

        if (reserva.getVueloIda() != null) {
            total += reserva.getVueloIda().getPrecio() * reserva.getPasajeros();
        }
        if (reserva.isEsIdaVuelta() && reserva.getVueloVuelta() != null) {
            total += reserva.getVueloVuelta().getPrecio() * reserva.getPasajeros();
        }

        // Precio fijo de asientos: 12 cada uno
        total += reserva.getAsientosIda().size() * 12.0;
        total += reserva.getAsientosVuelta().size() * 12.0;

        return total;
    }

    public ReservaService getReservaService() {
        return reservaService;
    }


}
