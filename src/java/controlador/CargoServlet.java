package controlador;

import conexion.Conexion;
import dao.CargoDao;
import dao.DepartamentoDao;
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
import modelo.Cargo;
import modelo.Departamento;
import modelo.Empleado;

public class CargoServlet extends HttpServlet {
    
    String msg;
    boolean respuesta;
    Conexion conn = new Conexion();
    CargoDao cargd = new CargoDao(conn);
    DepartamentoDao departd = new DepartamentoDao(conn);
    EmpleadoDao empd = new EmpleadoDao(conn);
    RequestDispatcher rd;
    List<Cargo> lista;
    List<Empleado> listaEmpleados;
    List<Departamento> listaDepartamento;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch(action){
            case "insertar": insert(request, response);break;
            case "irinsertar": irInsertar(request, response);break;
            case "seleccionar": selectAll(request, response);break;
            case "logout":logout(request, response); break;
        }
    }
    
    protected void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getParameter("id_empleado") + " " + request.getParameter("id_departamento") + " " + request.getParameter("tipo_cargo"));
        int empleado = Integer.parseInt(request.getParameter("id_empleado"));
        int departamento = Integer.parseInt(request.getParameter("id_departamento"));       
        Cargo carg = new Cargo(0, new Empleado(empleado), new Departamento(departamento), request.getParameter("tipo_cargo"));                
        respuesta = cargd.insert(carg);
        if (respuesta) {
            msg = "REGISTRO GUARDADO";
        }
        else {
            msg = "REGISTRO NO GUARDADO";
        }
        request.setAttribute("msg", msg); 
        rd = request.getRequestDispatcher("/insertarcargo.jsp");
        rd.forward(request, response);        
    }
    
    protected void selectAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lista = cargd.selectAll();
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/mostrar.jsp");
        rd.forward(request, response);
    }
        
    private void irInsertar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        listaEmpleados = empd.selectAll();
        listaDepartamento = departd.selectAll();
        request.setAttribute("empleados", listaEmpleados);
        request.setAttribute("departamento", listaDepartamento);
        rd = request.getRequestDispatcher("/insertarcargo.jsp");
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
