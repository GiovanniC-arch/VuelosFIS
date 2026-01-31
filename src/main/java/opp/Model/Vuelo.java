package opp.Model;

import java.time.LocalDateTime;

public class Vuelo {

    private String codigo;
    private Ruta ruta;
    private Avion avion;
    private LocalDateTime fechaSalida;
    private double precio;

    // Constructor vacío (JavaBeans)
    public Vuelo() {
    }

    // Constructor COMPLETO (el que usa el repository)
    public Vuelo(String codigo, Ruta ruta, Avion avion,
                 LocalDateTime fechaSalida, double precio) {
        this.codigo = codigo;
        this.ruta = ruta;
        this.avion = avion;
        this.fechaSalida = fechaSalida;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public Avion getAvion() {
        return avion;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public double getPrecio() {
        return precio;
    }
}
