package dao.implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.interfaces.IPaisDAO;
import excepcion.BusinessException;
import utils.ConexionDAO;
import vo.PaisVO;

public class PaisDAO extends ConexionDAO implements IPaisDAO {

	@Override
	public ArrayList<PaisVO> consultaPaises(PaisVO pais) throws BusinessException {
		// TODO Auto-generated method stub
		
		try {
			ArrayList<PaisVO> listaPaises = new ArrayList<PaisVO>();
			
			Connection connection = null;
			connection = crearConexion(connection);
			
			Statement statement = connection.createStatement();
			
			String query = "SELECT * FROM PAISES WHERE ESTADO = 1 ORDER BY ID ASC";
			
			System.out.println(this.getClass() + " -> MiSQL-> " + query);
			
			statement.execute(query);
			
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next()) {
				PaisVO paisVO = new PaisVO();

				paisVO.setID_Pais(resultSet.getInt("ID"));
				paisVO.setNombre(resultSet.getString("Nombre"));
				
				listaPaises.add(paisVO);
			}
			
			cerrarConexion(resultSet, statement, connection);
			
			return listaPaises;
			
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
	public String agregarPais(PaisVO pais) {
		// TODO Auto-generated method stub
		try {
		Connection connection = null;
		connection = crearConexion(connection);
		Statement stId = connection.createStatement();
		String queryId = "SELECT id_pais_seq.nextval AS nextId FROM DUAL";
		stId.executeQuery(queryId);
		ResultSet rsId = stId.getResultSet();
		rsId.next();
		int id = rsId.getInt("nextId");
		
		String query = "INSERT INTO PAISES VALUES(?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1,id);
		statement.setString(2, pais.getNombre());
		statement.setInt(3, 1);
		
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
	public String modificarPais(PaisVO pais) {
		// TODO Auto-generated method stub
		try {
		Connection connection = null;
		connection = crearConexion(connection);
		String query = "UPDATE PAISES SET NOMBRE = ? WHERE ID = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, pais.getNombre());
		statement.setInt(2, pais.getID_Pais());
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
	public String eliminarPais(PaisVO pais) {
		// TODO Auto-generated method stub
		try {
			Connection connection = null;
			connection = crearConexion(connection);
			String query = "UPDATE PAISES SET ESTADO = 0 WHERE ID = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, pais.getID_Pais());
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
	public ArrayList<PaisVO> obtenerDatosPais(PaisVO pais) {
		// TODO Auto-generated method stub
		try {
		ArrayList<PaisVO> listaDatosEvento = new ArrayList<PaisVO>();
		Connection connection = null;
		connection = crearConexion(connection);
		Statement statement = connection.createStatement();
		String query = "SELECT * FROM PAISES WHERE ID = " +pais.getID_Pais();
		System.out.println(this.getClass() + " -> MiSQL-> " + query);
		statement.execute(query);
		ResultSet resultSet = statement.getResultSet();
		while(resultSet.next()) {
			PaisVO paisVO = new PaisVO();
			paisVO.setID_Pais(resultSet.getInt("ID"));
			paisVO.setNombre(resultSet.getString("Nombre"));
			listaDatosEvento.add(paisVO);
		}
		
		cerrarConexion(resultSet, statement, connection);
		return listaDatosEvento;
		
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error en DAO");
			return null;
		}
		
	}

}
