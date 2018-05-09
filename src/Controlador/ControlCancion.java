package Controlador;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Model.Cancion.FachadaCancion;
import Model.Cancion.InterfazFachadaCancion;
import Model.Objetos.Cancion;
import Model.Objetos.Genero;
import Model.Objetos.Letra;
import Model.Objetos.Usuario;
import Model.Objetos.Video;
import Vista.VentanaPrincipal;

public class ControlCancion {
	
	InterfazFachadaCancion fCancion;
	//el controlador necesita el usuario actual para acceder a solo a sus listas
	Usuario usuarioActual;

	public ControlCancion(Usuario usuarioActual) {
		this.setfCancion(fCancion);
		this.setUsuarioActual(usuarioActual);
	}
	
	private void setfCancion(InterfazFachadaCancion fCancion) {
		this.fCancion = new FachadaCancion();
	}

	private void setUsuarioActual(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;
	}
	
	public void creaCancion(Cancion cancion) {
		if (this.usuarioActual.getId() == "u0") {
			//si es administrador puede hacer esto
			try {
				fCancion.creaCancion(cancion);
				VentanaPrincipal.actualizaCanciones();
			} catch (ErrorCreacionObjeto e) {
				//notifica
				VentanaPrincipal.muestraError(e);
			}
		} else {
			//notifica
			VentanaPrincipal.muestraError(new ErrorAutenticacion());
		}
	}
	
	public void eliminaCancion(Cancion cancion) {
		if (this.usuarioActual.getId() == "u0") {
			//si es administrador puede hacer esto
			try {
				fCancion.eliminaCancion(cancion);
				VentanaPrincipal.actualizaCanciones();
			} catch (Exception e) {
				//notifica
				VentanaPrincipal.muestraError(e);
			}
		} else {
			//notifica
			VentanaPrincipal.muestraError(new ErrorAutenticacion());
		}
	}
	
	public Video consultaVideo(String cancion) {
		try {
			return fCancion.consultaVideo(cancion);
		} catch (ErrorConsulta e) {
			//notifica
			VentanaPrincipal.muestraError(e);
		}
	}
	
	public Letra consultaLetra(String cancion) {
		try {
			return fCancion.consultaLetra(cancion);
		} catch (ErrorConsulta e) {
			//notifica
			VentanaPrincipal.muestraError(e);
		}
	}
	
	public Cancion consultaCancion(String cancion) {
		try {
			return fCancion.consultaCancion(cancion);
		} catch (ErrorConsulta e) {
			//notifica
			VentanaPrincipal.muestraError(e);
		}
	}
	
	public String descargaVideo(String cancion) {
		try {
			return fCancion.descargaVideo(cancion);
		} catch (ErrorConsulta e) {
			//notifica
			VentanaPrincipal.muestraError(e);
		}
	}
}
