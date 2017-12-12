/**
 * 
 */
package servicio.implementacion;

import java.util.ArrayList;

import dao.implementacion.CiudadDAO;
import dao.implementacion.EventoDAO;
import dao.implementacion.PaisDAO;
import dao.interfaces.ICiudadDAO;
import dao.interfaces.IEventoDAO;
import dao.interfaces.IPaisDAO;
import excepcion.BusinessException;
import servicio.interfaces.ICiudadService;
import vo.CiudadVO;
import vo.PaisVO;

/**
 * @author Eric
 *
 */
public class CiudadService implements ICiudadService {

	/* (non-Javadoc)
	 * @see servicio.interfaces.ICiudadService#consultaCiudades(int)
	 */
	@Override
	public ArrayList<CiudadVO> consultaCiudades(int id_pais) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			ArrayList<CiudadVO> listaCiudades = new ArrayList<CiudadVO>();
			
			ICiudadDAO ciudadDAO = new CiudadDAO();
			
			listaCiudades = ciudadDAO.consultaCiudades(id_pais);
			
			return listaCiudades;
			
		}catch(Exception e) {
			BusinessException be = new BusinessException();
			be.setStackTrace(e.getStackTrace());
			be.setIdException("201");
			be.setMessage("Error en la capa de negocio");
			throw be;
		}
	}
	
	@Override
	public ArrayList<CiudadVO> consultaListaCiudades(CiudadVO ciudad) {
		// TODO Auto-generated method stub
		try {
			ArrayList<CiudadVO> listaCiudades = new ArrayList<CiudadVO>();
			
			ICiudadDAO ciudadDAO = new CiudadDAO();
			
			listaCiudades = ciudadDAO.consultaListaCiudades(ciudad);
			
			return listaCiudades;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error en Service");
			return null;
		}
	}

	@Override
	public String agregarCiudad(CiudadVO ciudad) {
		// TODO Auto-generated method stub
		try {
			
			ICiudadDAO ciudadDAO = new CiudadDAO();
			String res = ciudadDAO.agregarCiudad(ciudad);
			
			
			return res;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error en service");
			return null;
		}
	}

	@Override
	public String modificarCiudad(CiudadVO ciudad) {
		// TODO Auto-generated method stub
		try {
			ICiudadDAO ciudadDAO = new CiudadDAO();
			String res = ciudadDAO.modificarCiudad(ciudad);
			return res;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error en Service");
			return null;
		}
	}

	@Override
	public String eliminarCiudad(CiudadVO ciudad) {
		// TODO Auto-generated method stub
		try {
			ICiudadDAO ciudadDAO = new CiudadDAO();
			String res = ciudadDAO.eliminarCiudad(ciudad);
			
			
			return res;
			}catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("Error en el service");
				return null;
			}
	}

	@Override
	public ArrayList<CiudadVO> obtenerDatosCiudad(CiudadVO ciudad) {
		// TODO Auto-generated method stub
		try {
			ArrayList<CiudadVO> listaDatosCiudades = new ArrayList<CiudadVO>();
			ICiudadDAO ciudadDAO = new CiudadDAO();
			listaDatosCiudades = ciudadDAO.obtenerDatosCiudad(ciudad);
			return listaDatosCiudades;
			}catch(Exception ex) {
				ex.printStackTrace();
				System.out.println("Error en Service");
				return null;
			}
	}

	


}
