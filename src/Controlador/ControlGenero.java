package Controlador;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Genero.FachadaGenero;
import Model.Genero.InterfazFachadaGenero;
import Model.Objetos.Genero;
import Model.Objetos.Usuario;
import Vista.VentanaPrincipal;

/**
 * Clase ControlGenero, permite la interacción entre la interfaz gráfica y el subsistema género.
 */
public class ControlGenero {
	
	//Fachada del subsistema
	private InterfazFachadaGenero fGenero;
	//Usuario actual
	private Usuario usuarioActual;
	
	/**
	 * Construye el controlador.
	 * @param usuarioActual el usuario actual
	 */
	public ControlGenero(Usuario usuarioActual) {
		this.setfGenero();
		this.setUsuarioActual(usuarioActual);
	}
	
	/**
	 * Establece la fachada del subsistema a conectar.
	 */
	private void setfGenero() {
		this.fGenero = new FachadaGenero();
	}
	
	/**
	 * Establece el usuario actual.
	 * @param usuarioActual El usuario a establecer.
	 */
	private void setUsuarioActual(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;
	}
	
	/**
	 * Solicita al subsistema género el guardado de un género, además lo asocia al usuario solicitante.
	 * Si hay error, lo notifica a la interfaz gráfica.
	 * @param genero El género a guardar.
	 */
	public void Anadir(Genero genero) {
		try {
			fGenero.Anadir(genero, usuarioActual);
		} catch (ErrorAutenticacion | ErrorGuardado e) {
			VentanaPrincipal.muestraError(e);
		}
		VentanaPrincipal.actualizaGeneros();
	}
	
	/**
	 * Solicita al subsistema género la desvinculacion del género indicado al usuario actual.
	 * Si hay error, lo notifica a la interfaz gráfica.
	 * @param genero El género a eliminar.
	 */
	public void Eliminar(Genero genero) {
		try {
			fGenero.Eliminar(genero, usuarioActual);
		} catch (ErrorEliminacion | ErrorAutenticacion e) {
			VentanaPrincipal.muestraError(e);
		}
		VentanaPrincipal.actualizaGeneros();
	}


	/**
	 * Solicita al subsistema género la informacion de un género.
	 * Si hay error, lo notifica a la interfaz gráfica.
	 * @param idGenero Identificador del género a consulatr.
	 * @return Género que se consulta a la base de datos.
	 */
	public Genero Consultar(String idGenero) {
		try {
			return fGenero.Consultar(idGenero);
		} catch (ErrorConsulta | ErrorCreacionObjeto e) {
			VentanaPrincipal.muestraError(e);
		}
		return null;
	}
}
