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
	 */
	@Override
    public Lista consulta(String id) throws ErrorConsulta {
		Lista lista = dao.getListaDB(id);
		if (lista == null)
			throw new ErrorConsulta("Error al consultar lista");
		else
			return lista;
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
    		//lista.setNombre(nombre); Se debe hacer antes y aqui llega ya la lista con los datos completos
    		dao.setLista(lista, usuario);
    }

    /**
     * Crea una lista vacia (las canciones se anaden aparte) y la guarda en la DB
     * @param nombre nombre de la lista
     * @param usuario usuario que desea crear la lista
     * @throws ErrorCreacionObjeto 
     * @throws ErrorGuardado 
     */
    @SuppressWarnings("unused")
	@Override
    public void crearLista(String nombre, Usuario usuario) throws ErrorAutenticacion, ErrorCreacionObjeto, ErrorGuardado {
    		ListaNormal lista = new ListaNormal(/*l aputa id*/"a", nombre);
    		if (lista == null)
    			throw new ErrorCreacionObjeto("Error al crear la lista");
    		else
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
    public void crearListaAuto(ListaAuto lista, Genero genero, Usuario usuario, int duracionMax) throws ErrorAutenticacion, ErrorCreacionObjeto, ErrorConsulta, ErrorGuardado {
    		//ListaAuto lista = new ListaAuto("a"/*TODO*/, nombre, genero);
    		if (lista == null)
    			throw new ErrorCreacionObjeto("Error al crear lista auto");
    		else {
	    		//obtener lista de canciones con el genero que nos interesa
    			int duracion = 0;
	    		int i = 0;
    			ArrayList<Cancion> canciones = dao.getCancionesGeneroDB(genero.getId());
	    		Cancion cancion = canciones.get(i);
	    		duracion += cancion.getDuracion();
	    		while (duracion < duracionMax && i < canciones.size()) {
	    			this.anadirCancion(cancion, lista, usuario);
		    		cancion = canciones.get(i);
		    		duracion += cancion.getDuracion();
		    		i++;
	    		}
	    		dao.setListaAuto(lista, genero, usuario);
	    		if (i == canciones.size())
	    			throw new ErrorCreacionObjeto("No hay suficiente canciones para llegar a la duracion deseada");
    		}
    }

    /**
     * Guardafo en la DB la pertenencia de una cancion a una lista, vamos que mete
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
    		if (dao.getCancionDB(cancion.getId()).equals(cancion)) {
    			//comprueba que vamos a anadir una cancion valida
    			lista.anadirCancion(cancion);
    			dao.setLista(lista, usuario);
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
    		if (dao.getCancionDB(cancion.getId()).equals(cancion)) {
    			lista.eliminarCancion(cancion);
    			dao.setLista(lista, usuario);
    		}
    }
}
