package Main;

import Controlador.ControlCancion;
import Controlador.ControlGenero;
import Controlador.ControlLista;
import Controlador.ControlUsuario;
import Controlador.DAO.InterfazDAOFachada;
import Excepciones.ErrorCreacionObjeto;
import Model.Cancion.InterfazFachadaCancion;
import Model.Genero.InterfazFachadaGenero;
import Model.Lista.InterfazFachadaLista;
import Model.Usuario.InterfazFachadaUsuario;
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

		iniciarControladores();
		try {
			iniciarGUI();
		} catch (ErrorCreacionObjeto e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void iniciarControladores() {
		
		controlCancion = new ControlCancion(null);
		controlGenero = new ControlGenero(null);
		controlLista = new ControlLista(null);
		controlUsuario = new ControlUsuario(null);
	}

	private static void iniciarGUI() throws ErrorCreacionObjeto
	{	 

		 vista = new VentanaPrincipal();	

	}

}
