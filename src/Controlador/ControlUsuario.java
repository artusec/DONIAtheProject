package Controlador;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.Usuario;
import Model.Usuario.InterfazFachadaUsuario;
import Vista.VentanaPrincipal;

public class ControlUsuario {
	
	//el controlador necesita el usuario actual para acceder a solo a sus listas
	Usuario usuarioActual = null;
	InterfazFachadaUsuario fUsuario;
	
	public ControlUsuario(Usuario usuarioActual) {
		this.setUsuarioActual(usuarioActual);
	}

	private void setUsuarioActual(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;
	}
	
	public Usuario getUsuario() {
		return this.usuarioActual;
	}
	
	public void borrar(Usuario usuario) {
		try {
			fUsuario.eliminar(usuario);
			VentanaPrincipal.actualizaUsuario();
		} catch (ErrorAutenticacion | ErrorEliminacion e) {
			VentanaPrincipal.muestraError(e);
		}
	}
	
	public void registro(Usuario usuario) {
		try {
			fUsuario.registro(usuario);
			VentanaPrincipal.actualizaUsuario();
		} catch (ErrorCreacionObjeto | ErrorAutenticacion | ErrorGuardado e) {
			VentanaPrincipal.muestraError(e);
		}
	}
	
	public void modificar(Usuario usuario) {
		try {
			fUsuario.modificar(usuario);
			VentanaPrincipal.actualizaUsuario();
		} catch (ErrorCreacionObjeto | ErrorAutenticacion | ErrorGuardado e) {
			VentanaPrincipal.muestraError(e);
		}
	}
	
	public Usuario ingreso(String id, String pass) {
		try {
			this.usuarioActual = fUsuario.ingreso(id, pass);
			return usuarioActual;
		} catch (ErrorAutenticacion e) {
			VentanaPrincipal.muestraError(e);
		}
		return null;
	}
}
