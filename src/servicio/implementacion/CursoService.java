/**
 * 
 */
package servicio.implementacion;

import java.util.ArrayList;

import dao.implementacion.CiudadDAO;
import dao.implementacion.CursoDAO;
import dao.implementacion.PaisDAO;
import dao.implementacion.ProgramasDAO;
import dao.interfaces.ICiudadDAO;
import dao.interfaces.ICursoDAO;
import dao.interfaces.IPaisDAO;
import dao.interfaces.IProgramasDAO;
import excepcion.BusinessException;
import servicio.interfaces.ICursoService;
import vo.CiudadVO;
import vo.CursoVO;
import vo.PaisVO;
import vo.ProgramaVO;

/**
 * @author Eric
 *
 */
public class CursoService implements ICursoService {

	/* (non-Javadoc)
	 * @see servicio.interfaces.ICursoService#consultaCursos(vo.CursoVO)
	 */
	@Override
	public ArrayList<CursoVO> consultaCursos() {
		// TODO Auto-generated method stub
		ArrayList<CursoVO> listaCursos = new ArrayList<CursoVO>();
		
		try {
			
			ICursoDAO cursoDAO = new CursoDAO();
			
			listaCursos = cursoDAO.consultaCursos();
			
			
		}catch(Exception e) {
			System.out.println("Error en consultaCursos de CursoService. Mensage: " + e);
		}
		
		return listaCursos;
	}

	@Override
	public String insertarCurso(CursoVO curso) {
		// TODO Auto-generated method stub
		ArrayList<CursoVO> listaCursos = new ArrayList<CursoVO>();
		
		ICursoDAO cursoDAO = new CursoDAO();
		
		boolean realizarInsert = true;
		
		String respuesta ="";
		
		int id_encontrado = 0;
		
		try {
			
			listaCursos = consultaCursos();
			
			for(int i=0; i<listaCursos.size();i++) {
				if(listaCursos.get(i).getNombre().equals(curso.getNombre())) {
					realizarInsert = false;
					System.out.println("Curso encontrado");
					System.out.println("Curso a insertar: " + curso.getNombre());
					System.out.println("Curso en DB: " + listaCursos.get(i).getNombre());
					id_encontrado = listaCursos.get(i).getId();
					System.out.println("id Curso en DB: " + id_encontrado);
				}
			}
			
			if (realizarInsert == true) {

				respuesta = cursoDAO.insertarCurso(curso);
				
			}else {
				System.out.println("Curso ya existe");
				int status = 1;
				curso.setStatus(status);
				curso.setId(id_encontrado);
				respuesta = actualizarCurso(curso);
			}
			
		}catch(Exception e) {
			System.out.println("Error en insertarCurso de cursoService. Mensaje: "+e);
		}
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see servicio.interfaces.ICursoService#consultarCurso(int)
	 */
	@Override
	public CursoVO consultarCurso(int id) {
		// TODO Auto-generated method stub
		CursoVO curso = new CursoVO();
		
		ICursoDAO cursoDAO = new CursoDAO();
		
		curso = cursoDAO.consultarCurso(id);
		
		return curso;
	}

	/* (non-Javadoc)
	 * @see servicio.interfaces.ICursoService#actualizarCurso(vo.CursoVO)
	 */
	@Override
	public String actualizarCurso(CursoVO curso) {
		// TODO Auto-generated method stub
		String respuesta ="";
		
		ICursoDAO cursoDAO = new CursoDAO();
		
		try {
			
			respuesta = cursoDAO.actualizarCurso(curso);
			
		}catch(Exception e) {
			System.out.println("Error en actualizarCurso de CursoService. Mensaje: "+e);
		}
		
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see servicio.interfaces.ICursoService#eliminarCurso(vo.CursoVO)
	 */
	@Override
	public String eliminarCurso(CursoVO curso) {
		// TODO Auto-generated method stub
		
		String respuesta ="";
		
		ICursoDAO cursoDAO = new CursoDAO();

		try {
			
			respuesta = cursoDAO.eliminarCurso(curso);
			
		}catch(Exception e) {
			System.out.println("Error en eliminarCurso de CursoService. Mensaje: "+e);
		}
		
		return respuesta;
	}

	@Override
	public ArrayList<CursoVO> selectConsultaCursos(int id_programa) {
		// TODO Auto-generated method stub
		try {
			ArrayList<CursoVO> listaCursos = new ArrayList<CursoVO>();
			
			ICursoDAO cursoDAO = new CursoDAO();
			
			listaCursos = cursoDAO.selectConsultaCursos(id_programa);
			
			return listaCursos;
		}catch(Exception ex) {
			System.out.println("Error en el service");
			return null;
		}
	}
}
