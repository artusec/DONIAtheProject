package Main;

import Excepciones.ErrorCreacionObjeto;
import Vista.VentanaPrincipal;

/**
 * Clase principal desde la cual se crea la ventana principal.
 */
public class Main {
	
	private static VentanaPrincipal vista;
	
	public static void main (String [] args) {
		
		try {
			iniciarGUI();
			
		} catch (Exception e) {
			System.out.println("Error al iniciar la ventana principal");
		}
	}

	private static void iniciarGUI() throws ErrorCreacionObjeto {
		
		 vista = new VentanaPrincipal();
	}
}