package Excepciones;

/**
 * Esta clase es para los errores en la eliminacion de objetos de la DB
 * 
 * @author borja
 */
public class ErrorEliminacion extends Exception {

	private static final long serialVersionUID = 1L;

	private static String defaultError = "Error al eliminar datos";
	
    public ErrorEliminacion() {
        super(ErrorEliminacion.defaultError);
    }

    public ErrorEliminacion(String message) {
        super(message);
    }

    public ErrorEliminacion(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorEliminacion(Throwable cause) {
        super(cause);
    }
}
