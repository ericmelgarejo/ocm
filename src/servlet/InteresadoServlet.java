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
import javax.servlet.http.HttpSession;

import excepcion.BusinessException;
import servicio.implementacion.CursoService;
import servicio.implementacion.EventoService;
import servicio.implementacion.InstructorService;
import servicio.implementacion.PagoService;
import servicio.implementacion.PaisService;
import servicio.implementacion.PreinscripcionService;
import servicio.implementacion.UsuarioService;
import servicio.interfaces.ICursoService;
import servicio.interfaces.IEventoService;
import servicio.interfaces.IInstructorService;
import servicio.interfaces.IPagoService;
import servicio.interfaces.IPaisService;
import servicio.interfaces.IPreinscripcionService;
import servicio.interfaces.IUsuarioService;
import vo.CursoVO;
import vo.EventoVO;
import vo.InstructorVO;
import vo.MensajesVO;
import vo.PagoVO;
import vo.PaisVO;
import vo.PreinscripcionVO;
import vo.UsuarioVO;

/**
 * @author Eric
 *
 */
public class InteresadoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String correo = (String) req.getRemoteUser();
		System.out.println("j_user_name: " + correo);
		
		HttpSession session = req.getSession();
		session.setAttribute("correo", correo);
		
		System.out.println("j_user_name: " + session.getAttribute("correo"));
		
		String opcion = req.getParameter("opcion");
		String detallesEvento = req.getParameter("detallesEvento");
		String preinscripcion = req.getParameter("preinscripcion");
		String confirmarPreinscripcion = req.getParameter("confirmarPreinscripcion");
		String pagarEvento = req.getParameter("pagarEvento");
		
		String confirmarInscripcion = req.getParameter("confirmarInscripcion");
		
		
		if(opcion != null) {
			if(opcion.equals("verListadoEventos")) {
				listadoEventos(req, resp);
			}
			if(opcion.equals("verListadoInscripciones")) {
				listaInscripciones(req, resp);
			}
		}else if(detallesEvento != null) {
			detallesEvento(req, resp, detallesEvento);
		}else if(preinscripcion != null) {
			inicioPreinscripcion(req, resp, preinscripcion);
		}else if(confirmarPreinscripcion != null) {
			if(confirmarPreinscripcion.equals("preinscrito")) {
				confirmarPreinscripcion(req, resp);
			}
		}else if(pagarEvento != null) {
			pagarEvento(req, resp, pagarEvento);
		}else if(confirmarInscripcion != null) {
			if(confirmarInscripcion.equals("inscripcion")) {
				confirmarInscripcion(req, resp);
			}
			
		}
	}
	
	private void confirmarInscripcion(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		int idEvento = Integer.parseInt(req.getParameter("idInscripcion"));
		String metodoPago = req.getParameter("metodoPago");
		System.out.println(metodoPago);
		
		MensajesVO mensVO = new MensajesVO();
		
		try {
		
			ArrayList<UsuarioVO> listaUsuarios = new ArrayList<UsuarioVO>();
		
			System.out.println("Confirmar Inscripcion");

			
			String correoUsuario = req.getRemoteUser();
		
			UsuarioVO usuario = new UsuarioVO();
			IUsuarioService usuarioService = new UsuarioService();
		
			usuario.setCorreo(correoUsuario);
		
			listaUsuarios = usuarioService.consultarUsuario(usuario);
		
			int usuario_id = listaUsuarios.get(0).getId_usuario();
		
			System.out.println("Usuario ID: " + usuario_id);
			System.out.println("Evento ID: " + idEvento);
		
			PreinscripcionVO inscripcion = new PreinscripcionVO();
			IPreinscripcionService preinscripcionService = new PreinscripcionService();
		
			inscripcion.setId_evento(idEvento);
			inscripcion.setId_usuario(usuario_id);
			inscripcion.setPago(metodoPago);
			
		
			preinscripcionService.actualizarInscripcion(inscripcion);
			
		}catch(BusinessException be) {
			
			mensVO.setId(be.getIdException());
			mensVO.setMensaje(be.getMessage());
			req.setAttribute("mens", mensVO);
			
		}catch(Exception e) {
			
			mensVO.setId("302");
			mensVO.setMensaje("Error en la llamada al recurso alta-evento.do");
			req.setAttribute("mens", mensVO);
			
		}finally{
			
			listaInscripciones(req, resp);
			
		}
	}

	private void pagarEvento(HttpServletRequest req, HttpServletResponse resp, String pagarEvento) {
		// TODO Auto-generated method stub
		int idModificado = Integer.parseInt(pagarEvento);
		
		MensajesVO mensVO = new MensajesVO();
		
		HttpSession session = req.getSession();
		String correo = (String) session.getAttribute("correo");
		System.out.println(correo);
		System.out.println(req.getRemoteUser());
		
		try {
			
			ArrayList<UsuarioVO> listaUsuarios = new ArrayList<UsuarioVO>();
			
			UsuarioVO usuario = new UsuarioVO();
			
			IUsuarioService usuarioService = new UsuarioService();
			
			usuario.setCorreo(correo);
			usuario.setId_usuario(idModificado);
			
			listaUsuarios = usuarioService.consultarUsuario(usuario);
			
			req.setAttribute("listaUsuarios", listaUsuarios);
			req.setAttribute("idPreinscripcion", idModificado);
			
						
			mensVO.setId("000");
			mensVO.setMensaje("Ejecicion exitosa");
			
			req.setAttribute("mens", mensVO);
			
		}catch(BusinessException be) {
			
			mensVO.setId(be.getIdException());
			mensVO.setMensaje(be.getMessage());
			req.setAttribute("mens", mensVO);
			
		}catch(Exception e) {
			
			mensVO.setId("302");
			mensVO.setMensaje("Error en la llamada al recurso alta-evento.do");
			req.setAttribute("mens", mensVO);
			
		}finally{
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/pagarEvento.jsp");
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

	private void listaInscripciones(HttpServletRequest req, HttpServletResponse resp) {
		MensajesVO mensVO = new MensajesVO();
		
		String correo = req.getRemoteUser();
		
		try {
			ArrayList<UsuarioVO> listaUsuarios = new ArrayList<UsuarioVO>();
			ArrayList<PreinscripcionVO> listaPreinscripciones = new ArrayList<PreinscripcionVO>();
			
			PreinscripcionVO preinscripcion = new PreinscripcionVO();
			IPreinscripcionService preinscripcionService = new PreinscripcionService();
			
			UsuarioVO usuario = new UsuarioVO();
			IUsuarioService usuarioService = new UsuarioService();
			
			usuario.setCorreo(correo);
			
			listaUsuarios = usuarioService.consultarUsuario(usuario);
			
			int usuario_id = listaUsuarios.get(0).getId_usuario();
			
			preinscripcion.setId_usuario(usuario_id);
			
			listaPreinscripciones = preinscripcionService.consultaInscripcionesUsuario(preinscripcion);
			
			System.out.println("numero de inscripciones: " + listaPreinscripciones.size());
			
			req.setAttribute("listaInscripcionesUsuario", listaPreinscripciones);
			
		}catch(BusinessException be) {
			
			mensVO.setId(be.getIdException());
			mensVO.setMensaje(be.getMessage());
			req.setAttribute("mens", mensVO);
			
		}catch(Exception e) {
			
			mensVO.setId("302");
			mensVO.setMensaje("Error en la llamada al recurso alta-evento.do");
			req.setAttribute("mens", mensVO);
			
		}finally{
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaInscripcionesInteresado.jsp");
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

	private void confirmarPreinscripcion(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		MensajesVO mensVO = new MensajesVO();
		
		try {
		
			ArrayList<UsuarioVO> listaUsuarios = new ArrayList<UsuarioVO>();
		
			System.out.println("Confirmar Inscripcion");
			int evento_id = Integer.parseInt(req.getParameter("idPreinscripcion"));
			System.out.println("Evento id: "+evento_id);
			
			String metodoPago = req.getParameter("metodoPago");
			String nombreUsuario = req.getParameter("nombrePreinscripcion");
			String appelidoPUsuario = req.getParameter("apellidoPaternoPreinscripcion");
			String appelidoMUsuario = req.getParameter("apellidoMaternoPreinscripcion");
			String telefonoUsuario = req.getParameter("telefonoPreinscripcion");
			String correoUsuario = req.getRemoteUser();
		
			UsuarioVO usuario = new UsuarioVO();
			IUsuarioService usuarioService = new UsuarioService();
		
			usuario.setCorreo(correoUsuario);
		
			listaUsuarios = usuarioService.consultarUsuario(usuario);
		
			int usuario_id = listaUsuarios.get(0).getId_usuario();
		
			System.out.println("Usuario ID: " + usuario_id);
			System.out.println("Evento ID: " + evento_id);
		
			PreinscripcionVO preinscripcion = new PreinscripcionVO();
			IPreinscripcionService preinscripcionService = new PreinscripcionService();
		
			preinscripcion.setId_evento(evento_id);
			preinscripcion.setId_usuario(usuario_id);
			preinscripcion.setPago(metodoPago);
			preinscripcion.setNombre(nombreUsuario);
			preinscripcion.setApellido_paterno(appelidoPUsuario);
			preinscripcion.setApellido_materno(appelidoMUsuario);
			preinscripcion.setTelefono(telefonoUsuario);
		
			preinscripcionService.insertarInscripcion(preinscripcion);
			
		}catch(BusinessException be) {
			
			mensVO.setId(be.getIdException());
			mensVO.setMensaje(be.getMessage());
			req.setAttribute("mens", mensVO);
			
		}catch(Exception e) {
			
			mensVO.setId("302");
			mensVO.setMensaje("Error en la llamada al recurso alta-evento.do");
			req.setAttribute("mens", mensVO);
			
		}finally{
			
			listaInscripciones(req, resp);
			
		}

	}

	private void inicioPreinscripcion(HttpServletRequest req, HttpServletResponse resp, String id) {
		// TODO Auto-generated method stub
		MensajesVO mensVO = new MensajesVO();
		
		HttpSession session = req.getSession();
		String correo = (String) session.getAttribute("correo");
		System.out.println(correo);
		System.out.println(req.getRemoteUser());
		
		try {
			int idModificado = Integer.parseInt(id);
			ArrayList<UsuarioVO> listaUsuarios = new ArrayList<UsuarioVO>();
			
			UsuarioVO usuario = new UsuarioVO();
			
			IUsuarioService usuarioService = new UsuarioService();
			
			usuario.setCorreo(correo);
			usuario.setId_usuario(idModificado);
			
			listaUsuarios = usuarioService.consultarUsuario(usuario);
			
			req.setAttribute("listaUsuarios", listaUsuarios);
			req.setAttribute("idPreinscripcion", idModificado);
			
						
			mensVO.setId("000");
			mensVO.setMensaje("Ejecicion exitosa");
			
			req.setAttribute("mens", mensVO);
			
		}catch(BusinessException be) {
			
			mensVO.setId(be.getIdException());
			mensVO.setMensaje(be.getMessage());
			req.setAttribute("mens", mensVO);
			
		}catch(Exception e) {
			
			mensVO.setId("302");
			mensVO.setMensaje("Error en la llamada al recurso alta-evento.do");
			req.setAttribute("mens", mensVO);
			
		}finally{
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/preinscripcion.jsp");
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

	private void detallesEvento(HttpServletRequest req, HttpServletResponse resp, String detallesEvento) {
		// TODO Auto-generated method stub
		MensajesVO mensVO = new MensajesVO();
		try {
			ArrayList<EventoVO> listaDatosEvento = new ArrayList<EventoVO>();
			EventoVO evento = new EventoVO();
		
			IEventoService eventoService = new EventoService();
		
			int idModificado = Integer.parseInt(detallesEvento);
			evento.setNombre("EVENTOS");
			evento.setId_evento(idModificado);
			listaDatosEvento = eventoService.obtenerDatosEvento(evento);
			req.setAttribute("listaDatosEvento", listaDatosEvento);
			
			
		
		
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/detallesEvento2.jsp");
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

	private void listadoEventos(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		MensajesVO mensVO = new MensajesVO();
		
		try {
			
			ArrayList<EventoVO> listaEventos = new ArrayList<EventoVO>();
			
			EventoVO evento = new EventoVO();
			
			IEventoService eventoService = new EventoService();
			
			evento.setNombre("EVENTOS");
			
			listaEventos = eventoService.listarEvento(evento);
			
			req.setAttribute("listaEventos", listaEventos);
			
			
			mensVO.setId("000");
			mensVO.setMensaje("Ejecicion exitosa");
			
			req.setAttribute("mens", mensVO);
			
		}catch(BusinessException be) {
			
			mensVO.setId(be.getIdException());
			mensVO.setMensaje(be.getMessage());
			req.setAttribute("mens", mensVO);
			
		}catch(Exception e) {
			
			mensVO.setId("302");
			mensVO.setMensaje("Error en la llamada al recurso alta-evento.do");
			req.setAttribute("mens", mensVO);
			
		}finally{
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaEventosInteresado.jsp");
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
