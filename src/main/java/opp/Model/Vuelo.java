package opp.Model;

public class Vuelo {

    private String codigo;
    private Ruta ruta;
    private String hora;
    private int asientosDisponibles;
    private double precio;

    public Vuelo(String codigo, Ruta ruta, String hora, int asientosDisponibles, double precio) {
        this.codigo = codigo;
        this.ruta = ruta;
        this.hora = hora;
        this.asientosDisponibles = asientosDisponibles;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public String getHora() {
        return hora;
    }

    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public double getPrecio() {
        return precio;
    }
}
