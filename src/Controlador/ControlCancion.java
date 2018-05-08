package Controlador;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorCreacionObjeto;
import Model.Cancion.InterfazSASCancion;
import Model.Objetos.Cancion;
import Model.Objetos.Genero;
import Model.Objetos.Letra;
import Model.Objetos.Usuario;
import Model.Objetos.Video;
import Vista.VentanaPrincipal;

public class ControlCancion {
	
	//el controlador necesita el usuario actual para acceder a solo a sus listas
	Usuario usuarioActual = null;
	InterfazSASCancion fCancion;
	VentanaPrincipal ventanaPrincipal;

	public ControlCancion() {
		
	}

	public void setUsuarioActual(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;
	}
	
	public void creaCancion(String titulo, String autor, String album, int duracion,
			Genero genero, Letra letra, Video video) {
		if (this.usuarioActual.getId() == "u0") {
			//si es administrador puede hacer esto
			try {
				fCancion.creaCancion(titulo, autor, album, duracion, letra, video, genero);
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
		fCancion.consultaVideo(cancion);
	}
	
	public void consultaLetra(String cancion) {
		fCancion.consultaLetra(cancion);
	}
	
	public void consultaCancion(String cancion) {
		fCancion.consultaCancion(cancion);
	}
	
	public void descargaVideo(String cancion) {
		fCancion.descargaVideo(cancion);
	}
}
