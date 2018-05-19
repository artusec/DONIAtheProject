package Excepciones;

/**
 * Esta clase es para los errores en la eliminacion de objetos de la DB
 * 
 * @author borja
 */
public class ErrorEliminacion extends Exception {

	private static final long serialVersionUID = 1L;

	private static String defaultError = "Error al eliminar datos";
	
	/**
	 * Constructora que llama a Exception para lanzar un mensaje de error en el que ponfa "Error al eliminar datos".
	 */
    public ErrorEliminacion() {
        super(ErrorEliminacion.defaultError);
    }

    /**
     * Constructora que lanza un mensaje de error que pasa por parámetro.
     * @param message Mensaje de error que se verá en la vista.
     */
    public ErrorEliminacion(String message) {
        super(message);
    }

    /**
     * Constructora que lanza un mensaje de error que pasa por parámetro y un throwable.
     * @param message Mensaje de error que se verá en la vista.
     * @param cause Throwable.
     */
    public ErrorEliminacion(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructora con un throwable.
     * @param cause Throwable.
     */
    public ErrorEliminacion(Throwable cause) {
        super(cause);
    }
}
