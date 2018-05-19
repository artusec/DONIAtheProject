package Excepciones;

/**
 * Esta clase es para los errores en la autenticacion de usuarios
 * 
 * @author borja
 */
public class ErrorAutenticacion extends Exception {

	private static final long serialVersionUID = 1L;
	
	private static String defaultError = "La autenticación del usuario ha fallado!";

	/**
	 * Constructora que llama a Exception para lanzar un mensaje de error en el que ponfa "La autenticación del usuario ha fallado!".
	 */
    public ErrorAutenticacion() {
        super(ErrorAutenticacion.defaultError);
    }

    /**
     * Constructora que lanza un mensaje de error que pasa por parámetro.
     * @param message Mensaje de error que se verá en la vista.
     */
    public ErrorAutenticacion(String message) {
        super(message);
    }

    /**
     * Constructora que lanza un mensaje de error que pasa por parámetro y un throwable.
     * @param message Mensaje de error que se verá en la vista.
     * @param cause Throwable.
     */
    public ErrorAutenticacion(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructora con un throwable.
     * @param cause Throwable.
     */
    public ErrorAutenticacion(Throwable cause) {
        super(cause);
    }
}
