package modelo;

public class Cargo {
    
    private int id_cargo;
    private Empleado id_empleado;
    private Departamento id_departamento;
    private String tipo_cargo;
    
    public Cargo(int id){
        this.id_cargo = id;
    }

    public Cargo(int id_cargo, Empleado id_empleado, Departamento id_departamento, String tipo_cargo) {
        this.id_cargo = id_cargo;
        this.id_empleado = id_empleado;
        this.id_departamento = id_departamento;
        this.tipo_cargo = tipo_cargo;
    }
    
    
    public Cargo(int id, int empleado, int departamento, String tipo_cargo){
        this.id_cargo = id;
        this.id_empleado = new Empleado(id);
        this.id_departamento = new Departamento(id);
        this.tipo_cargo = tipo_cargo;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public Empleado getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Empleado id_empleado) {
        this.id_empleado = id_empleado;
    }

    public Departamento getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(Departamento id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getTipo_cargo() {
        return tipo_cargo;
    }

    public void setTipo_cargo(String tipo_cargo) {
        this.tipo_cargo = tipo_cargo;
    }
    
}
