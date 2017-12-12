/**
 * 
 */
package dao.implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.interfaces.IInstructorDAO;
import excepcion.BusinessException;
import vo.InstructorVO;
import utils.ConexionDAO;;

/**
 * @author b
 *
 */
public class InstructorDAO extends ConexionDAO implements IInstructorDAO {

	/* (non-Javadoc)
	 * @see dao.interfaces.IInstructorDAO#consultaInstructores(vo.InstructorVO)
	 */

	public ArrayList<InstructorVO> consultaInstructores(InstructorVO instructor) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			ArrayList<InstructorVO> listaInstructores = new ArrayList<InstructorVO>();
			
			Connection connection = null;
			connection = crearConexion(connection);
			
			Statement statement = connection.createStatement();
			
			String query = "SELECT * FROM USUARIOS WHERE TIPO_USUARIO = 2 AND ESTADO != 0";
			
			System.out.println(this.getClass() + " -> MiSQL-> " + query);
			
			statement.execute(query);
			
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next()) {
				InstructorVO instructorVO = new InstructorVO();

				instructorVO.setId_instructor(resultSet.getInt("ID"));
				instructorVO.setNombre(resultSet.getString("NOMBRE"));
				instructorVO.setApellido_paterno(resultSet.getString("APELLIDO_PATERNO"));
				instructorVO.setApellido_materno(resultSet.getString("APELLIDO_MATERNO"));
				instructorVO.setCorreo(resultSet.getString("CORREO"));
				instructorVO.setTelefono(resultSet.getString("TELEFONO"));
				instructorVO.setFecha_nacimiento(resultSet.getString("FECHA_NACIMIENTO"));
				instructorVO.setTipo_usuario(resultSet.getInt("TIPO_USUARIO"));
				instructorVO.setPassword(resultSet.getString("PASSWORD"));
				
				listaInstructores.add(instructorVO);
			}
			
			cerrarConexion(resultSet, statement, connection);
			
			return listaInstructores;
			
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
	public String agregarInstructor(InstructorVO instructor) {
		// TODO Auto-generated method stub
				try {
				Connection connection = null;
				connection = crearConexion(connection);
				Statement stId = connection.createStatement();
				String queryId = "SELECT id_Instructor_seq.nextval AS nextId FROM DUAL";
				stId.executeQuery(queryId);
				ResultSet rsId = stId.getResultSet();
				rsId.next();
				int id = rsId.getInt("nextId");
				
				String query = "INSERT INTO USUARIOS VALUES(?, ?, ?, ?, ?, ?, ?, 2 , ?, 1)";
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setInt(1,id);
				statement.setString(2, instructor.getNombre());
				statement.setString(3, instructor.getApellido_paterno());
				statement.setString(4, instructor.getApellido_materno());
				statement.setString(5, instructor.getCorreo());
				statement.setString(6, instructor.getTelefono());
				statement.setString(7, instructor.getFecha_nacimiento());
				statement.setString(8, instructor.getPassword());
				
				
				
				System.out.println(this.getClass() + " -> MiSQL-> " + query);
				statement.executeUpdate();
				ResultSet resultSet = statement.getResultSet();
				cerrarConexion(resultSet, statement, connection);
				
				return "1";
				}catch(Exception ex) {
					ex.printStackTrace();
					return "0";
				}
	}

	@Override
	public String modificarInstructor(InstructorVO instructor) {
		// TODO Auto-generated method stub
				try {
				Connection connection = null;
				connection = crearConexion(connection);
				String query = "UPDATE USUARIOS SET NOMBRE = ?, APELLIDO_PATERNO = ?, APELLIDO_MATERNO = ?, CORREO = ?, TELEFONO= ?, FECHA_NACIMIENTO = ?, TIPO_USUARIO = 2, PASSWORD = ? WHERE ID = ?";
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setString(1, instructor.getNombre());
				statement.setString(2, instructor.getApellido_paterno());
				statement.setString(3, instructor.getApellido_materno());
				statement.setString(4, instructor.getCorreo());
				statement.setString(5, instructor.getTelefono());
				statement.setString(6, instructor.getFecha_nacimiento());
				//statement.setInt(7, instructor.getTipo_usuario());
				statement.setString(7, instructor.getPassword());
				statement.setInt(8, instructor.getId_instructor());
				System.out.println(this.getClass() + " -> MiSQL-> " + query);
				statement.executeUpdate();
				ResultSet resultSet = statement.getResultSet();
				
				cerrarConexion(resultSet, statement, connection);
				return "1";
				}catch(Exception ex) {
					ex.printStackTrace();
					System.out.println("Error en el DAO");
					return "0";
				}
				
	}

	@Override
	public String eliminarInstructor(InstructorVO instructor) {
		// TODO Auto-generated method stub
				try {
					Connection connection = null;
					connection = crearConexion(connection);
					String query = "UPDATE USUARIOS SET ESTADO = 0 WHERE ID = ?";
					PreparedStatement statement = connection.prepareStatement(query);
					statement.setInt(1, instructor.getId_instructor());
					System.out.println(this.getClass() + " -> MiSQL-> " + query);
					statement.executeUpdate();
					ResultSet resultSet = statement.getResultSet();
					
					
					
					cerrarConexion(resultSet, statement, connection);
					return "1";
				}catch(Exception ex) {
					ex.printStackTrace();
					System.out.println("Error en DAO");
					return "0";
				}
	}

	@Override
	public ArrayList<InstructorVO> obtenerDatosInstructor(InstructorVO instructor) {
		// TODO Auto-generated method stub
				try {
				ArrayList<InstructorVO> listaDatosInstructores = new ArrayList<InstructorVO>();
				Connection connection = null;
				connection = crearConexion(connection);
				Statement statement = connection.createStatement();
				String query = "SELECT * FROM USUARIOS WHERE ID = " + instructor.getId_instructor();
				System.out.println(this.getClass() + " -> MiSQL-> " + query);
				statement.execute(query);
				ResultSet resultSet = statement.getResultSet();
				while(resultSet.next()) {
					InstructorVO instructorVO = new InstructorVO();
					instructorVO.setId_instructor(resultSet.getInt("ID"));
					instructorVO.setNombre(resultSet.getString("NOMBRE"));
					instructorVO.setApellido_paterno(resultSet.getString("APELLIDO_PATERNO"));
					instructorVO.setApellido_materno(resultSet.getString("APELLIDO_MATERNO"));
					instructorVO.setCorreo(resultSet.getString("CORREO"));
					instructorVO.setTelefono(resultSet.getString("TELEFONO"));
					instructorVO.setFecha_nacimiento(resultSet.getString("FECHA_NACIMIENTO"));
					instructorVO.setTipo_usuario(resultSet.getInt("TIPO_USUARIO"));
					instructorVO.setPassword(resultSet.getString("PASSWORD"));
					listaDatosInstructores.add(instructorVO);
				}
				
				cerrarConexion(resultSet, statement, connection);
				return listaDatosInstructores;
				
				}catch(Exception ex) {
					ex.printStackTrace();
					System.out.println("Error en DAO");
					return null;
				}
				
			}
	

}
