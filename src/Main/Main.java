package Main;

import Excepciones.ErrorCreacionObjeto;
import Vista.VentanaPrincipal;

/**
 * Clase principal desde la cual se crea la ventana principal.
 */
public class Main {
	
	private static VentanaPrincipal vista;
	
	/**
	 * Función main con la que empieza el programa.
	 * @param args Argumentos.
	 */
	public static void main (String [] args) {
		iniciarGUI();
	}

	/**
	 * Método que inicia la vista.
	 */
	private static void iniciarGUI() {
		 vista = new VentanaPrincipal();
	}
}