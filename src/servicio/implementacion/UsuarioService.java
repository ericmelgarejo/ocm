/**
 * 
 */
package servicio.implementacion;

import java.util.ArrayList;

import dao.implementacion.UsuarioDAO;
import dao.interfaces.IUsuarioDAO;
import excepcion.BusinessException;
import servicio.interfaces.IUsuarioService;
import vo.UsuarioVO;

/**
 * @author sergi
 *
 */
public class UsuarioService implements IUsuarioService {

	/* (non-Javadoc)
	 * @see servicio.interfaces.IUsuarioService#consultarUsuario(vo.UsuarioVO)
	 */
	@Override
	public ArrayList<UsuarioVO> consultarUsuario(UsuarioVO usuario) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			ArrayList<UsuarioVO> listaUsuario = new ArrayList<UsuarioVO>();
			
			IUsuarioDAO usuarioDAO = new UsuarioDAO();
			
			listaUsuario = usuarioDAO.consultarUsuario(usuario);
			
			return listaUsuario;
			
			}catch(Exception e) {
				BusinessException be = new BusinessException();
				be.setStackTrace(e.getStackTrace());
				be.setIdException("201");
				be.setMessage("Error en la capa de negocio");
				throw be;
			
		}
	}

}
