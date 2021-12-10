package controlador;

import conexion.Conexion;
import dao.ContratoDao;
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
import modelo.Contrato;
import modelo.Empleado;

public class ContratoServlet extends HttpServlet {

    String msg;
    boolean respuesta;
    Conexion conn = new Conexion();
    ContratoDao contd = new ContratoDao(conn);
    EmpleadoDao empd = new EmpleadoDao(conn);
    RequestDispatcher rd;
    List<Contrato> lista;
    List<Empleado> listaEmpleados;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "insertar":
                insert(request, response);
                break;
            case "irinsertar":
                irInsertar(request, response);
                break;
            case "seleccionar":
                selectAll(request, response);
                break;
            case "seleccionaByid":
                selectById(request, response);
                break;
            case "actualizar":
                update(request, response);
                break;
            case "eliminar":
                delete(request, response);
                break;
            case "logout":
                logout(request, response);
                break;
        }
    }

    protected void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getParameter("id_empleado") + " " + request.getParameter("fecha_inicial") + " " + request.getParameter("fecha_final"));
        int empleado = Integer.parseInt(request.getParameter("id_empleado"));
        Contrato cont = new Contrato(0, new Empleado(empleado), request.getParameter("fecha_inicial"), request.getParameter("fecha_final"));
        respuesta = contd.insert(cont);
        if (respuesta) {
            msg = "registro guardado";
        } else {
            msg = "registro NO guardado";
        }
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/indexcont.jsp");
        rd.forward(request, response);
    }

    private void irInsertar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        listaEmpleados = empd.selectAll();
        request.setAttribute("empleados", listaEmpleados);
        rd = request.getRequestDispatcher("/indexcont.jsp");
        rd.forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getParameter("id_empleado") + " " + request.getParameter("fecha_inicial") + " " + request.getParameter("fecha_final"));
        int id_contrato = Integer.parseInt(request.getParameter("id_contrato"));
        int empleado = Integer.parseInt(request.getParameter("id_empleado"));
        Contrato cont = new Contrato(id_contrato, new Empleado(empleado), request.getParameter("fecha_inicial"), request.getParameter("fecha_final"));
        respuesta = contd.update(cont);
        if (respuesta) {
            msg = "registro ACTUALIZADO";
        } else {
            msg = "registro NO ACTUALIZADO";
        }
        lista = contd.selectById(id_contrato);
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/actualizarcont.jsp");
        rd.forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_contrato = Integer.parseInt(request.getParameter("id_contrato"));
        respuesta = contd.delete(id_contrato);
        if (respuesta) {
            msg = "registro ELIMINADO";
        } else {
            msg = "registro NO ELIMINADO";
        }
        lista = contd.selectAll();
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/indexcont.jsp");
        rd.forward(request, response);
    }

    protected void selectAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lista = contd.selectAll();
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/mostrarcont.jsp");
        rd.forward(request, response);
    }

    protected void selectById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_contrato = Integer.parseInt(request.getParameter("id_contrato"));
        lista = contd.selectById(id_contrato);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/actualizarcont.jsp");
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
