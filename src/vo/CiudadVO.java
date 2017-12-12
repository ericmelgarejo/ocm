/**
 * 
 */
package vo;

/**
 * @author Eric
 *
 */
public class CiudadVO {
	private int id;
	private String nombre;
	private int pais_id;
	private String pais_nombre;
	/**
	 * @return the pais_nombre
	 */
	public String getPais_nombre() {
		return pais_nombre;
	}
	/**
	 * @param pais_nombre the pais_nombre to set
	 */
	public void setPais_nombre(String pais_nombre) {
		this.pais_nombre = pais_nombre;
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
	 * @return the pais_id
	 */
	public int getPais_id() {
		return pais_id;
	}
	/**
	 * @param pais_id the pais_id to set
	 */
	public void setPais_id(int pais_id) {
		this.pais_id = pais_id;
	}
}
