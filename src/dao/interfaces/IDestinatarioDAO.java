package dao.interfaces;

import java.util.ArrayList;

import excepcion.BusinessException;
import vo.DestinatarioVO;

public interface IDestinatarioDAO {

	public ArrayList<DestinatarioVO> consultaDestinatarios (DestinatarioVO destinatario) throws BusinessException;
	public String agregarDestinatario (DestinatarioVO destinatario);
	public String modificarDestinatario(DestinatarioVO destinatario);
	public String eliminarDestinatario(DestinatarioVO destinatario);
	public ArrayList<DestinatarioVO > obtenerDatosDestinatario(DestinatarioVO destinatario);
}
