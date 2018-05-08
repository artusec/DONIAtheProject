package Controlador;

import Excepciones.ErrorConsulta;
import Model.Cancion.InterfazSASCancion;
import Model.Genero.InterfazFachadaGenero;
import Model.Objetos.Genero;
import Model.Objetos.Usuario;
import Vista.VentanaPrincipal;

//TODO: revisar mucho el fuckin sas loko

public class ControlGenero {

	InterfazFachadaGenero fGenero;
	VentanaPrincipal ventanaPrincipal;
	Usuario usuarioActual;

	public ControlGenero(VentanaPrincipal ventanaPrincipal, InterfazFachadaGenero fGenero,
						Usuario usuarioActual) {
		this.setfGenero(fGenero);
		this.setUsuarioActual(usuarioActual);
		this.setVentanaPrincipal(ventanaPrincipal);
	}
	
	private void setfGenero(InterfazFachadaGenero fGenero) {
		this.fGenero = fGenero;
	}

	private void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

	private void setUsuarioActual(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;
	}
	
	public void Anadir(Genero genero) {
		fGenero.Anadir(genero, usuarioActual);
	}
	
	public void Eliminar(Genero genero) {
		fGenero.Eliminar(genero, usuarioActual);
	}

	public Genero Consultar(String idGenero) {
		try {
			return fGenero.Consultar(idGenero);
		} catch (ErrorConsulta e) {
			ventanaPrincipal.muestraError(e);
		}
		return null;
	}
}
