/**
 * 
 */
package dao.implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.interfaces.ICursoDAO;
import utils.ConexionDAO;
import vo.CiudadVO;
import vo.CursoVO;
import vo.ProgramaVO;

/**
 * @author Eric
 *
 */
public class CursoDAO extends ConexionDAO implements ICursoDAO {

	/* (non-Javadoc)
	 * @see dao.interfaces.ICursoDAO#consultaCursos(vo.CursoVO)
	 */
	@Override
	public ArrayList<CursoVO> consultaCursos() {
		// TODO Auto-generated method stub
		ArrayList<CursoVO> listaCursos = new ArrayList<CursoVO>();
		
		try {

			Connection connection = null;
			connection = crearConexion(connection);
			
			Statement statement = connection.createStatement();
			
			String query = "SELECT C.ID, C.NOMBRE, C.DESCRIPCION, C.HORAS, C.PROGRAMA_ID, P.NOMBRE PROGRAMA_NOMBRE, C.STATUS FROM CURSOS C JOIN PROGRAMAS P ON C.PROGRAMA_ID = P.ID ORDER BY C.ID ASC";
			
			System.out.println(this.getClass() + " -> MiSQL-> " + query);
			
			statement.execute(query);
			
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next()) {
				CursoVO cursoVO = new CursoVO();

				cursoVO.setId(resultSet.getInt("ID"));
				cursoVO.setNombre(resultSet.getString("NOMBRE"));
				cursoVO.setDescripcion(resultSet.getString("DESCRIPCION"));
				cursoVO.setHoras(resultSet.getInt("HORAS"));
				cursoVO.setPrograma_id(resultSet.getInt("PROGRAMA_ID"));
				cursoVO.setPrograma_nombre(resultSet.getString("PROGRAMA_NOMBRE"));
				cursoVO.setStatus(resultSet.getInt("STATUS"));
				
				listaCursos.add(cursoVO);
			}
			
			cerrarConexion(resultSet, statement, connection);
			
		}catch(Exception e) {
			System.out.println("Error en consultaCursos en CursoDAO. Mensaje: " + e);
		}
		return listaCursos;
	}

	/* (non-Javadoc)
	 * @see dao.interfaces.ICursoDAO#insertarCurso(vo.CursoVO)
	 */
	@Override
	public String insertarCurso(CursoVO curso) {
		// TODO Auto-generated method stub
		
		String queryId = "SELECT id_cur_seq.nextval AS nextId FROM DUAL";
		
		String respuesta = "";
		
		try {
			
			Connection connection = null;
			connection = crearConexion(connection);
			
			Statement stId = connection.createStatement();
			
			stId.executeQuery(queryId);
			
			ResultSet rsId = stId.getResultSet();
			rsId.next();
			int id = rsId.getInt("nextId");
			
			String query = "INSERT INTO CURSOS VALUES(?, ?, ?, ?, ?, ?)";
			//ID, NOMBRE, DESCRIPCION, HORAS, PROGRAMA_ID, STATUS
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.setString(2, curso.getNombre());
			statement.setString(3, curso.getDescripcion());
			statement.setInt(4, curso.getHoras());
			statement.setInt(5, curso.getPrograma_id());
			statement.setInt(6, curso.getStatus());
			
			statement.executeUpdate();
			
			ResultSet resultSet = statement.getResultSet();
			
			cerrarConexion(resultSet, statement, connection);
			
			respuesta = "Curso agregado con exito";
			
		
		}catch(Exception e) {
			System.out.println("Error en insertarCursode CursoDAO. Mensaje: " + e);
			respuesta = "Error al insertar curso";
		}
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see dao.interfaces.ICursoDAO#consultarCurso(int)
	 */
	@Override
	public CursoVO consultarCurso(int id) {
		// TODO Auto-generated method stub
		CursoVO curso = new CursoVO();
		
		String query = "SELECT * FROM CURSOS WHERE ID = " + id;
		
		try {
			
			Connection connection = null;
			connection = crearConexion(connection);
			
			Statement statement = connection.createStatement();
			
			System.out.println(this.getClass() + " -> MiSQL-> " + query);
			
			statement.execute(query);
			
			ResultSet resultSet = statement.getResultSet();
			
			resultSet.next();
			
			curso.setId(resultSet.getInt("id"));
			curso.setNombre(resultSet.getString("nombre"));
			curso.setDescripcion(resultSet.getString("descripcion"));
			curso.setHoras(resultSet.getInt("horas"));
			curso.setPrograma_id(resultSet.getInt("programa_id"));
			curso.setStatus(resultSet.getInt("status"));
			
			cerrarConexion(resultSet, statement, connection);
			
		}catch(Exception e) {
			System.out.println("Error en consultarCurso de CursoDAO. Mensage: "+e);
		}

		return curso;
	}

	/* (non-Javadoc)
	 * @see dao.interfaces.ICursoDAO#actualizarCurso(vo.CursoVO)
	 */
	@Override
	public String actualizarCurso(CursoVO curso) {
		// TODO Auto-generated method stub
		String respuesta = "";
		
		try {
			
			Connection connection = null;
			connection = crearConexion(connection);
			
			String query = "UPDATE CURSOS SET NOMBRE = ?, DESCRIPCION = ?, HORAS = ?, PROGRAMA_ID = ?, STATUS = ? WHERE ID = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, curso.getNombre());
			statement.setString(2, curso.getDescripcion());
			statement.setInt(3, curso.getHoras());
			statement.setInt(4, curso.getPrograma_id());
			statement.setInt(5, curso.getStatus());
			statement.setInt(6, curso.getId());
			
			statement.executeUpdate();
			
			ResultSet resultSet = statement.getResultSet();
			
			cerrarConexion(resultSet, statement, connection);
			
			respuesta = "Curso actualizado con exito";
			
			
		}catch(Exception e) {
			System.out.println("Error en actualizarCurso en CursoDAO. Mensaje :" + e);
			respuesta = "Error al actualizar curso";
		}
		
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see dao.interfaces.ICursoDAO#eliminarCurso(vo.CursoVO)
	 */
	@Override
	public String eliminarCurso(CursoVO curso) {
		// TODO Auto-generated method stub
		String respuesta = "";
		
		try {
			
			Connection connection = null;
			connection = crearConexion(connection);
			
			String query = "UPDATE CURSOS SET STATUS = ? WHERE ID = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, curso.getStatus());
			statement.setInt(2, curso.getId());
			
			statement.executeUpdate();
			
			System.out.println(this.getClass() + " -> MiSQL-> " + statement);
			
			ResultSet resultSet = statement.getResultSet();
			
			cerrarConexion(resultSet, statement, connection);
			
			respuesta = "Curso 'eliminado' con exito";
			
			
		}catch(Exception e) {
			System.out.println("Error en eliminarCurso en CursoDAO. Mensaje :" + e);
			respuesta = "Error al 'eliminar' curso";
		}
		
		return respuesta;
	}

	@Override
	public ArrayList<CursoVO> selectConsultaCursos(int id_programa) {
		// TODO Auto-generated method stub
		
		try {
			ArrayList<CursoVO> listaCursos = new ArrayList<CursoVO>();
			
			Connection connection = null;
			connection = crearConexion(connection);
			
			Statement statement = connection.createStatement();
			
			String query = "SELECT * FROM CURSOS WHERE STATUS = 1 AND PROGRAMA_ID = " + id_programa +" ORDER BY ID ASC";
			
			System.out.println(this.getClass() + " -> MiSQL-> " + query);
			
			statement.execute(query);
			
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next()) {
				CursoVO cursoVO = new CursoVO();
	
				
				cursoVO.setId(resultSet.getInt("ID"));
				cursoVO.setNombre(resultSet.getString("Nombre"));
				cursoVO.setPrograma_id(resultSet.getInt("Programa_Id"));
				
				
				listaCursos.add(cursoVO);
			}
			
			cerrarConexion(resultSet, statement, connection);
			
			return listaCursos;
		}catch(Exception ex) {
			return null;
		}
	}

}
