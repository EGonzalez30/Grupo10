package controlador;

import conexion.Conexion;
import dao.DepartamentoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Departamento;

public class DepartamentoServlet extends HttpServlet {
    
    String msg;
    boolean respuesta;
    Conexion conn = new Conexion();
    DepartamentoDao departd = new DepartamentoDao(conn);
    RequestDispatcher rd;
    List<Departamento> lista;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch(action){
            case "insertar": insert(request, response);break;
            case "seleccionar": selectAll(request, response);break;
            case "seleccionarById": selectById(request, response);break;
            case "update": update(request, response);break;
            case "delete": delete(request, response);break;
            case "logout":logout(request, response);break;
        }
    }
    
    protected void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String departamento = request.getParameter("departamento");
        String ciudad = request.getParameter("ciudad");
        String area_trabajo = request.getParameter("area_trabajo");
        Departamento depart = new Departamento(0);
        depart.setDepartamento(departamento);
        depart.setCiudad(ciudad);
        depart.setArea_trabajo(area_trabajo);
        respuesta = departd.insert(depart);
        if (respuesta) {
            msg = "REGISTRO GUARDADO";
        }
        else {
            msg = "REGISTRO NOO GUARDADO";
        }
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/insertardepart.jsp");
        rd.forward(request, response);
    }
    
    protected void selectAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lista = departd.selectAll();
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/mostrardepart.jsp");
        rd.forward(request, response);
    }
    
    protected void selectById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_departamento = Integer.parseInt(request.getParameter("id_departamento"));
        lista = departd.selectById(id_departamento);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/actualizardepart.jsp");
        rd.forward(request, response);
    }
    
    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_departamento = Integer.parseInt(request.getParameter("id_departamento"));
        String departamento = request.getParameter("departamento");
        String ciudad = request.getParameter("ciudad");
        String area_trabajo = request.getParameter("area_trabajo");
        Departamento depart = new Departamento(id_departamento);
        depart.setDepartamento(departamento);
        depart.setCiudad(ciudad);
        depart.setArea_trabajo(area_trabajo);
        respuesta = departd.update(depart);
        if (respuesta) {
            msg="registro actualizado";
        }else{
            msg="registro NO actualizado";
        }
        lista = departd.selectById(id_departamento);  
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd= request.getRequestDispatcher("/actualizardepart.jsp");
        rd.forward(request, response);    
    }
    
    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_departamento = Integer.parseInt(request.getParameter("id_departamento"));
          respuesta = departd.delete(id_departamento);
          if (respuesta) {
            msg="registro eliminado";
        }else{
            msg="registro NO eliminado";
        }
        lista = departd.selectAll();  
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/insertardepart.jsp");
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
