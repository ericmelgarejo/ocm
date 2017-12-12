/**
 * 
 */
package vo;

/**
 * @author Eric
 *
 */
public class CursoVO {
	
 private int id;
 
 private String nombre;
 
 private String descripcion;
 
 private int horas;
 
 private int programa_id;
 
 private int status;
 
 private String programa_nombre;

/**
 * @return the id
 */
public int getId() {
	return id;
}

/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}

/**
 * @return the nombre
 */
public String getNombre() {
	return nombre;
}

/**
 * @param nombre the nombre to set
 */
public void setNombre(String nombre) {
	this.nombre = nombre;
}

/**
 * @return the descripcion
 */
public String getDescripcion() {
	return descripcion;
}

/**
 * @param descripcion the descripcion to set
 */
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

/**
 * @return the horas
 */
public int getHoras() {
	return horas;
}

/**
 * @param horas the horas to set
 */
public void setHoras(int horas) {
	this.horas = horas;
}

/**
 * @return the programa_id
 */
public int getPrograma_id() {
	return programa_id;
}

/**
 * @param programa_id the programa_id to set
 */
public void setPrograma_id(int programa_id) {
	this.programa_id = programa_id;
}

/**
 * @return the status
 */
public int getStatus() {
	return status;
}

/**
 * @param status the status to set
 */
public void setStatus(int status) {
	this.status = status;
}

/**
 * @return the programa_nombre
 */
public String getPrograma_nombre() {
	return programa_nombre;
}

/**
 * @param programa_nombre the programa_nombre to set
 */
public void setPrograma_nombre(String programa_nombre) {
	this.programa_nombre = programa_nombre;
}
 
}
