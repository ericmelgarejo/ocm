/**
 * 
 */
package dao.interfaces;

import java.util.ArrayList;

import excepcion.BusinessException;
import vo.PaisVO;

/**
 * @author sergio
 *
 */
public interface IPaisDAO {
	public ArrayList<PaisVO> consultaPaises (PaisVO pais) throws BusinessException;
	public String agregarPais (PaisVO pais);
	public String modificarPais(PaisVO pais);
	public String eliminarPais(PaisVO pais);
	public ArrayList<PaisVO> obtenerDatosPais(PaisVO pais);
}
