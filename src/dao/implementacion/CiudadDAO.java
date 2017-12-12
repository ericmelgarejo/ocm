/**
 * 
 */
package dao.implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.interfaces.ICiudadDAO;
import excepcion.BusinessException;
import utils.ConexionDAO;
import vo.CiudadVO;
import vo.PaisVO;

/**
 * @author Eric
 *
 */
public class CiudadDAO extends ConexionDAO implements ICiudadDAO {

	/* (non-Javadoc)
	 * @see dao.interfaces.ICiudadDAO#consultaCiudades(int)
	 */
	@Override
	public ArrayList<CiudadVO> consultaCiudades(int id_pais) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			ArrayList<CiudadVO> listaCiudades = new ArrayList<CiudadVO>();
			
			Connection connection = null;
			connection = crearConexion(connection);
			
			Statement statement = connection.createStatement();
			
			String query = "SELECT * FROM CIUDADES WHERE ESTADO = 1 AND PAIS_ID = " + id_pais;
			
			System.out.println(this.getClass() + " -> MiSQL-> " + query);
			
			statement.execute(query);
			
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next()) {
				CiudadVO ciudadVO = new CiudadVO();

				ciudadVO.setId(resultSet.getInt("ID"));
				ciudadVO.setNombre(resultSet.getString("Nombre"));
				ciudadVO.setPais_id(resultSet.getInt("Pais_Id"));
				
				listaCiudades.add(ciudadVO);
			}
			
			cerrarConexion(resultSet, statement, connection);
			
			return listaCiudades;
			
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
	public ArrayList<CiudadVO> consultaListaCiudades(CiudadVO ciudad) {
		// TODO Auto-generated method stub
		try {
			ArrayList<CiudadVO> listaCiudades = new ArrayList<CiudadVO>();
			
			Connection connection = null;
			connection = crearConexion(connection);
			
			Statement statement = connection.createStatement();
			
			String query = "SELECT c.id, c.nombre, c.pais_id, p.id, p.nombre as nombrepais FROM ciudades c, paises p where c.ESTADO = 1 AND p.estado = 1 AND c.pais_id = p.id"; 
			
			System.out.println(this.getClass() + " -> MiSQL-> " + query);
			
			statement.execute(query);
			
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next()) {
				CiudadVO ciudadVO = new CiudadVO();
				
				ciudadVO.setId(resultSet.getInt("ID"));
				ciudadVO.setNombre(resultSet.getString("Nombre"));
				ciudadVO.setPais_id(resultSet.getInt("Pais_Id"));
				ciudadVO.setPais_nombre(resultSet.getString("nombrepais"));
				
				
				listaCiudades.add(ciudadVO);
			}
			
			cerrarConexion(resultSet, statement, connection);
			
			return listaCiudades;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error en DAO");
			return null;
		}
	}

	@Override
	public String agregarCiudad(CiudadVO ciudad) {
		// TODO Auto-generated method stub
		try {
			Connection connection = null;
			connection = crearConexion(connection);
			Statement stId = connection.createStatement();
			String queryId = "SELECT id_ciu_seq.nextval AS nextId FROM DUAL";
			stId.executeQuery(queryId);
			ResultSet rsId = stId.getResultSet();
			rsId.next();
			int id = rsId.getInt("nextId");
			
			String query = "INSERT INTO CIUDADES VALUES(?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1,id);
			statement.setString(2, ciudad.getNombre());
			statement.setInt(3, ciudad.getPais_id());
			statement.setInt(4, 1);
			
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
	public String modificarCiudad(CiudadVO ciudad) {
		// TODO Auto-generated method stub
		try {
			Connection connection = null;
			connection = crearConexion(connection);
			String query = "UPDATE CIUDADES SET NOMBRE = ?, PAIS_ID = ? WHERE ID = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, ciudad.getNombre());
			statement.setInt(2, ciudad.getPais_id());
			statement.setInt(3, ciudad.getId());
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
	public String eliminarCiudad(CiudadVO ciudad) {
		// TODO Auto-generated method stub
		try {
			Connection connection = null;
			connection = crearConexion(connection);
			String query = "UPDATE CIUDADES SET ESTADO = 0 WHERE ID = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, ciudad.getId());
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
	public ArrayList<CiudadVO> obtenerDatosCiudad(CiudadVO ciudad) {
		// TODO Auto-generated method stub
		try {
			ArrayList<CiudadVO> listaDatosCiudad = new ArrayList<CiudadVO>();
			Connection connection = null;
			connection = crearConexion(connection);
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM CIUDADES WHERE ID = " +ciudad.getId();
			System.out.println(this.getClass() + " -> MiSQL-> " + query);
			statement.execute(query);
			ResultSet resultSet = statement.getResultSet();
			while(resultSet.next()) {
				CiudadVO ciudadVO = new CiudadVO();
				ciudadVO.setId(resultSet.getInt("ID"));
				ciudadVO.setPais_id(resultSet.getInt("Pais_Id"));
				ciudadVO.setNombre(resultSet.getString("Nombre"));
				
				listaDatosCiudad.add(ciudadVO);
			}
			
			cerrarConexion(resultSet, statement, connection);
			return listaDatosCiudad;
			
			}catch(Exception ex) {
				ex.printStackTrace();
				System.out.println("Error en DAO");
				return null;
			}
			
	}

	

}
