package Model.Lista;

import java.util.ArrayList;
import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.*;

public interface InterfazFachadaLista {
	
	/**
	 * Consulta una lista en la base de datos.
	 * @param idLista
	 * @return
	 * @throws ErrorConsulta - Error en la consulta
	 * @throws ErrorCreacionObjeto - Error en la creación de la lista.
	 */
	public Lista consulta(String idLista) throws ErrorConsulta, ErrorCreacionObjeto;
	
	/**
	 * Muestra la lista de canciones asociadas al usuario pasado por parámetro.
	 * @param usuarioActual
	 * @return ArrayList<Lista>
	 * @throws ErrorAutenticacion
	 * @throws ErrorConsulta
	 * @throws ErrorCreacionObjeto
	 */
	public ArrayList<Lista> mostrar(Usuario usuarioActual) throws ErrorAutenticacion, ErrorConsulta, ErrorCreacionObjeto;
	
	/**
	 * Elimina la lista del usuario pasados por parámetro.
	 * @param lista
	 * @param usuario
	 * @throws ErrorAutenticacion
	 * @throws ErrorEliminacion
	 */
	public void eliminar(Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorEliminacion;
	
	/**
	 * Modifica la lista del usuario pasados por parámetro.
	 * @param lista
	 * @param usuario
	 * @throws ErrorAutenticacion
	 * @throws ErrorGuardado
	 */
	public void modificar(Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado;
	
	/**
	 * Crea una lista para el usuario pasados por parámetro.
	 * @param lista
	 * @param usuario
	 * @throws ErrorAutenticacion
	 * @throws ErrorCreacionObjeto
	 * @throws ErrorGuardado
	 */
	public void crearLista(Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorCreacionObjeto, ErrorGuardado;
	
	/**
	 * Crea una lista automática con una cierta duración máxima.
	 * @param lista
	 * @param usuario
	 * @param d
	 * @throws ErrorAutenticacion
	 * @throws ErrorCreacionObjeto
	 * @throws ErrorConsulta
	 * @throws ErrorGuardado
	 */
	public void crearListaAuto(ListaAuto lista, Usuario usuario, double d) throws ErrorAutenticacion, ErrorCreacionObjeto, ErrorConsulta, ErrorGuardado;
	
	/**
	 * Añade una canción a una lista del usuario pasados por parámetro.
	 * @param cancion
	 * @param lista
	 * @param usuario
	 * @throws ErrorAutenticacion
	 * @throws ErrorCreacionObjeto
	 * @throws ErrorConsulta
	 * @throws ErrorGuardado
	 */
	public void anadirCancion(Cancion cancion, Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorCreacionObjeto, ErrorConsulta, ErrorGuardado;
	
	/**
	 *  Elimina una canción de una lista del usuario pasados por parámetro.
	 * @param cancion
	 * @param lista
	 * @param usuario
	 * @throws ErrorAutenticacion
	 * @throws ErrorCreacionObjeto
	 * @throws ErrorConsulta
	 * @throws ErrorGuardado
	 */
	public void eliminarCancion(Cancion cancion, Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorCreacionObjeto, ErrorConsulta, ErrorGuardado;
}
