package Main;

import Excepciones.ErrorCreacionObjeto;
import Vista.VentanaPrincipal;

public class Main {
	
	// VISTA
	private static VentanaPrincipal vista;
	
	public static void main (String [] args) {
		
		try {
			iniciarGUI();
			
		} catch (Exception e) {
			System.out.println("imposible arrancar esto");
			e.printStackTrace();
		}
	}

	private static void iniciarGUI() throws ErrorCreacionObjeto {
		
		 vista = new VentanaPrincipal();
	}
}