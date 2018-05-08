package Controlador;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorCreacionObjeto;
import Model.Objetos.Usuario;
import Model.Usuario.InterfazFachadaUsuario;
import Vista.VentanaPrincipal;

public class ControlUsuario {
	
	//el controlador necesita el usuario actual para acceder a solo a sus listas
	Usuario usuarioActual = null;
	InterfazFachadaUsuario fUsuario;
	VentanaPrincipal ventanaPrincipal;
	
	public ControlUsuario(VentanaPrincipal ventanaPrincipal, InterfazFachadaUsuario fUsuario,
			Usuario usuarioActual) {
		this.setfUsuario(fUsuario);
		this.setUsuarioActual(usuarioActual);
		this.setVentanaPrincipal(ventanaPrincipal);
	}

	private void setfUsuario(InterfazFachadaUsuario fUsuario) {
		this.fUsuario = fUsuario;
	}

	private void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

	private void setUsuarioActual(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;
	}
	
	public Usuario getUsuario() {
		return this.usuarioActual;
	}
	
	public void borrar(Usuario usuario) {
		try {
			fUsuario.borrar(usuario);
		} catch (ErrorAutenticacion e) {
			ventanaPrincipal.muestraError(e);
		}
	}
	
	public void salir(Usuario usuario) {
		try {
			fUsuario.borrar(usuario);
		} catch (ErrorAutenticacion e) {
			ventanaPrincipal.muestraError(e);
		}
	}
	
	public void registro(String id, String nombre, String pass) {
		try {
			fUsuario.registro(id, nombre, pass);
		} catch (ErrorCreacionObjeto | ErrorAutenticacion e) {
			ventanaPrincipal.muestraError(e);
		}
	}
	
	public void modificar(Usuario usuario, String nombre, String pass) {
		try {
			fUsuario.modificar(usuario, nombre, pass);
		} catch (ErrorCreacionObjeto | ErrorAutenticacion e) {
			ventanaPrincipal.muestraError(e);
		}
	}
	
	public Usuario ingreso(String id, String pass) {
		try {
			return fUsuario.ingreso(id, pass);
		} catch (ErrorAutenticacion e) {
			ventanaPrincipal.muestraError(e);
		}
		return null;
	}
}
