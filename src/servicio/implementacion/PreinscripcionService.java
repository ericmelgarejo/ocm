/**
 * 
 */
package servicio.implementacion;

import java.util.ArrayList;

import dao.implementacion.PaisDAO;
import dao.implementacion.PreinscripcionDAO;
import dao.interfaces.IPaisDAO;
import dao.interfaces.IPreinscripcionDAO;
import excepcion.BusinessException;
import servicio.interfaces.IPreinscripcionService;
import vo.PaisVO;
import vo.PreinscripcionVO;

/**
 * @author Eric
 *
 */
public class PreinscripcionService implements IPreinscripcionService {

	/* (non-Javadoc)
	 * @see servicio.interfaces.IPreinscripcionService#insertarInscripcion(vo.PreinscripcionVO)
	 */
	@Override
	public String insertarInscripcion(PreinscripcionVO inscripcion) throws BusinessException {
		// TODO Auto-generated method stub
		
		IPreinscripcionDAO preinscripcionDAO = new PreinscripcionDAO();
		
		String res = preinscripcionDAO.insertarInscripcion(inscripcion);
		
		return res;
	}

	@Override
	public ArrayList<PreinscripcionVO> consultaInscripciones(PreinscripcionVO preinscripcion) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			ArrayList<PreinscripcionVO> listaPreinscripciones = new ArrayList<PreinscripcionVO>();
			
			IPreinscripcionDAO preinscripcionDAO = new PreinscripcionDAO();
			
			listaPreinscripciones = preinscripcionDAO.consultaInscripciones(preinscripcion);
			
			return listaPreinscripciones;
			
		}catch(Exception e) {
			BusinessException be = new BusinessException();
			be.setStackTrace(e.getStackTrace());
			be.setIdException("201");
			be.setMessage("Error en la capa de negocio");
			throw be;
		}
	}

	@Override
	public ArrayList<PreinscripcionVO> consultaInscripcionesUsuario(PreinscripcionVO preinscripcion)
			throws BusinessException {
		// TODO Auto-generated method stub
		try {
			ArrayList<PreinscripcionVO> listaPreinscripciones = new ArrayList<PreinscripcionVO>();
			
			IPreinscripcionDAO preinscripcionDAO = new PreinscripcionDAO();
			
			listaPreinscripciones = preinscripcionDAO.consultaInscripcionesUsuario(preinscripcion);
			
			return listaPreinscripciones;
			
		}catch(Exception e) {
			BusinessException be = new BusinessException();
			be.setStackTrace(e.getStackTrace());
			be.setIdException("201");
			be.setMessage("Error en la capa de negocio");
			throw be;
		}
	}

	@Override
	public String actualizarInscripcion(PreinscripcionVO inscripcion) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			
			IPreinscripcionDAO preinscripcionDAO = new PreinscripcionDAO();
			String res = preinscripcionDAO.actualizarInscripcion(inscripcion);
			
			
			return res;
			
		}catch(Exception e) {
			BusinessException be = new BusinessException();
			be.setStackTrace(e.getStackTrace());
			be.setIdException("201");
			be.setMessage("Error en la capa de negocio");
			throw be;
		}
	}
	

}
