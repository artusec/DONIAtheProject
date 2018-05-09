package Excepciones;

/**
 * Esta clase es para los errores en el guardado de objetos en la DB
 * 
 * @author borja
 */
public class ErrorGuardado extends Exception {

	private static final long serialVersionUID = 1L;

	private static String defaultError = "Error al guardar datos";
	
    public ErrorGuardado() {
        super(ErrorGuardado.defaultError);
    }

    public ErrorGuardado(String message) {
        super(message);
    }

    public ErrorGuardado(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorGuardado(Throwable cause) {
        super(cause);
    }
}
