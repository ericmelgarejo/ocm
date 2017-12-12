/**
 * 
 */
package servicio.interfaces;

import java.util.ArrayList;

import excepcion.BusinessException;
import vo.CursoVO;

/**
 * @author Eric
 *
 */
public interface ICursoService {
	public ArrayList<CursoVO> consultaCursos();
	public CursoVO consultarCurso(int id);
	public String insertarCurso(CursoVO curso);
	public String actualizarCurso(CursoVO curso);
	public String eliminarCurso(CursoVO curso);
	public ArrayList<CursoVO> selectConsultaCursos(int id_programa);
}
