package Controlador;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Model.Lista.InterfazFachadaLista;
import Model.Lista.ListaFachada;
import Model.Objetos.Cancion;
import Model.Objetos.Genero;
import Model.Objetos.Lista;
import Model.Objetos.ListaAuto;
import Model.Objetos.Usuario;
import Vista.VentanaPrincipal;

public class ControlLista {

	//el controlador necesita el usuario actual para acceder a solo a sus listas
	Usuario usuarioActual = null;
	InterfazFachadaLista fLista;
	VentanaPrincipal ventanaPrincipal;

	public ControlLista(Usuario usuarioActual) {
		this.setfLista();
		this.setUsuarioActual(usuarioActual);
	}

	private void setfLista() {
		this.fLista = new ListaFachada();
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

    public void crearListaAuto(ListaAuto listaAuto, Genero genero, int duracion) {
    		try {
    			fLista.crearListaAuto(listaAuto, genero, usuarioActual, duracion);
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

	public void eliminar(Lista lista) {
		try {
			fLista.eliminar(lista, usuarioActual);
			VentanaPrincipal.actualizaListas();
		} catch (ErrorAutenticacion e) {
			VentanaPrincipal.muestraError(e);
		}
	}

	public void modificar(Lista lista) {
		try {
			fLista.modificar(lista, usuarioActual);
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
			VentanaPrincipal.muestraError(e);
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
