/**
 * 
 */
package dao.interfaces;

import java.util.ArrayList;

import excepcion.BusinessException;
import vo.CursoVO;
import vo.PagoVO;

/**
 * @author Eric
 *
 */
public interface IPagoDAO {
	public ArrayList<PagoVO> consultaPagos (PagoVO pago) throws BusinessException;

}
