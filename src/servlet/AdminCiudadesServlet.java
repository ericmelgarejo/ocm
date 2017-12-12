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
import servicio.implementacion.PaisService;
import servicio.interfaces.ICiudadService;
import servicio.interfaces.IPaisService;
import vo.CiudadVO;
import vo.PaisVO;

/**
 * @author Eric
 *
 */
public class AdminCiudadesServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcionCiudades = req.getParameter("opcionCiudades");
		String inicioModificarCiudad = req.getParameter("modificarCiudad");
		String confirmarModificarCiudad = req.getParameter("confirmarModificarCiudad");
		String eliminarCiudad = req.getParameter("eliminarCiudad");
		if(opcionCiudades != null) {
			if(opcionCiudades.equals("listarCiudades")) {
				listarCiudades(req, resp);
			}else if(opcionCiudades.equals("agregarCiudad")) {
				agregarCiudad(req, resp);
			}else if(opcionCiudades.equals("inicioAltaCiudad")) {
				inicioAltaCiudad(req, resp);
			}
		}else if(inicioModificarCiudad != null) {
			inicioModificarCiudad(req, resp, inicioModificarCiudad);
			
		}else if(eliminarCiudad != null) {
			eliminarCiudad(req, resp, eliminarCiudad);
		}else if(confirmarModificarCiudad != null) {
			modificarCiudad(req, resp);
		}
	}

	private void inicioAltaCiudad(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
		ArrayList<PaisVO> listaPaises = new ArrayList<PaisVO>();
		
		PaisVO pais = new PaisVO();
		
		IPaisService psService = new PaisService();
		
		pais.setNombre("PAISES");
		
		listaPaises = psService.consultaPaises(pais);
		
		req.setAttribute("listaPaises", listaPaises);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/inicioCiudad.jsp");
		rd.forward(req, resp);
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
	}

	private void modificarCiudad(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		System.out.println("Modificar Ciudad");
		int id = Integer.parseInt(req.getParameter("idCiudad"));
		String nombre = req.getParameter("nombreModificarCiudad");
		int pais_id = Integer.parseInt(req.getParameter("selectPais"));
		CiudadVO ciudad = new CiudadVO();
		ICiudadService ciudadService = new CiudadService();
		
		ciudad.setId(id);
		ciudad.setNombre(nombre);
		ciudad.setPais_id(pais_id);
		ciudadService.modificarCiudad(ciudad);
		listarCiudades(req, resp);
		
	}

	private void eliminarCiudad(HttpServletRequest req, HttpServletResponse resp, String eliminarCiudad) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(eliminarCiudad);
		CiudadVO ciudad = new CiudadVO();
		ICiudadService ciudadService = new CiudadService();
		ciudad.setId(id);
		ciudadService.eliminarCiudad(ciudad);
		listarCiudades(req, resp);
	}

	private void inicioModificarCiudad(HttpServletRequest req, HttpServletResponse resp, String inicioModificarCiudad) {
		// TODO Auto-generated method stub
		try {
			ArrayList<CiudadVO> listaDatosCiudad = new ArrayList<CiudadVO>();
			CiudadVO ciudad = new CiudadVO();
			ICiudadService ciudadService = new CiudadService();
			int id = Integer.parseInt(inicioModificarCiudad);
			ciudad.setId(id);
			listaDatosCiudad = ciudadService.obtenerDatosCiudad(ciudad);
			req.setAttribute("listaDatosCiudad", listaDatosCiudad);
			ArrayList<PaisVO> listaPaises = new ArrayList<PaisVO>();
			
			PaisVO pais = new PaisVO();
			
			IPaisService psService = new PaisService();
			
			pais.setNombre("PAISES");
			
			listaPaises = psService.consultaPaises(pais);
			
			req.setAttribute("listaPaises", listaPaises);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificarCiudad.jsp");
			rd.forward(req, resp);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		
	}

	private void agregarCiudad(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		System.out.println("Crear Nueva Ciudad");
		int id_pais = Integer.parseInt(req.getParameter("selectPais"));
		String nombre = req.getParameter("nombreAgregarCiudad");
		
		CiudadVO ciudad = new CiudadVO();
		ICiudadService ciudadService = new CiudadService();
		
		ciudad.setPais_id(id_pais);
		ciudad.setNombre(nombre);
		
		ciudadService.agregarCiudad(ciudad);
		listarCiudades(req, resp);
		
	}

	private void listarCiudades(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			ArrayList<CiudadVO> listaCiudades = new ArrayList<CiudadVO>();
			
			CiudadVO ciudad = new CiudadVO();
			
			ICiudadService ciudadService = new CiudadService();
			listaCiudades = ciudadService.consultaListaCiudades(ciudad);
			req.setAttribute("listaCiudades2", listaCiudades);
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaCiudades.jsp");
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
