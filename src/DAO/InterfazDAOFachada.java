package DAO;

import java.util.ArrayList;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.*;

/**
 * Clase InterfazDAOFachada, contiene las funciones sin implementar que conforman la
 * fachada del DAO.
 */
public interface InterfazDAOFachada {
	// GET
	/**
	 * Solicita la información de un género a la base de datos.
	 * @param idGenero Id del género.
	 * @return El género, null si no se ha podido encontrar.
	 * @throws ErrorConsulta Si se ha producido un error al buscar el género.
	 * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
	 */
	public Genero getGeneroDB(String idGenero) throws ErrorConsulta, ErrorCreacionObjeto;
	/**
	 * Solicita la información de una canción a la base de datos.
	 * @param idCancion
	 * @return
	 * @throws ErrorCreacionObjeto
	 * @throws ErrorConsulta
	 */
	public Cancion getCancionDB(String idCancion) throws ErrorCreacionObjeto, ErrorConsulta;
	/**
	 * Solicita la lista de canciones de un género a la base de datos.
	 * @param id
	 * @return
	 * @throws ErrorConsulta
	 * @throws ErrorCreacionObjeto
	 */
	public ArrayList<Cancion> getCancionesGeneroDB(String id) throws ErrorConsulta, ErrorCreacionObjeto;
	/**
	 * Solicita la información de una lista a la base de datos.
	 * @param idLista
	 * @return
	 * @throws ErrorConsulta
	 * @throws ErrorCreacionObjeto
	 */
	public Lista getListaDB(String idLista) throws ErrorConsulta, ErrorCreacionObjeto;
	/**
	 * Solicita la información de un usuario a la base de datos.
	 * @param idUsuario
	 * @param clave
	 * @return
	 * @throws ErrorAutenticacion
	 * @throws ErrorConsulta
	 * @throws ErrorCreacionObjeto
	 */
	public Usuario getUsuarioDB(String idUsuario, String clave) throws ErrorAutenticacion, ErrorConsulta, ErrorCreacionObjeto;
	/**
	 * Solicita una lista que contenga todas las listas de un usuario a la base de datos.
	 * @param idUsuario
	 * @param clave
	 * @return
	 * @throws ErrorAutenticacion
	 * @throws ErrorConsulta
	 * @throws ErrorCreacionObjeto
	 */
	public ArrayList<Lista> getListasDB(String idUsuario, String clave) throws ErrorAutenticacion, ErrorConsulta, ErrorCreacionObjeto;
	// SET
	public void setCancion(Cancion cancion) throws ErrorGuardado, ErrorCreacionObjeto;
	public void setGenero(Genero genero, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado;
	public void setUsuario(Usuario usuario) throws ErrorAutenticacion, ErrorGuardado;
	public void setLista(Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado;
	public void setListaAuto(ListaAuto lista, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado;
	// ELIMINAR
	public void eliminarLista(Lista lista, Usuario usuarioActual) throws ErrorAutenticacion, ErrorEliminacion;
	public void eliminarCancion(Cancion cancion) throws ErrorEliminacion;
	public void eliminarGenero(Genero genero, Usuario usuario) throws ErrorEliminacion, ErrorAutenticacion;
	public void eliminarUsuario(Usuario usuario) throws ErrorEliminacion, ErrorAutenticacion;
}
