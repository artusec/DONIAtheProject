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

public class ControlGenero {

	InterfazFachadaGenero fGenero;
	Usuario usuarioActual;

	public ControlGenero(Usuario usuarioActual) {
		this.setfGenero();
		this.setUsuarioActual(usuarioActual);
	}
	
	private void setfGenero() {
		this.fGenero = new FachadaGenero();
	}

	private void setUsuarioActual(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;
	}
	
	public void Anadir(Genero genero) {
		try {
			fGenero.Anadir(genero, usuarioActual);
		} catch (ErrorAutenticacion | ErrorGuardado e) {
			VentanaPrincipal.muestraError(e);
		}
		VentanaPrincipal.actualizaGeneros();
	}
	
	public void Eliminar(Genero genero) {
		try {
			fGenero.Eliminar(genero, usuarioActual);
		} catch (ErrorEliminacion | ErrorAutenticacion e) {
			VentanaPrincipal.muestraError(e);
		}
		VentanaPrincipal.actualizaGeneros();
	}

	public Genero Consultar(String idGenero) {
		try {
			return fGenero.Consultar(idGenero);
		} catch (ErrorConsulta | ErrorCreacionObjeto e) {
			VentanaPrincipal.muestraError(e);
		}
		return null;
	}
}
