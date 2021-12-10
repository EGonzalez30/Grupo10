package controlador;

import conexion.Conexion;
import dao.CargoDao;
import dao.EmpleadoDao;
import dao.NominasDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Cargo;
import modelo.Empleado;
import modelo.Nominas;

public class NominasServlet extends HttpServlet {
    
    String msg;
    boolean respuesta;
    Conexion conn = new Conexion();
    NominasDao nomd = new NominasDao(conn);
    EmpleadoDao empd = new EmpleadoDao(conn);
    CargoDao cargd = new CargoDao(conn);
    RequestDispatcher rd;
    List<Nominas> lista;
    List<Empleado> listaEmpleados;
    List<Cargo> listaCargo;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch(action){
            case "insertar":insert(request,response); break;
            case "irinsertar": irInsertar(request, response);break;
            case "seleccionar":selectAll(request,response); break;
            case "seleccionaByid":selectById(request,response); break;
            case "actualizar":update(request,response); break;
            case "eliminar":delete(request,response); break;
            case "logout":logout(request, response);
        }
    }

    protected void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getParameter("id_empleado") + " " + request.getParameter("id_cargo") + " " + request.getParameter("fecha_nacimiento") + " " + request.getParameter("salario"));
        int empleado = Integer.parseInt(request.getParameter("id_empleado"));
        int cargo = Integer.parseInt(request.getParameter("id_cargo"));
        Nominas nom = new Nominas(0, new Empleado(empleado), new Cargo(cargo), request.getParameter("fecha_nacimiento"), Double.parseDouble(request.getParameter("salario"))); 
        respuesta = nomd.insert(nom);
        if (respuesta) {
            msg="registro guardado";
        }
        else{
            msg="registro NO guardado";
        }
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/indexnomina.jsp");
        rd.forward(request, response);
    }
    
    private void irInsertar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        listaEmpleados = empd.selectAll();
        listaCargo = cargd.selectAll();
        request.setAttribute("empleados", listaEmpleados);
        request.setAttribute("cargo", listaCargo);
        rd = request.getRequestDispatcher("/indexnomina.jsp");
        rd.forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getParameter("id_empleado") + " " + request.getParameter("id_cargo") + " " + request.getParameter("fecha_nacimiento") + " " + request.getParameter("salario"));
        int id_nomina = Integer.parseInt(request.getParameter("id_nomina"));
        int empleado = Integer.parseInt(request.getParameter("id_empleado"));
        int cargo = Integer.parseInt(request.getParameter("id_cargo"));
        Nominas nom = new Nominas(id_nomina, new Empleado(empleado), new Cargo(cargo), request.getParameter("fecha_nacimiento"), Double.parseDouble(request.getParameter("salario")));
        respuesta = nomd.update(nom);
        if (respuesta) {
            msg="registro ACTUALIZADO";
        }
        else{
            msg="registro NO ACTUALIZADO";
        }
        lista = nomd.selectById(id_nomina);
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/actualizarnomina.jsp");
        rd.forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_nomina = Integer.parseInt(request.getParameter("id_nomina"));
        respuesta = nomd.delete(id_nomina);
        if (respuesta) {
            msg="registro ELIMINADO";
        }
        else{
            msg="registro NO ELIMINADO";
        }
        lista = nomd.selectAll();
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/indexnomina.jsp");
        rd.forward(request, response);
    }

    protected void selectAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lista = nomd.selectAll();
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/mostrarnomina.jsp");
        rd.forward(request, response);
    }

    protected void selectById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_nomina = Integer.parseInt(request.getParameter("id_nomina"));
        lista = nomd.selectById(id_nomina);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/actualizarnomina.jsp");
        rd.forward(request, response);
    }
    
    protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        sesion.invalidate();
        request.getRequestDispatcher("/login.jsp").forward(request, response);   
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
