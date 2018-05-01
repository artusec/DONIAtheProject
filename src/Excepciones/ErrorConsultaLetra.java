package Excepciones;

public class ErrorConsultaLetra extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ErrorConsultaLetra() {
        super();
    }

	public ErrorConsultaLetra(String message) {
        super(message);
    }

	public ErrorConsultaLetra(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorConsultaLetra(Throwable cause) {
        super(cause);
    }
}
