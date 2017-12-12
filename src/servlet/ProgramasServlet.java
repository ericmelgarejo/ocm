package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicio.implementacion.ProgramasService;
import servicio.interfaces.IProgramasService;
import vo.ProgramaVO;

/**
 * Servlet implementation class ProgramasServlet
 */
@WebServlet("/ProgramasServlet")
public class ProgramasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProgramasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String opcion = request.getParameter("opcion");
		
		System.out.println("Opcion: " + opcion);
		
		if (opcion.equals("verProgramas")){
			
			try {
				verProgramas(request, response);
			}catch(Exception e) {
				System.out.println("Error en metodo verProgramas. Mensaje: "+e);
			}
		}else if(opcion.equals("crear")){
			
			try {
				System.out.println("Entro al metodo inicioCrear");
				inicioCrearPrograma(request, response, opcion);
			}catch(Exception e) {
				System.out.println("Error en metodo crearPrograma. Mensaje: "+e);
			}
		}else if(opcion.equals("insertar")) {
			
			try {
				insertarPrograma(request, response);
			}catch(Exception e) {
				System.out.println("Error en metodo insertarPrograma. Mensaje: "+e);
			}
		}else if(opcion.equals("modificar")) {
		
			try {
				inicioModificarPrograma(request, response, opcion);
				System.out.println("Entro al metodo modificar");
			}catch(Exception e) {
				System.out.println("Error en metodo inicioModificarPrograma. Mensaje: "+e);
			}
		}else if(opcion.equals("actualizar")) {
			
			try {
				actualizarPrograma(request, response);
			}catch(Exception e) {
				System.out.println("Error en metodo actualizarPrograma. Mensaje: "+e);
			}
		}else if(opcion.equals("eliminar")) {
			
			try {
				eliminarPrograma(request, response);
				System.out.println("Entro al metodo eliminar");
			}catch(Exception e) {
				System.out.println("Error en metodo eliminarPrograma. Mensaje: "+e);
			}
		}
	}

	private void verProgramas(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {
			
			ArrayList<ProgramaVO> listaProgramas = new ArrayList<ProgramaVO>();
			
			IProgramasService programasService = new ProgramasService();
			
			listaProgramas = programasService.consultarProgramas();
			
			for (int i = 0; i<listaProgramas.size(); i++) {
				if(listaProgramas.get(i).getStatus() == 0) {
					listaProgramas.remove(i);
				}
			}
			
			request.setAttribute("listaProgramas", listaProgramas);
			
		}catch(Exception e) {
			
			System.out.println("Error en verProgramas de ProgramaServlet. Mensaje: " + e);
			
			
		}finally {
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaProgramas.jsp");
			rd.forward(request, response);
		}
	}
	
	private void inicioCrearPrograma(HttpServletRequest request, HttpServletResponse response, String opcion) throws Exception{
		try {
			request.setAttribute("accion",opcion);
		}catch(Exception e) {
			System.out.println("Error en inicioCrearPrograma de ProgramaServlet. Mensaje: " + e);
		}finally {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/inicioPrograma.jsp");
			rd.forward(request, response);
		}
	}
	
	private void insertarPrograma(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		int status = 1;
		
		String respuesta = "";
			
		ProgramaVO programa = new ProgramaVO();
		IProgramasService programaService = new ProgramasService();
			
		programa.setNombre(nombre);
		programa.setDescripcion(descripcion);
		programa.setStatus(status);
		
		try {
			respuesta = programaService.insertarPrograma(programa);
			request.setAttribute("respuesta", respuesta);
		}catch(Exception e) {
			System.out.println("Error en insertarPrograma de ProgramaServlet. Mensaje: " + e);
		}finally {
			verProgramas(request, response);
		}
	}
	
	private void inicioModificarPrograma(HttpServletRequest request, HttpServletResponse response, String opcion) throws Exception{
		try {
			request.setAttribute("accion",opcion);
			
			int id = Integer.parseInt(request.getParameter("id_programa"));
			
			ProgramaVO programa = new ProgramaVO();
			IProgramasService programaService = new ProgramasService();
			
			programa = programaService.consultarPrograma(id);
			
			request.setAttribute("id_programa", id);
			request.setAttribute("nombre",programa.getNombre());
			request.setAttribute("descripcion",programa.getDescripcion());
			
			
		}catch(Exception e) {
			System.out.println("Error en inicioCrearPrograma de ProgramaServlet. Mensaje: " + e);
		}finally {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/inicioPrograma.jsp");
			rd.forward(request, response);
		}
	}
	
	private void actualizarPrograma(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		int id = Integer.parseInt(request.getParameter("id_programa"));
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		int status = 1;
		
		String respuesta = "";
			
		ProgramaVO programa = new ProgramaVO();
		IProgramasService programaService = new ProgramasService();
		
		programa.setId(id);
		programa.setNombre(nombre);
		programa.setDescripcion(descripcion);
		programa.setStatus(status);
		
		try {
			
			respuesta = programaService.actualizarPrograma(programa);
			
			request.setAttribute("respuesta", respuesta);
			
		}catch(Exception e) {
			System.out.println("Error en actualizarPrograma de ProgramaServlet. Mensaje: " + e);
		}finally {
			verProgramas(request, response);
		}
	}
	
	private void eliminarPrograma(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id_programa"));
		
		int status = 0;
		
		String respuesta = "";
		
		ProgramaVO programa = new ProgramaVO();
		IProgramasService programaService = new ProgramasService();
		
		programa.setId(id);
		programa.setStatus(status);
		
		try {
			
			respuesta = programaService.eliminarPrograma(programa);
			
			request.setAttribute("respuesta", respuesta);
			
		}catch(Exception e) {
			System.out.println("Error en eliminarPrograma de ProgramaServlet. Mensaje: " + e);
		}finally {
			verProgramas(request, response);
		}
	}
}
