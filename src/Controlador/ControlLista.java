package Controlador;

import java.util.ArrayList;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Lista.InterfazFachadaLista;
import Model.Lista.ListaFachada;
import Model.Objetos.Cancion;
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
	
	public void crearLista(Lista lista) {
	    	try {
	    		fLista.crearLista(lista, usuarioActual);
	    		VentanaPrincipal.actualizaListas();
	    	} catch (ErrorAutenticacion | ErrorCreacionObjeto | ErrorGuardado e) {
	    		VentanaPrincipal.muestraError(e);
	    	}
    }

    public void crearListaAuto(ListaAuto listaAuto, int duracion) {
    		try {
    			fLista.crearListaAuto(listaAuto, usuarioActual, duracion);
    			VentanaPrincipal.actualizaListas();
		} catch (ErrorAutenticacion | ErrorCreacionObjeto | ErrorConsulta | ErrorGuardado e) {
			VentanaPrincipal.muestraError(e);
		}
    }

	public Lista consulta(String idLista) {
    		try {
			return fLista.consulta(idLista);
		} catch (ErrorCreacionObjeto | ErrorConsulta e) {
			VentanaPrincipal.muestraError(e);
		}
    		return null;
	}

	public void eliminar(Lista lista) {
		try {
			fLista.eliminar(lista, usuarioActual);
		} catch (ErrorAutenticacion | ErrorEliminacion e) {
			VentanaPrincipal.muestraError(e);
		}
		VentanaPrincipal.actualizaListas();
	}

	public void modificar(Lista lista) {
		try {
			fLista.modificar(lista, usuarioActual);
			VentanaPrincipal.actualizaListas();
		} catch (ErrorAutenticacion | ErrorGuardado e) {
			VentanaPrincipal.muestraError(e);
		}		
	}

	public void anadirCancion(Cancion cancion, Lista lista) {
		try {
			fLista.anadirCancion(cancion, lista, usuarioActual);
			VentanaPrincipal.actualizaListas();
		} catch (ErrorAutenticacion | ErrorCreacionObjeto | ErrorConsulta | ErrorGuardado e) {
			VentanaPrincipal.muestraError(e);
		}
	}

	public void eliminarCancion(Cancion cancion, Lista lista) {
		try {
			fLista.eliminarCancion(cancion, lista, usuarioActual);
			VentanaPrincipal.actualizaListas();
		} catch (ErrorAutenticacion | ErrorCreacionObjeto | ErrorConsulta | ErrorGuardado e) {
			VentanaPrincipal.muestraError(e);
		}
	}
	
	public ArrayList<Lista> getListasUsuario() {
		try {
			return fLista.mostrar(usuarioActual);
		} catch (ErrorAutenticacion | ErrorConsulta | ErrorCreacionObjeto e) {
			VentanaPrincipal.muestraError(e);
		}
		return null;
	}
}
