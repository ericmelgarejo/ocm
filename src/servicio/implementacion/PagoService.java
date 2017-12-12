/**
 * 
 */
package servicio.implementacion;

import java.util.ArrayList;

import dao.implementacion.PagoDAO;
import dao.implementacion.PaisDAO;
import dao.interfaces.IPagoDAO;
import dao.interfaces.IPaisDAO;
import excepcion.BusinessException;
import servicio.interfaces.IPagoService;
import vo.PagoVO;
import vo.PaisVO;

/**
 * @author Eric
 *
 */
public class PagoService implements IPagoService {

	/* (non-Javadoc)
	 * @see servicio.interfaces.IPagoService#consultaPagos(vo.PagoVO)
	 */
	@Override
	public ArrayList<PagoVO> consultaPagos(PagoVO pago) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			ArrayList<PagoVO> listaPagos = new ArrayList<PagoVO>();
			
			IPagoDAO pagoDAO = new PagoDAO();
			
			listaPagos = pagoDAO.consultaPagos(pago);
			
			return listaPagos;
			
		}catch(Exception e) {
			BusinessException be = new BusinessException();
			be.setStackTrace(e.getStackTrace());
			be.setIdException("201");
			be.setMessage("Error en la capa de negocio");
			throw be;
		}
	}

}
