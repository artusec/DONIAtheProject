package Excepciones;

/**
 * Esta clase es para los errores en el guardado de objetos en la DB
 * 
 * @author borja
 */
public class ErrorGuardado extends Exception {

	private static final long serialVersionUID = 1L;

	private static String defaultError = "Error al guardar datos";
	
	/**
	 * Constructora que llama a Exception para lanzar un mensaje de error en el que ponfa "Error al guardar datos".
	 */
    public ErrorGuardado() {
        super(ErrorGuardado.defaultError);
    }

    /**
     * Constructora que lanza un mensaje de error que pasa por parámetro.
     * @param message Mensaje de error que se verá en la vista.
     */
    public ErrorGuardado(String message) {
        super(message);
    }

    /**
     * Constructora que lanza un mensaje de error que pasa por parámetro y un throwable.
     * @param message Mensaje de error que se verá en la vista.
     * @param cause Throwable.
     */
    public ErrorGuardado(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructora con un throwable.
     * @param cause Throwable.
     */
    public ErrorGuardado(Throwable cause) {
        super(cause);
    }
}
