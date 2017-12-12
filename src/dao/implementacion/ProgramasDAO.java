/**
 * 
 */
package dao.implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.interfaces.IProgramasDAO;
import utils.ConexionDAO;
import vo.ProgramaVO;

/**
 * @author Sergio Ramos
 *
 */
public class ProgramasDAO extends ConexionDAO implements IProgramasDAO {

	/* (non-Javadoc)
	 * @see servicio.interfaces.IProgramasService#consultarProgramas()
	 */
	@Override
	public ArrayList<ProgramaVO> consultarProgramas() {
		// TODO Auto-generated method stub
		ArrayList<ProgramaVO> listaProgramas = new ArrayList<ProgramaVO>();
		String query = "SELECT * FROM PROGRAMAS WHERE STATUS = 1 ORDER BY ID ASC";
		
		try {
			
			Connection connection = null;
			connection = crearConexion(connection);
			
			Statement statement = connection.createStatement();
			
			System.out.println(this.getClass() + " -> MiSQL-> " + query);
			
			statement.execute(query);
			
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next()) {
				
				ProgramaVO programaVO = new ProgramaVO();
				
				programaVO.setId(resultSet.getInt("Id"));
				programaVO.setNombre(resultSet.getString("Nombre"));
				programaVO.setDescripcion(resultSet.getString("Descripcion"));
				programaVO.setStatus(resultSet.getInt("status"));
				
				listaProgramas.add(programaVO);
			}
			
			cerrarConexion(resultSet, statement, connection);
			
		}catch(Exception e) {
			
			System.out.println("Error en consultaProgramas de ProgramasDAO. Mensaje: " + e);
			
		}
		
		return listaProgramas;
		
	}

	@Override
	public String insertarPrograma(ProgramaVO programa) {
		// TODO Auto-generated method stub
		
		String queryId = "SELECT id_pro_seq.nextval AS nextId FROM DUAL";
		
		String respuesta = "";
		
		try {
			
			Connection connection = null;
			connection = crearConexion(connection);
			
			Statement stId = connection.createStatement();
			
			stId.executeQuery(queryId);
			
			ResultSet rsId = stId.getResultSet();
			rsId.next();
			int id = rsId.getInt("nextId");
			
			String query = "INSERT INTO PROGRAMAS VALUES(?, ?, ?, ?)";
			//ID, NOMBRE, DESCRIPCION
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.setString(2, programa.getNombre());
			statement.setString(3, programa.getDescripcion());
			statement.setInt(4, programa.getStatus());
			
			statement.executeUpdate();
			
			ResultSet resultSet = statement.getResultSet();
			
			cerrarConexion(resultSet, statement, connection);
			
			respuesta = "Programa agregado con exito";
			
		
		}catch(Exception e) {
			System.out.println("Error en insertarPrograma de ProgramasDAO. Mensaje: " + e);
			respuesta = "Error al agregar programa";
		}
		return respuesta;
	}

	@Override
	public ProgramaVO consultarPrograma(int id) {
		// TODO Auto-generated method stub
		
		ProgramaVO programa = new ProgramaVO();
		
		String query = "SELECT * FROM PROGRAMAS WHERE ID = " + id;
		
		try {
			
			Connection connection = null;
			connection = crearConexion(connection);
			
			Statement statement = connection.createStatement();
			
			System.out.println(this.getClass() + " -> MiSQL-> " + query);
			
			statement.execute(query);
			
			ResultSet resultSet = statement.getResultSet();
			
			resultSet.next();
			
			programa.setId(resultSet.getInt("id"));
			programa.setNombre(resultSet.getString("nombre"));
			programa.setDescripcion(resultSet.getString("descripcion"));
			programa.setStatus(resultSet.getInt("status"));
			
			cerrarConexion(resultSet, statement, connection);
			
		}catch(Exception e) {
			System.out.println("Error en consultarPrograma de Programas DAO. Mensage: "+e);
		}

		return programa;
	}
	
	@Override
	public String actualizarPrograma(ProgramaVO programa) {
		// TODO Auto-generated method stub
		
		String respuesta = "";
		
		try {
			
			Connection connection = null;
			connection = crearConexion(connection);
			
			String query = "UPDATE PROGRAMAS SET NOMBRE = ?, DESCRIPCION = ?, STATUS = ? WHERE ID = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, programa.getNombre());
			statement.setString(2, programa.getDescripcion());
			statement.setInt(3, programa.getStatus());
			statement.setInt(4, programa.getId());
			
			statement.executeUpdate();
			
			ResultSet resultSet = statement.getResultSet();
			
			cerrarConexion(resultSet, statement, connection);
			
			respuesta = "Programa actualizado con exito";
			
			
		}catch(Exception e) {
			System.out.println("Error en actualizarPrograma en ProgramasDAO. Mensaje :" + e);
			respuesta = "Error al actualizar programa";
		}
		
		return respuesta;
	}

	@Override
	public String eliminarPrograma(ProgramaVO programa) {
		// TODO Auto-generated method stub
		
		String respuesta = "";
		
		try {
			
			Connection connection = null;
			connection = crearConexion(connection);
			
			String query = "UPDATE PROGRAMAS SET STATUS = ? WHERE ID = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, programa.getStatus());
			statement.setInt(2, programa.getId());
			
			statement.executeUpdate();
			
			System.out.println(this.getClass() + " -> MiSQL-> " + statement);
			
			ResultSet resultSet = statement.getResultSet();
			
			cerrarConexion(resultSet, statement, connection);
			
			respuesta = "Programa 'eliminado' con exito";
			
			
		}catch(Exception e) {
			System.out.println("Error en eliminarPrograma en ProgramasDAO. Mensaje :" + e);
			respuesta = "Error al 'eliminar' programa";
		}
		
		return respuesta;
	}

	@Override
	public int consultarProgramaDeCurso(int id_curso) {
		// TODO Auto-generated method stub
		
		int idPrograma;
		String query = "SELECT PROGRAMA_ID FROM CURSOS WHERE ID = " + id_curso;
		
		try {
			
			Connection connection = null;
			connection = crearConexion(connection);
			
			Statement statement = connection.createStatement();
			
			System.out.println(this.getClass() + " -> MiSQL-> " + query);
			
			statement.execute(query);
			
			ResultSet resultSet = statement.getResultSet();
			
			resultSet.next();
			
			idPrograma = resultSet.getInt("PROGRAMA_ID");
			
			
			cerrarConexion(resultSet, statement, connection);
			return idPrograma;
			
		}catch(Exception e) {
			System.out.println("Error en consultarProgramadeCurso de Programas DAO. Mensage: "+e);
			return 0;
		}

		
	}
}