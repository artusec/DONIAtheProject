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
	 * @param idCancion Id de la canción a consultar.
	 * @return La canción; si no se ha podido encontrar, null.
	 * @throws ErrorConsulta Si se ha producido un error al buscar el género.
	 * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
	 */
	public Cancion getCancionDB(String idCancion) throws ErrorCreacionObjeto, ErrorConsulta;
	/**
	 * Solicita la lista de canciones de un género a la base de datos.
	 * @param id Id del género.
	 * @return La lista de canciones; si no se ha podido, null.
	 * @throws ErrorConsulta Si se ha producido un error al buscar el género.
	 * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
	 */
	public ArrayList<Cancion> getCancionesGeneroDB(String id) throws ErrorConsulta, ErrorCreacionObjeto;
	/**
	 * Solicita la información de una lista a la base de datos.
	 * @param idLista Id de la lista.
	 * @return La lista; si no se ha podido encontrar, null.
	 * @throws ErrorConsulta Si se ha producido un error al buscar el género.
	 * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
	 */
	public Lista getListaDB(String idLista) throws ErrorConsulta, ErrorCreacionObjeto;
	/**
	 * Solicita la información de un usuario a la base de datos.
	 * @param idUsuario Id del usuario.
	 * @param clave Clave del usuario.
	 * @return El usuario; si no se ha podido encontrar, null.
	 * @throws ErrorAutenticacion Si la clave no coincide con la esperada, o el usuario no existe.
	 * @throws ErrorConsulta Si se ha producido un error al buscar el género.
	 * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
	 */
	public Usuario getUsuarioDB(String idUsuario, String clave) throws ErrorAutenticacion, ErrorConsulta, ErrorCreacionObjeto;
	/**
	 * Solicita una lista que contenga todas las listas de un usuario a la base de datos.
	 * @param idUsuario Id del usuario.
	 * @param clave Clave del usuario.
	 * @return Las listas del usuario; si no se ha podido, null.
	 * @throws ErrorAutenticacion Si la clave no coincide con la esperada, o el usuario no existe.
	 * @throws ErrorConsulta Si se ha producido un error al buscar el género.
	 * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
	 */
	public ArrayList<Lista> getListasDB(String idUsuario, String clave) throws ErrorAutenticacion, ErrorConsulta, ErrorCreacionObjeto;
	// SET
	/**
	 * Solicita establecer la informacion de una canción a la base de datos.
	 * @param cancion Id de la canción.
	 * @throws ErrorGuardado Si no se ha podido guardar la información.
	 * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
	 */
	public void setCancion(Cancion cancion) throws ErrorGuardado, ErrorCreacionObjeto;
	/**
	 * Solicita establecer la informacion de una género a la base de datos.
	 * @param genero Id del género.
	 * @param usuario Id del usuario.
	 * @throws ErrorAutenticacion Si la clave no coincide con la esperada, o el usuario no existe.
	 * @throws ErrorGuardado Si no se ha podido guardar la información.
	 */
	public void setGenero(Genero genero, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado;
	/**
	 * Solicita establecer la informacion de una usuario a la base de datos.
	 * @param usuario Id del usuario.
	 * @throws ErrorAutenticacion Si la clave no coincide con la esperada, o el usuario no existe.
	 * @throws ErrorGuardado Si no se ha podido guardar la información.
	 */
	public void setUsuario(Usuario usuario) throws ErrorAutenticacion, ErrorGuardado;
	/**
	 * Solicita establecer la informacion de un lista a la base de datos.
	 * @param lista Id de la lista.
	 * @param usuario Id del usuario.
	 * @throws ErrorAutenticacion Si la clave no coincide con la esperada, o el usuario no existe.
	 * @throws ErrorGuardado Si no se ha podido guardar la información.
	 */
	public void setLista(Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado;
	/**
	 * Solicita establecer la informacion de una lista generada automáticamente a la base de datos.
	 * @param lista Id de la lista.
	 * @param usuario Id del usuario.
	 * @throws ErrorAutenticacion Si la clave no coincide con la esperada, o el usuario no existe.
	 * @throws ErrorGuardado Si no se ha podido guardar la información.
	 */
	public void setListaAuto(ListaAuto lista, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado;
	// ELIMINAR
	/**
	 * Solicita a la base de datos la eliminación de una lista.
	 * @param lista Id de la lista.
	 * @param usuarioActual Id del usuario.
	 * @throws ErrorAutenticacion Si la clave no coincide con la esperada, o el usuario no existe.
	 * @throws ErrorEliminacion Si no se ha podido eliminar.
	 */
	public void eliminarLista(Lista lista, Usuario usuarioActual) throws ErrorAutenticacion, ErrorEliminacion;
	/**
	 * Solicita a la base de datos la eliminación de una canción.
	 * @param cancion Id de la canción.
	 * @throws ErrorEliminacion Si no se ha podido eliminar.
	 */
	public void eliminarCancion(Cancion cancion) throws ErrorEliminacion;
	/**
	 * Solicita a la base de datos la eliminación de un género.
	 * @param genero Id del género.
	 * @param usuario Id del usuario.
	 * @throws ErrorEliminacion Si no se ha podido eliminar.
	 * @throws ErrorAutenticacion Si la clave no coincide con la esperada, o el usuario no existe.
	 */
	public void eliminarGenero(Genero genero, Usuario usuario) throws ErrorEliminacion, ErrorAutenticacion;
	/**
	 * Solicita a la base de datos la eliminación de un usuario.
	 * @param usuario Id del usuario.
	 * @throws ErrorEliminacion Si no se ha podido eliminar.
	 * @throws ErrorAutenticacion Si la clave no coincide con la esperada, o el usuario no existe.
	 */
	public void eliminarUsuario(Usuario usuario) throws ErrorEliminacion, ErrorAutenticacion;
}
