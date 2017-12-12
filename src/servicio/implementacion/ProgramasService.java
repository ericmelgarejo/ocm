/**
 * 
 */
package servicio.implementacion;

import java.util.ArrayList;

import dao.implementacion.ProgramasDAO;
import dao.interfaces.IProgramasDAO;
import servicio.interfaces.IProgramasService;
import vo.ProgramaVO;

/**
 * @author Sergio Ramos
 *
 */
public class ProgramasService implements IProgramasService {

	/* (non-Javadoc)
	 * @see servicio.interfaces.IProgramasService#consultarProgramas()
	 */
	@Override
	public ArrayList<ProgramaVO> consultarProgramas() {
		// TODO Auto-generated method stub
		ArrayList<ProgramaVO> listaProgramas = new ArrayList<ProgramaVO>();
		
		IProgramasDAO programasDAO = new ProgramasDAO();
		
		try {
		
			listaProgramas = programasDAO.consultarProgramas();
		
		}catch(Exception e) {
			System.out.println("Error en consultarProgramas de programaService. Mensaje: "+e);
		}
		
		return listaProgramas;
		
	}

	@Override
	public String insertarPrograma(ProgramaVO programa) {
		// TODO Auto-generated method stub
		ArrayList<ProgramaVO> listaProgramas = new ArrayList<ProgramaVO>();
		
		IProgramasDAO programaDAO = new ProgramasDAO();
		
		boolean realizarInsert = true;
		
		String respuesta ="";
		
		int id_encontrado = 0;
		
		try {
			
			listaProgramas = consultarProgramas();
			
			for(int i=0; i<listaProgramas.size();i++) {
				if(listaProgramas.get(i).getNombre().equals(programa.getNombre())) {
					realizarInsert = false;
					System.out.println("Programa encontrado");
					System.out.println("Programa a insertar: " + programa.getNombre());
					System.out.println("Programa en DB: " + listaProgramas.get(i).getNombre());
					id_encontrado = listaProgramas.get(i).getId();
					System.out.println("id Programa en DB: " + id_encontrado);
				}
			}
			
			if (realizarInsert == true) {

				respuesta = programaDAO.insertarPrograma(programa);
				
			}else {
				System.out.println("Programa ya existe");
				int status = 1;
				programa.setStatus(status);
				programa.setId(id_encontrado);
				respuesta = actualizarPrograma(programa);
			}
			
		}catch(Exception e) {
			System.out.println("Error en insertarPrograma de programaService. Mensaje: "+e);
		}
		return respuesta;	
	}

	@Override
	public ProgramaVO consultarPrograma(int id) {
		// TODO Auto-generated method stub
		ProgramaVO programa = new ProgramaVO();
		
		IProgramasDAO programaDAO = new ProgramasDAO();
		
		programa = programaDAO.consultarPrograma(id);
		
		return programa;
		
	}

	@Override
	public String actualizarPrograma(ProgramaVO programa) {
		// TODO Auto-generated method stub
		
		String respuesta ="";
		
		IProgramasDAO programaDAO = new ProgramasDAO();
		
		try {
			
			respuesta = programaDAO.actualizarPrograma(programa);
			
		}catch(Exception e) {
			System.out.println("Error en actualizarPrograma de ProgramaService. Mensaje: "+e);
		}
		
		return respuesta;
	}

	@Override
	public String eliminarPrograma(ProgramaVO programa) {
		// TODO Auto-generated method stub
		
		String respuesta ="";
		
		IProgramasDAO programaDAO = new ProgramasDAO();

		try {
			
			respuesta = programaDAO.eliminarPrograma(programa);
			
		}catch(Exception e) {
			System.out.println("Error en eliminarPrograma de ProgramaService. Mensaje: "+e);
		}
		
		return respuesta;
	}

	@Override
	public int consultarProgramaDeCurso(int id_curso) {
		// TODO Auto-generated method stub
		try {
		int idPrograma;
		IProgramasDAO programaDAO = new ProgramasDAO();
		idPrograma = programaDAO.consultarProgramaDeCurso(id_curso);
		return idPrograma;
		}catch(Exception ex) {
			System.out.println("Error en service");
			return 0;
		}
	}
}