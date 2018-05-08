package Controlador;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorCreacionObjeto;
import Model.Cancion.InterfazSASCancion;
import Model.Lista.InterfazListaFachada;
import Model.Objetos.Cancion;
import Model.Objetos.Genero;
import Model.Objetos.Letra;
import Model.Objetos.Lista;
import Model.Objetos.Usuario;
import Model.Objetos.Video;
import Vista.VentanaPrincipal;

public class ControlLista {

	//el controlador necesita el usuario actual para acceder a solo a sus listas
	Usuario usuarioActual = null;
	InterfazListaFachada fLista;
	VentanaPrincipal ventanaPrincipal;

	public ControlLista() {
		
	}

	public void setUsuarioActual(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;
	}
	
	public void crearLista(String nombre) {
	    	try {
	    		fLista.crearLista(nombre, usuarioActual);
	    	} catch (ErrorAutenticacion | ErrorCreacionObjeto e) {
	    		ventanaPrincipal.muestraError(e);
	    	}
    }

    public void crearListaAuto(String nombre, Genero genero) {
    	try {
	    		fLista.crearListaAuto(nombre, genero, usuarioActual);
		} catch (ErrorAutenticacion | ErrorCreacionObjeto e) {
			ventanaPrincipal.muestraError(e);
		}
    }

	public Lista consulta(String idLista) {
    		return fLista.consulta(idLista);		
	}

	public void borrar(Lista lista) {
		fLista.borrar(lista);
	}

	public void modificar(String nombre, Lista lista) {
		try {
			fLista.modificar(nombre, lista);
		} catch (ErrorAutenticacion e) {
			ventanaPrincipal.muestraError(e);
		}		
	}

	public void anadirCancion(Cancion cancion, Lista lista) {
		try {
			fLista.anadirCancion(cancion, lista, usuarioActual);
		} catch (ErrorAutenticacion | ErrorCreacionObjeto e) {
			ventanaPrincipal.muestraError(e);
		}
	}

	public void eliminarCancion(Cancion cancion, Lista lista) {
		try {
			fLista.eliminarCancion(cancion, lista, usuarioActual);
		} catch (ErrorAutenticacion | ErrorCreacionObjeto e) {
			ventanaPrincipal.muestraError(e);
		}
	}
}
