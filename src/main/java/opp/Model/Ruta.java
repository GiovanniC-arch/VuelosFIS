package opp.Model;

public class Ruta {

    private Ciudad origen;
    private Ciudad destino;

    public Ruta(Ciudad origen, Ciudad destino) {
        this.origen = origen;
        this.destino = destino;
    }

    public Ciudad getOrigenCiudad() {
        return origen;
    }

    public Ciudad getDestinoCiudad() {
        return destino;
    }

    public String getOrigen() {
        return origen.getNombre();
    }

    public String getDestino() {
        return destino.getNombre();
    }
}
