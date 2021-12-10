package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Departamento;

public class DepartamentoDao {

    Conexion conn;

    public DepartamentoDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insert(Departamento depart) {
        String sql = "insert into departamentos values (?,?,?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, depart.getId_departamento());
            ps.setString(2, depart.getDepartamento());
            ps.setString(3, depart.getCiudad());
            ps.setString(4, depart.getArea_trabajo());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(Departamento depart) {
        String sql = "update departamentos set departamento = ?, ciudad = ?, area_trabajo = ? where id_departamento = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, depart.getDepartamento());
            ps.setString(2, depart.getCiudad());
            ps.setString(3, depart.getArea_trabajo());
            ps.setInt(4, depart.getId_departamento());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Departamento> selectAll() {
        String sql = "select * from departamentos";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Departamento depart;
            List<Departamento> lista = new LinkedList<>();
            while (rs.next()) {
                depart = new Departamento(rs.getInt("id_departamento"));
                depart.setDepartamento(rs.getString("departamento"));
                depart.setCiudad(rs.getString("ciudad"));
                depart.setArea_trabajo(rs.getString("area_trabajo"));
                lista.add(depart);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Departamento> selectById(int id_departamento) {
        String sql = "select * from departamentos where id_departamento = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_departamento);
            ResultSet rs = ps.executeQuery();
            Departamento depart;
            List<Departamento> lista = new LinkedList<>();
            while (rs.next()) {
                depart = new Departamento(rs.getInt("id_departamento"));
                depart.setDepartamento(rs.getString("departamento"));
                depart.setCiudad(rs.getString("ciudad"));
                depart.setArea_trabajo(rs.getString("area_trabajo"));
                lista.add(depart);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean delete(int id_departamento) {
        String sql = "delete from departamentos where id_departamento = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_departamento);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
