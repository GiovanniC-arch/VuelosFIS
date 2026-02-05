
package opp.Model;

public class Pasajero {
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String cedula;
    private String nacionalidad;
    private String correo;
    private String telefono;
    private String genero;
    private Asiento asiento;


    // Constructor
    public Pasajero(String nombre, String apellido, String fechaNacimiento, String cedula,
                    String nacionalidad, String correo, String telefono, String genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.cedula = cedula;
        this.nacionalidad = nacionalidad;
        this.correo = correo;
        this.telefono = telefono;
        this.genero = genero;
    }
    
    public void asignarAsiento(Asiento asiento) {
        this.asiento = asiento;
    }



    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    
    public Asiento getAsiento() {
        return asiento;
    }


    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + cedula;
    }

}
