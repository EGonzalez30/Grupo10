package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Usuario;

public class UsuarioDao {

    Conexion conn;

    public UsuarioDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insert(Usuario user) {
        String sql = "insert into usuarios values (?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.setString(2, user.getNombre());
            ps.setString(3, user.getApellido());
            ps.setString(4, user.getUsuario());
            ps.setString(5, user.getClave());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean update(Usuario user){
       String sql = "update usuarios set nombre = ?, apellido = ?, usuario = ?, clave = ? where id=?";
       try {
           PreparedStatement ps = conn.conectar().prepareStatement(sql); 
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellido());
            ps.setString(3, user.getUsuario());
            ps.setString(4, user.getClave());
            ps.setInt(5, user.getId());
            ps.executeUpdate();
           return true;    
       } catch (Exception e) {
           return false;
       }
   }

    public List<Usuario> selectAll() {
        String sql = "select * from usuarios";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Usuario user;
            List<Usuario> lista = new LinkedList<>();
            while (rs.next()) {
                user = new Usuario(rs.getInt("id"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setUsuario(rs.getString("usuario"));
                user.setClave(rs.getString("clave"));
                lista.add(user);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("error: " + e);
            return null;
        }
    }
    
    public List<Usuario> selectById(int id){
        String sql = "select * from usuarios where id = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Usuario user;
            List<Usuario> lista = new LinkedList<>();
            while(rs.next()){
                user = new Usuario(rs.getInt("id"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setUsuario(rs.getString("usuario"));
                user.setClave(rs.getString("clave"));
                lista.add(user);
            }          
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
    
    
        public boolean delete(int id){
        String sql = "delete from usuarios where id = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();          
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean login(String usuario, String clave) {
        String sql = "select usuario, clave from usuarios where usuario = ? and clave = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
