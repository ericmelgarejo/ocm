/**
 * 
 */
package dao.interfaces;

import java.util.ArrayList;

import vo.ProgramaVO;

/**
 * @author Sergio Ramos
 *
 */
public interface IProgramasDAO {
	public ArrayList<ProgramaVO> consultarProgramas();
	public ProgramaVO consultarPrograma(int id);
	public String insertarPrograma(ProgramaVO programa);
	public String actualizarPrograma(ProgramaVO programa);
	public String eliminarPrograma(ProgramaVO programa);
	public int consultarProgramaDeCurso(int id_curso);
}
