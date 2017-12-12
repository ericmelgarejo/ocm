/**
 * 
 */
package servicio.interfaces;

import java.util.ArrayList;

import excepcion.BusinessException;
import vo.UsuarioVO;

/**
 * @author sergi
 *
 */
public interface IUsuarioService {
	public ArrayList<UsuarioVO> consultarUsuario (UsuarioVO usuario) throws BusinessException;
}
