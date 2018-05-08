package Main;

import Controlador.Controlador;
import Vista.VentanaPrincipal;

public class Main {
	
	public static void main (String [] args) {
		iniciar();
	}
	
	private static void iniciar(){
		Controlador controlador = new Controlador();
		try {
			new VentanaPrincipal(controlador);
		}
		catch (Exception e) { // Aqui se pondran todos los posibles errores al iniciar
			e.printStackTrace();
		}
	}

}
