package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Contrato;
import modelo.Empleado;

public class ContratoDao {
    
    Conexion conn;
    
    public ContratoDao(Conexion conn){
        this.conn = conn;
    }
    
    public boolean insert(Contrato cont) {
        String sql = "insert into contrato values (?,?,?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, cont.getId_contrato());
            ps.setInt(2, cont.getId_empleado().getId_empleado());
            ps.setString(3, cont.getFecha_inicial());
            ps.setString(4, cont.getFecha_final());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(Contrato cont) {
        String sql = "update contrato set id_empleado = ?, fecha_inicial = ?, fecha_final = ? where id_contrato = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            Empleado emp = cont.getId_empleado();
            ps.setInt(1, emp.getId_empleado());
            ps.setString(2, cont.getFecha_inicial());
            ps.setString(3, cont.getFecha_final());
            ps.setInt(4, cont.getId_contrato());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Contrato> selectAll() {
        String sql = "select * from contrato";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Contrato cont;
            List<Contrato> lista = new LinkedList<>();
            while (rs.next()) {
                Empleado emp = new Empleado(rs.getInt("id_empleado"));
                cont = new Contrato(rs.getInt("id_contrato"));
                cont.setId_empleado(emp);
                cont.setFecha_inicial(rs.getString("fecha_inicial"));
                cont.setFecha_final(rs.getString("fecha_final"));
                lista.add(cont);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("error: " + e);
            return null;
        }
    }
    
    public List<Contrato> selectById(int id) {
        String sql = "select * from contrato where id_contrato = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Contrato cont;
            List<Contrato> lista = new LinkedList<>();
            while (rs.next()) {
                Empleado emp = new Empleado(rs.getInt("id_empleado"));
                cont = new Contrato(rs.getInt("id_contrato"));
                cont.setId_empleado(emp);
                cont.setFecha_inicial(rs.getString("fecha_inical"));
                cont.setFecha_final(rs.getString("fecha_final"));
                lista.add(cont);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("error: " + e);
            return null;
        }
    }
    
    public boolean delete(int id_contrato){
        String sql = "delete from contrato where id_contrato = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_contrato);
            ps.executeUpdate();          
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
