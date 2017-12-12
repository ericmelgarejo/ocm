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

import excepcion.BusinessException;
import servicio.implementacion.CiudadService;
import servicio.implementacion.LugarService;
import servicio.interfaces.ICiudadService;
import servicio.interfaces.ILugarService;
import vo.CiudadVO;
import vo.LugarVO;

/**
 * @author Eric
 *
 */
public class LugarServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id_ciudad = Integer.parseInt(req.getParameter("id_ciudad"));
		ILugarService lugarService = new LugarService();
		ArrayList<LugarVO> listaLugares = new ArrayList<LugarVO>();
		try {
			listaLugares = lugarService.consultaLugares(id_ciudad);
			String respuesta = "<option>Selecciona el lugar...</option>";
			for (LugarVO lugarVO : listaLugares) {
				respuesta += "<option value='"+lugarVO.getId()+"' >"+lugarVO.getNombre()+"</option>";
				
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
