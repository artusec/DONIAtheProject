package Controlador;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Model.Cancion.InterfazFachadaCancion;
import Model.Objetos.Cancion;
import Model.Objetos.Genero;
import Model.Objetos.Letra;
import Model.Objetos.Usuario;
import Model.Objetos.Video;
import Vista.VentanaPrincipal;

public class ControlCancion {
	
	InterfazFachadaCancion fCancion;
	VentanaPrincipal ventanaPrincipal;
	//el controlador necesita el usuario actual para acceder a solo a sus listas
	Usuario usuarioActual;

	public ControlCancion(VentanaPrincipal ventanaPrincipal, InterfazFachadaCancion fCancion,
							Usuario usuarioActual) {
		this.setfCancion(fCancion);
		this.setUsuarioActual(usuarioActual);
		this.setVentanaPrincipal(ventanaPrincipal);
	}
	
	private void setfCancion(InterfazFachadaCancion fCancion) {
		this.fCancion = fCancion;
	}

	private void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

	private void setUsuarioActual(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;
	}
	
	public void creaCancion(String titulo, String autor, String album, int duracion,
			Genero genero, Letra letra, Video video) {
		if (this.usuarioActual.getId() == "u0") {
			//si es administrador puede hacer esto
			try {
				fCancion.creaCancion(titulo, autor, album, duracion, genero, letra, video);
			} catch (ErrorCreacionObjeto e) {
				//notifica
				ventanaPrincipal.muestraError(e);
			}
		} else {
			//notifica
			ventanaPrincipal.muestraError(new ErrorAutenticacion());
		}
	}
	
	public void eliminaCancion(Cancion cancion) {
		if (this.usuarioActual.getId() == "u0") {
			//si es administrador puede hacer esto
			try {
				fCancion.eliminaCancion(cancion);
			} catch (Exception e) {
				//notifica
				ventanaPrincipal.muestraError(e);
			}
		} else {
			//notifica
			ventanaPrincipal.muestraError(new ErrorAutenticacion());
		}
	}
	
	public void consultaVideo(String cancion) {
		try {
			fCancion.consultaVideo(cancion);
		} catch (ErrorConsulta e) {
			//notifica
			ventanaPrincipal.muestraError(e);
		}
	}
	
	public void consultaLetra(String cancion) {
		try {
			fCancion.consultaLetra(cancion);
		} catch (ErrorConsulta e) {
			//notifica
			ventanaPrincipal.muestraError(e);
		}
	}
	
	public void consultaCancion(String cancion) {
		try {
			fCancion.consultaCancion(cancion);
		} catch (ErrorConsulta e) {
			//notifica
			ventanaPrincipal.muestraError(e);
		}
	}
	
	public void descargaVideo(String cancion) {
		try {
			fCancion.descargaVideo(cancion);
		} catch (ErrorConsulta e) {
			//notifica
			ventanaPrincipal.muestraError(e);
		}
	}
}
