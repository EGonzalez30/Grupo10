package controlador;

import conexion.Conexion;
import dao.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;

public class UsuarioServlet extends HttpServlet {
    
    boolean respuesta;
    String msg;
    RequestDispatcher rd;
    Conexion conn = new Conexion();
    UsuarioDao userd = new UsuarioDao(conn);
    List<Usuario> lista;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "login":login(request, response); break;
            case "logout":logout(request, response); break;
            case "insert":insert(request, response);break;
            case "seleccionar":selectAll(request,response); break;
            case "seleccionaByid":selectById(request,response); break;
            case "actualizar":update(request,response); break;
            case "eliminar":delete(request,response); break;
        }
    }
    
    protected void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        Usuario user = new Usuario(0);
        user.setNombre(nombre);
        user.setApellido(apellido);
        user.setUsuario(usuario);
        user.setClave(clave);
        respuesta = userd.insert(user);
        if (respuesta) {
            msg="registro guardado";
        }
        else{
            msg="registro NO guardado";
        }
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/insertuser.jsp");
        rd.forward(request, response);
    }
    
    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        Usuario user = new Usuario(id);
        user.setNombre(nombre);
        user.setApellido(apellido);
        user.setUsuario(usuario);
        user.setClave(clave);
        respuesta = userd.update(user);
        if (respuesta) {
            msg="registro actualizado";
        }else{
            msg="registro NO actualizado";
        }
        lista = userd.selectById(id);
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd= request.getRequestDispatcher("/actualizaruser.jsp");
        rd.forward(request, response);                
    }
    
    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        respuesta = userd.delete(id);
        if (respuesta) {
            msg="registro eliminado";
        }else{
            msg="registro NO eliminado";
        }
        lista = userd.selectAll();  
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/insertuser.jsp");
        rd.forward(request, response);               
    }
    
    protected void selectAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lista = userd.selectAll();
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/mostraruser.jsp");
        rd.forward(request, response);
    }
    
    protected void selectById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        lista = userd.selectById(id);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/actualizaruser.jsp");
        rd.forward(request, response);
    }   
    
    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Usuario = request.getParameter("usuario");
        String Password = request.getParameter("clave");

        if (userd.login(Usuario, Password)) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("usuario", Usuario);
            rd = request.getRequestDispatcher("/inicio.jsp");
            rd.forward(request, response);
        } else {
            msg = "usuario o clave incorrecta";
            request.setAttribute("msg", msg);
            rd = request.getRequestDispatcher("/ingresar.jsp");
            rd.forward(request, response);
        }
    }
    
      protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        sesion.invalidate();
        rd = request.getRequestDispatcher("/ingresar.jsp");
        rd.forward(request, response);   
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
