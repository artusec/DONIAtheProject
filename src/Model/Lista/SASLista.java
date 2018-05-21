package Model.Lista;

import java.util.ArrayList;

import DAO.DAOFachada;
import DAO.InterfazDAOFachada;
import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Lista.InterfazSASLista;
import Model.Objetos.*;
import Vista.VentanaPrincipal;

/**
 * Servicio de aplicación de lista.
 */
public class SASLista implements InterfazSASLista {
	
	private InterfazDAOFachada dao;
	
	/**
	 * Constructora de la clase.
	 */
	public SASLista() {
		this.setDao();
	}
	
	/**
	 * Actualiza el atributo dao a un nuevo DAOFachada.
	 */
	private void setDao() {
		this.dao = new DAOFachada();
	}

	/**
	 * Devuelve la lista solicitada
	 * 
	 * @param id id de la lista a consultar
	 * @return la lista buscada, null si no existe
	 * @throws ErrorConsulta  Si se ha producido un error al buscar la lista.
	 * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
	 */
	@Override
    public Lista consulta(String id) throws ErrorConsulta, ErrorCreacionObjeto {
		Lista lista = dao.getListaDB(id);
		if (lista == null)
			throw new ErrorConsulta("Error al consultar lista");
		else
			return lista;
    }
	
	/**
	 * Devuelve todas las listas del usuario.
	 * @param usuarioActual Usuario del que se quiere ver las listas.
	 * @return Listas de reproducción del usuario.
	 * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
	 * @throws ErrorConsulta Si se ha producido un error al buscar alguna lista.
	 * @throws ErrorAutenticacion Si el usuario no existe.
	 */
	@Override
	public ArrayList<Lista> mostrar(Usuario usuarioActual) throws ErrorAutenticacion, ErrorConsulta, ErrorCreacionObjeto {
		ArrayList<Lista> listas = dao.getListasDB(usuarioActual.getId(), usuarioActual.getClave());
		if (listas == null)
			throw new ErrorConsulta("Error al obtener listas");
		else
			return listas;
    }
	
    /**
     * Borra una lista.
     * @param lista lista a borrar
     * @param usuario usuario que desea borrar la lista
     * @throws ErrorEliminacion Si no se ha podido eliminar.
     * @throws ErrorAutenticacion Si el usuario no existe.
     */
    @Override
    public void eliminar(Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorEliminacion { 
    		if (!lista.getId().equals("l0"))
    			dao.eliminarLista(lista, usuario);
    }
    
    /**
     * Modifica una lista.
     * @param usuario Usuario que desea modificar la lista.
     * @param lista Lista a modificar.
     * @throws ErrorGuardado Si no se ha podido guardar la información.
     */
    @Override
    public void modificar(Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado{
	    	if (!lista.getId().equals("l0"))
	    		dao.setLista(lista, usuario);
    }

    /**
     * Crea una lista vacia y la guarda en la base de datos.
     * @param lista Objeto creado que se actualizará con la lista creada.
     * @param usuario Usuario que desea crear la lista
     * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
     * @throws ErrorGuardado Si no se ha podido guardar la información.
     */
	@Override
    public void crearLista(Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorCreacionObjeto, ErrorGuardado {
    		dao.setLista(lista, usuario);
    }

    /**
     * Crea una listaAuto con sus temas correspondientes y la guarda en la base de datos.
     * @param lista objeto que se quiere crear
     * @param usuario usuario que quiere crear la lista
     * @param duracionMax duracion maxima que se quiere para la lista
     * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
     * @throws ErrorConsulta Si se ha producido un error al buscar canciones.
     * @throws ErrorGuardado Si no se ha podido guardar la información.
     */
    @Override
    public void crearListaAuto(ListaAuto lista, Usuario usuario, double duracionMax) throws ErrorAutenticacion, ErrorCreacionObjeto, ErrorConsulta, ErrorGuardado {
		if (lista == null)
			throw new ErrorCreacionObjeto("Error al crear lista auto");
		else {
			ArrayList<Cancion> canciones = dao.getCancionesGeneroDB(lista.getGenero().getId());
			if (canciones != null) 
			{
				double duracion = 0;
		    	int i = 0;
		    	if (canciones.size() > 0) 
		    	{
		    		Cancion cancion = canciones.get(i);
		    		duracion += cancion.getDuracion();
		    		while (duracion < duracionMax && i < canciones.size()) 
		    		{
		    			this.anadirCancion(cancion, lista, usuario);
			    		cancion = canciones.get(i);
			    		duracion += cancion.getDuracion();
			    		while (duracion < duracionMax && i < canciones.size()) 
			    		{
			    			this.anadirCancion(cancion, lista, usuario);
				    		cancion = canciones.get(i);
				    		duracion += cancion.getDuracion();
				    		i++;
			    		}
			    		dao.setListaAuto(lista, usuario);
			    		if (i == canciones.size())
			    			throw new ErrorCreacionObjeto("Lista creada\n Aviso: No hay suficientes canciones para llegar a la duracion solicitada");
			    		if (lista.getCanciones().isEmpty())
			    			throw new ErrorCreacionObjeto("Lista creada\n Aviso:La duracion TAN corta que no cabe ninguna cancion de " + lista.getGenero().getId());
		    		}
		    	} 
		    	else {
		    		throw new ErrorCreacionObjeto("No hay canciones de " + lista.getGenero());
		    	}
			}	
		}
    }

    /**
     * Guardado en la DB la pertenencia de una cancion a una lista.
     * @param cancion cancion a anadir
     * @param lista lista objetivo
     * @param usuario usuario que quiere anadir la cancion
     * @throws ErrorAutenticacion Si usuario no existe.
     * @throws ErrorGuardado Si no se ha podido guardar la información.
     * @throws ErrorConsulta Si se ha producido un error al buscar la canción.
     * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
     */
    @Override
    public void anadirCancion(Cancion cancion, Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorCreacionObjeto, ErrorConsulta, ErrorGuardado {
    	
    		if (dao.getCancionDB(cancion.getId()).getId().equals(cancion.getId())) {
    			if (!lista.getId().equals("l0")) {	
	    			lista.anadirCancion(cancion);
	    			dao.setLista(lista, usuario);
    			} else {
    				throw new ErrorGuardado("No puedes añadir canciones a la biblioteca");
    			}
    		}
    }
    
    /**
     * Elimina de la base de datos la pertenencia de una cancion a una lista.
     * @param cancion cancion a eliminar
     * @param lista lista objetivo
     * @param usuario usuario que quiere eliminar la cancion
     * @throws ErrorAutenticacion Si el usuario no existe.
     * @throws ErrorGuardado Si no se ha podido guardar la información.
     * @throws ErrorConsulta  Si se ha producido un error al buscar la canción.
     * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
     */
    @Override
    public void eliminarCancion(Cancion cancion, Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorCreacionObjeto, ErrorConsulta, ErrorGuardado {
    		if (dao.getCancionDB(cancion.getId()).getId().equals(cancion.getId())) {
    			if (!lista.getId().equals("l0")) {	
	    			lista.eliminarCancion(cancion);
	    			dao.setLista(lista, usuario);
	    			VentanaPrincipal.actualizaCanciones(lista.getId());
    			} else {
    				throw new ErrorGuardado("No puedes borrar canciones de la biblioteca");
    			}
    		}
    }
}
