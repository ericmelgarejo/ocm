/**
 * 
 */
package dao.implementacion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.interfaces.IPagoDAO;
import excepcion.BusinessException;
import utils.ConexionDAO;
import vo.PagoVO;
import vo.PaisVO;

/**
 * @author Eric
 *
 */
public class PagoDAO extends ConexionDAO implements IPagoDAO {

	/* (non-Javadoc)
	 * @see dao.interfaces.IPagoDAO#consultaPagos(vo.PagoVO)
	 */
	@Override
	public ArrayList<PagoVO> consultaPagos(PagoVO pago) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			ArrayList<PagoVO> listaPagos = new ArrayList<PagoVO>();
			
			Connection connection = null;
			connection = crearConexion(connection);
			
			Statement statement = connection.createStatement();
			
			String query = "SELECT * FROM " + pago.getMetodo();
			
			System.out.println(this.getClass() + " -> MiSQL-> " + query);
			
			statement.execute(query);
			
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next()) {
				PagoVO pagoVO = new PagoVO();

				pagoVO.setId_pago(resultSet.getInt("id"));
				pagoVO.setMetodo(resultSet.getString("metodo"));
				
				listaPagos.add(pagoVO);
			}
			
			cerrarConexion(resultSet, statement, connection);
			
			return listaPagos;
			
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
