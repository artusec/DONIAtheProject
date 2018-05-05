package Main;

import Vista.VentanaPrincipal;

public class Main {
	
	public static void main (String [] args) {
		iniciar();
	}
	
	private static void iniciar(){	
		try {
			new VentanaPrincipal();
		}
		catch (Exception e) { // Aqui se pondran todos los posibles errores al iniciar
			e.printStackTrace();
		}
	}

}
