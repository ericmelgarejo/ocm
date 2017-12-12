/**
 * 
 */
package servicio.implementacion;

import java.util.ArrayList;

import dao.implementacion.InstructorDAO;

import dao.interfaces.IInstructorDAO;
import excepcion.BusinessException;
import servicio.interfaces.IInstructorService;
import vo.InstructorVO;


/**
 * @author b
 *
 */
public class InstructorService implements IInstructorService {

	/* (non-Javadoc)
	 * @see servicio.interfaces.IInstructorService#consultaInstructores(vo.InstructorVO)
	 */

	public ArrayList<InstructorVO> consultaInstructores(InstructorVO instructor) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			ArrayList<InstructorVO> listaInstructores = new ArrayList<InstructorVO>();
			
			IInstructorDAO instructorDAO = new InstructorDAO();
			
			listaInstructores = instructorDAO.consultaInstructores(instructor);
			
			return listaInstructores;
			
		}catch(Exception e) {
			BusinessException be = new BusinessException();
			be.setStackTrace(e.getStackTrace());
			be.setIdException("201");
			be.setMessage("Error en la capa de negocio");
			System.out.println(e);
			throw be;
		}
	}


	public String agregarInstructor(InstructorVO instructor) {
		try {
			IInstructorDAO instructorDAO = new InstructorDAO();
			String res = instructorDAO.agregarInstructor(instructor);
			return res;
			}catch(Exception ex) {
				ex.printStackTrace();
				System.out.println("Error en Service");
				return null;
			}
	}


	public String modificarInstructor(InstructorVO instructor) {
		try {
			IInstructorDAO instructorDAO = new InstructorDAO();
			String res = instructorDAO.modificarInstructor(instructor);
			return res;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error en Service");
			return null;
		}
	}

	
	public String eliminarInstructor(InstructorVO instructor) {
		try {
			IInstructorDAO instructorDAO = new InstructorDAO();
			String res = instructorDAO.eliminarInstructor(instructor);
			
			
			return res;
			}catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("Error en el service");
				return null;
			}
	}

	
	public ArrayList<InstructorVO> obtenerDatosInstructor(InstructorVO instructor) {
		try {
			ArrayList<InstructorVO> listaDatosInstructores = new ArrayList<InstructorVO>();
			IInstructorDAO instructorDAO = new InstructorDAO();
			listaDatosInstructores = instructorDAO.obtenerDatosInstructor(instructor);
			return listaDatosInstructores;
			}catch(Exception ex) {
				ex.printStackTrace();
				System.out.println("Error en Service");
				return null;
			}
	}

}
