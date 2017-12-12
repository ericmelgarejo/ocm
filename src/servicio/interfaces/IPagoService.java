/**
 * 
 */
package servicio.interfaces;

import java.util.ArrayList;

import excepcion.BusinessException;
import vo.PagoVO;

/**
 * @author Eric
 *
 */
public interface IPagoService {
	public ArrayList<PagoVO> consultaPagos (PagoVO pago) throws BusinessException;
}
