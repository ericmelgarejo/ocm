/**
 * 
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.implementacion.PaisDAO;
import excepcion.BusinessException;
import servicio.implementacion.CiudadService;
import servicio.implementacion.CursoService;
import servicio.implementacion.DestinatarioService;
import servicio.implementacion.EventoService;
import servicio.implementacion.InstructorService;
import servicio.implementacion.LugarService;
import servicio.implementacion.PaisService;
import servicio.implementacion.PreinscripcionService;
import servicio.implementacion.ProgramasService;
import servicio.interfaces.ICiudadService;
import servicio.interfaces.ICursoService;
import servicio.interfaces.IDestinatarioService;
import servicio.interfaces.IEventoService;
import servicio.interfaces.IInstructorService;
import servicio.interfaces.ILugarService;
import servicio.interfaces.IPaisService;
import servicio.interfaces.IPreinscripcionService;
import servicio.interfaces.IProgramasService;
import vo.CiudadVO;
import vo.CursoVO;
import vo.DestinatarioVO;
import vo.EventoVO;
import vo.InstructorVO;
import vo.LugarVO;
import vo.MensajesVO;
import vo.PaisVO;
import vo.PreinscripcionVO;
import vo.ProgramaVO;

/**
 * @author sergio
 *
 */
public class Servlet extends HttpServlet {
	
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
		System.out.println(opcion);
		String modificarEvento = req.getParameter("modificarEvento");
		String confirmarModificarEvento = req.getParameter("confirmarModificarEvento");
		String eliminarEvento = req.getParameter("eliminarEvento");
		String detallesListaEvento = req.getParameter("detallesListaEvento");
		String detallesInscripcionEvento = req.getParameter("detallesInscripcionEvento");
		String preinscripcionEvento = req.getParameter("preinscripcionEvento");
		String crearInscripcion = req.getParameter("crearInscripcion");
		String pagarEvento = req.getParameter("pagarEvento");
		String confirmarPago = req.getParameter("confirmarPago");
		if(opcion != null) {
			if (opcion.equals("inicioAltaEvento")) {
				try {
					inicioAltaEvento(req, resp);
				}catch(Exception e) {
					
				}
			}else if(opcion.equals("verEventos")){
				listarEventosInscripciones(req, resp);
				
			}else if(opcion.equals("crearPreinscripcion")){
				inicioCrearPreinscripcion(req, resp);
			}else if(opcion.equals("crearNuevoEvento")) {
				crearNuevoEvento(req, resp);
			}else if(opcion.equals("verListadoEventos")) {
				try {
					listadoEventos(req, resp);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(opcion.equals("verListadoEventosDetalle")) {
				try {
					listadoEventosDetalle(req, resp);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}else if(opcion.equals("verInscripciones")) {
				listadoInscripciones(req, resp);
			}else if(opcion.equals("cerrarSeccion")) {
				cerrarSecion(req, resp);
			}else if(opcion.equals("generatxt")) {
				try {
					generaTxt(req, resp);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(opcion.equals("inicioAltaInscripcion")) {
				
			}
			
		}else if(modificarEvento != null) {
			try {
				inicioModificarEvento(req, resp, modificarEvento);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(confirmarModificarEvento != null) {
			modificarEvento(req, resp);
		}else if(eliminarEvento != null) {
			eliminarEvento(req, resp, eliminarEvento);
		}else if(detallesListaEvento != null) {
			detallesListaEvento(req, resp, detallesListaEvento);
		}else if(detallesInscripcionEvento != null) {
			detallesInscripcionEvento(req, resp, detallesInscripcionEvento);
		}else if(preinscripcionEvento != null) {
			listaPreinscripcionEvento(req, resp, preinscripcionEvento);
		}else if(crearInscripcion != null) {
			crearInscripcion(req, resp);
		}else if(pagarEvento != null) {
			pagarEvento(req, resp, pagarEvento);
		}else if(confirmarPago != null) {
			confirmarPago(req, resp, confirmarPago);
		}
	}
	
	private void confirmarPago(HttpServletRequest req, HttpServletResponse resp, String confirmarPago) {
		// TODO Auto-generated method stub
		try {
			int id_inscripcion = Integer.parseInt(confirmarPago);
			String id_evento = req.getParameter("idEventoInscripcion");
			int id_evento_modificado = Integer.parseInt(id_evento);
			System.out.println(id_inscripcion);
			String metodoPago = req.getParameter("metodoPago");
			System.out.println(metodoPago);
			PreinscripcionVO preinscripcion = new PreinscripcionVO();
			preinscripcion.setId_inscripcion(id_inscripcion);
			preinscripcion.setPago(metodoPago);
			preinscripcion.setId_evento(id_evento_modificado);
			IPreinscripcionService psService = new PreinscripcionService();
			psService.actualizarInscripcion(preinscripcion);
			listaPreinscripcionEvento(req, resp, id_evento);
		}catch(Exception ex) {
			
		}
	}

	private void pagarEvento(HttpServletRequest req, HttpServletResponse resp, String pagarEvento) {
		// TODO Auto-generated method stub
		try {
			int idusuario = Integer.parseInt(pagarEvento);
			int id_evento = Integer.parseInt(req.getParameter("idPagarEvento"));
			ArrayList<PreinscripcionVO> listaPreinscripcion = new ArrayList<PreinscripcionVO>();
			
			PreinscripcionVO preinscripcion = new PreinscripcionVO();
			
			IPreinscripcionService psService = new PreinscripcionService();
			preinscripcion.setId_evento(id_evento);
			preinscripcion.setId_usuario(idusuario);
			//pais.setNombre("PAISES");
			
			listaPreinscripcion = psService.consultaInscripcionesUsuario(preinscripcion);
			
			req.setAttribute("listaPreinscripciones", listaPreinscripcion);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/pagarEvento.jsp");
			rd.forward(req, resp);
			
		}catch(Exception ex) {
			
		}
		
	}

	private void inicioCrearPreinscripcion(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		int idEvento = Integer.parseInt(req.getParameter("idEvento"));
		System.out.println(idEvento);
	}

	private void crearInscripcion(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
		String evento = req.getParameter("idEvento");
		int idEvento = Integer.parseInt(evento);
		System.out.println(idEvento);
		String nombre = req.getParameter("nombrePreinscripcion");
		String apellido_paterno = req.getParameter("apellidoPaternoPreinscripcion");
		String apellido_materno = req.getParameter("apellidoMaternoPreinscripcion");
		String telefono = req.getParameter("telefonoPreinscripcion");
		
		PreinscripcionVO preinscripcion = new PreinscripcionVO();
		preinscripcion.setNombre(nombre);
		preinscripcion.setId_evento(idEvento);
		preinscripcion.setApellido_paterno(apellido_paterno);
		preinscripcion.setApellido_materno(apellido_materno);
		preinscripcion.setTelefono(telefono);
		
		IPreinscripcionService psService = new PreinscripcionService();
		psService.insertarInscripcion(preinscripcion);
		listaPreinscripcionEvento(req, resp, evento);
		}catch(Exception ex) {
			
		}
	}

	private void listaPreinscripcionEvento(HttpServletRequest req, HttpServletResponse resp,
			String preinscripcionEvento) {
		// TODO Auto-generated method stub
		try {
		int id = Integer.parseInt(preinscripcionEvento);
		ArrayList<PreinscripcionVO> listaPreinscripciones = new ArrayList<PreinscripcionVO>();
		PreinscripcionVO preinscripcion = new PreinscripcionVO();
		IPreinscripcionService preinscripcionService = new PreinscripcionService();
		preinscripcion.setId_evento(id);
		listaPreinscripciones = preinscripcionService.consultaInscripciones(preinscripcion);
		req.setAttribute("listaPreinscripciones", listaPreinscripciones);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaInscripcionesEvento.jsp");
		rd.forward(req, resp);
		}catch(Exception ex) {
			
		}
		
	}

	private void detallesInscripcionEvento(HttpServletRequest req, HttpServletResponse resp,
			String detallesInscripcionEvento) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(detallesInscripcionEvento);
		ArrayList<EventoVO> listaEventos = new ArrayList<EventoVO>();
		
		EventoVO evento = new EventoVO();
		
		IEventoService eventoService = new EventoService();
		
		evento.setNombre("EVENTOS");
		evento.setId_evento(id);
		
		listaEventos = eventoService.detallesInscripcionEvento(evento);
		
		req.setAttribute("listaEventos", listaEventos);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/detallesInscripcionEvento.jsp");
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

	private void listarEventosInscripciones(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			
			ArrayList<EventoVO> listaEventos = new ArrayList<EventoVO>();
			
			EventoVO evento = new EventoVO();
			
			IEventoService eventoService = new EventoService();
			
			evento.setNombre("EVENTOS");
			
			listaEventos = eventoService.listarEvento(evento);
			
			req.setAttribute("listaEventos", listaEventos);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/eventosInscripciones.jsp");
			rd.forward(req, resp);
		}catch(Exception ex) {
			
		}
	}

	private void detallesListaEvento(HttpServletRequest req, HttpServletResponse resp, String detallesListaEvento) {
		// TODO Auto-generated method stub
		
			int id = Integer.parseInt(detallesListaEvento);
			ArrayList<EventoVO> listaEventos = new ArrayList<EventoVO>();
			
			EventoVO evento = new EventoVO();
			
			IEventoService eventoService = new EventoService();
			
			evento.setNombre("EVENTOS");
			evento.setId_evento(id);
			
			listaEventos = eventoService.detallesListaEvento(evento);
			
			req.setAttribute("listaEventos", listaEventos);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/detallesListaEvento.jsp");
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

	public void inicioAltaEvento(HttpServletRequest req, HttpServletResponse resp) throws Exception{ 
		
		MensajesVO mensVO = new MensajesVO();
		
		try {
			
			ArrayList<PaisVO> listaPaises = new ArrayList<PaisVO>();
			
			PaisVO pais = new PaisVO();
			
			IPaisService psService = new PaisService();
			
			pais.setNombre("PAISES");
			
			listaPaises = psService.consultaPaises(pais);
			
			req.setAttribute("listaPaises", listaPaises);
			
			ArrayList<InstructorVO> listaInstructores = new ArrayList<InstructorVO>();
			InstructorVO instructor = new InstructorVO();
			IInstructorService instService = new InstructorService();
			instructor.setNombre("USUARIOS");
			listaInstructores = instService.consultaInstructores(instructor);
			req.setAttribute("listaInstructores", listaInstructores);
			
			ArrayList<CursoVO> listaCursos = new ArrayList<CursoVO>();
			CursoVO curso = new CursoVO();
			ICursoService cursoService = new CursoService();
			curso.setNombre("CURSOS");
			listaCursos = cursoService.consultaCursos();
			req.setAttribute("listaCursos", listaCursos);
			
			ArrayList<ProgramaVO> listaProgramas = new ArrayList<ProgramaVO>();
			ProgramaVO programa = new ProgramaVO();
			IProgramasService programaService = new ProgramasService();
			listaProgramas = programaService.consultarProgramas();
			req.setAttribute("listaProgramas", listaProgramas);
			
			
			
			ArrayList<DestinatarioVO> listaDestinatarios = new ArrayList<DestinatarioVO>();
			DestinatarioVO destinatario = new DestinatarioVO();
			IDestinatarioService destinatarioService = new DestinatarioService();
			listaDestinatarios = destinatarioService.consultaDestinatarios(destinatario);
			req.setAttribute("listaDestinatarios", listaDestinatarios);
			
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
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/inicioEvento.jsp");
			rd.forward(req, resp);
			
		}
		
		
	}
	
	private void listadoEventosDetalle(HttpServletRequest req, HttpServletResponse resp) throws Exception {
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
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/detallesEvento.jsp");
			rd.forward(req, resp);
			
		}
		
	}

	private void listadoInscripciones(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		System.out.println("Listar Inscripciones");
		MensajesVO mensVO = new MensajesVO();
		
		try {
			
			ArrayList<PreinscripcionVO> listaInscripciones = new ArrayList<PreinscripcionVO>();
			
			PreinscripcionVO preinscripcion = new PreinscripcionVO();
			
			IPreinscripcionService preinscripcionService = new PreinscripcionService();
			
			preinscripcion.setNombre("INSCRIPCIONES");
			
			listaInscripciones = preinscripcionService.consultaInscripciones(preinscripcion);
			
			req.setAttribute("listaInscripciones", listaInscripciones);
			
			
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
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaInscripciones.jsp");
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

	private void eliminarEvento(HttpServletRequest req, HttpServletResponse resp, String eliminarEvento) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(eliminarEvento);
		EventoVO evento = new EventoVO();
		IEventoService eventoService = new EventoService();
		evento.setId_evento(id);
		try {
			eventoService.eliminarEvento(evento);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
				try {
					listadoEventos(req, resp);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	private void modificarEvento(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		System.out.println("Crear Nuevo Evento");
		int id = Integer.parseInt(req.getParameter("idEvento"));
		String nombre = req.getParameter("nombreModificarEvento");
		String descripcion = req.getParameter("descripcionModificarEvento");
		String tipo = req.getParameter("tipoModificarEvento");
		double precio = Double.parseDouble(req.getParameter("precioModificarEvento"));
		int capacidad = Integer.parseInt(req.getParameter("capacidadModificarEvento"));
		String fecha_inicio = req.getParameter("fechaInicioModificarEvento");
		String fecha_fin = req.getParameter("fechaFinModificarEvento");
		String promocion = req.getParameter("promocion");
		int id_usuario = Integer.parseInt(req.getParameter("selectInstructor"));
		int id_curso = Integer.parseInt(req.getParameter("selectCurso"));
		int id_lugar = Integer.parseInt(req.getParameter("selectLugar"));
		int id_destinatario = Integer.parseInt(req.getParameter("selectDestinatario"));
		
		EventoVO evento = new EventoVO();
		IEventoService eventoService = new EventoService();
		evento.setId_evento(id);
		evento.setNombre(nombre);
		evento.setDescripcion(descripcion);
		evento.setTipo(tipo);
		evento.setPrecio(precio);
		evento.setCapacidad(capacidad);
		evento.setFecha_inicio(fecha_inicio);
		evento.setFecha_fin(fecha_fin);
		evento.setPromocion(promocion);
		evento.setId_usuario(id_usuario);
		evento.setId_curso(id_curso);
		evento.setId_lugar(id_lugar);
		evento.setId_destinatario(id_destinatario);
		try {
			eventoService.modificarEvento(evento);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				listadoEventos(req, resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private void inicioModificarEvento(HttpServletRequest req, HttpServletResponse resp, String modificarEvento) throws Exception {
		// TODO Auto-generated method stub
		MensajesVO mensVO = new MensajesVO();
		try {
			ArrayList<EventoVO> listaDatosEvento = new ArrayList<EventoVO>();
			EventoVO evento = new EventoVO();
		
			IEventoService eventoService = new EventoService();
		
			int idModificado = Integer.parseInt(modificarEvento);
			evento.setNombre("EVENTOS");
			evento.setId_evento(idModificado);
			listaDatosEvento = eventoService.obtenerDatosEvento(evento);
			req.setAttribute("listaDatosEvento", listaDatosEvento);
			
			ArrayList<PaisVO> listaPaises = new ArrayList<PaisVO>();
			
			PaisVO pais = new PaisVO();
			
			IPaisService psService = new PaisService();
			
			pais.setNombre("PAISES");
			
			listaPaises = psService.consultaPaises(pais);
			
			req.setAttribute("listaPaises", listaPaises);
			
			ArrayList<InstructorVO> listaInstructores = new ArrayList<InstructorVO>();
			InstructorVO instructor = new InstructorVO();
			IInstructorService instService = new InstructorService();
			instructor.setNombre("USUARIOS");
			listaInstructores = instService.consultaInstructores(instructor);
			req.setAttribute("listaInstructores", listaInstructores);
			
			ArrayList<CursoVO> listaCursos = new ArrayList<CursoVO>();
			CursoVO curso = new CursoVO();
			ICursoService cursoService = new CursoService();
			curso.setNombre("CURSOS");
			listaCursos = cursoService.consultaCursos();
			req.setAttribute("listaCursos", listaCursos);
			
			ArrayList<CiudadVO> listaCiudades = new ArrayList<CiudadVO>();
			ICiudadService ciudadService = new CiudadService();
			CiudadVO ciudad = new CiudadVO();
			listaCiudades = ciudadService.consultaListaCiudades(ciudad);
			req.setAttribute("listaCiudades", listaCiudades);
			
			ArrayList<LugarVO> listaLugares = new ArrayList<LugarVO>();
			ILugarService listaLugarService = new LugarService();
			LugarVO lugar = new LugarVO();
			listaLugares = listaLugarService.consultaListaLugares(lugar);
			req.setAttribute("listaLugares", listaLugares);
			
			ArrayList<ProgramaVO> listaProgramas = new ArrayList<ProgramaVO>();
			IProgramasService programaService = new ProgramasService();
			listaProgramas = programaService.consultarProgramas();
			req.setAttribute("listaProgramas", listaProgramas);
			
			ArrayList<DestinatarioVO> listaDestinatarios = new ArrayList<DestinatarioVO>();
			DestinatarioVO destinatario = new DestinatarioVO();
			IDestinatarioService destinatarioService = new DestinatarioService();
			listaDestinatarios = destinatarioService.consultaDestinatarios(destinatario);
			req.setAttribute("listaDestinatarios", listaDestinatarios);
			
			int idCurso = 0;
			int idLugar = 0;
			for (EventoVO eventovo : listaDatosEvento) {
				idCurso = eventovo.getId_curso();
				idLugar = eventovo.getId_lugar();
			}
			
			ArrayList<Integer> idCiudadPais = new ArrayList<Integer>();
			ILugarService lugarService = new LugarService();
			idCiudadPais = lugarService.obtenerCiudadPais(idLugar);
						
			req.setAttribute("idCiudad", idCiudadPais.get(0));
			req.setAttribute("idPais", idCiudadPais.get(1));
			
		
			
			int idPrograma;
			IProgramasService programasService = new ProgramasService();
			idPrograma = programasService.consultarProgramaDeCurso(idCurso);
			req.setAttribute("idPrograma", idPrograma);
			
		
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificarEvento.jsp");
			rd.forward(req, resp);
			
		}
		
		
		
	}

	//Inicia  Listado Evento sin Detalle
		private void listadoEventos(HttpServletRequest req, HttpServletResponse resp) throws Exception {
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
				
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaEventos.jsp");
				rd.forward(req, resp);
				
			}
			
		}

	private void crearNuevoEvento(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		System.out.println("Crear Nuevo Evento");
		String nombre = req.getParameter("nombreCrearEvento");
		String descripcion = req.getParameter("descripcionCrearEvento");
		String tipo = req.getParameter("tipoEvento");
		double precio = Double.parseDouble(req.getParameter("precioCrearEvento"));
		int capacidad = Integer.parseInt(req.getParameter("capacidadCrearEvento"));
		String fecha_inicio = req.getParameter("fechaInicioCrearEvento");
		String fecha_fin = req.getParameter("fechaFinCrearEvento");
		//int id_usuario = Integer.parseInt(req.getParameter("usuarioCrearEvento"));
		String promocion = req.getParameter("promocion");
		int id_usuario = Integer.parseInt(req.getParameter("selectInstructor"));
		int id_curso = Integer.parseInt(req.getParameter("selectCurso"));
		int id_lugar = Integer.parseInt(req.getParameter("selectLugar"));
		int id_destinatario = Integer.parseInt(req.getParameter("selectDestinatario"));

		
		EventoVO evento = new EventoVO();
		IEventoService eventoService = new EventoService();
		evento.setNombre(nombre);
		evento.setDescripcion(descripcion);
		evento.setTipo(tipo);
		evento.setPrecio(precio);
		evento.setCapacidad(capacidad);
		evento.setFecha_inicio(fecha_inicio);
		evento.setFecha_fin(fecha_fin);
		evento.setPromocion(promocion);
		evento.setId_usuario(id_usuario);
		evento.setId_curso(id_curso);
		evento.setId_lugar(id_lugar);
		evento.setId_destinatario(id_destinatario);
		
		try {
			eventoService.insertarEvento(evento);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				listadoEventos(req, resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}	
	
	
	private void generaTxt(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
				MensajesVO mensVO = new MensajesVO();
				
				try {
					
					ArrayList<EventoVO> listaEventos = new ArrayList<EventoVO>();
					
					EventoVO evento = new EventoVO();
					
					IEventoService eventoService = new EventoService();
					
					evento.setNombre("EVENTOS");
					
					listaEventos = eventoService.generarTxt(evento);
					
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
					
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaEventos.jsp");
					rd.forward(req, resp);
					
				}
		
	}
	
	
	private void cerrarSecion(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	
		
		try {
			/*
			resp.setContentType("text/html");  
		    PrintWriter out=resp.getWriter();  
		      
		    req.getRequestDispatcher("login.jsp").include(req, resp);  
		      
		    HttpSession session=req.getSession();  
		    session.invalidate();  
		      
		    out.print("You are successfully logged out!");  
		      
		    out.close();  
		    */
			req.getSession().invalidate();
	        resp.sendRedirect(req.getContextPath() + "/login.jsp");
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	

}
