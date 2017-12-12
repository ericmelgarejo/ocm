/**
 * 
 */
package dao.interfaces;

import java.util.ArrayList;

import excepcion.BusinessException;
import vo.EventoVO;
import vo.UsuarioVO;

/**
 * @author sergi
 *
 */
public interface IUsuarioDAO {
	public ArrayList<UsuarioVO> consultarUsuario (UsuarioVO usuario) throws BusinessException;
}
