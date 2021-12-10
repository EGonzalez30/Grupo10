package modelo;

public class Contrato {
    
    private int id_contrato;
    private Empleado id_empleado;
    private String fecha_inicial;
    private String fecha_final;
    
    public Contrato(int id){
        this.id_contrato = id;
    }
    
    public Contrato(int id_contrato, Empleado id_empleado, String fecha_inicial, String fecha_final) {
        this.id_contrato = id_contrato;
        this.id_empleado = id_empleado;
        this.fecha_inicial = fecha_inicial;
        this.fecha_final = fecha_final;
    }
       
    public Contrato(int id, int empleado, String fecha_inicial, String fecha_final){
        this.id_contrato = id;
        this.id_empleado = new Empleado(id);
        this.fecha_inicial = fecha_inicial;
        this.fecha_final = fecha_final;
    }

    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    public Empleado getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Empleado id_empleado) {
        this.id_empleado = id_empleado;
    }
    

    public String getFecha_inicial() {
        return fecha_inicial;
    }

    public void setFecha_inicial(String fecha_inicial) {
        this.fecha_inicial = fecha_inicial;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }
    
}
