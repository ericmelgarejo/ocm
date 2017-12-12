/**
 * 
 */
package vo;

/**
 * @author Eric
 *
 */
public class LugarVO {
	private int id;
	private String nombre;
	private String direccion;
	private int ciudad_id;
	private String ciudad_nombre;
	/**
	 * @return the ciudad_nombre
	 */
	public String getCiudad_nombre() {
		return ciudad_nombre;
	}
	/**
	 * @param ciudad_nombre the ciudad_nombre to set
	 */
	public void setCiudad_nombre(String ciudad_nombre) {
		this.ciudad_nombre = ciudad_nombre;
	}
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
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the ciudad_id
	 */
	public int getCiudad_id() {
		return ciudad_id;
	}
	/**
	 * @param ciudad_id the ciudad_id to set
	 */
	public void setCiudad_id(int ciudad_id) {
		this.ciudad_id = ciudad_id;
	}
	
	
}
