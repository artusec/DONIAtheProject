package Controlador;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.Usuario;
import Model.Usuario.FachadaUsuario;
import Model.Usuario.InterfazFachadaUsuario;
import Vista.VentanaPrincipal;

/**
 * Clase ControlUsuario, permite la interacción entre la interfaz gráfica y el subsistema usuario.
 */
public class ControlUsuario {
	
	//El controlador necesita el usuario actual para acceder a su informacion
	Usuario usuarioActual;
	//Fachada del subsistema
	InterfazFachadaUsuario fUsuario;
	
	/**
	 * Crea el controlador.
	 * @param usuarioActual el usuario actual
	 */
	public ControlUsuario(Usuario usuarioActual) {
		this.setUsuarioActual(usuarioActual);
		fUsuario = new FachadaUsuario();
	}
	
	/**
	 * Establece el usuario actual.
	 * @param usuarioActual El usuario a establecer.
	 */
	private void setUsuarioActual(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;
	}
	
	/**
	 * Solicita al subsistema usuario la eliminación de un usuaro.
	 * Si hay error, lo notifica a la interfaz gráfica.
	 * @param usuario El usuario a eliminar.
	 */
	public void borrar(Usuario usuario) {
		try {
			fUsuario.eliminar(usuario);
			VentanaPrincipal.actualizaUsuario();
		} catch (ErrorAutenticacion | ErrorEliminacion e) {
			VentanaPrincipal.muestraError(e);
		}
	}
	
	/**
	 * Solicita al subsistema usuario el guardado de un usuario.
	 * Si hay error, lo notifica a la interfaz gráfica.
	 * @param usuario El usuario a guardar.
	 */
	public void registro(Usuario usuario) {
		try {
			fUsuario.registro(usuario);
			VentanaPrincipal.actualizaUsuario();
		} catch (ErrorCreacionObjeto | ErrorAutenticacion | ErrorGuardado e) {
			VentanaPrincipal.muestraError(e);
		}
	}
	
	/**
	 * Solicita al subsistema usuario la modificación de un usuario.
	 * Si hay error, lo notifica a la interfaz gráfica.
	 * @param usuario El usuario a modificar.
	 */
	public void modificar(Usuario usuario) {
		try {
			fUsuario.modificar(usuario);
			VentanaPrincipal.actualizaUsuario();
		} catch (ErrorCreacionObjeto | ErrorAutenticacion | ErrorGuardado e) {
			VentanaPrincipal.muestraError(e);
		}
	}
	
	/**
	 * Solicita al subsistema usuario el inicio de sesión de un usuario.
	 * @param id El identificador del usuario.
	 * @param pass La clave del usuario.
	 * @return Si el inicio de sesión ha sido correcto, el usuario actual;
	 * 			si no, null.
	 */
	public Usuario ingreso(String id, String pass) {
		try {
			this.usuarioActual = fUsuario.ingreso(id, pass);
			return usuarioActual;
		} catch (ErrorAutenticacion | ErrorConsulta | ErrorCreacionObjeto e) {
			VentanaPrincipal.muestraError(e);
		}
		return null;
	}
}
