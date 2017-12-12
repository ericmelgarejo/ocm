package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicio.implementacion.CursoService;
import servicio.implementacion.ProgramasService;
import servicio.interfaces.ICursoService;
import servicio.interfaces.IProgramasService;
import vo.CursoVO;
import vo.ProgramaVO;

/**
 * Servlet implementation class CursosServlet
 */
@WebServlet("/CursosServlet")
public class CursosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CursosServlet() {
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
		
		if (opcion.equals("verCursos")){
			try {
				verCursos(request, response);
			}catch(Exception e) {
				System.out.println("Error en metodo verCursos. Mensaje: "+e);
			}
		}else if(opcion.equals("crear")){
			
			try {
				inicioCrearCurso(request, response, opcion);
			}catch(Exception e) {
				System.out.println("Error en metodo inicioCrearCurso. Mensaje: "+e);
			}
		}else if(opcion.equals("insertar")){
			
			try {
				insertarCurso(request, response, opcion);
			}catch(Exception e) {
				System.out.println("Error en metodo insertarCurso. Mensaje: "+e);
			}
		}else if(opcion.equals("modificar")) {
		
			try {
				inicioModificarCurso(request, response, opcion);
			}catch(Exception e) {
				System.out.println("Error en metodo inicioModificarCurso. Mensaje: "+e);
			}
		}else if(opcion.equals("actualizar")) {
			
			try {
				actualizarCurso(request, response);
			}catch(Exception e) {
				System.out.println("Error en metodo actualizarCurso. Mensaje: "+e);
			}
		}else if(opcion.equals("eliminar")) {
			
			try {
				eliminarCurso(request, response);
			}catch(Exception e) {
				System.out.println("Error en metodo eliminarCurso. Mensaje: "+e);
			}
		}
	}

	private void verCursos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		try {
			
			ArrayList<CursoVO> listaCursos = new ArrayList<CursoVO>();
			
			ICursoService cursosService = new CursoService();
			
			listaCursos = cursosService.consultaCursos();
			
			for (int i = 0; i<listaCursos.size(); i++) {
				if(listaCursos.get(i).getStatus() == 0) {
					listaCursos.remove(i);
				}
			}
			
			request.setAttribute("listaCursos", listaCursos);
			
		}catch(Exception e) {
			
			System.out.println("Error en verCursos de CursosServlet. Mensaje: " + e);
			
			
		}finally {
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaCursos.jsp");
			rd.forward(request, response);
		}
	}
	
	private void inicioCrearCurso(HttpServletRequest request, HttpServletResponse response, String opcion)  throws Exception {
		// TODO Auto-generated method stub
		
		ArrayList<ProgramaVO> listaProgramas = new ArrayList<ProgramaVO>();
		
		IProgramasService programasService = new ProgramasService();
		
		listaProgramas = programasService.consultarProgramas();
		
		request.setAttribute("listaProgramas", listaProgramas);
		
		try {
			request.setAttribute("accion",opcion);
			
		}catch(Exception e) {
			System.out.println("Error en inicioCrearCurso de ProgramaServlet. Mensaje: " + e);
		}finally {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/inicioCurso.jsp");
			rd.forward(request, response);
		}
	}
	
	private void insertarCurso(HttpServletRequest request, HttpServletResponse response, String opcion) throws Exception {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		int horas = Integer.parseInt(request.getParameter("horas"));
		int programa_id = Integer.parseInt(request.getParameter("programa"));
		int status = 1;
		
		String respuesta = "";
			
		CursoVO curso = new CursoVO();
		ICursoService cursoService = new CursoService();
			
		curso.setNombre(nombre);
		curso.setDescripcion(descripcion);
		curso.setHoras(horas);
		curso.setPrograma_id(programa_id);
		curso.setStatus(status);
		
		try {
			respuesta = cursoService.insertarCurso(curso);
			request.setAttribute("respuesta", respuesta);
		}catch(Exception e) {
			System.out.println("Error en insertarCurso de CursosServlet. Mensaje: " + e);
		}finally {
			verCursos(request, response);
		}
	}
	
	private void inicioModificarCurso(HttpServletRequest request, HttpServletResponse response, String opcion) throws Exception {
		// TODO Auto-generated method stub
		
		ArrayList<ProgramaVO> listaProgramas = new ArrayList<ProgramaVO>();
		
		IProgramasService programaService = new ProgramasService();
		
		try {
			request.setAttribute("accion",opcion);
			
			int id = Integer.parseInt(request.getParameter("id_curso"));
			
			CursoVO curso = new CursoVO();
			ICursoService cursoService = new CursoService();
			
			listaProgramas = programaService.consultarProgramas();
			
			curso = cursoService.consultarCurso(id);
			
			request.setAttribute("id_curso", id);
			request.setAttribute("nombre", curso.getNombre());
			request.setAttribute("descripcion",curso.getDescripcion());
			request.setAttribute("horas", curso.getHoras());
			request.setAttribute("programa_id", curso.getPrograma_id());
			
			request.setAttribute("listaProgramas", listaProgramas);
			
			
		}catch(Exception e) {
			System.out.println("Error en inicioModificarCurso de CursosServlet. Mensaje: " + e);
		}finally {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/inicioCurso.jsp");
			rd.forward(request, response);
		}
	}
	
	private void actualizarCurso(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id_curso"));
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		int horas = Integer.parseInt(request.getParameter("horas"));
		int programa_id = Integer.parseInt(request.getParameter("programa"));
		int status = 1;
		
		String respuesta = "";
			
		CursoVO curso = new CursoVO();
		ICursoService cursoService = new CursoService();
		
		curso.setId(id);
		curso.setNombre(nombre);
		curso.setHoras(horas);
		curso.setPrograma_id(programa_id);
		curso.setDescripcion(descripcion);
		curso.setStatus(status);
		
		try {
			
			respuesta = cursoService.actualizarCurso(curso);
			
			request.setAttribute("respuesta", respuesta);
			
		}catch(Exception e) {
			System.out.println("Error en actualizarCurso de CursoServlet. Mensaje: " + e);
		}finally {
			verCursos(request, response);
		}
	}
	
	private void eliminarCurso(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id_curso"));
		
		int status = 0;
		
		String respuesta = "";
		
		CursoVO curso= new CursoVO();
		ICursoService cursoService = new CursoService();
		
		curso.setId(id);
		curso.setStatus(status);
		
		try {
			
			respuesta = cursoService.eliminarCurso(curso);
			
			request.setAttribute("respuesta", respuesta);
			
		}catch(Exception e) {
			System.out.println("Error en eliminarCurso de CursosServlet. Mensaje: " + e);
		}finally {
			verCursos(request, response);
		}
	}
}