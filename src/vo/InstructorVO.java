/**
 * 
 */
package vo;

/**
 * @author Eric
 *
 */
public class InstructorVO {
	private int id_instructor;
	private String nombre;
	private String apellido_paterno;
	private String apellido_materno;
	private String correo;
	private String telefono;
	private String fecha_nacimiento;
	private String password;
	private int tipo_usuario;
	private int estado;
	
	/**
	 * @return the id_instructor
	 */
	public int getId_instructor() {
		return id_instructor;
	}
	/**
	 * @param id_instructor the id_instructor to set
	 */
	public void setId_instructor(int id_instructor) {
		this.id_instructor = id_instructor;
	}
	/**
	 * @return the estado
	 */
	public int getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(int estado) {
		this.estado = estado;
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
	 * @return the apellido_paterno
	 */
	public String getApellido_paterno() {
		return apellido_paterno;
	}
	/**
	 * @param apellido_paterno the apellido_paterno to set
	 */
	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}
	/**
	 * @return the apellido_materno
	 */
	public String getApellido_materno() {
		return apellido_materno;
	}
	/**
	 * @param apellido_materno the apellido_materno to set
	 */
	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}
	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}
	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return the fecha_nacimiento
	 */
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	/**
	 * @param fecha_nacimiento the fecha_nacimiento to set
	 */
	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the tipo_usuario
	 */
	public int getTipo_usuario() {
		return tipo_usuario;
	}
	/**
	 * @param tipo_usuario the tipo_usuario to set
	 */
	public void setTipo_usuario(int tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}
	
}