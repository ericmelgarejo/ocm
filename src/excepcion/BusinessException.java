package excepcion;

public class BusinessException extends Exception {
	
	/** id de excepcion **/
	private String idException;
	
	/**mensaje de la excepcion**/
	private String message;
	
	public String getIdException() {
		return idException;
	}

	public void setIdException(String idException) {
		this.idException = idException;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
