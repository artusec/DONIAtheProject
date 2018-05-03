package Excepciones;

/**
 * Esta clase es para los errores en la autenticacion de usuarios
 * 
 * @author borja
 */
public class ErrorAutenticacion extends Exception {

	private static final long serialVersionUID = 1L;
	
	private static String defaultError = "La autenticacion del usuario ha fallado!";

    public ErrorAutenticacion() {
        super(ErrorAutenticacion.defaultError);
    }

    public ErrorAutenticacion(String message) {
        super(message);
    }

    public ErrorAutenticacion(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorAutenticacion(Throwable cause) {
        super(cause);
    }
}
