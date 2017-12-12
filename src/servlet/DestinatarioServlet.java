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

import servicio.implementacion.DestinatarioService;
import servicio.interfaces.IDestinatarioService;
import vo.DestinatarioVO;

/**
 * @author b
 *
 */
public class DestinatarioServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcionDestinatarios = req.getParameter("opcionDestinatarios");
		String inicioModificarDestinatario = req.getParameter("modificarDestinatario");
		String confirmarModificarDestinatario = req.getParameter("confirmarModificarDestinatario");
		String eliminarDestinatario = req.getParameter("eliminarDestinatario");
		
		if(opcionDestinatarios != null) {
			if(opcionDestinatarios.equals("listarDestinatarios")) {
				listarDestinatarios(req, resp);
			}else if(opcionDestinatarios.equals("agregarDestinatario")) {
				agregarDestinatario(req, resp);
			} 
		}else if(inicioModificarDestinatario != null) {
			inicioModificarDestinatario(req, resp, inicioModificarDestinatario);
			
		}else if(eliminarDestinatario != null) {
			eliminarDestinatario(req, resp, eliminarDestinatario);
		}else if(confirmarModificarDestinatario != null) {
			modificarDestinatario(req, resp);
		}
		
	}

	private void modificarDestinatario(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		System.out.println("Modificar Destinatario");
		int id = Integer.parseInt(req.getParameter("idDestinatario"));
		String nombre = req.getParameter("nombreModificarDestinatario");

		DestinatarioVO destinatario = new DestinatarioVO();
		IDestinatarioService DestinatarioService = new DestinatarioService();
		
		destinatario.setId_destinatario(id);
		destinatario.setNombre(nombre);
		
		DestinatarioService.modificarDestinatario(destinatario);
		listarDestinatarios(req, resp);
	}

	private void eliminarDestinatario(HttpServletRequest req, HttpServletResponse resp, String eliminarDestinatario) {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(eliminarDestinatario);
		DestinatarioVO Destinatario = new DestinatarioVO();
		IDestinatarioService DestinatarioService = new DestinatarioService();
		Destinatario.setId_destinatario(id);
		DestinatarioService.eliminarDestinatario(Destinatario);
		listarDestinatarios(req, resp);
		
	}

	private void inicioModificarDestinatario(HttpServletRequest req, HttpServletResponse resp, String inicioModificarDestinatario) {
		// TODO Auto-generated method stub
		try {
		ArrayList<DestinatarioVO> listaDatosDestinatario = new ArrayList<DestinatarioVO>();
		DestinatarioVO Destinatario = new DestinatarioVO();
		IDestinatarioService DestinatarioService = new DestinatarioService();
		int id = Integer.parseInt(inicioModificarDestinatario);
		Destinatario.setId_destinatario(id);
		listaDatosDestinatario = DestinatarioService.obtenerDatosDestinatario(Destinatario);
		req.setAttribute("listaDatosDestinatarios", listaDatosDestinatario);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificarDestinatario.jsp");
		rd.forward(req, resp);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	private void agregarDestinatario(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		System.out.println("Agregar Destinatario");
		String nombre = req.getParameter("nombreAgregarDestinatario");
		DestinatarioVO Destinatario = new DestinatarioVO();
		IDestinatarioService DestinatarioService = new DestinatarioService();
		Destinatario.setNombre(nombre);
		
		DestinatarioService.agregarDestinatario(Destinatario);
		
		listarDestinatarios(req, resp);
	}

	private void listarDestinatarios(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("Listar Destinatario");
		
		try {
		ArrayList<DestinatarioVO> listaDestinatarios = new ArrayList<DestinatarioVO>();
		
		DestinatarioVO destinatario = new DestinatarioVO();
		
		IDestinatarioService psService = new DestinatarioService();
		listaDestinatarios = psService.consultaDestinatarios(destinatario);
		req.setAttribute("listaDestinatarios", listaDestinatarios);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaDestinatario.jsp");
			try {
				rd.forward(req, resp);
			} catch (ServletException e) {
				System.out.println(e);
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println(e);
				e.printStackTrace();
			}
		}
	}
}

