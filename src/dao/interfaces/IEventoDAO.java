/**
 * 
 */
package dao.interfaces;

import java.util.ArrayList;

import excepcion.BusinessException;
import vo.EventoVO;

/**
 * @author Eric
 *
 */
public interface IEventoDAO {
	public String insertarEvento(EventoVO evento) throws BusinessException;
	public ArrayList<EventoVO> obtenerDatosEvento(EventoVO evento) throws BusinessException;
	public ArrayList<EventoVO> listarEvento (EventoVO evento) throws BusinessException;
	public String modificarEvento(EventoVO evento) throws BusinessException;
	public String eliminarEvento(EventoVO evento) throws BusinessException;
	public ArrayList<EventoVO> generarTxt(EventoVO evento)throws BusinessException;
	public ArrayList<EventoVO> detallesListaEvento(EventoVO evento);
	public ArrayList<EventoVO> detallesInscripcionEvento(EventoVO evento);
}
