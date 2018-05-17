package Controlador;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorGuardado;
import Model.Cancion.FachadaCancion;
import Model.Cancion.InterfazFachadaCancion;
import Model.Objetos.Cancion;
import Model.Objetos.Letra;
import Model.Objetos.Usuario;
import Model.Objetos.Video;
import Vista.VentanaPrincipal;

/**
 * Clase ControlCancion, permite la interacción entre la interfaz gráfica y el subsistema canción.
 */
public class ControlCancion {
	
	//Fachada 
	InterfazFachadaCancion fCancion;
	//El controlador necesita el usuario actual para acceder a solo a sus listas
	Usuario usuarioActual;

	/**
	 * Crea el controlador.
	 * @param usuarioActual el usuario actual
	 */
	public ControlCancion(Usuario usuarioActual) {
		this.setfCancion();
		this.setUsuarioActual(usuarioActual);
	}
	
	/**
	 * Establece la fachada del subsistema a conectar.
	 * @param fCancion
	 */
	private void setfCancion() {
		this.fCancion = new FachadaCancion();
	}

	/**
	 * Establece el usuario actual.
	 * @param usuarioActual El usuario a establecer.
	 */
	private void setUsuarioActual(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;
	}
	
	/**
	 * Solicita al subsistema canción el guardado de una canción (solo funciona si el usuario es administrador).
	 * Si hay error, lo notifica a la interfaz gráfica.
	 * @param cancion La canción a guardar.
	 */
	public void creaCancion(Cancion cancion) {
		if (this.usuarioActual != null && this.usuarioActual.getId().equals("u0")) {
			//si es administrador puede hacer esto
			try {
				fCancion.creaCancion(cancion);
				VentanaPrincipal.actualizaCanciones("l0");
			} catch (ErrorCreacionObjeto | ErrorGuardado e) {
				//notifica
				VentanaPrincipal.muestraError(e);
			}
		} else {
			//notifica
			VentanaPrincipal.muestraError(new ErrorAutenticacion("Debes iniciar sesion como administrador"));
		}
	}
	
	/**
	 * Solicita al subsistema canción la eliminación de una canción (solo funciona si el usuario es administrador).
	 * Si hay error, lo notifica a la interfaz gráfica.
	 * @param cancion La canción a eliminar.
	 */
	public void eliminaCancion(Cancion cancion) {
		if (this.usuarioActual.getId().equals("u0")) {
			//si es administrador puede hacer esto
			try {
				fCancion.eliminaCancion(cancion);
				VentanaPrincipal.actualizaCanciones("l0");
			} catch (Exception e) {
				//notifica
				VentanaPrincipal.muestraError(e);
			}
		} else {
			//notifica
			VentanaPrincipal.muestraError(new ErrorAutenticacion());
		}
	}
	
	/**
	 * Solicita al subsistema canción la informacion del vídeo de una canción.
	 * Si hay error, lo notifica a la interfaz gráfica.
	 * @param cancion El identificador de la canción de la cual se quiere obtener el vídeo.
	 */
	public Video consultaVideo(String cancion) {
		try {
			return fCancion.consultaVideo(cancion);
		} catch (ErrorConsulta | ErrorCreacionObjeto e) {
			//notifica
			VentanaPrincipal.muestraError(e);
		}
		return null;
	}
	
	/**
	 * Solicita al subsistema canción la informacion la letra de una canción.
	 * Si hay error, lo notifica a la interfaz gráfica.
	 * @param cancion El identificador de la canción de la cual se quiere obtener la letra.
	 * @return La letra obtenida.
	 */
	public Letra consultaLetra(String cancion) {
		try {
			return fCancion.consultaLetra(cancion);
		} catch (ErrorConsulta | ErrorCreacionObjeto e) {
			//notifica
			VentanaPrincipal.muestraError(e);
		}
		return null;
	}
	
	/**
	 * Solicita al subsistema canción la informacion de una canción.
	 * Si hay error, lo notifica a la interfaz gráfica.
	 * @param cancion El identificador de la canción de la cual se quieren obtener los datos.
	 */
	public Cancion consultaCancion(String cancion) {
		try {
			return fCancion.consultaCancion(cancion);
		} catch (ErrorConsulta | ErrorCreacionObjeto e) {
			//notifica
			VentanaPrincipal.muestraError(e);
		}
		return null;
	}
}
