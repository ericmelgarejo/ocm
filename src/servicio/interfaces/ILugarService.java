/**
 * 
 */
package servicio.interfaces;

import java.util.ArrayList;

import excepcion.BusinessException;
import vo.CiudadVO;
import vo.LugarVO;

/**
 * @author Eric
 *
 */
public interface ILugarService {
	public ArrayList<LugarVO> consultaLugares(int id_ciudad) throws BusinessException;
	public ArrayList<LugarVO> consultaListaLugares (LugarVO lugar);
	public String agregarLugar (LugarVO lugar);
	public String modificarLugar(LugarVO lugar);
	public String eliminarLugar(LugarVO lugar);
	public ArrayList<LugarVO> obtenerDatosLugar(LugarVO lugar);
	public ArrayList<Integer> obtenerCiudadPais(int id_lugar);

}
