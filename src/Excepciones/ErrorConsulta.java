package Excepciones;

//porque hacemos esto tan concreto wero mio??!?!?!
public class ErrorConsulta extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ErrorConsulta() {
        super();
    }

	public ErrorConsulta(String message) {
        super(message);
    }

	public ErrorConsulta(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorConsulta(Throwable cause) {
        super(cause);
    }
}
