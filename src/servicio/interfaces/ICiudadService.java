/**
 * 
 */
package servicio.interfaces;

import java.util.ArrayList;

import excepcion.BusinessException;
import vo.CiudadVO;

/**
 * @author Eric
 *
 */
public interface ICiudadService {
	public ArrayList<CiudadVO> consultaCiudades(int id_pais) throws BusinessException;
	public ArrayList<CiudadVO> consultaListaCiudades (CiudadVO ciudad);
	public String agregarCiudad (CiudadVO ciudad);
	public String modificarCiudad(CiudadVO ciudad);
	public String eliminarCiudad(CiudadVO ciudad);
	public ArrayList<CiudadVO> obtenerDatosCiudad(CiudadVO ciudad);
	
}
