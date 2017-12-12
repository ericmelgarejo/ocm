/**
 * 
 */
package dao.implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.interfaces.ILugarDAO;
import excepcion.BusinessException;
import utils.ConexionDAO;
import vo.CiudadVO;
import vo.LugarVO;

/**
 * @author Eric
 *
 */
public class LugarDAO extends ConexionDAO implements ILugarDAO {

	/* (non-Javadoc)
	 * @see dao.interfaces.ILugarDAO#consultaLugares(int)
	 */
	@Override
	public ArrayList<LugarVO> consultaLugares(int id_ciudad) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			ArrayList<LugarVO> listaLugares = new ArrayList<LugarVO>();
			
			Connection connection = null;
			connection = crearConexion(connection);
			
			Statement statement = connection.createStatement();
			
			String query = "SELECT * FROM LUGARES WHERE CIUDAD_ID = " + id_ciudad;
			
			System.out.println(this.getClass() + " -> MiSQL-> " + query);
			
			statement.execute(query);
			
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next()) {
				LugarVO lugarVO = new LugarVO();

				lugarVO.setId(resultSet.getInt("ID"));
				lugarVO.setNombre(resultSet.getString("Nombre"));
				lugarVO.setDireccion(resultSet.getString("Direccion"));
				lugarVO.setCiudad_id(resultSet.getInt("Ciudad_Id"));
				
				listaLugares.add(lugarVO);
			}
			
			cerrarConexion(resultSet, statement, connection);
			
			return listaLugares;
			
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
	public ArrayList<LugarVO> consultaListaLugares(LugarVO lugar) {
		// TODO Auto-generated method stub
		try {
			ArrayList<LugarVO> listaLugares = new ArrayList<LugarVO>();
			
			Connection connection = null;
			connection = crearConexion(connection);
			
			Statement statement = connection.createStatement();
			
			String query = "select l.id, l.nombre, l.direccion, l.ciudad_id, c.nombre as nombreciudad FROM lugares l, ciudades c WHERE l.ciudad_id = c.id AND c.estado = 1 AND l.estado = 1"; 
			
			System.out.println(this.getClass() + " -> MiSQL-> " + query);
			
			statement.execute(query);
			
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next()) {
				LugarVO lugarVO = new LugarVO();
				
				lugarVO.setId(resultSet.getInt("ID"));
				lugarVO.setNombre(resultSet.getString("Nombre"));
				lugarVO.setDireccion(resultSet.getString("Direccion"));
				lugarVO.setCiudad_id(resultSet.getInt("Ciudad_Id"));
				lugarVO.setCiudad_nombre(resultSet.getString("nombreciudad"));
				
							
				listaLugares.add(lugarVO);
			}
			
			cerrarConexion(resultSet, statement, connection);
			
			return listaLugares;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error en DAO");
			return null;
		}
	}

	@Override
	public String agregarLugar(LugarVO lugar) {
		// TODO Auto-generated method stub
		try {
			Connection connection = null;
			connection = crearConexion(connection);
			Statement stId = connection.createStatement();
			String queryId = "SELECT id_lug_seq.nextval AS nextId FROM DUAL";
			stId.executeQuery(queryId);
			ResultSet rsId = stId.getResultSet();
			rsId.next();
			int id = rsId.getInt("nextId");
			
			String query = "INSERT INTO LUGARES VALUES(?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1,id);
			statement.setString(2, lugar.getNombre());
			statement.setString(3, lugar.getDireccion());
			statement.setInt(4, lugar.getCiudad_id());
			statement.setInt(5, 1);
			
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
	public String modificarLugar(LugarVO lugar) {
		// TODO Auto-generated method stub
		try {
			Connection connection = null;
			connection = crearConexion(connection);
			String query = "UPDATE LUGARES SET NOMBRE = ?, DIRECCION = ?, CIUDAD_ID = ? WHERE ID = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, lugar.getNombre());
			statement.setString(2, lugar.getDireccion());
			statement.setInt(3, lugar.getCiudad_id());
			statement.setInt(4, lugar.getId());
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
	public String eliminarLugar(LugarVO lugar) {
		// TODO Auto-generated method stub
		try {
			Connection connection = null;
			connection = crearConexion(connection);
			String query = "UPDATE LUGARES SET ESTADO = 0 WHERE ID = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, lugar.getId());
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
	public ArrayList<LugarVO> obtenerDatosLugar(LugarVO lugar) {
		// TODO Auto-generated method stub
		try {
			ArrayList<LugarVO> listaDatosLugar = new ArrayList<LugarVO>();
			Connection connection = null;
			connection = crearConexion(connection);
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM LUGARES WHERE ID = " +lugar.getId();
			System.out.println(this.getClass() + " -> MiSQL-> " + query);
			statement.execute(query);
			ResultSet resultSet = statement.getResultSet();
			while(resultSet.next()) {
				
				LugarVO lugarVO = new LugarVO();
				lugarVO.setId(resultSet.getInt("ID"));
				lugarVO.setNombre(resultSet.getString("Nombre"));
				lugarVO.setDireccion(resultSet.getString("Direccion"));
				lugarVO.setCiudad_id(resultSet.getInt("Ciudad_Id"));
				
				
				listaDatosLugar.add(lugarVO);
			}
			
			cerrarConexion(resultSet, statement, connection);
			return listaDatosLugar;
			
			}catch(Exception ex) {
				ex.printStackTrace();
				System.out.println("Error en DAO");
				return null;
			}
	}

	@Override
	public ArrayList<Integer> obtenerCiudadPais(int id_lugar) {
		// TODO Auto-generated method stub
		try {
			ArrayList<Integer> idCiudadPais = new ArrayList<Integer>();
			
			Connection connection = null;
			connection = crearConexion(connection);
			
			Statement statement = connection.createStatement();
			
			String query = "SELECT l.nombre, l.ciudad_id, c.nombre as nombreciudad, c.pais_id, p.nombre as nombrepais from lugares l, ciudades c, paises p WHERE l.ciudad_id = c.id AND c.pais_id = p.id AND l.id = "+id_lugar;
			
			System.out.println(this.getClass() + " -> MiSQL-> " + query);
			
			statement.execute(query);
			
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next()) {
				idCiudadPais.add(resultSet.getInt("CIUDAD_ID"));
				idCiudadPais.add(resultSet.getInt("PAIS_ID"));
				
				
			}
			
			cerrarConexion(resultSet, statement, connection);
			
			return idCiudadPais;
		}catch(Exception ex) {
			System.out.println("Error en el dao");
			return null;
		}
	}

}
