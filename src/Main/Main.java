package Main;

import Controlador.ControlCancion;
import Controlador.ControlGenero;
import Controlador.ControlLista;
import Controlador.ControlUsuario;
import Controlador.DAO.InterfazDAOFachada;
import Model.Cancion.InterfazFachadaCancion;
import Model.Genero.InterfazFachadaGenero;
import Model.Lista.InterfazListaFachada;
import Model.Usuario.InterfazFachadaUsuario;
import Vista.VentanaPrincipal;

public class Main {
	
	// CONTROL
	private static ControlCancion controlCancion;
	private static ControlGenero controlGenero;
	private static ControlLista controlLista;
	private static ControlUsuario controlUsuario;
	
	// VISTA
	private static VentanaPrincipal vista;
	
	// MODELO
	// private static InterfazFachadaLista fLista;
	private static InterfazFachadaCancion fCancion;
	private static InterfazFachadaGenero fGenero;
	private static InterfazFachadaUsuario fUsuario;
	
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
		// vista = new VentanaPrincipal();	
	}

}
