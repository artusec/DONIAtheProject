package Controlador;

import Excepciones.ErrorConsulta;
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
		fGenero.Anadir(genero, usuarioActual);
		VentanaPrincipal.actualizaGeneros();
	}
	
	public void Eliminar(Genero genero) {
		fGenero.Eliminar(genero, usuarioActual);
		VentanaPrincipal.actualizaGeneros();
	}

	public Genero Consultar(String idGenero) {
		try {
			return fGenero.Consultar(idGenero);
		} catch (ErrorConsulta e) {
			VentanaPrincipal.muestraError(e);
		}
		return null;
	}
}
