package modelo;

public class Nominas {

    private int id_nomina;
    private Empleado id_empleado;
    private Cargo id_cargo;
    private String fecha_nacimiento;
    private double salario;

    public Nominas(int id) {
        this.id_nomina = id;
    }
    
    public Nominas(int id_nomina, Empleado id_empleado, Cargo id_cargo, String fecha_nacimiento, double salario) {
        this.id_nomina = id_nomina;
        this.id_empleado = id_empleado;
        this.id_cargo = id_cargo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.salario = salario;
    }
    
    
    public Nominas(int id, int empleado, int cargo, String fecha_nacimiento, double salario){
        this.id_nomina = id;
        this.id_empleado = new Empleado(id);
        this.id_cargo = new Cargo(id);
        this.fecha_nacimiento = fecha_nacimiento;
        this.salario = salario;
    }

    public Empleado getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Empleado id_empleado) {
        this.id_empleado = id_empleado;
    }

    public Cargo getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(Cargo id_cargo) {
        this.id_cargo = id_cargo;
    }
    
    public int getId_nomina() {
        return id_nomina;
    }

    public void setId_nomina(int id_nomina) {
        this.id_nomina = id_nomina;
    }
    
    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
