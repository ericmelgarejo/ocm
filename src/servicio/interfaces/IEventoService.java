/**
 * 
 */
package servicio.interfaces;

import java.util.ArrayList;

import excepcion.BusinessException;
import vo.EventoVO;
import vo.InstructorVO;

/**
 * @author Eric
 *
 */
public interface IEventoService {
	public String insertarEvento(EventoVO evento) throws BusinessException;
	public ArrayList<EventoVO> listarEvento (EventoVO evento) throws BusinessException;
	public ArrayList<EventoVO> obtenerDatosEvento(EventoVO evento) throws BusinessException;
	public String modificarEvento(EventoVO evento) throws BusinessException;
	public String eliminarEvento(EventoVO evento) throws BusinessException;
	public ArrayList<EventoVO> generarTxt(EventoVO evento)throws BusinessException;
	public ArrayList<EventoVO> detallesListaEvento(EventoVO evento);
	public ArrayList<EventoVO> detallesInscripcionEvento(EventoVO evento);
}
