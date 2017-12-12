/**
 * 
 */
package servicio.implementacion;

import java.io.File;
import java.io.FileWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import dao.implementacion.EventoDAO;
import dao.implementacion.InstructorDAO;
import dao.interfaces.IEventoDAO;
import dao.interfaces.IInstructorDAO;
import excepcion.BusinessException;
import servicio.interfaces.IEventoService;
import vo.EventoVO;
import vo.InstructorVO;

/**
 * @author Eric
 *
 */
public class EventoService implements IEventoService {

	/* (non-Javadoc)
	 * @see servicio.interfaces.IEventoService#insertarEvento(vo.EventoVO)
	 */
	@Override
	public String insertarEvento(EventoVO evento) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			
			IEventoDAO eventoDAO = new EventoDAO();
			String res = eventoDAO.insertarEvento(evento);
			
			
			return res;
			
		}catch(Exception e) {
			BusinessException be = new BusinessException();
			be.setStackTrace(e.getStackTrace());
			be.setIdException("201");
			be.setMessage("Error en la capa de negocio");
			throw be;
		}

	}
	
	public ArrayList<EventoVO> listarEvento (EventoVO evento) throws BusinessException{
		try {
			ArrayList<EventoVO> listaEventos = new ArrayList<EventoVO>();
			
			IEventoDAO eventoDAO = new EventoDAO();
			
			listaEventos = eventoDAO.listarEvento(evento);
			
//			for(int i=0; i<listaEventos.size();i++) {
//			String fechaInicio=listaEventos.get(i).getFecha_inicio();
//			int cupoEvento= listaEventos.get(i).getCapacidad();
//			int cupoEvento50 = cupoEvento;  //obtiene el numero de cupo
//			double rojo = cupoEvento50 * 0.5; //numero a 50%         --50
//			double naranja = cupoEvento50 * 0.75;  //numero a 75%    --37
//			double amarillo = cupoEvento50 * 0.90;  //numero a 90%   --45
//			double verde = cupoEvento50 * 0.999;  //numero a 50%     --49   
//			
////			}
//			//Instanciamos el objeto Calendar
//	        //en fecha obtenemos la fecha y hora del sistema
//	        Calendar fecha = new GregorianCalendar();
//	        //Obtenemos el valor del año, mes, día,
//	        //hora, minuto y segundo del sistema
//	        //usando el método get y el parámetro correspondiente
//	        int año = fecha.get(Calendar.YEAR);
//	        int mes = fecha.get(Calendar.MONTH)+1;
//	        int dia = fecha.get(Calendar.DAY_OF_MONTH);
//	    	
//	        String fechaActual =   Integer.toString(dia)+"/"+ Integer.toString(mes)+"/"+ Integer.toString(año) ;
//	        //String fecha2 =  String.valueOf(año)+"-"+String.valueOf(mes)+"-"+String.valueOf(dia) ;
//	        System.out.println("fechaactual "+fechaActual);
//	        String startDate= fechaActual;
//	        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
//	        java.util.Date date = sdf1.parse(startDate);
//	        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());  
//	        
//	        System.out.println("fechainicio "+fechaInicio);
//	        String startDate2= fechaInicio;
//	        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
//	        java.util.Date date2 = sdf2.parse(startDate2);
//	        java.sql.Date sqlStartDate2 = new java.sql.Date(date2.getTime());  
//	        
//	        //Date fechaInicial = SimpleDateFormat.parse(fechaInicio);
//	        
//	        long diass = getDiffDates(sqlStartDate,sqlStartDate2,2); 
//	        System.out.println("diass "+diass);
//	        
//	        if(diass>15) { //&& cupoEvento>rojo
//	        	String color="#FFFC8E";
//	        	System.out.println("red");
//	        	//listaEventos.set(0, listaEventos);
//	        	listaEventos.get(i).setColor("red");
//	        }
//	        else if(diass<=15 && diass>7 ) { //&& diass>amarillo
//	        	System.out.println("orange");
//	        	listaEventos.get(i).setColor("orange");
//	        }
//	        else if(diass<=7 && diass>1) { //&& diass>1
//	        	System.out.println("yellow");
//	        	listaEventos.get(i).setColor("yellow");
//	        }else if(diass==1 && diass>0) {
//	        	System.out.println("green");
//	        	listaEventos.get(i).setColor("green");
//	        }
//			}//fin for
			return listaEventos;
			
		}catch(Exception e) {
			BusinessException be = new BusinessException();
			be.setStackTrace(e.getStackTrace());
			System.out.println(e);
			//be.setIdException("201");
			be.setMessage("Error en la capa de negocio");
			throw be;
		}
		
	}

	/* (non-Javadoc)
	 * @see servicio.interfaces.IEventoService#modificarEvento(vo.EventoVO)
	 */
	@Override
	public String modificarEvento(EventoVO evento) throws BusinessException {
		// TODO Auto-generated method stub
		
		try {
			
			IEventoDAO eventoDAO = new EventoDAO();
			String res = eventoDAO.modificarEvento(evento);
			
			
			return res;
			
		}catch(Exception e) {
			BusinessException be = new BusinessException();
			be.setStackTrace(e.getStackTrace());
			be.setIdException("201");
			be.setMessage("Error en la capa de negocio");
			throw be;
		}
		
	}

	/* (non-Javadoc)
	 * @see servicio.interfaces.IEventoService#eliminarEvento(vo.EventoVO)
	 */
	@Override
	public String eliminarEvento(EventoVO evento) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			
			IEventoDAO eventoDAO = new EventoDAO();
			String res = eventoDAO.eliminarEvento(evento);
			
			
			return res;
			
		}catch(Exception e) {
			BusinessException be = new BusinessException();
			be.setStackTrace(e.getStackTrace());
			be.setIdException("201");
			be.setMessage("Error en la capa de negocio");
			throw be;
		}
	}

	@Override
	public ArrayList<EventoVO> obtenerDatosEvento(EventoVO evento) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			ArrayList<EventoVO> listaDatosEvento = new ArrayList<EventoVO>();
			
			IEventoDAO eventoDAO = new EventoDAO();
			
			listaDatosEvento = eventoDAO.obtenerDatosEvento(evento);
			
			return listaDatosEvento;
			
		}catch(Exception e) {
			BusinessException be = new BusinessException();
			be.setStackTrace(e.getStackTrace());
			be.setIdException("201");
			be.setMessage("Error en la capa de negocio");
			throw be;
		}
	}

	@Override
	public ArrayList<EventoVO>  generarTxt(EventoVO evento) throws BusinessException {
		// TODO Auto-generated method stub
		
		try {
			ArrayList<EventoVO> listaDatosEvento = new ArrayList<EventoVO>();
			IEventoDAO eventoDAO = new EventoDAO();
			listaDatosEvento = eventoDAO.generarTxt(evento);
			
			for(int i=0; i<listaDatosEvento.size();i++) {
				//Extrae Datos de los eventos
				
				//System.out.println("Entro "+ i);
				
				String nombre=listaDatosEvento.get(i).getNombre();
				String descripcion=listaDatosEvento.get(i).getDescripcion();
				String fechaInicio=listaDatosEvento.get(i).getFecha_inicio();
				String fechaFin=listaDatosEvento.get(i).getFecha_fin();
				String precio = String.valueOf(listaDatosEvento.get(i).getPrecio());
				
				try
				{
				//Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
				File archivo=new File("C:\\Users\\lipe\\eclipse-workspace\\"+nombre+".txt");
				//System.out.println("si Entro");
				//Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
				FileWriter escribir=new FileWriter(archivo,true);

				//Escribimos en el archivo con el metodo write 
				escribir.write(descripcion);
				escribir.write(System.getProperty( "line.separator" ));
				escribir.write(fechaInicio);
				escribir.write(System.getProperty( "line.separator" ));
				escribir.write(fechaFin);
				escribir.write(System.getProperty( "line.separator" ));
				escribir.write(precio);

				//Cerramos la conexion
				escribir.close();
				}

				//Si existe un problema al escribir cae aqui
				catch(Exception e)
				{
				System.out.println("Error al escribir");
				}
			
			}//Fin del for
			
			
			return listaDatosEvento;
		}catch(Exception e) {
			BusinessException be = new BusinessException();
			be.setStackTrace(e.getStackTrace());
			System.out.println(e);
			be.setIdException("201");
			be.setMessage("Error en la capa de negocio");
			throw be;
		}
		

	}

	
	public long getDiffDates(Date fechaInicio, Date fechaFin, int tipo) {
		// Fecha inicio
		Calendar calendarInicio = Calendar.getInstance();
		calendarInicio.setTime(fechaInicio);
		int diaInicio = calendarInicio.get(Calendar.DAY_OF_MONTH);
		int mesInicio = calendarInicio.get(Calendar.MONTH) + 1; // 0 Enero, 11 Diciembre
		int anioInicio = calendarInicio.get(Calendar.YEAR);
	 
		// Fecha fin
		Calendar calendarFin = Calendar.getInstance();
		calendarFin.setTime(fechaFin);
		int diaFin = calendarFin.get(Calendar.DAY_OF_MONTH);
		int mesFin = calendarFin.get(Calendar.MONTH) + 1; // 0 Enero, 11 Diciembre
		int anioFin = calendarFin.get(Calendar.YEAR);
	 
		int anios = 0;
		int mesesPorAnio = 0;
		int diasPorMes = 0;
		int diasTipoMes = 0;
	 
		//
		// Calculo de días del mes
		//
		if (mesInicio == 2) {
			// Febrero
			if ((anioFin % 4 == 0) && ((anioFin % 100 != 0) || (anioFin % 400 == 0))) {
				// Bisiesto
				diasTipoMes = 29;
			} else {
				// No bisiesto
				diasTipoMes = 28;
			}
		} else if (mesInicio <= 7) {
			// De Enero a Julio los meses pares tienen 30 y los impares 31
			if (mesInicio % 2 == 0) {
				diasTipoMes = 30;
			} else {
				diasTipoMes = 31;
			}
		} else if (mesInicio > 7) {
			// De Julio a Diciembre los meses pares tienen 31 y los impares 30
			if (mesInicio % 2 == 0) {
				diasTipoMes = 31;
			} else {
				diasTipoMes = 30;
			}
		}
	 
	 
		//
		// Calculo de diferencia de año, mes y dia
		//
		if ((anioInicio > anioFin) || (anioInicio == anioFin && mesInicio > mesFin)
				|| (anioInicio == anioFin && mesInicio == mesFin && diaInicio > diaFin)) {
			// La fecha de inicio es posterior a la fecha fin
			// System.out.println("La fecha de inicio ha de ser anterior a la fecha fin");
			return -1;
		} else {
			if (mesInicio <= mesFin) {
				anios = anioFin - anioInicio;
				if (diaInicio <= diaFin) {
					mesesPorAnio = mesFin - mesInicio;
					diasPorMes = diaFin - diaInicio;
				} else {
					if (mesFin == mesInicio) {
						anios = anios - 1;
					}
					mesesPorAnio = (mesFin - mesInicio - 1 + 12) % 12;
					diasPorMes = diasTipoMes - (diaInicio - diaFin);
				}
			} else {
				anios = anioFin - anioInicio - 1;
				System.out.println(anios);
				if (diaInicio > diaFin) {
					mesesPorAnio = mesFin - mesInicio - 1 + 12;
					diasPorMes = diasTipoMes - (diaInicio - diaFin);
				} else {
					mesesPorAnio = mesFin - mesInicio + 12;
					diasPorMes = diaFin - diaInicio;
				}
			}
		}
		//System.out.println("Han transcurrido " + anios + " Años, " + mesesPorAnio + " Meses y " + diasPorMes + " Días.");		
	 
		//
		// Totales
		//
		long returnValue = -1;
	 
		switch (tipo) {
			case 0:
				// Total Años
				returnValue = anios;
				// System.out.println("Total años: " + returnValue + " Años.");
				break;
	 
			case 1:
				// Total Meses
				returnValue = anios * 12 + mesesPorAnio;
				// System.out.println("Total meses: " + returnValue + " Meses.");
				break;
	 
			case 2:
				// Total Dias (se calcula a partir de los milisegundos por día)
				long millsecsPerDay = 86400000; // Milisegundos al día
				returnValue = (fechaFin.getTime() - fechaInicio.getTime()) / millsecsPerDay;
				// System.out.println("Total días: " + returnValue + " Días.");
				break;
	 
			case 3:
				// Meses del año
				returnValue = mesesPorAnio;
				// System.out.println("Meses del año: " + returnValue);
				break;
	 
			case 4:
				// Dias del mes
				returnValue = diasPorMes;
				// System.out.println("Dias del mes: " + returnValue);
				break;
	 
			default:
				break;
		}
	 
		return returnValue;
	}

	@Override
	public ArrayList<EventoVO> detallesListaEvento(EventoVO evento) {
		// TODO Auto-generated method stub
		try {
			ArrayList<EventoVO> listaEventos = new ArrayList<EventoVO>();
			
			IEventoDAO eventoDAO = new EventoDAO();
			
			listaEventos = eventoDAO.detallesListaEvento(evento);
			return listaEventos;
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error en service");
			return null;
			
			
		}
	}

	@Override
	public ArrayList<EventoVO> detallesInscripcionEvento(EventoVO evento) {
		// TODO Auto-generated method stub
		try {
			ArrayList<EventoVO> listaEventos = new ArrayList<EventoVO>();
			
			IEventoDAO eventoDAO = new EventoDAO();
			
			listaEventos = eventoDAO.detallesInscripcionEvento(evento);
			return listaEventos;
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error en service");
			return null;
			
			
		}
	}

}
