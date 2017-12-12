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
import servicio.implementacion.CursoService;
import servicio.interfaces.ICiudadService;
import servicio.interfaces.ICursoService;
import vo.CiudadVO;
import vo.CursoVO;

/**
 * @author Eric
 *
 */
public class SelectCursosServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id_programa = Integer.parseInt(req.getParameter("id_programa"));
		ICursoService ciudadService = new CursoService();
		ArrayList<CursoVO> listaCursos = new ArrayList<CursoVO>();
		try {
			listaCursos = ciudadService.selectConsultaCursos(id_programa);
			String respuesta = "<option>Selecciona el curso...</option>";
			for (CursoVO cursoVO : listaCursos) {
				respuesta += "<option value='"+cursoVO.getId()+"' >"+cursoVO.getNombre()+"</option>";
				
			}
			
			resp.setContentType("text/plain");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(respuesta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
