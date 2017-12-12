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

import servicio.implementacion.PaisService;
import servicio.interfaces.IPaisService;
import vo.PaisVO;

/**
 * @author Eric
 *
 */
public class AdminPaisesServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcionPaises = req.getParameter("opcionPaises");
		String inicioModificarPais = req.getParameter("modificarPais");
		String confirmarModificarPais = req.getParameter("confirmarModificarPais");
		String eliminarPais = req.getParameter("eliminarPais");
		if(opcionPaises != null) {
			if(opcionPaises.equals("listarPaises")) {
				listarPaises(req, resp);
			}else if(opcionPaises.equals("agregarPais")) {
				agregarPais(req, resp);
			} 
		}else if(inicioModificarPais != null) {
			inicioModificarPais(req, resp, inicioModificarPais);
			
		}else if(eliminarPais != null) {
			eliminarPais(req, resp, eliminarPais);
		}else if(confirmarModificarPais != null) {
			modificarPais(req, resp);
		}
		
	}

	private void modificarPais(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		System.out.println("Modificar Pais");
		int id = Integer.parseInt(req.getParameter("idPais"));
		String nombre = req.getParameter("nombreModificarPais");
		PaisVO pais = new PaisVO();
		IPaisService paisService = new PaisService();
		pais.setID_Pais(id);
		pais.setNombre(nombre);
		paisService.modificarPais(pais);
		listarPaises(req, resp);
	}

	private void eliminarPais(HttpServletRequest req, HttpServletResponse resp, String eliminarPais) {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(eliminarPais);
		PaisVO pais = new PaisVO();
		IPaisService paisService = new PaisService();
		pais.setID_Pais(id);
		paisService.eliminarPais(pais);
		listarPaises(req, resp);
		
	}

	private void inicioModificarPais(HttpServletRequest req, HttpServletResponse resp, String inicioModificarPais) {
		// TODO Auto-generated method stub
		try {
		ArrayList<PaisVO> listaDatosPais = new ArrayList<PaisVO>();
		PaisVO pais = new PaisVO();
		IPaisService paisService = new PaisService();
		int id = Integer.parseInt(inicioModificarPais);
		pais.setID_Pais(id);
		listaDatosPais = paisService.obtenerDatosPais(pais);
		req.setAttribute("listaDatosPais", listaDatosPais);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificarPais.jsp");
		rd.forward(req, resp);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	private void agregarPais(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		System.out.println("Agregar Pais");
		String nombre = req.getParameter("nombreAgregarPais");
		PaisVO pais = new PaisVO();
		IPaisService paisService = new PaisService();
		pais.setNombre(nombre);
		
		paisService.agregarPais(pais);
		
		listarPaises(req, resp);
	}

	private void listarPaises(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
		ArrayList<PaisVO> listaPaises = new ArrayList<PaisVO>();
		
		PaisVO pais = new PaisVO();
		
		IPaisService psService = new PaisService();
		listaPaises = psService.consultaPaises(pais);
		req.setAttribute("listaPaises", listaPaises);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaPaises.jsp");
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
