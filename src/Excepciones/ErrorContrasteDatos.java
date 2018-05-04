package Excepciones;

/**
 * Esta clase es para los errores al escribir algo en la base de datos que romperia
 * la consistencia
 * 
 * @author borja
 */
public class ErrorContrasteDatos extends Exception {

	private static final long serialVersionUID = 1L;
	
	private static String defaultError = "Error al guardar datos";

    public ErrorContrasteDatos() {
        super(ErrorContrasteDatos.defaultError);
    }

    public ErrorContrasteDatos(String message) {
        super(message);
    }

    public ErrorContrasteDatos(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorContrasteDatos(Throwable cause) {
        super(cause);
    }
}
