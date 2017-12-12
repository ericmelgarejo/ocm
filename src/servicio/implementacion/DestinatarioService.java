package servicio.implementacion;

import java.util.ArrayList;

import dao.implementacion.DestinatarioDAO;
import dao.interfaces.IDestinatarioDAO;
import excepcion.BusinessException;
import servicio.interfaces.IDestinatarioService;
import servicio.interfaces.IDestinatarioService;
import vo.DestinatarioVO;
import vo.DestinatarioVO;

public class DestinatarioService implements IDestinatarioService{


	public ArrayList<DestinatarioVO> consultaDestinatarios(DestinatarioVO destinatario) throws BusinessException {
		
		System.out.println("error enservice"+ destinatario.getNombre());
		
		try {
			ArrayList<DestinatarioVO> listaDestinatarios = new ArrayList<DestinatarioVO>();
			
			IDestinatarioDAO destinatarioDAO = new DestinatarioDAO();
			
			listaDestinatarios = destinatarioDAO.consultaDestinatarios(destinatario);
			
			return listaDestinatarios;
			
		}catch(Exception e) {
			BusinessException be = new BusinessException();
			be.setStackTrace(e.getStackTrace());
			be.setIdException("201");
			be.setMessage("Error en la capa de negocio");
			System.out.println(e);
			throw be;
		}
	}

	
	public String agregarDestinatario(DestinatarioVO destinatario) {
		try {
			IDestinatarioDAO destinatarioDAO = new DestinatarioDAO();
			String res = destinatarioDAO.agregarDestinatario(destinatario);
			return res;
			}catch(Exception ex) {
				ex.printStackTrace();
				System.out.println("Error en Service agrega");
				return null;
			}
	}

	
	public String modificarDestinatario(DestinatarioVO destinatario) {
		try {
			IDestinatarioDAO destinatarioDAO = new DestinatarioDAO();
			String res = destinatarioDAO.modificarDestinatario(destinatario);
			return res;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error en Service midifica");
			return null;
		}
	}

	@Override
	public String eliminarDestinatario(DestinatarioVO destinatario) {
		try {
			IDestinatarioDAO destinatarioDAO = new DestinatarioDAO();
			String res = destinatarioDAO.eliminarDestinatario(destinatario);
			
			
			return res;
			}catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("Error en el service elimia");
				return null;
			}
	}

	
	public ArrayList<DestinatarioVO> obtenerDatosDestinatario(DestinatarioVO destinatario) {
		try {
			ArrayList<DestinatarioVO> listaDatosDestinatarios = new ArrayList<DestinatarioVO>();
			IDestinatarioDAO destinatarioDAO = new DestinatarioDAO();
			listaDatosDestinatarios = destinatarioDAO.obtenerDatosDestinatario(destinatario);
			return listaDatosDestinatarios;
			}catch(Exception ex) {
				ex.printStackTrace();
				System.out.println("Error en Service datos");
				return null;
			}
	}
		
}
