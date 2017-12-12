/**
 * 
 */
package dao.implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.interfaces.IEventoDAO;
import excepcion.BusinessException;
import utils.ConexionDAO;
import vo.EventoVO;
import vo.InstructorVO;

/**
 * @author Eric
 *
 */
public class EventoDAO extends ConexionDAO implements IEventoDAO {

	/* (non-Javadoc)
	 * @see dao.interfaces.IEventoDAO#insertarEvento(vo.EventoVO)
	 */
	@Override
	public String insertarEvento(EventoVO evento) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			Connection connection = null;
			connection = crearConexion(connection);
			Statement stId = connection.createStatement();
			String queryId = "SELECT id_eve_seq.nextval AS nextId FROM DUAL";
			stId.executeQuery(queryId);
			ResultSet rsId = stId.getResultSet();
			rsId.next();
			int id = rsId.getInt("nextId");
			//mano_el@hotmail.com
			
			String query = "INSERT INTO EVENTOS VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			//6, 'Capacitacion', 'Te divertiras', 'Privado', 35000, 30, '27/02/2017', '30/06/2018', 1, 1, 1, 1);
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1,id);
			statement.setString(2, evento.getNombre());
			statement.setString(3, evento.getDescripcion());
			statement.setString(4, evento.getTipo());
			statement.setDouble(5, evento.getPrecio());
			statement.setInt(6, evento.getCapacidad());
			statement.setString(7, evento.getFecha_inicio());
			//System.out.println(evento.getFecha_inicio());
			///String fechaInicioModificada = acomodarFecha(evento.getFecha_inicio());
			//System.out.println(fechaInicioModificada);
			//statement.setString(7, fechaInicioModificada);
			//String fechaFinModificada = acomodarFecha(evento.getFecha_fin());
			//statement.setString(8, fechaFinModificada);
			statement.setString(8, evento.getFecha_fin());
			statement.setInt(9, evento.getId_lugar());
			statement.setInt(10, 1);
			statement.setInt(11, 0);
			statement.setInt(12, evento.getId_usuario());
			statement.setString(13, evento.getPromocion());
			statement.setInt(14, evento.getId_curso());
			statement.setInt(15, evento.getId_destinatario());
			
			System.out.println(this.getClass() + " -> MiSQL-> " + query);
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

	private String acomodarFecha(String fecha) {
		
		String[] partes = fecha.split("-");
		String anio = partes[0];
		String mes = partes[1];
		String dia = partes[2];
		String nuevaFecha = dia+"/"+mes+"/"+anio;
		return nuevaFecha;
		// TODO Auto-generated method stub
		
	}
	
	
	
	public ArrayList<EventoVO> listarEvento (EventoVO evento) throws BusinessException{
		try {
			ArrayList<EventoVO> listaEventos = new ArrayList<EventoVO>();
			
			Connection connection = null;
			connection = crearConexion(connection);
			
			Statement statement = connection.createStatement();
			
			//String query = "SELECT * FROM " + evento.getNombre()+" WHERE ESTADO != 0 ORDER BY ID ASC;";
//			String query = "SELECT e.id as Id, e.nombre as Nombre, e.descripcion as Descripcion, e.tipo as Tipo, e.precio as Precio,\r\n" + 
//					"e.capacidad as Capacidad, e.fecha_inicio as Fecha_Inicio, e.fecha_fin as Fecha_Fin, e.lugar_id as Lugar_ID,\r\n" + 
//					"e.estado as Estado, e.inscritos as Inscritos, e.usuario_id as Usuario_ID, e.promocion as Promocion, e.curso_id as Curso_ID, u.nombre || "+"' '"+" || u.apellido_paterno || "+"' '"+" || apellido_materno as NombreInstructor, l.nombre as NombreLugar \r\n" + 
//					"FROM eventos e, usuarios u, lugares l WHERE e.ESTADO != 0 AND e.usuario_id = u.id AND e.lugar_id = l.id ORDER BY ID ASC";
			
			String query = "SELECT e.id, e.nombre, e.precio, e.fecha_inicio, e.fecha_fin, e.curso_id, c.nombre as nombrecurso FROM EVENTOS e, cursos c WHERE ESTADO = 1 AND e.curso_id = c.id";
			System.out.println(this.getClass() + " -> MiSQL-> " + query);
			
			statement.execute(query);
			
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next()) {
												
				EventoVO eventoVO = new EventoVO();
				eventoVO.setId_evento(resultSet.getInt("Id"));
				eventoVO.setNombre(resultSet.getString("Nombre"));
				//eventoVO.setDescripcion(resultSet.getString("Descripcion"));
				//eventoVO.setTipo(resultSet.getString("Tipo"));
				eventoVO.setPrecio(resultSet.getDouble("Precio"));
				//eventoVO.setCapacidad(resultSet.getInt("Capacidad"));
				eventoVO.setFecha_inicio(resultSet.getString("Fecha_Inicio"));
				eventoVO.setFecha_fin(resultSet.getString("Fecha_Fin"));
				//eventoVO.setId_lugar(resultSet.getInt("Lugar_ID"));
				//eventoVO.setEstado(resultSet.getString("Estado"));
				//eventoVO.setInscritos(resultSet.getInt("Inscritos"));
				//eventoVO.setId_usuario(resultSet.getInt("Usuario_ID"));
				//eventoVO.setPromocion(resultSet.getString("Promocion"));
				eventoVO.setId_curso(resultSet.getInt("Curso_ID"));
				eventoVO.setNombre_curso(resultSet.getString("nombrecurso"));
				//eventoVO.setNombre_instructor(resultSet.getString("NombreInstructor"));
				//eventoVO.setNombre_lugar(resultSet.getString("NombreLugar"));
				
				
				listaEventos.add(eventoVO);
			}
			
			cerrarConexion(resultSet, statement, connection);
			
			return listaEventos;
			
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

	/* (non-Javadoc)
	 * @see dao.interfaces.IEventoDAO#modificarEvento(vo.EventoVO)
	 */
	@Override
	public String modificarEvento(EventoVO evento) throws BusinessException {
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
			
			String query = "UPDATE EVENTOS SET NOMBRE = ?, DESCRIPCION = ?, TIPO = ?, PRECIO = ?, CAPACIDAD = ?, FECHA_INICIO = ?, FECHA_FIN = ?, LUGAR_ID = ?, ESTADO = ?, USUARIO_ID = ?, PROMOCION = ?, CURSO_ID = ?, DESTINATARIO_ID = ? WHERE ID = ?";
			//6, 'Capacitacion', 'Te divertiras', 'Privado', 35000, 30, '27/02/2017', '30/06/2018', 1, 1, 1, 1);
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, evento.getNombre());
			statement.setString(2, evento.getDescripcion());
			statement.setString(3, evento.getTipo());
			statement.setDouble(4, evento.getPrecio());
			statement.setInt(5, evento.getCapacidad());
			statement.setString(6, evento.getFecha_inicio());
			//String fechaInicioModificada = acomodarFecha(evento.getFecha_inicio());
			//System.out.println(fechaInicioModificada);
			//statement.setString(6, fechaInicioModificada);
			//String fechaFinModificada = acomodarFecha(evento.getFecha_fin());
			//System.out.println(fechaFinModificada);
			//statement.setString(7, fechaFinModificada);
			statement.setString(7, evento.getFecha_fin());
			statement.setInt(8, evento.getId_lugar()); //Lugar
			statement.setInt(9, 1); //estado
			statement.setInt(10, evento.getId_usuario()); //usuario_id
			statement.setString(11, evento.getPromocion());
			statement.setInt(12, evento.getId_curso()); //curso
			System.out.println("El id del destinatario es: "+evento.getId_destinatario());
			statement.setInt(13, evento.getId_destinatario());//destinatario
			statement.setInt(14, evento.getId_evento()); //id del evento
			
			System.out.println(this.getClass() + " -> MiSQL-> " + query);
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

	/* (non-Javadoc)
	 * @see dao.interfaces.IEventoDAO#eliminarEvento(vo.EventoVO)
	 */
	@Override
	public String eliminarEvento(EventoVO evento) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			Connection connection = null;
			connection = crearConexion(connection);
			String query = "UPDATE EVENTOS SET ESTADO = 0 WHERE ID = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, evento.getId_evento());
			System.out.println(this.getClass() + " -> MiSQL-> " + query);
			statement.executeUpdate();
			ResultSet resultSet = statement.getResultSet();
			
			
			
			cerrarConexion(resultSet, statement, connection);
			return "1";
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "0";
		}

	}
	
	public ArrayList<EventoVO> obtenerDatosEvento(EventoVO evento) throws BusinessException{
		try {
			ArrayList<EventoVO> listaDatosEvento = new ArrayList<EventoVO>();
			Connection connection = null;
			connection = crearConexion(connection);
			Statement statement = connection.createStatement();
			//String query = "SELECT * FROM "+evento.getNombre()+" WHERE ID = "+evento.getId_evento();
			String query = "SELECT e.id as Id, e.nombre as Nombre, e.descripcion as Descripcion, e.tipo as Tipo, e.precio as Precio,\r\n" + 
					"e.capacidad as Capacidad, e.fecha_inicio as Fecha_Inicio, e.fecha_fin as Fecha_Fin, e.lugar_id as Lugar_ID,\r\n" + 
					"e.estado as Estado, e.inscritos as Inscritos, e.usuario_id as Usuario_ID, e.promocion as Promocion, e.curso_id as Curso_ID, u.nombre || "+"' '"+" || u.apellido_paterno || "+"' '"+" || apellido_materno as NombreInstructor, l.nombre as NombreLugar \r\n" + 
					",e.destinatario_id FROM eventos e, usuarios u, lugares l WHERE e.id = "+evento.getId_evento()+" AND e.usuario_id = u.id AND e.lugar_id = l.id ORDER BY ID ASC";
			System.out.println(this.getClass() + " -> MiSQL-> " + query);
			statement.execute(query);
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next()) {
				EventoVO eventoVO = new EventoVO();
				eventoVO.setId_evento(resultSet.getInt("Id"));
				eventoVO.setNombre(resultSet.getString("Nombre").trim());
				eventoVO.setDescripcion(resultSet.getString("Descripcion").trim());
				eventoVO.setTipo(resultSet.getString("Tipo"));
				eventoVO.setPrecio(resultSet.getDouble("Precio"));
				eventoVO.setCapacidad(resultSet.getInt("Capacidad"));
				eventoVO.setFecha_inicio(resultSet.getString("Fecha_Inicio"));
				eventoVO.setFecha_fin(resultSet.getString("Fecha_Fin"));
				//String fecha_inicio = modificarFecha(resultSet.getString("Fecha_Inicio"));
				//eventoVO.setFecha_inicio(fecha_inicio);
				//String fecha_fin = modificarFecha(resultSet.getString("Fecha_Fin"));
				//eventoVO.setFecha_fin(fecha_fin);
				//System.out.println(fecha_inicio);
				//System.out.println(fecha_fin);
//				String fecha_inicio = resultSet.getString("Fecha_Inicio");
//				eventoVO.setFecha_inicio(fecha_inicio);
//				String fecha_fin = resultSet.getString("Fecha_Fin");
//				eventoVO.setFecha_fin(fecha_fin);
				eventoVO.setId_lugar(resultSet.getInt("Lugar_ID"));
				eventoVO.setEstado(resultSet.getString("Estado"));
				eventoVO.setInscritos(resultSet.getInt("Inscritos"));
				eventoVO.setId_usuario(resultSet.getInt("Usuario_ID"));
				eventoVO.setPromocion(resultSet.getString("Promocion"));
				eventoVO.setId_curso(resultSet.getInt("Curso_ID"));
				eventoVO.setNombre_instructor(resultSet.getString("NombreInstructor"));
				eventoVO.setNombre_lugar(resultSet.getString("NombreLugar"));
				eventoVO.setId_destinatario(resultSet.getInt("Destinatario_Id"));
				
				listaDatosEvento.add(eventoVO);
			}
			cerrarConexion(resultSet, statement, connection);
			return listaDatosEvento;
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
	
	
	public ArrayList<EventoVO> generarTxt (EventoVO evento) throws BusinessException{
		try {
			ArrayList<EventoVO> listaEventos = new ArrayList<EventoVO>();
			
			Connection connection = null;
			connection = crearConexion(connection);
			
			Statement statement = connection.createStatement();
			
			String query = "SELECT * FROM " + evento.getNombre()+" WHERE ESTADO != 0 ORDER BY ID ASC";
			
			System.out.println(this.getClass() + " -> MiSQL-> " + query);
			
			statement.execute(query);
			
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next()) {
												
				EventoVO eventoVO = new EventoVO();
				eventoVO.setId_evento(resultSet.getInt("Id"));
				eventoVO.setNombre(resultSet.getString("Nombre"));
				eventoVO.setDescripcion(resultSet.getString("Descripcion"));
				eventoVO.setTipo(resultSet.getString("Tipo"));
				eventoVO.setPrecio(resultSet.getDouble("Precio"));
				eventoVO.setCapacidad(resultSet.getInt("Capacidad"));
				eventoVO.setFecha_inicio(resultSet.getString("Fecha_Inicio"));
				eventoVO.setFecha_fin(resultSet.getString("Fecha_Fin"));
				eventoVO.setId_lugar(resultSet.getInt("Lugar_ID"));
				eventoVO.setEstado(resultSet.getString("Estado"));
				eventoVO.setInscritos(resultSet.getInt("Inscritos"));
				eventoVO.setId_usuario(resultSet.getInt("Usuario_ID"));
				eventoVO.setPromocion(resultSet.getString("Promocion"));
				eventoVO.setId_curso(resultSet.getInt("Curso_ID"));
				
				
				listaEventos.add(eventoVO);
			}
			
			cerrarConexion(resultSet, statement, connection);
			
			return listaEventos;
			
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

	private String modificarFecha(String fecha) {
		// TODO Auto-generated method stub
		String[] partes = fecha.split("/");
		String dia = partes[0];
		String mes = partes[1];
		String anio = partes[2];
		String nuevaFecha = anio+"-"+mes+"-"+dia;
		String[] parteFecha = nuevaFecha.split(" ");
		String fechaModificada = parteFecha[0];
		System.out.println(fechaModificada);
		return fechaModificada;
	}

	@Override
	public ArrayList<EventoVO> detallesListaEvento(EventoVO evento) {
		// TODO Auto-generated method stub
		try {
			ArrayList<EventoVO> listaEventos = new ArrayList<EventoVO>();
			
			Connection connection = null;
			connection = crearConexion(connection);
			
			Statement statement = connection.createStatement();
			
			//String query = "SELECT * FROM " + evento.getNombre()+" WHERE ESTADO != 0 ORDER BY ID ASC;";
			String query = "SELECT e.id as Id, e.nombre as Nombre, e.descripcion as Descripcion, e.tipo as Tipo, e.precio as Precio,\r\n" + 
					"e.capacidad as Capacidad, e.fecha_inicio as Fecha_Inicio, e.fecha_fin as Fecha_Fin, e.lugar_id as Lugar_ID,\r\n" + 
					"e.estado as Estado, e.inscritos as Inscritos, e.usuario_id as Usuario_ID, e.promocion as Promocion, e.curso_id as Curso_ID, u.nombre || "+"' '"+" || u.apellido_paterno || "+"' '"+" || apellido_materno as NombreInstructor, l.nombre as NombreLugar, c.nombre as nombrecurso \r\n" + 
					"FROM eventos e, usuarios u, lugares l, cursos c WHERE e.ESTADO != 0 AND e.usuario_id = u.id AND e.curso_id = c.id AND e.lugar_id = l.id AND e.ID = "+evento.getId_evento()+" ORDER BY ID ASC";
			
			
			System.out.println(this.getClass() + " -> MiSQL-> " + query);
			
			statement.execute(query);
			
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next()) {
												
				EventoVO eventoVO = new EventoVO();
				eventoVO.setId_evento(resultSet.getInt("Id"));
				eventoVO.setNombre(resultSet.getString("Nombre"));
				eventoVO.setDescripcion(resultSet.getString("Descripcion"));
				eventoVO.setTipo(resultSet.getString("Tipo"));
				eventoVO.setPrecio(resultSet.getDouble("Precio"));
				eventoVO.setCapacidad(resultSet.getInt("Capacidad"));
				eventoVO.setFecha_inicio(resultSet.getString("Fecha_Inicio"));
				eventoVO.setFecha_fin(resultSet.getString("Fecha_Fin"));
				eventoVO.setId_lugar(resultSet.getInt("Lugar_ID"));
				eventoVO.setEstado(resultSet.getString("Estado"));
				//eventoVO.setInscritos(resultSet.getInt("Inscritos"));
				eventoVO.setId_usuario(resultSet.getInt("Usuario_ID"));
				eventoVO.setPromocion(resultSet.getString("Promocion"));
				eventoVO.setId_curso(resultSet.getInt("Curso_ID"));
				eventoVO.setNombre_instructor(resultSet.getString("NombreInstructor"));
				eventoVO.setNombre_lugar(resultSet.getString("NombreLugar"));
				eventoVO.setNombre_curso(resultSet.getString("nombrecurso"));
				
				
				listaEventos.add(eventoVO);
			}
			
			cerrarConexion(resultSet, statement, connection);
			
			return listaEventos;
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error en DAO");
			return null;
		}
	}

	@Override
	public ArrayList<EventoVO> detallesInscripcionEvento(EventoVO evento) {
		// TODO Auto-generated method stub
		try {
			ArrayList<EventoVO> listaEventos = new ArrayList<EventoVO>();
			
			Connection connection = null;
			connection = crearConexion(connection);
			
			Statement statement = connection.createStatement();
			
			//String query = "SELECT * FROM " + evento.getNombre()+" WHERE ESTADO != 0 ORDER BY ID ASC;";
			String query = "SELECT e.id as Id, e.nombre as Nombre, e.descripcion as Descripcion, e.tipo as Tipo, e.precio as Precio,\r\n" + 
					"e.capacidad as Capacidad, e.fecha_inicio as Fecha_Inicio, e.fecha_fin as Fecha_Fin, e.lugar_id as Lugar_ID,\r\n" + 
					"e.estado as Estado, e.inscritos as Inscritos, e.usuario_id as Usuario_ID, e.promocion as Promocion, e.curso_id as Curso_ID, u.nombre || "+"' '"+" || u.apellido_paterno || "+"' '"+" || apellido_materno as NombreInstructor, l.nombre as NombreLugar, \r\n" + 
					"c.nombre as nombrecurso FROM eventos e, usuarios u, cursos c, lugares l WHERE e.ESTADO != 0 AND e.curso_id = c.id AND e.usuario_id = u.id AND e.lugar_id = l.id AND e.ID = "+evento.getId_evento()+" ORDER BY ID ASC";
			
			
			System.out.println(this.getClass() + " -> MiSQL-> " + query);
			
			statement.execute(query);
			
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next()) {
												
				EventoVO eventoVO = new EventoVO();
				eventoVO.setId_evento(resultSet.getInt("Id"));
				eventoVO.setNombre(resultSet.getString("Nombre"));
				eventoVO.setDescripcion(resultSet.getString("Descripcion"));
				eventoVO.setTipo(resultSet.getString("Tipo"));
				eventoVO.setPrecio(resultSet.getDouble("Precio"));
				eventoVO.setCapacidad(resultSet.getInt("Capacidad"));
				eventoVO.setFecha_inicio(resultSet.getString("Fecha_Inicio"));
				eventoVO.setFecha_fin(resultSet.getString("Fecha_Fin"));
				eventoVO.setId_lugar(resultSet.getInt("Lugar_ID"));
				eventoVO.setEstado(resultSet.getString("Estado"));
				eventoVO.setInscritos(resultSet.getInt("Inscritos"));
				eventoVO.setId_usuario(resultSet.getInt("Usuario_ID"));
				eventoVO.setPromocion(resultSet.getString("Promocion"));
				eventoVO.setId_curso(resultSet.getInt("Curso_ID"));
				eventoVO.setNombre_instructor(resultSet.getString("NombreInstructor"));
				eventoVO.setNombre_lugar(resultSet.getString("NombreLugar"));
				eventoVO.setNombre_curso(resultSet.getString("nombrecurso"));
				
				
				listaEventos.add(eventoVO);
			}
			
			cerrarConexion(resultSet, statement, connection);
			
			return listaEventos;
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error en DAO");
			return null;
		}
	}

	
	
}
