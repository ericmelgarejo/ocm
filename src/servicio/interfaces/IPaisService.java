package servicio.interfaces;

import java.util.ArrayList;

import excepcion.BusinessException;
import vo.PaisVO;

public interface IPaisService {
	public ArrayList<PaisVO> consultaPaises (PaisVO pais) throws BusinessException;
	public String agregarPais (PaisVO pais);
	public String modificarPais(PaisVO pais);
	public String eliminarPais(PaisVO pais);
	public ArrayList<PaisVO> obtenerDatosPais(PaisVO pais);
}
