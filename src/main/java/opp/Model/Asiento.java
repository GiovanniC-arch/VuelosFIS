
package opp.Model;


public class Asiento {
    private String codigo;
    private boolean ocupado;
    private double precio = 12.0;

    public Asiento(String codigo) {
        this.codigo = codigo;
        this.ocupado = false;
    }

    public String getCodigo() { return codigo; }
    public boolean isOcupado() { return ocupado; }
    public void ocupar() { this.ocupado = true; }
    public double getPrecio() { return precio; }

    
}
