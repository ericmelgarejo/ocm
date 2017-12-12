/**
 * 
 */
package servicio.implementacion;

import java.util.ArrayList;

import dao.implementacion.CiudadDAO;
import dao.implementacion.LugarDAO;
import dao.implementacion.ProgramasDAO;
import dao.interfaces.ICiudadDAO;
import dao.interfaces.ILugarDAO;
import dao.interfaces.IProgramasDAO;
import excepcion.BusinessException;
import servicio.interfaces.ILugarService;
import vo.CiudadVO;
import vo.LugarVO;

/**
 * @author Eric
 *
 */
public class LugarService implements ILugarService {

	/* (non-Javadoc)
	 * @see servicio.interfaces.ILugarService#consultaLugares(int)
	 */
	@Override
	public ArrayList<LugarVO> consultaLugares(int id_ciudad) throws BusinessException {
		// TODO Auto-generated method stub
		ArrayList<LugarVO> listaLugares = new ArrayList<LugarVO>();
		ILugarDAO lugarDAO = new LugarDAO();
		listaLugares = lugarDAO.consultaLugares(id_ciudad);
		return listaLugares;
	}

	@Override
	public ArrayList<LugarVO> consultaListaLugares(LugarVO lugar) {
		// TODO Auto-generated method stub
		try {
			ArrayList<LugarVO> listaLugares = new ArrayList<LugarVO>();
			
			ILugarDAO lugarDAO = new LugarDAO();
			
			listaLugares = lugarDAO.consultaListaLugares(lugar);
			
			return listaLugares;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error en Service");
			return null;
		}
	}

	@Override
	public String agregarLugar(LugarVO lugar) {
		// TODO Auto-generated method stub
		try {
			
			ILugarDAO lugarDAO = new LugarDAO();
			String res = lugarDAO.agregarLugar(lugar);
			
			
			return res;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error en service");
			return null;
		}
	}

	@Override
	public String modificarLugar(LugarVO lugar) {
		// TODO Auto-generated method stub
		try {
			ILugarDAO lugarDAO = new LugarDAO();
			String res = lugarDAO.modificarLugar(lugar);
			return res;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error en Service");
			return null;
		}
	}

	@Override
	public String eliminarLugar(LugarVO lugar) {
		// TODO Auto-generated method stub
		try {
			ILugarDAO lugarDAO = new LugarDAO();
			String res = lugarDAO.eliminarLugar(lugar);
			
			
			return res;
			}catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("Error en el service");
				return null;
			}
	}

	@Override
	public ArrayList<LugarVO> obtenerDatosLugar(LugarVO lugar) {
		// TODO Auto-generated method stub
		try {
			ArrayList<LugarVO> listaDatosLugar = new ArrayList<LugarVO>();
			ILugarDAO lugarDAO = new LugarDAO();
			listaDatosLugar = lugarDAO.obtenerDatosLugar(lugar);
			return listaDatosLugar;
			}catch(Exception ex) {
				ex.printStackTrace();
				System.out.println("Error en Service");
				return null;
			}
	}

	@Override
	public ArrayList<Integer> obtenerCiudadPais(int id_lugar) {
		// TODO Auto-generated method stub
		try {
			ArrayList<Integer> idCiudadPais = new ArrayList<Integer>();
			ILugarDAO lugarDAO = new LugarDAO();
			idCiudadPais = lugarDAO.obtenerCiudadPais(id_lugar);
			return idCiudadPais;
			}catch(Exception ex) {
				System.out.println("Error en service");
				return null;
			}
	}

}
