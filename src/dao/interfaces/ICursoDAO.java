/**
 * 
 */
package dao.interfaces;

import java.util.ArrayList;

import excepcion.BusinessException;
import vo.CursoVO;
import vo.PaisVO;
import vo.ProgramaVO;

/**
 * @author Eric
 *
 */
public interface ICursoDAO {
	public ArrayList<CursoVO> consultaCursos ();
	public CursoVO consultarCurso(int id);
	public String insertarCurso(CursoVO curso);
	public String actualizarCurso(CursoVO curso);
	public String eliminarCurso(CursoVO curso);
	public ArrayList<CursoVO> selectConsultaCursos(int id_programa);
}
