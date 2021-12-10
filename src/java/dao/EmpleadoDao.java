package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Empleado;

public class EmpleadoDao {
    
     Conexion conn;
    
    public EmpleadoDao(Conexion conn){
        this.conn = conn;
    }
    
    public boolean insert(Empleado emp){
       String sql = "insert into empleados values (?,?,?,?,?,?,?,?)";
       try {
           PreparedStatement ps = conn.conectar().prepareStatement(sql);
           ps.setInt(1, emp.getId_empleado());
           ps.setInt(2, emp.getDni());
           ps.setInt(3, emp.getNumero_ss());
           ps.setString(4, emp.getCod_trabajador());
           ps.setString(5, emp.getNombre());
           ps.setString(6, emp.getApellido());
           ps.setString(7, emp.getDireccion());
           ps.setString(8, emp.getTelefono());
           ps.executeUpdate();
           return true;          
        } catch (Exception e) {
           return false;
       }
   }
   
   
   public boolean update(Empleado emp){
       String sql = "update empleados set dni = ?, numero_ss = ?, cod_trabajador = ?, direccion = ?, nombre = ?, apellido = ?, telefono = ? where id_empleado=?";
       try {
           PreparedStatement ps = conn.conectar().prepareStatement(sql); 
           ps.setInt(1, emp.getDni());
           ps.setInt(2, emp.getNumero_ss());
           ps.setString(3, emp.getCod_trabajador());
           ps.setString(4, emp.getNombre());
           ps.setString(5, emp.getApellido());
           ps.setString(6, emp.getDireccion());
           ps.setString(7, emp.getTelefono());
           ps.setInt(8, emp.getId_empleado());
           ps.executeUpdate();
           return true;    
       } catch (Exception e) {
           return false;
       }
   }
    
    
    public List<Empleado>selectAll(){
        String sql = "select * from empleados";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Empleado emp;
            List<Empleado> lista = new LinkedList<>();
            while(rs.next()){
                emp = new Empleado(rs.getInt("id_empleado"));
                emp.setDni(rs.getInt("dni"));
                emp.setNumero_ss(rs.getInt("numero_ss"));
                emp.setCod_trabajador(rs.getString("cod_trabajador"));
                emp.setNombre(rs.getString("nombre"));
                emp.setApellido(rs.getString("apellido"));
                emp.setDireccion(rs.getString("direccion"));
                emp.setTelefono(rs.getString("telefono"));
                lista.add(emp);
            }           
            return lista;
        } catch (Exception e) {
            System.out.println("error: "+e);
            return null;
        }
    }
    
    
    public List<Empleado> selectById(int id_empleado){
        String sql = "select * from empleados where id_empleado = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_empleado);
            ResultSet rs = ps.executeQuery();
            Empleado emp;
            List<Empleado> lista = new LinkedList<>();
            while(rs.next()){
                emp = new Empleado(rs.getInt("id_empleado"));
                emp.setDni(rs.getInt("dni"));
                emp.setNumero_ss(rs.getInt("numero_ss"));
                emp.setCod_trabajador(rs.getString("cod_trabajador"));
                emp.setNombre(rs.getString("nombre"));
                emp.setApellido(rs.getString("apellido"));
                emp.setDireccion(rs.getString("direccion"));
                emp.setTelefono(rs.getString("telefono"));
                lista.add(emp);
            }          
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
    
    
        public boolean delete(int id_empleado){
        String sql = "delete from empleados where id_empleado = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_empleado);
            ps.executeUpdate();          
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
