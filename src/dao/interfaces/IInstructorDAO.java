/**
 * 
 */
package dao.interfaces;

import java.util.ArrayList;

import excepcion.BusinessException;
import vo.InstructorVO;


/**
 * @author Eric
 *
 */
public interface IInstructorDAO {
	public ArrayList<InstructorVO> consultaInstructores (InstructorVO instructor) throws BusinessException;
	public String agregarInstructor (InstructorVO instructor);
	public String modificarInstructor(InstructorVO instructor);
	public String eliminarInstructor(InstructorVO instructor);
	public ArrayList<InstructorVO > obtenerDatosInstructor(InstructorVO instructor);
}
