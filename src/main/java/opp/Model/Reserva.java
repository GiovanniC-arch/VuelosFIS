
package opp.Model;

import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private Ciudad origen;
    private Ciudad destino;
    private String tipoVuelo;
    private String fechaIda;
    private String fechaVuelta;
    private int pasajeros;
    private Vuelo vueloIda;
    private Vuelo vueloVuelta;
    private boolean esIdaVuelta;

    // Listas de asientos seleccionados
    private List<String> asientosIda;
    private List<String> asientosVuelta;

    // NUEVO: lista de pasajeros
    private List<Pasajero> listaPasajeros;

    public Reserva(Ciudad origen, Ciudad destino, String tipoVuelo,
                   String fechaIda, String fechaVuelta, int pasajeros) {
        this.origen = origen;
        this.destino = destino;
        this.tipoVuelo = tipoVuelo;
        this.fechaIda = fechaIda;
        this.fechaVuelta = fechaVuelta;
        this.pasajeros = pasajeros;
        this.esIdaVuelta = (fechaVuelta != null && !fechaVuelta.isEmpty());
        this.asientosIda = new ArrayList<>();
        this.asientosVuelta = new ArrayList<>();
        this.listaPasajeros = new ArrayList<>();
    }

    // Getters y setters
    public Ciudad getOrigen() { return origen; }
    public Ciudad getDestino() { return destino; }
    public String getTipoVuelo() { return tipoVuelo; }
    public String getFechaIda() { return fechaIda; }
    public String getFechaVuelta() { return fechaVuelta; }
    public int getPasajeros() { return pasajeros; }
    public Vuelo getVueloIda() { return vueloIda; }
    public Vuelo getVueloVuelta() { return vueloVuelta; }
    public boolean isEsIdaVuelta() { return esIdaVuelta; }

    public void setVueloIda(Vuelo vueloIda) { this.vueloIda = vueloIda; }
    public void setVueloVuelta(Vuelo vueloVuelta) { this.vueloVuelta = vueloVuelta; }

    public List<String> getAsientosIda() { return asientosIda; }
    public List<String> getAsientosVuelta() { return asientosVuelta; }

    public void addAsientoIda(String asiento) { asientosIda.add(asiento); }
    public void addAsientoVuelta(String asiento) { asientosVuelta.add(asiento); }

    // NUEVO: manejo de pasajeros
    public void addPasajero(Pasajero pasajero) {
        if (listaPasajeros.size() < pasajeros) {
            listaPasajeros.add(pasajero);
        }
    }

    public List<Pasajero> getListaPasajeros() {
        return listaPasajeros;
    }

}

