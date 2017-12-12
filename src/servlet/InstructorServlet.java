/**
 * 
 */
package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicio.implementacion.EventoService;
import servicio.implementacion.InstructorService;
import servicio.interfaces.IEventoService;
import servicio.interfaces.IInstructorService;
import vo.EventoVO;
import vo.InstructorVO;

/**
 * @author b
 *
 */
public class InstructorServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcionInstructores = req.getParameter("opcionInstructores");
		String inicioModificarInstructor = req.getParameter("modificarInstructor");
		String confirmarModificarInstructor = req.getParameter("confirmarModificarInstructor");
		String eliminarInstructor = req.getParameter("eliminarInstructor");
		if(opcionInstructores != null) {
			if(opcionInstructores.equals("listarInstructores")) {
				
				listarInstructores(req, resp);
			}else if(opcionInstructores.equals("agregarInstructor")) {
				agregarInstructor(req, resp);
			} 
		}else if(inicioModificarInstructor != null) {
			inicioModificarInstructor(req, resp, inicioModificarInstructor);
			
		}else if(eliminarInstructor != null) {
			eliminarInstructor(req, resp, eliminarInstructor);
		}else if(confirmarModificarInstructor != null) {
			modificarInstructor(req, resp);
		}
		
	}

	private void modificarInstructor(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		System.out.println("Modificar Instructor");
		
		int id = Integer.parseInt(req.getParameter("idInstructor"));
		String nombre = req.getParameter("nombreModificarInstructor");
		String apellidoP = req.getParameter("apellidopModificarInstructor");
		String apellidoM = req.getParameter("apellidomModificarInstructor");
		String correo = req.getParameter("correoModificarInstructor");
		String telefono = req.getParameter("telefonoModificarInstructor");
		String fecha_Nacimiento = req.getParameter("fechanModificarInstructor");
		//int tipo = Integer.parseInt(req.getParameter("tipouModificarInstructor"));
		String password = req.getParameter("passwordModificarInstructor");
		
		InstructorVO instructor = new InstructorVO();
		IInstructorService InstructorService = new InstructorService();
		instructor.setId_instructor(id);
		instructor.setNombre(nombre);
		instructor.setApellido_paterno(apellidoP);
		instructor.setApellido_materno(apellidoM);
		instructor.setCorreo(correo);
		instructor.setTelefono(telefono);
		instructor.setFecha_nacimiento(fecha_Nacimiento);
		//instructor.setTipo_usuario(tipo);
		instructor.setPassword(password);
		
		InstructorService.modificarInstructor(instructor);
		listarInstructores(req, resp);
	}

	private void eliminarInstructor(HttpServletRequest req, HttpServletResponse resp, String eliminarInstructor) {
		// TODO Auto-generated method stub
		System.out.println("eliminar Instructor");
		int id = Integer.parseInt(eliminarInstructor);
		InstructorVO Instructor = new InstructorVO();
		IInstructorService InstructorService = new InstructorService();
		Instructor.setId_instructor(id);
		InstructorService.eliminarInstructor(Instructor);
		listarInstructores(req, resp);
		
	}

	private void inicioModificarInstructor(HttpServletRequest req, HttpServletResponse resp, String inicioModificarInstructor) {
		System.out.println("modifica Instructor");
		try {
		ArrayList<InstructorVO> listaDatosInstructor = new ArrayList<InstructorVO>();
		InstructorVO instructor = new InstructorVO();
		IInstructorService instructorService = new InstructorService();
		
		int id = Integer.parseInt(inicioModificarInstructor);// "idInstructor"
		//System.out.println(id);
		String nombre = req.getParameter("nombreModificarInstructor");
		String apellidoP = req.getParameter("apellidopModificarInstructor");
		String apellidoM = req.getParameter("apellidomModificarInstructor");
		String correo = req.getParameter("correoModificarInstructor");
		String telefono = req.getParameter("telefonoModificarInstructor");
		String fecha_Nacimiento = req.getParameter("fechanModificarInstructor");
		
		System.out.println("aqui llega1");
		//int tipou = Integer.parseInt(tipo);
		System.out.println("aqui llega2");
		String password = req.getParameter("passwordModificarInstructor");
		System.out.println("aqui llega3");
		
		
		instructor.setId_instructor(id);
		instructor.setNombre(nombre);
		instructor.setApellido_paterno(apellidoP);
		instructor.setApellido_materno(apellidoM);
		instructor.setCorreo(correo);
		instructor.setTelefono(telefono);
		instructor.setFecha_nacimiento(fecha_Nacimiento);
		//instructor.setTipo_usuario(tipou);
		instructor.setPassword(password);
		

		listaDatosInstructor = instructorService.obtenerDatosInstructor(instructor);
		req.setAttribute("listaDatosInstructor", listaDatosInstructor);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificarInstructor.jsp");
		rd.forward(req, resp);
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	private void agregarInstructor(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		System.out.println("Agregar Instructor");
		String nombre = req.getParameter("nombreAgregarInstructor");
		String apellidoP = req.getParameter("apellidopAgregarInstructor");
		String apellidoM = req.getParameter("apellidomAgregarInstructor");
		String correo = req.getParameter("correoAgregarInstructor");
		String telefono = req.getParameter("telefonoAgregarInstructor");
		String fecha_Nacimiento = req.getParameter("fechanAgregarInstructor");
		InstructorVO instructor = new InstructorVO();
		IInstructorService InstructorService = new InstructorService();
		
		instructor.setNombre(nombre);
		instructor.setApellido_paterno(apellidoP);
		instructor.setApellido_materno(apellidoM);
		instructor.setCorreo(correo);
		instructor.setTelefono(telefono);
		instructor.setFecha_nacimiento(fecha_Nacimiento);
		//instructor.setTipo_usuario(tipou);
		
		
		InstructorService.agregarInstructor(instructor);
		
		listarInstructores(req, resp);
	}

	private void listarInstructores(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("listar Instructor");
		try {
		ArrayList<InstructorVO> listaInstructores = new ArrayList<InstructorVO>();
		
		InstructorVO instructor = new InstructorVO();
		
		IInstructorService psService = new InstructorService();
		listaInstructores = psService.consultaInstructores(instructor);
		req.setAttribute("listaInstructores", listaInstructores);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaInstructores.jsp");
			try {
				rd.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

