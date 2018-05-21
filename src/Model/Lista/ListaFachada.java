package Model.Lista;

import java.util.ArrayList;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.*;

/**
 * Fachada de lista. Implementa InterfazFachadaLista.
 * @author Raúl
 *
 */
public class ListaFachada implements InterfazFachadaLista {
	
    public InterfazSASLista sasLista;

    /**
     * Constructora.
     */
    public ListaFachada(){
    		sasLista = new SASLista();
    }
    
	/**
	 * Crea una lista para el usuario pasados por parámetro.
	 * @param lista Objeto creado, el cual se actualizará a la lista creada.
	 * @param usuario Usuario que desea crear la lista.
	 * @throws ErrorAutenticacion Si el usuario no existe.
	 * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
	 * @throws ErrorGuardado Si no se ha podido guardar la información.
	 */
    @Override
    public void crearLista(Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorCreacionObjeto, ErrorGuardado {
    		sasLista.crearLista(lista, usuario);
    }

	/**
	 * Crea una lista automática con una cierta duración máxima.
	 * @param lista Objeto creado que se actualizarña a la Lista creada.
	 * @param usuario Usuario que desea crear la lista.
	 * @param duracion Duración máxima que se quiere para la lista.
	 * @throws ErrorAutenticacion Si el usuario no existe.
	 * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
	 * @throws ErrorConsulta Si se ha producido un error al buscar.
	 * @throws ErrorGuardado Si no se ha podido guardar la información.
	 */
    @Override
    public void crearListaAuto(ListaAuto lista, Usuario usuario, double duracion) throws ErrorAutenticacion, ErrorCreacionObjeto, ErrorConsulta, ErrorGuardado {
    		sasLista.crearListaAuto(lista, usuario,duracion);
    }

	/**
	 * Consulta una lista en la base de datos.
	 * @param idLista Id de la lista que se desea consultar.
	 * @return Lista obtenida de la base de datos.
	 * @throws ErrorConsulta - Error en la consulta
	 * @throws ErrorCreacionObjeto - Error en la creación de la lista.
	 */
	@Override
	public Lista consulta(String idLista) throws ErrorConsulta, ErrorCreacionObjeto {
    		return sasLista.consulta(idLista);		
	}

	/**
	 * Muestra la lista de canciones asociadas al usuario pasado por parámetro.
	 * @param usuarioActual Usuario del que se quiere ver las listas de reproducción.
	 * @return ArrayList Listas de reproducción del usuario.
	 * @throws ErrorAutenticacion Si el usuario no existe.
	 * @throws ErrorConsulta Si se ha producido un error al buscar alguna lista.
	 * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
	 */
	@Override
	public ArrayList<Lista> mostrar(Usuario usuarioActual) throws ErrorAutenticacion, ErrorConsulta, ErrorCreacionObjeto {
		return sasLista.mostrar(usuarioActual);
	}
	
	/**
	 * Elimina la lista del usuario pasados por parámetro.
	 * @param lista Lista a eliminar.
	 * @param usuario Usuario del que se quiere eliminar la lista.
	 * @throws ErrorAutenticacion Si el usuario no existe.
	 * @throws ErrorEliminacion Si no se ha podido eliminar.
	 */
	@Override
	public void eliminar(Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorEliminacion {
		sasLista.eliminar(lista, usuario);		
	}

	/**
	 * Modifica la lista del usuario pasados por parámetro.
	 * @param lista Lista que se desea modificar.
	 * @param usuario Usuario del que se desea modificar la lista.
	 * @throws ErrorAutenticacion Si el usuario no existe.
	 * @throws ErrorGuardado Si no se ha podido guardar la información.
	 */
	@Override
	public void modificar(Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado {
		sasLista.modificar(lista, usuario);		
	}

	/**
	 * Añade una canción a una lista del usuario pasados por parámetro.
	 * @param cancion Canción que se quiere añadir a la lista.
	 * @param lista Lista a la que se quiere añadir la canción.
	 * @param usuario Usuario que desea realizar la acción.
	 * @throws ErrorAutenticacion Si el usuario no existe.
	 * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
	 * @throws ErrorConsulta Si se ha producido un error al buscar la canción.
	 * @throws ErrorGuardado Si no se ha podido guardar la información.
	 */
	@Override
	public void anadirCancion(Cancion cancion, Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorCreacionObjeto, ErrorConsulta, ErrorGuardado {
		sasLista.anadirCancion(cancion, lista, usuario);		
	}

	/**
	 *  Elimina una canción de una lista del usuario pasados por parámetro.
	 * @param cancion Canción que se quiere eliminar de la lista.
	 * @param lista Lista a la que se le quiere borrar la canción.
	 * @param usuario Usuario que desea realizar la acción.
	 * @throws ErrorAutenticacion Si el usuario no existe.
	 * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
	 * @throws ErrorConsulta Si se ha producido un error al buscar la canción.
	 * @throws ErrorGuardado Si no se ha podido guardar la información.
	 */
	@Override
	public void eliminarCancion(Cancion cancion, Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorCreacionObjeto, ErrorConsulta, ErrorGuardado {
		sasLista.eliminarCancion(cancion, lista, usuario);	
	}
}
