package Excepciones;

/**
 * Esta clase es para los errores en la creacion de objetos
 * 
 * @author borja
 */
public class ErrorCreacionObjeto extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructora que llama a la constructora de Exception.
	 */
    public ErrorCreacionObjeto() {
        super();
    }

    /**
     * Constructora que lanza un mensaje de error que pasa por parámetro.
     * @param message Mensaje de error que se verá en la vista.
     */
    public ErrorCreacionObjeto(String message) {
        super(message);
    }

    /**
     * Constructora que lanza un mensaje de error que pasa por parámetro y un throwable.
     * @param message Mensaje de error que se verá en la vista.
     * @param cause Throwable.
     */
    public ErrorCreacionObjeto(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructora con un throwable.
     * @param cause Throwable.
     */
    public ErrorCreacionObjeto(Throwable cause) {
        super(cause);
    }
}
