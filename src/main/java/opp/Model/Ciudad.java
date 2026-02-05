package opp.Model;

public class Ciudad {

   private String nombre;
    private String codigo;

    public Ciudad(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getNombre() { 
        return nombre; 
    }
    public String getCodigo() { 
        return codigo; 
    }

    @Override
    public String toString() {
        return nombre + " (" + codigo + ")";
    }

}
