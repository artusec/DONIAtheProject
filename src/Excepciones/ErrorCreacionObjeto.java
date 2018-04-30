package Excepciones;

/**
 * Esta clase es para los errores en la creacion de objetos
 * 
 * @author borja
 */
public class ErrorCreacionObjeto extends Exception {

	private static final long serialVersionUID = 1L;

    public ErrorCreacionObjeto() {
        super();
    }

    public ErrorCreacionObjeto(String message) {
        super(message);
    }

    public ErrorCreacionObjeto(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorCreacionObjeto(Throwable cause) {
        super(cause);
    }
}
