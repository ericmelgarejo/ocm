/**
 * 
 */
package servicio.implementacion;

import java.util.ArrayList;

import dao.implementacion.PaisDAO;
import dao.interfaces.IPaisDAO;
import excepcion.BusinessException;
import servicio.interfaces.IPaisService;
import vo.PaisVO;

/**
 * @author sergi
 *
 */
public class PaisService implements IPaisService {

	/* (non-Javadoc)
	 * @see servicio.interfaces.IPaisService#consultaPaises(vo.PaisVO)
	 */
	@Override
	public ArrayList<PaisVO> consultaPaises(PaisVO pais) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			ArrayList<PaisVO> listaPaises = new ArrayList<PaisVO>();
			
			IPaisDAO paisDAO = new PaisDAO();
			
			listaPaises = paisDAO.consultaPaises(pais);
			
			return listaPaises;
			
		}catch(Exception e) {
			BusinessException be = new BusinessException();
			be.setStackTrace(e.getStackTrace());
			be.setIdException("201");
			be.setMessage("Error en la capa de negocio");
			throw be;
		}
	}
	
	@Override
	public String agregarPais(PaisVO pais) {
		// TODO Auto-generated method stub
		try {
		IPaisDAO paisDAO = new PaisDAO();
		String res = paisDAO.agregarPais(pais);
		return res;
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error en Service");
			return null;
		}
	}

	@Override
	public String modificarPais(PaisVO pais) {
		// TODO Auto-generated method stub
		try {
			IPaisDAO paisDAO = new PaisDAO();
			String res = paisDAO.modificarPais(pais);
			return res;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error en Service");
			return null;
		}
		
	}

	@Override
	public String eliminarPais(PaisVO pais) {
		// TODO Auto-generated method stub
		try {
		IPaisDAO paisDAO = new PaisDAO();
		String res = paisDAO.eliminarPais(pais);
		
		
		return res;
		}catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Error en el service");
			return null;
		}
	}

	@Override
	public ArrayList<PaisVO> obtenerDatosPais(PaisVO pais) {
		// TODO Auto-generated method stub
		try {
		ArrayList<PaisVO> listaDatosPaises = new ArrayList<PaisVO>();
		IPaisDAO paisDAO = new PaisDAO();
		listaDatosPaises = paisDAO.obtenerDatosPais(pais);
		return listaDatosPaises;
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error en Service");
			return null;
		}
	}
}
