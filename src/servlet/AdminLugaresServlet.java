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

import servicio.implementacion.CiudadService;
import servicio.implementacion.LugarService;
import servicio.implementacion.PaisService;
import servicio.interfaces.ICiudadService;
import servicio.interfaces.ILugarService;
import servicio.interfaces.IPaisService;
import vo.CiudadVO;
import vo.LugarVO;
import vo.PaisVO;

/**
 * @author Eric
 *
 */
public class AdminLugaresServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcionLugares = req.getParameter("opcionLugares");
		String inicioModificarLugar = req.getParameter("modificarLugar");
		String confirmarModificarLugar = req.getParameter("confirmarModificarLugar");
		String eliminarLugar = req.getParameter("eliminarLugar");
		if(opcionLugares != null) {
			if(opcionLugares.equals("listarLugares")) {
				listarLugares(req, resp);
			}else if(opcionLugares.equals("agregarLugar")) {
				agregarLugar(req, resp);
			}else if(opcionLugares.equals("inicioAltaLugar")) {
				inicioAltaLugar(req, resp);
			}
		}else if(inicioModificarLugar != null) {
			inicioModificarLugar(req, resp, inicioModificarLugar);
			
		}else if(eliminarLugar != null) {
			eliminarLugar(req, resp, eliminarLugar);
		}else if(confirmarModificarLugar != null) {
			modificarLugar(req, resp);
		}
	}

	private void modificarLugar(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		System.out.println("Modificar Lugar");
		int id = Integer.parseInt(req.getParameter("idLugar"));
		String nombre = req.getParameter("nombreModificarLugar");
		String direccion = req.getParameter("direccionModificarLugar");
		int ciudad_id = Integer.parseInt(req.getParameter("selectCiudad"));
		LugarVO lugar = new LugarVO();
		ILugarService lugarService = new LugarService();
		
		lugar.setId(id);
		lugar.setNombre(nombre);
		lugar.setDireccion(direccion);
		lugar.setCiudad_id(ciudad_id);
		
		lugarService.modificarLugar(lugar);
		listarLugares(req, resp);
	}

	private void eliminarLugar(HttpServletRequest req, HttpServletResponse resp, String eliminarLugar) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(eliminarLugar);
		LugarVO lugar = new LugarVO();
		ILugarService lugarService = new LugarService();
		lugar.setId(id);
		lugarService.eliminarLugar(lugar);
		listarLugares(req, resp);
	}

	private void inicioModificarLugar(HttpServletRequest req, HttpServletResponse resp, String inicioModificarLugar) {
		// TODO Auto-generated method stub
		try {
			ArrayList<LugarVO> listaDatosLugar = new ArrayList<LugarVO>();
			LugarVO lugar = new LugarVO();
			ILugarService lugarService = new LugarService();
			int id = Integer.parseInt(inicioModificarLugar);
			lugar.setId(id);
			listaDatosLugar = lugarService.obtenerDatosLugar(lugar);
			req.setAttribute("listaDatosLugar", listaDatosLugar);
			ArrayList<CiudadVO> listaCiudades = new ArrayList<CiudadVO>();
			
			CiudadVO ciudad = new CiudadVO();
			
			ICiudadService ciudadService = new CiudadService();
			
			ciudad.setNombre("CIUDADES");
			
			listaCiudades = ciudadService.consultaListaCiudades(ciudad);
			
			req.setAttribute("listaCiudades", listaCiudades);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificarLugar.jsp");
			rd.forward(req, resp);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
	}

	private void inicioAltaLugar(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			ArrayList<CiudadVO> listaCiudades = new ArrayList<CiudadVO>();
			
			CiudadVO ciudad = new CiudadVO();
			
			ICiudadService ciudadService = new CiudadService();
			
			ciudad.setNombre("CIUDADES");
			
			listaCiudades = ciudadService.consultaListaCiudades(ciudad);
			
			req.setAttribute("listaCiudades", listaCiudades);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/inicioLugar.jsp");
			rd.forward(req, resp);
			}catch(Exception ex) {
				ex.printStackTrace();
				
			}
		
	}

	private void agregarLugar(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		System.out.println("Crear Nuevo Lugar");
		int id_ciudad = Integer.parseInt(req.getParameter("selectCiudad"));
		System.out.println(id_ciudad);
		String nombre = req.getParameter("nombreAgregarLugar");
		System.out.println(nombre);
		String direccion = req.getParameter("direccionAgregarLugar");
		System.out.println(direccion);
		
		LugarVO lugar = new LugarVO();
		ILugarService lugarService = new LugarService();
		
		lugar.setCiudad_id(id_ciudad);
		lugar.setNombre(nombre);
		lugar.setDireccion(direccion);
		lugarService.agregarLugar(lugar);
		listarLugares(req, resp);
		
		
	}

	private void listarLugares(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			ArrayList<LugarVO> listaLugares = new ArrayList<LugarVO>();
			
			LugarVO lugar = new LugarVO();
			
			ILugarService lugarService = new LugarService();
			listaLugares = lugarService.consultaListaLugares(lugar);
			req.setAttribute("listaLugares", listaLugares);
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaLugares.jsp");
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
