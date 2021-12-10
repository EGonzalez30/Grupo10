package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Cargo;
import modelo.Departamento;
import modelo.Empleado;

public class CargoDao {
    
    Conexion conn;

        public CargoDao(Conexion conn) {
            this.conn = conn;
        }

        public boolean insert(Cargo carg) {
            String sql = "insert into cargo values (?,?,?,?)";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ps.setInt(1, carg.getId_cargo());
                ps.setInt(2, carg.getId_empleado().getId_empleado());
                ps.setInt(3, carg.getId_departamento().getId_departamento());
                ps.setString(4, carg.getTipo_cargo());
                ps.executeUpdate();
                return true;
            } catch (Exception e) {
                System.out.println("ERROR: " + e);
                return false;
            }
        }

        public boolean update(Cargo carg) {
            String sql = "update cargo set id_empleado = ?, id_departamento = ?, tipo_cargo = ?, where id_cargo=?";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                Empleado emp = carg.getId_empleado();
                Departamento depart = carg.getId_departamento();
                ps.setInt(1, emp.getId_empleado());
                ps.setInt(2, depart.getId_departamento());
                ps.setString(3, carg.getTipo_cargo());
                ps.setInt(4, carg.getId_cargo());
                ps.executeUpdate();
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        public List<Cargo> selectAll() {
            String sql = "select * from cargo";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                Cargo carg;
                List<Cargo> lista = new LinkedList<>();
                while (rs.next()) {
                    Empleado emp = new Empleado(rs.getInt("id_empleado"));
                    Departamento depart = new Departamento(rs.getInt("id_departamento"));
                    carg = new Cargo(rs.getInt("id_cargo"));
                    carg.setId_empleado(emp);
                    carg.setId_departamento(depart);
                    carg.setTipo_cargo(rs.getString("tipo_cargo"));
                    lista.add(carg);
                }
                return lista;
            } catch (Exception e) {
                System.out.println("error: " + e);
                        
                return null;
            }
        }

        public List<Cargo> selectById(int id) {
            String sql = "select * from cargo where id_cargo = ?";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                Cargo carg;
                List<Cargo> lista = new LinkedList<>();
                while (rs.next()) {
                    Empleado emp = new Empleado(rs.getInt("id_empleado"));
                    Departamento depart = new Departamento(rs.getInt("id_departamento"));
                    carg = new Cargo(rs.getInt("id_cargo"));
                    carg.setId_empleado(emp);
                    carg.setId_departamento(depart);
                    carg.setTipo_cargo(rs.getString("tipo_cargo"));
                    lista.add(carg);
                }
                return lista;
            } catch (Exception e) {
                return null;
            }
        }

        public boolean delete(int id_cargo) {
            String sql = "delete from cargo where id_cargo = ?";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ps.setInt(1, id_cargo);
                ps.executeUpdate();
                return true;
            } catch (Exception e) {
                return false;
            }
        }
}
