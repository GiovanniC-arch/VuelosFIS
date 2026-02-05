package opp.Model;

import java.time.LocalDate;

public class Vuelo {
    private Ciudad origen;
    private Ciudad destino;
    private String horaSalida;
    private String horaLlegada;
    private String duracion;
    private double precio;
    private LocalDate fecha; // se asigna al confirmar la reserva

    public Vuelo(Ciudad origen, Ciudad destino, String horaSalida,
                 String horaLlegada, String duracion, double precio, LocalDate fecha) {
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.duracion = duracion;
        this.precio = precio;
        this.fecha = fecha;
    }

    public Ciudad getOrigen() { return origen; }
    public Ciudad getDestino() { return destino; }
    public String getHoraSalida() { return horaSalida; }
    public String getHoraLlegada() { return horaLlegada; }
    public String getDuracion() { return duracion; }
    public double getPrecio() { return precio; }
    public LocalDate getFecha() { return fecha; }

    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

}
