package Controlador;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Model.Lista.InterfazListaFachada;
import Model.Lista.FachadaLista;
import Model.Objetos.Cancion;
import Model.Objetos.Genero;
import Model.Objetos.Lista;
import Model.Objetos.Usuario;
import Vista.VentanaPrincipal;

public class ControlLista {

	//el controlador necesita el usuario actual para acceder a solo a sus listas
	Usuario usuarioActual = null;
	InterfazListaFachada fLista;
	VentanaPrincipal ventanaPrincipal;

	public ControlLista(Usuario usuarioActual) {
		this.setfLista();
		this.setUsuarioActual(usuarioActual);
	}

	private void setfLista() {
		this.fLista = new FachadaLista();
	}

	private void setUsuarioActual(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;
	}
	
	public void crearLista(String nombre) {
	    	try {
	    		fLista.crearLista(nombre, usuarioActual);
	    		VentanaPrincipal.actualizaListas();
	    	} catch (ErrorAutenticacion | ErrorCreacionObjeto e) {
	    		VentanaPrincipal.muestraError(e);
	    	}
    }

    public void crearListaAuto(String nombre, Genero genero, int duracion) {
    		try {
    			fLista.crearListaAuto(nombre, genero, usuarioActual, duracion);
    			VentanaPrincipal.actualizaListas();
		} catch (ErrorAutenticacion | ErrorCreacionObjeto e) {
			VentanaPrincipal.muestraError(e);
		}
    }

	public Lista consulta(String idLista) {
    		try {
			return fLista.consulta(idLista);
		} catch (ErrorConsulta e) {
			VentanaPrincipal.muestraError(e);
		}
    		return null;
	}

	public void borrar(Lista lista) {
		try {
			fLista.borrar(lista, usuarioActual);
			VentanaPrincipal.actualizaListas();
		} catch (ErrorAutenticacion e) {
			VentanaPrincipal.muestraError(e);
		}
	}

	public void modificar(String nombre, Lista lista) {
		try {
			fLista.modificar(nombre, lista, usuarioActual);
			VentanaPrincipal.actualizaListas();
		} catch (ErrorAutenticacion e) {
			VentanaPrincipal.muestraError(e);
		}		
	}

	public void anadirCancion(Cancion cancion, Lista lista) {
		try {
			fLista.anadirCancion(cancion, lista, usuarioActual);
			VentanaPrincipal.actualizaListas();
		} catch (ErrorAutenticacion e) {
			ventanaPrincipal.muestraError(e);
		}
	}

	public void eliminarCancion(Cancion cancion, Lista lista) {
		try {
			fLista.eliminarCancion(cancion, lista, usuarioActual);
			VentanaPrincipal.actualizaListas();
		} catch (ErrorAutenticacion e) {
			VentanaPrincipal.muestraError(e);
		}
	}
}
