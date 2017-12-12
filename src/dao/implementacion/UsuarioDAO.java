/**
 * 
 */
package dao.implementacion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.interfaces.IUsuarioDAO;
import excepcion.BusinessException;
import utils.ConexionDAO;
import vo.CursoVO;
import vo.UsuarioVO;

/**
 * @author sergi
 *
 */
public class UsuarioDAO extends ConexionDAO implements IUsuarioDAO {

	/* (non-Javadoc)
	 * @see dao.interfaces.IUsuarioDAO#consultarUsuario(vo.UsuarioVO)
	 */
	@Override
	public ArrayList<UsuarioVO> consultarUsuario(UsuarioVO usuario) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			ArrayList<UsuarioVO> listaUsuarios = new ArrayList<UsuarioVO>();
			
			Connection connection = null;
			connection = crearConexion(connection);
			
			Statement statement = connection.createStatement();
			
			String query = "SELECT * FROM USUARIOS WHERE CORREO = '" + usuario.getCorreo() +"'";
			
			System.out.println(this.getClass() + " -> MiSQL-> " + query);
			
			statement.execute(query);
			
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next()) {
				UsuarioVO usuarioVO = new UsuarioVO();

				usuarioVO.setId_usuario(resultSet.getInt("id"));
				usuarioVO.setNombre(resultSet.getString("nombre"));
				usuarioVO.setApellido_paterno(resultSet.getString("apellido_paterno"));
				usuarioVO.setApellido_materno(resultSet.getString("apellido_materno"));
				usuarioVO.setCorreo(resultSet.getString("correo"));
				usuarioVO.setTelefono(resultSet.getString("telefono"));
				usuarioVO.setFecha_nacimiento(resultSet.getString("fecha_nacimiento"));
				usuarioVO.setTipo_usuario(resultSet.getInt("tipo_usuario"));
				usuarioVO.setPassword(resultSet.getString("password"));
				
				listaUsuarios.add(usuarioVO);
			}
			
			cerrarConexion(resultSet, statement, connection);
			
			return listaUsuarios;
			
		}catch(Exception e) {
			e.printStackTrace();
			BusinessException be = new BusinessException();
			be.setStackTrace(e.getStackTrace());
			be.setMessage("Error en la capa de base de datos");
			be.setIdException("0001");
			System.out.println(e.getStackTrace());
			System.out.println(be.getStackTrace());
			throw be;
		}
	}

}
