package Controlador;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorCreacionObjeto;
import Model.Lista.InterfazListaFachada;
import Model.Objetos.Cancion;
import Model.Objetos.Genero;
import Model.Objetos.Lista;
import Model.Objetos.Usuario;
import Model.Usuario.InterfazFachadaUsuario;
import Vista.VentanaPrincipal;

public class ControlUsuario {
	
	//el controlador necesita el usuario actual para acceder a solo a sus listas
	Usuario usuarioActual = null;
	InterfazFachadaUsuario fUsuario;
	VentanaPrincipal ventanaPrincipal;
	
	public ControlLista() {
		
	}
	
	public void borrar(Usuario usuario) {
		
	}
	
	public void salir(Usuario usuario) {
		
	}
	
	public void registro(String id, String nombre, String pass) {
		
	}
	
	public void modificar(Usuario usuario, String nombre, String pass) {
		
	}
	
	public Usuario ingreso(String id, String pass) {
		
	}
}
