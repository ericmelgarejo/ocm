/**
 * 
 */
package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import excepcion.BusinessException;
import servicio.implementacion.CiudadService;
import servicio.interfaces.ICiudadService;
import vo.CiudadVO;

/**
 * @author Eric
 *
 */
public class CiudadServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id_pais = Integer.parseInt(req.getParameter("id_pais"));
		ICiudadService ciudadService = new CiudadService();
		ArrayList<CiudadVO> listaCiudades = new ArrayList<CiudadVO>();
		try {
			listaCiudades = ciudadService.consultaCiudades(id_pais);
			String respuesta = "<option>Selecciona la ciudad...</option>";
			for (CiudadVO ciudadVO : listaCiudades) {
				respuesta += "<option value='"+ciudadVO.getId()+"' >"+ciudadVO.getNombre()+"</option>";
				
			}
			
			resp.setContentType("text/plain");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(respuesta);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
