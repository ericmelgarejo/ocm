/**
 * 
 */
package dao.implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.interfaces.IPreinscripcionDAO;
import excepcion.BusinessException;
import utils.ConexionDAO;
import vo.PaisVO;
import vo.PreinscripcionVO;

/**
 * @author Eric
 *
 */
public class PreinscripcionDAO extends ConexionDAO implements IPreinscripcionDAO {

	/* (non-Javadoc)
	 * @see dao.interfaces.IPreinscripcionDAO#insertarInscripcion(vo.PreinscripcionVO)
	 */
	@Override
	public String insertarInscripcion(PreinscripcionVO inscripcion) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			Connection connection = null;
			connection = crearConexion(connection);
			Statement stId = connection.createStatement();
			
			String queryId = "SELECT id_ins_seq.nextval AS nextId FROM DUAL";
			stId.executeQuery(queryId);
			ResultSet rsId = stId.getResultSet();
			rsId.next();
			int id = rsId.getInt("nextId");
			
			Statement stIdUsuario = connection.createStatement();
			String queryIdUsuario = "SELECT id_usu_seq.nextval AS nextIdU FROM DUAL";
			stIdUsuario.executeQuery(queryIdUsuario);
			ResultSet rsIdUsuario = stIdUsuario.getResultSet();
			rsIdUsuario.next();
			int idusuario = rsIdUsuario.getInt("nextIdU");
	
			
			String query = "INSERT INTO INSCRIPCIONES VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			//6, 1, 1, 'TARJETA', 1, 'EDUARDO','PEREZ', 'ARELLANO', 442545654654);
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1,id);
			statement.setInt(2,inscripcion.getId_evento());
			statement.setInt(3, idusuario);
			statement.setString(4, inscripcion.getPago());
			statement.setInt(5,inscripcion.getEstado());
			statement.setString(6, inscripcion.getNombre());
			statement.setString(7, inscripcion.getApellido_paterno());
			statement.setString(8, inscripcion.getApellido_materno());
			statement.setString(9, inscripcion.getTelefono());
			
			System.out.println("Id Evento: "+inscripcion.getId_evento());
			System.out.println(this.getClass() + " -> MiSQL-> ");
			statement.executeUpdate();
			ResultSet resultSet = statement.getResultSet();
			
			
			
			cerrarConexion(resultSet, statement, connection);
			
			return "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "0";
		}
	}

	@Override
	public ArrayList<PreinscripcionVO> consultaInscripciones(PreinscripcionVO preinscripcion) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			ArrayList<PreinscripcionVO> listaPreinscripciones = new ArrayList<PreinscripcionVO>();
			
			Connection connection = null;
			connection = crearConexion(connection);
			
			Statement statement = connection.createStatement();
			
			//String query = "SELECT i.id as ID, i.evento_id as Evento_Id, i.usuario_id as Usuario_id, i.metodo_pago as Metodo_Pago, i.estado as Estado, i.nombre as Nombre, i.apellido_paterno as Apellido_Paterno, i.apellido_materno as Apellido_Materno, i.telefono as Telefono, e.nombre as NombreEvento, u.nombre || "+"' '"+" || u.apellido_paterno || "+"' '"+" || u.apellido_materno as NombreInstructor FROM INSCRIPCIONES i, eventos e, usuarios u WHERE i.evento_id = e.id AND i.usuario_id = u.id";
			String query = "SELECT i.id, i.evento_id, i.usuario_id, i.metodo_pago, i.estado, i.nombre, i.apellido_paterno, i.apellido_materno, i.telefono, e.nombre as nombreevento FROM INSCRIPCIONES i, eventos e WHERE e.id = i.evento_id AND EVENTO_ID = "+preinscripcion.getId_evento();
			System.out.println(this.getClass() + " -> MiSQL-> " + query);
			
			statement.execute(query);
			
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next()) {
				PreinscripcionVO preinscripcionVO = new PreinscripcionVO();
				
				preinscripcionVO.setId_inscripcion(resultSet.getInt("ID"));
				preinscripcionVO.setId_evento(resultSet.getInt("Evento_Id"));
				preinscripcionVO.setId_usuario(resultSet.getInt("Usuario_Id"));
				preinscripcionVO.setPago(resultSet.getString("Metodo_Pago"));
				preinscripcionVO.setEstado(resultSet.getInt("Estado"));
				preinscripcionVO.setNombre(resultSet.getString("Nombre"));
				preinscripcionVO.setApellido_paterno(resultSet.getString("Apellido_Paterno"));
				preinscripcionVO.setApellido_materno(resultSet.getString("Apellido_Materno"));
				preinscripcionVO.setTelefono(resultSet.getString("Telefono"));
				preinscripcionVO.setNombre_evento(resultSet.getString("nombreevento"));
				
				

				
				
				listaPreinscripciones.add(preinscripcionVO);
			}
			
			cerrarConexion(resultSet, statement, connection);
			return listaPreinscripciones;
			
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
	
	@Override
	public ArrayList<PreinscripcionVO> consultaInscripcionesUsuario(PreinscripcionVO preinscripcion) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			ArrayList<PreinscripcionVO> listaPreinscripciones = new ArrayList<PreinscripcionVO>();
			
			Connection connection = null;
			connection = crearConexion(connection);
			
			Statement statement = connection.createStatement();
			
			//String query = "SELECT * FROM INSCRIPCIONES WHERE USUARIO_ID = " + preinscripcion.getId_usuario()+" ORDER BY ID ASC";
			//String query = "SELECT i.id as ID, i.evento_id as Evento_Id, i.usuario_id as Usuario_id, i.metodo_pago as Metodo_Pago, i.estado as Estado, i.nombre as Nombre, i.apellido_paterno as Apellido_Paterno, i.apellido_materno as Apellido_Materno, i.telefono as Telefono, e.nombre as NombreEvento, u.nombre || "+"' '"+" || u.apellido_paterno || "+"' '"+" || u.apellido_materno as NombreInstructor FROM INSCRIPCIONES i, eventos e, usuarios u WHERE i.evento_id = e.id AND i.usuario_id = u.id AND i.usuario_id = "+preinscripcion.getId_usuario();
			String query = "SELECT * FROM INSCRIPCIONES WHERE USUARIO_ID = "+preinscripcion.getId_usuario()+" AND EVENTO_ID = "+preinscripcion.getId_evento();
			
			System.out.println(this.getClass() + " -> MiSQL-> " + query);
			
			statement.execute(query);
			
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next()) {
				PreinscripcionVO preinscripcionVO = new PreinscripcionVO();
				
				preinscripcionVO.setId_inscripcion(resultSet.getInt("ID"));
				preinscripcionVO.setId_evento(resultSet.getInt("Evento_Id"));
				preinscripcionVO.setId_usuario(resultSet.getInt("Usuario_Id"));
				preinscripcionVO.setPago(resultSet.getString("Metodo_Pago"));
				preinscripcionVO.setEstado(resultSet.getInt("Estado"));
				preinscripcionVO.setNombre(resultSet.getString("Nombre"));
				preinscripcionVO.setApellido_paterno(resultSet.getString("Apellido_Paterno"));
				preinscripcionVO.setApellido_materno(resultSet.getString("Apellido_Materno"));
				preinscripcionVO.setTelefono(resultSet.getString("Telefono"));
			
				

				
				
				listaPreinscripciones.add(preinscripcionVO);
			}
			
			cerrarConexion(resultSet, statement, connection);
			return listaPreinscripciones;
			
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

	@Override
	public String actualizarInscripcion(PreinscripcionVO inscripcion) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			Connection connection = null;
			connection = crearConexion(connection);
			/**Statement stId = connection.createStatement();
			String queryId = "SELECT id_eve_seq.nextval AS nextId FROM DUAL";
			stId.executeQuery(queryId);
			ResultSet rsId = stId.getResultSet();
			rsId.next();
			int id = rsId.getInt("nextId");
			//mano_el@hotmail.com
			*/
			connection.setAutoCommit(false);
			String query = "UPDATE INSCRIPCIONES SET METODO_PAGO = ?, ESTADO = ? WHERE ID = ?";
			//6, 'Capacitacion', 'Te divertiras', 'Privado', 35000, 30, '27/02/2017', '30/06/2018', 1, 1, 1, 1);
			PreparedStatement statement = connection.prepareStatement(query);
			

			statement.setString(1, inscripcion.getPago());
			statement.setInt(2, 1);
			statement.setInt(3, inscripcion.getId_inscripcion());
			
		
			
			System.out.println(this.getClass() + " -> MiSQL-> " + query);
			statement.executeUpdate();
			
//			System.out.println("Id evento = "+inscripcion.getId_evento());
//			String queryInscritos = "UPDATE EVENTOS SET INSCRITOS = INSCRITOS + 1 WHERE ID = ? ";
//			System.out.println(queryInscritos);
//			int id_evento = inscripcion.getId_evento();
//			int r = updateInscritos(connection, queryInscritos, id_evento );
//			System.out.println("Aquí sí entró");
			connection.commit();
			cerrarConexion(null,statement, connection);
			
			return "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "0";
		}
	}
	
	public int updateInscritos(Connection connection, String queryInscritos, int idEvento) {
		int r = 0;
		try {
			PreparedStatement st = connection.prepareStatement(queryInscritos);
			st.setInt(1, idEvento);
			r = st.executeUpdate();
			return r;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return r;
		}
	}
}
