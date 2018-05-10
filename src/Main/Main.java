package Main;

import Controlador.ControlCancion;
import Controlador.ControlGenero;
import Controlador.ControlLista;
import Controlador.ControlUsuario;
import Controlador.DAO.InterfazDAOFachada;
import Vista.VentanaPrincipal;

public class Main {
	
	// CONTROL esto lo deberia vcrear la vista, se lo que hablamos arturo, pero me lo dijo pablo rabanal
	private static ControlCancion controlCancion;
	private static ControlGenero controlGenero;
	private static ControlLista controlLista;
	private static ControlUsuario controlUsuario;
	
	// VISTA
	private static VentanaPrincipal vista;

	
	// DAO
	private static InterfazDAOFachada fDao;

	
	
	
	public static void main (String [] args) {
		iniciarGUI();
		iniciarControladores();
	}
	
	private static void iniciarControladores() {
		
		/*controlCacion = new ControlCancion();
		controlGenero = new ControlGenero();
		controlLista = new ControlLista();
		controlUsuario = new ControlUsuario();*/
	}

	private static void iniciarGUI()
	{	 
		vista = new VentanaPrincipal();	
	}

}
