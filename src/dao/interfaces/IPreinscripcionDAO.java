/**
 * 
 */
package dao.interfaces;

import java.util.ArrayList;

import excepcion.BusinessException;
import vo.PreinscripcionVO;

/**
 * @author Eric
 *
 */
public interface IPreinscripcionDAO {
	public String insertarInscripcion(PreinscripcionVO inscripcion) throws BusinessException;
	public String actualizarInscripcion(PreinscripcionVO inscripcion) throws BusinessException;
	public ArrayList<PreinscripcionVO> consultaInscripciones (PreinscripcionVO preinscripcion) throws BusinessException;
	public ArrayList<PreinscripcionVO> consultaInscripcionesUsuario(PreinscripcionVO preinscripcion) throws BusinessException;
}
