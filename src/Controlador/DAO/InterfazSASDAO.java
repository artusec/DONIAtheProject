package Controlador.DAO;

import java.util.ArrayList;

import Excepciones.ErrorAutenticacion;
import Model.Objetos.*;

public interface InterfazSASDAO {
	// GET
	/**
	 * Consulta la base de datos y crea el genero solicitado
	 * @param idGenero id del genero solicitado
	 * @return genero solicitado, null si no existe
	 */
	public Genero getGeneroDB(String idGenero);
	/**
	 * Consulta la base de datos y crea la cancion solicitada
	 * @param idCancion id de la cancion solicitada
	 * @return cancion solicitada, null si no existe
	 */
	public Cancion getCancionDB(String idCancion);
	/**
	 * Consulta la base de datos y obtiene la lista de canciones de un genero musical
	 * @param idGenero id del genero del cual se desea obtener las canciones
	 * @return Lista de canciones, null si no existe el genero o no hay canciones
	 */
	public ArrayList<Cancion> getCancionesGeneroDB(String idGenero);
	/**
	 * Consulta la base de datos y crea la lista solicitado
	 * @param idLista id de la lista solicitada
	 * @return lista solicitada, null si no existe
	 */
	public Lista getListaDB(String idLista);
	/**
	 * Obtiene el usuario solicitado de la DB
	 * @param idUsuario id de usuario
	 * @param clave contraseña
	 * @return usuario solicitado
	 * @throws ErrorAutenticacion si la clave no coincide con la esperada, o el usuario no existe
	 */
	public Usuario getUsuarioDB(String idUsuario, String clave) throws ErrorAutenticacion;
	
	// SET
	/**
	 * Guarda la cancion en la DB, si ya existe actualiza
	 * @param cancion cancion a guardar
	 */
	public void setCancion(Cancion cancion);
	/**
	 * Guarda la genero en la DB y lo asocia a un usuario, si ya existe actualiza
	 * @param genero genero a guardar
	 * @param usuario usuario asociado
	 */
	public void setGenero(Genero genero, Usuario usuario);
	/**
	 * Registra usuario o lo actualiza si ya existe
	 * @param usuario usuario a guardar
	 * @throws ErrorAutenticacion si la clave no coincide con la almacenada
	 */
	public void setUsuario(Usuario usuario) throws ErrorAutenticacion;
	/**
	 * Guarda la lista en la DB y la asocia a un usuario, si ya existe actualiza
	 * @param lista lista a guardar
	 * @param usuario usuario al que pertenece la lista
	 * @throws ErrorAutenticacion si la clave no coincide con la almacenada
	 */
	public void setLista(Lista lista, Usuario usuario) throws ErrorAutenticacion;
	/**
	 * Guarda la lista auto en la DB y la asocia a un genero y a un usuario, si ya existe actualiza
	 * @param lista lista a guardar
	 * @param genero genero de la lista
	 * @param usuario usuario al que pertenece la lista
	 * @throws ErrorAutenticacion si la clave no coincide con la almacenada
	 */
	public void setListaAuto(Lista lista, Genero genero, Usuario usuario) throws ErrorAutenticacion;
	
	// ELIMINAR
	/**
	 * Elimina una lista de la DB
	 * @param lista lista a eliminar
	 * @param usuarioActual usuario de la lista
	 */
	public void eliminarLista(Lista lista, Usuario usuarioActual) throws ErrorAutenticacion;
	/**
	 * Elimina una cancion de la DB
	 * @param cancion cancion a eliminar
	 */
	public void eliminarCancion(Cancion cancion);
	/**
	 * Elimina la relacion entre un genero y un usuario de la DB
	 * @param genero genero a eliminar para el usuario
	 * @param usuario usuario del genero
	 */
	public void eliminarGenero(Genero genero, Usuario usuario);
	/**
	 * Elimina un usuario (asi como sus listas y generos) de la DB
	 * @param usuario usuario a eliminar
	 */
	public void eliminarUsuario(Usuario usuario);
}
