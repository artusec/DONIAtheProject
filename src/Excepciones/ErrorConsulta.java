package Excepciones;

/**
 * Esta clase es para los errores en las consultas a la base de datos.

 */
public class ErrorConsulta extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructora que llama a la constructora de Exception.
	 */
	public ErrorConsulta() {
        super();
    }

    /**
     * Constructora que lanza un mensaje de error que pasa por parámetro.
     * @param message Mensaje de error que se verá en la vista.
     */
	public ErrorConsulta(String message) {
        super(message);
    }

    /**
     * Constructora que lanza un mensaje de error que pasa por parámetro y un throwable.
     * @param message Mensaje de error que se verá en la vista.
     * @param cause Throwable.
     */
	public ErrorConsulta(String message, Throwable cause) {
        super(message, cause);
    }

	 /**
     * Constructora con un throwable.
     * @param cause Throwable.
     */
    public ErrorConsulta(Throwable cause) {
        super(cause);
    }
}