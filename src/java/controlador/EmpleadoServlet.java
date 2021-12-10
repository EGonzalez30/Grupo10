package controlador;

import conexion.Conexion;
import dao.EmpleadoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Empleado;

public class EmpleadoServlet extends HttpServlet {
    
    String msg;
    boolean respuesta;
    Conexion conn = new Conexion();
    EmpleadoDao empd = new EmpleadoDao(conn);
    RequestDispatcher rd;
    List<Empleado> lista;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch(action){
            case "insertar":insert(request,response); break;
            case "seleccionar":selectAll(request,response); break;
            case "seleccionaByid":selectById(request,response); break;
            case "actualizar":update(request,response); break;
            case "eliminar":delete(request,response); break;
        }
    }
    
    protected void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int dni = Integer.parseInt(request.getParameter("dni"));
        int numeros_ss = Integer.parseInt(request.getParameter("numero_ss"));
        String cod_trabajador = request.getParameter("cod_trabajador");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        Empleado emp = new Empleado(0);
        emp.setDni(dni);
        emp.setNumero_ss(numeros_ss);
        emp.setCod_trabajador(cod_trabajador);
        emp.setNombre(nombre);
        emp.setApellido(apellido);
        emp.setDireccion(direccion);
        emp.setTelefono(telefono);
        respuesta = empd.insert(emp);
        if (respuesta) {
            msg="registro guardado";
        }
        else{
            msg="registro NO guardado";
        }
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
    
    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_empleado = Integer.parseInt(request.getParameter("id_empleado"));
        int dni = Integer.parseInt(request.getParameter("dni"));
        int numeros_ss = Integer.parseInt(request.getParameter("numero_ss"));
        String cod_trabajador = request.getParameter("cod_trabajador");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        Empleado emp = new Empleado(id_empleado);
        emp.setDni(dni);
        emp.setNumero_ss(numeros_ss);
        emp.setCod_trabajador(cod_trabajador);
        emp.setDireccion(direccion);
        emp.setNombre(nombre);
        emp.setApellido(apellido);
        emp.setTelefono(telefono);
        respuesta = empd.update(emp);
        if (respuesta) {
            msg="registro actualizado";
        }else{
            msg="registro NO actualizado";
        }
        lista = empd.selectById(id_empleado);
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd= request.getRequestDispatcher("/actualizar.jsp");
        rd.forward(request, response);                
    }    
    
    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_empleado = Integer.parseInt(request.getParameter("id_empleado"));
        respuesta = empd.delete(id_empleado);
        if (respuesta) {
            msg="registro eliminado";
        }else{
            msg="registro NO eliminado";
        }
        lista = empd.selectAll();
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);               
    }
    
    protected void selectAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lista = empd.selectAll();
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/mostrar.jsp");
        rd.forward(request, response);
    }
    protected void selectById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_empleado = Integer.parseInt(request.getParameter("id_empleado"));
        lista = empd.selectById(id_empleado);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/actualizar.jsp");
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
