package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Nominas;
import modelo.Cargo;
import modelo.Empleado;

public class NominasDao {

    Conexion conn;

    public NominasDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insert(Nominas nom) {
        String sql = "insert into nominas values (?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, nom.getId_nomina());
            ps.setInt(2, nom.getId_empleado().getId_empleado());
            ps.setInt(3, nom.getId_cargo().getId_cargo());
            ps.setString(4, nom.getFecha_nacimiento());
            ps.setDouble(5, nom.getSalario());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(Nominas nom) {
        String sql = "update nominas set id_empleado = ?, id_cargo = ?, fecha_nacimiento = ?, salario = ? where id_nomina = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            Empleado emp = nom.getId_empleado();
            Cargo carg = nom.getId_cargo();
            ps.setInt(1, emp.getId_empleado());
            ps.setInt(2, carg.getId_cargo());
            ps.setString(3, nom.getFecha_nacimiento());
            ps.setDouble(4, nom.getSalario());
            ps.setInt(5, nom.getId_nomina());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Nominas> selectAll() {
        String sql = "select * from nominas";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Nominas nom;
            List<Nominas> lista = new LinkedList<>();
            while (rs.next()) {
                Empleado emp = new Empleado(rs.getInt("id_empleado"));
                Cargo carg = new Cargo(rs.getInt("id_cargo"));
                nom = new Nominas(rs.getInt("id_nomina"));
                nom.setId_empleado(emp);
                nom.setId_cargo(carg);
                nom.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                nom.setSalario(rs.getDouble("salario"));
                lista.add(nom);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("error: " + e);
            return null;
        }
    }

    public List<Nominas> selectById(int id) {
        String sql = "select * from nominas where id_nomina = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Nominas nom;
            List<Nominas> lista = new LinkedList<>();
            while (rs.next()) {
                Empleado emp = new Empleado(rs.getInt("id_empleado"));
                Cargo carg = new Cargo(rs.getInt("id_cargo"));
                nom = new Nominas(rs.getInt("id_nomina"));
                nom.setId_empleado(emp);
                nom.setId_cargo(carg);
                nom.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                nom.setSalario(rs.getDouble("salario"));
                lista.add(nom);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("error: " + e);
            return null;
        }
    }

    public boolean delete(int id_nomina) {
        String sql = "delete from nominas where id_nomina = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_nomina);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
