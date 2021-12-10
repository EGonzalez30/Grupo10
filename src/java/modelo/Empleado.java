package modelo;

public class Empleado {
    
    private int id_empleado;
    private int dni;
    private int numero_ss;
    private String cod_trabajador;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    
    public Empleado(int id_empleado){
        this.id_empleado = id_empleado;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getNumero_ss() {
        return numero_ss;
    }

    public void setNumero_ss(int numero_ss) {
        this.numero_ss = numero_ss;
    }

    public String getCod_trabajador() {
        return cod_trabajador;
    }

    public void setCod_trabajador(String cod_trabajador) {
        this.cod_trabajador = cod_trabajador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
