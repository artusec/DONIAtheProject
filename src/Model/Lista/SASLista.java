package Model.Lista;

import java.util.ArrayList;

import Controlador.DAO.DAOFachada;
import Controlador.DAO.InterfazDAOFachada;
import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Lista.InterfazSASLista;
import Model.Objetos.*;
import Vista.VentanaPrincipal;

/**
 * Clase SASLista
 *
 */
public class SASLista implements InterfazSASLista {
	
	private InterfazDAOFachada dao;
	//hay un objeto dao, solo que no se donde deberiamos ponerlo
	//tambien necesitamos en algunas clases (como esta) saber cual es el usuario con el que estamos trabajando ahora
	
	public SASLista() {
		this.setDao();
	}
	
	private void setDao() {
		this.dao = new DAOFachada();
	}

	/**
	 * Devuelve la lista solicitada
	 * 
	 * TODO: quizas la lista deberia ser un string con la id
	 * 
	 * @param id id de la lista a consultar
	 * @return la lista buscada, null si no existe
	 * @throws ErrorConsulta 
	 * @throws ErrorCreacionObjeto 
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
	 * Devuelve todas las listas del usuario
	 * @param usuarioActual
	 * @return
	 * @throws ErrorCreacionObjeto 
	 * @throws ErrorConsulta 
	 * @throws ErrorAutenticacion 
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
     * borra una lista existente (obvio)
     * @param lista lista a borrar
     * @param usuario usuario que desea borrar la lista
     * @throws ErrorEliminacion
     * @throws ErrorAutenticacion 
     */
    @Override
    public void eliminar(Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorEliminacion { 
    		if (!lista.getId().equals("l0"))
    			dao.eliminarLista(lista, usuario);
    }
    
    /**
     * modifica una lista existente
     * @param nombre el nuevo nombre
     * @param lista lista a modificar
     * @throws ErrorGuardado 
     */
    @Override
    public void modificar(Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado{
	    	if (!lista.getId().equals("l0"))
	    		dao.setLista(lista, usuario);
    }

    /**
     * Crea una lista vacia (las canciones se anaden aparte) y la guarda en la DB
     * @param nombre nombre de la lista
     * @param usuario usuario que desea crear la lista
     * @throws ErrorCreacionObjeto 
     * @throws ErrorGuardado 
     */
	@Override
    public void crearLista(Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorCreacionObjeto, ErrorGuardado {
    		dao.setLista(lista, usuario);
    }

    /**
     * Crea una listaAuto con sus temas correspondientes y la guarda en la DB
     * @param lista objeto que se quiere crear
     * @param genero el genero del cual seleccionar las canciones
     * @param usuario usuario que quiere crear la lista
     * @int duracionMax duracion maxima que se quiere para la lista
     * @throws ErrorCreacionObjeto 
     * @throws ErrorConsulta 
     * @throws ErrorGuardado 
     */
    @Override
    public void crearListaAuto(ListaAuto lista, Usuario usuario, int duracionMax) throws ErrorAutenticacion, ErrorCreacionObjeto, ErrorConsulta, ErrorGuardado {
    		if (lista == null)
    			throw new ErrorCreacionObjeto("Error al crear lista auto");
    		else {
	    		//obtener lista de canciones con el genero que nos interesa
    			ArrayList<Cancion> canciones = dao.getCancionesGeneroDB(lista.getGenero().getId());
    			if (canciones != null) {
        			int duracion = 0;
	    	    	int i = 0;
	    	    	if (canciones.size() > 0) {
		    		Cancion cancion = canciones.get(i);
		    		duracion += cancion.getDuracion();
		    		while (duracion < duracionMax && i < canciones.size()) {
		    			this.anadirCancion(cancion, lista, usuario);
			    		cancion = canciones.get(i);
			    		duracion += cancion.getDuracion();
			    		i++;
		    		}
		    		dao.setListaAuto(lista, usuario);
		    		//ESTO ESTA BIEN; PERO SI LO HACEMOS NO ACTUALIZA LA VISTA DEBIDO AL ERROR
		    		/*if (i == canciones.size())
		    			throw new ErrorCreacionObjeto("Lista creada\n Aviso: No hay suficientes canciones para llegar a la duracion solicitada");*/
		    	}
	    	} else {
	    		throw new ErrorCreacionObjeto("No hay canciones de " + lista.getGenero());
	    	}
    	}	
    }

    /**
     * Guardado en la DB la pertenencia de una cancion a una lista, vamos que mete
     * la cancion en la lista
     * @param cancion cancion a anadir
     * @param lista lista objetivo
     * @param usuario usuario que quiere anadir la cancion
     * @throws ErrorAutenticacion 
     * @throws ErrorGuardado 
     * @throws ErrorConsulta 
     * @throws ErrorCreacionObjeto 
     */
    @Override
    public void anadirCancion(Cancion cancion, Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorCreacionObjeto, ErrorConsulta, ErrorGuardado {
    		if (dao.getCancionDB(cancion.getId()).getId().equals(cancion.getId())) {
    			//comprueba que vamos a anadir una cancion valida
    			if (!lista.getId().equals("l0")) {	
	    			lista.anadirCancion(cancion);
	    			dao.setLista(lista, usuario);
    			} else {
    				throw new ErrorGuardado("No puedes añadir canciones a la biblioteca");
    			}
    		}
    }
    
    /**
     * Elimina de la DB la pertenencia de una cancion a una lista
     * @param cancion cancion a eliminar
     * @param lista lista objetivo
     * @param usuario usuario que quiere eliminar la cancion
     * @throws ErrorAutenticacion 
     * @throws ErrorGuardado 
     * @throws ErrorConsulta 
     * @throws ErrorCreacionObjeto 
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
