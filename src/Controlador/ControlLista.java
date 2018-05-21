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

/**
 * Clase ControlLista, permite la interacción entre la interfaz gráfica y el subsistema lista.
 */
public class ControlLista {

	//Usuario actual
	Usuario usuarioActual;
	//Fachada del subsistema
	InterfazFachadaLista fLista;

	/**
	 * Construye el controlador.
	 * @param usuarioActual el usuario actual
	 */
	public ControlLista(Usuario usuarioActual) {
		this.setfLista();
		this.setUsuarioActual(usuarioActual);
	}

	/**
	 * Establece la fachada del subsistema a conectar.
	 */
	private void setfLista() {
		this.fLista = new ListaFachada();
	}

	/**
	 * Establece el usuario actual.
	 * @param usuarioActual El usuario a establecer.
	 */
	private void setUsuarioActual(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;
	}
	
	/**
	 * Solicita al subsistema lista el guardado de una lista, además la asocia al usuario solicitante.
	 * Si hay error, lo notifica a la interfaz gráfica.
	 * @param lista La lista a guardar.
	 */
	public void crearLista(Lista lista) {
	    	try {
	    		fLista.crearLista(lista, usuarioActual);
	    		VentanaPrincipal.actualizaListas();
	    	} catch (ErrorAutenticacion | ErrorCreacionObjeto | ErrorGuardado e) {
	    		VentanaPrincipal.muestraError(e);
	    	}
    }

	/**
	 * Solicita al subsistema lista la elaboración y guardado de una lista automática de una lista de reproducción
	 * basada en el género indicado, además la asocia al usuario solicitante.
	 * Si hay error, lo notifica a la interfaz gráfica.
	 * @param listaAuto Objeto ya creado que se actualizará con los datos correspondientes a la creación de la lista.
	 * @param duracion Duración máxima que se desea para la lista.
	 */
    public void crearListaAuto(ListaAuto listaAuto, double duracion) {
    		try {
    			fLista.crearListaAuto(listaAuto, usuarioActual, duracion);
    			VentanaPrincipal.actualizaListas();
		} catch (ErrorAutenticacion | ErrorCreacionObjeto | ErrorConsulta | ErrorGuardado e) {
			VentanaPrincipal.muestraError(e);
		} finally {
			VentanaPrincipal.actualizaListas();
		}
    }

    /**
     * Solicita al subsistema lista la información de la lista indicada.
     * Si hay error, lo notifica a la interfaz gráfica.
     * @param idLista El identificador de la lista a consultar.
     * @return La lista obtenida.
     */
	public Lista consulta(String idLista) {
    		try {
			return fLista.consulta(idLista);
		} catch (ErrorCreacionObjeto | ErrorConsulta e) {
			VentanaPrincipal.muestraError(e);
		}
    		return null;
	}

	/**
	 * Solicita al subsistema lista la eliminación de una lista de reproducción.
	 * Si la lista a borrar es la biblioteca, se impide la eliminación.
	 * Si hay error, lo notifica a la interfaz gráfica.
	 * @param lista Lista que de quiere eliminar.
	 */
	public void eliminar(Lista lista) {
		try {
			if (!lista.getId().equals("l0"))
				fLista.eliminar(lista, usuarioActual);
			else
				VentanaPrincipal.muestraError(new ErrorEliminacion("No borres la biblioteca locx!"));
		} catch (ErrorAutenticacion | ErrorEliminacion e) {
			VentanaPrincipal.muestraError(e);
		}
		VentanaPrincipal.actualizaListas();
		VentanaPrincipal.actualizaCanciones("l0");
	}
	
	/**
	 * Solicita al subsistema lista la modificación de una lista de reproducción.
	 * Si la lista a modificar es la biblioteca, se impide la modificación.
	 * Si hay error, lo notifica a la interfaz gráfica.
	 * @param lista Lista que se desea modificar.
	 */
	public void modificar(Lista lista) {
		try {
			if (!lista.getId().equals("l0"))
				fLista.modificar(lista, usuarioActual);
			else
				VentanaPrincipal.muestraError(new ErrorEliminacion("No toques la biblioteca!"));
		} catch (ErrorAutenticacion | ErrorGuardado e) {
			VentanaPrincipal.muestraError(e);
		}
		VentanaPrincipal.actualizaListas();
	}

	/**
	 * Solicita al subsistema lista la inserción de una canción en una lista de reproducción.
	 * Si la lista a modificar es la biblioteca, se impide la inserción.
	 * Si hay error, lo notifica a la interfaz gráfica.
	 * @param cancion La canción a insertar.
	 * @param lista La lista objetivo.
	 */
	public void anadirCancion(Cancion cancion, Lista lista) {
		try {
			if (!lista.getId().equals("l0"))
				fLista.anadirCancion(cancion, lista, usuarioActual);
			VentanaPrincipal.actualizaCanciones(lista.getId());
		} catch (ErrorAutenticacion | ErrorCreacionObjeto | ErrorConsulta | ErrorGuardado e) {
			VentanaPrincipal.muestraError(e);
		}
	}

	/**
	 * Solicita al subsistema lista la eliminación de una canción en una lista de reproducción.
	 * Si la lista a modificar es la biblioteca, se impide la eliminación.
	 * Si hay error, lo notifica a la interfaz gráfica.
	 * @param cancion La canción a eliminar.
	 * @param lista La lista objetivo.
	 */
	public void eliminarCancion(Cancion cancion, Lista lista) {
		try {
			if (!lista.getId().equals("l0"))
				fLista.eliminarCancion(cancion, lista, usuarioActual);
			VentanaPrincipal.actualizaListas();
		} catch (ErrorAutenticacion | ErrorCreacionObjeto | ErrorConsulta | ErrorGuardado e) {
			VentanaPrincipal.muestraError(e);
		}
	}
	
	/**
     * Solicita al subsistema lista la colección de listas del usuario actual.
     * Si hay error, lo notifica a la interfaz gráfica.
     * @return Las listas obtenidas.
     */
	public ArrayList<Lista> getListasUsuario() {
		try {
			return fLista.mostrar(usuarioActual);
		} catch (ErrorAutenticacion | ErrorConsulta | ErrorCreacionObjeto e) {
			VentanaPrincipal.muestraError(e);
		}
		return null;
	}
}
