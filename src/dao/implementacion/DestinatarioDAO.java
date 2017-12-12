package dao.implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.interfaces.IDestinatarioDAO;
import dao.interfaces.IInstructorDAO;
import excepcion.BusinessException;
import utils.ConexionDAO;
import vo.DestinatarioVO;

public class DestinatarioDAO extends ConexionDAO implements IDestinatarioDAO{

	/* (non-Javadoc)
	 * @see dao.interfaces.IDestinatarioDAO#consultaDestinatarioes(vo.DestinatarioVO)
	 */
	
	public ArrayList<DestinatarioVO> consultaDestinatarios(DestinatarioVO destinatario) throws BusinessException {
		System.out.println("Listar Destinatario otro");
		// TODO Auto-generated method stub
		
				try {
					ArrayList<DestinatarioVO> listaDestinatarios = new ArrayList<DestinatarioVO>();
					
					Connection connection = null;
					connection = crearConexion(connection);
					
					Statement statement = connection.createStatement();
					
					String query = "SELECT * FROM DESTINATARIOS WHERE ESTADO = 1 ORDER BY ID ASC";
					
					System.out.println(this.getClass() + " -> MiSQL-> " + query);
					
					statement.execute(query);
					
					ResultSet resultSet = statement.getResultSet();
					
					while(resultSet.next()) {
						DestinatarioVO destinararioVO = new DestinatarioVO();

						destinararioVO.setId_destinatario(resultSet.getInt("ID"));
						destinararioVO.setNombre(resultSet.getString("NOMBRE"));
						destinararioVO.setEstado(resultSet.getInt("ESTADO"));
						
						listaDestinatarios.add(destinararioVO);
					}
					
					cerrarConexion(resultSet, statement, connection);
					
					return listaDestinatarios;
					
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

	
	public String agregarDestinatario(DestinatarioVO destinatario) {
		// TODO Auto-generated method stub
				try {
				Connection connection = null;
				connection = crearConexion(connection);
				Statement stId = connection.createStatement();
				String queryId = "SELECT id_Destinatario_seq.nextval AS nextId FROM DUAL";
				stId.executeQuery(queryId);
				ResultSet rsId = stId.getResultSet();
				rsId.next();
				int id = rsId.getInt("nextId");
				
				String query = "INSERT INTO DESTINATARIOS VALUES(?, ?, ?)";
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setInt(1,id);
				statement.setString(2, destinatario.getNombre());
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

	
	public String modificarDestinatario(DestinatarioVO destinatario) {
		// TODO Auto-generated method stub
				try {
				Connection connection = null;
				connection = crearConexion(connection);
				String query = "UPDATE DESTINATARIOS SET NOMBRE = ? WHERE ID = ?";
				
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setString(1, destinatario.getNombre());
				statement.setInt(2, destinatario.getId_destinatario());
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

	
	public String eliminarDestinatario(DestinatarioVO destinatario) {
		// TODO Auto-generated method stub
				try {
					Connection connection = null;
					connection = crearConexion(connection);
					String query = "UPDATE DESTINATARIOS SET ESTADO = 0 WHERE ID = ?";
					
					
					PreparedStatement statement = connection.prepareStatement(query);
					statement.setInt(1, destinatario.getId_destinatario());
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

	
	public ArrayList<DestinatarioVO> obtenerDatosDestinatario(DestinatarioVO destinatario) {
		// TODO Auto-generated method stub
				try {
				ArrayList<DestinatarioVO> listaDatosEvento = new ArrayList<DestinatarioVO>();
				Connection connection = null;
				connection = crearConexion(connection);
				Statement statement = connection.createStatement();
				String query = "SELECT * FROM DESTINATARIOS WHERE ID = " + destinatario.getId_destinatario();
				System.out.println(this.getClass() + " -> MiSQL-> " + query);
				statement.execute(query);
				ResultSet resultSet = statement.getResultSet();
				while(resultSet.next()) {
					DestinatarioVO DestinatarioVO = new DestinatarioVO();
					DestinatarioVO.setId_destinatario(resultSet.getInt("ID"));
					DestinatarioVO.setNombre(resultSet.getString("NOMBRE"));
					DestinatarioVO.setEstado(resultSet.getInt("ESTADO"));
					listaDatosEvento.add(DestinatarioVO);
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
