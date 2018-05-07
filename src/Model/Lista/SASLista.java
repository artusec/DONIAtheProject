package Model.Lista;

import java.util.ArrayList;
import java.util.List;

import Controlador.DAO.InterfazDAOFachada;
import Excepciones.ErrorAutenticacion;
import Model.Objetos.*;

/**
 * Clase SASLista
 *
 */
public class SASLista implements InterfazSASLista {
	
	private InterfazDAOFachada dao;
	//hay un objeto dao, solo que no se donde deberiamos ponerlo
	//tambien necesitamos en algunas clases (como esta) saber cual es el usuario con el que estamos trabajando ahora
	
	/**
	 * Devuelve la lista solicitada
	 * 
	 * TODO: quizas la lista deberia ser un string con la id
	 * 
	 * @param id id de la lista a consultar
	 * @return la lista buscada, null si no existe
	 */
    public Lista consultar(String id) {
    		return dao.getListaDB(id);
    }
    
    /**
     * borra una lsita existente (obvio)
     * @param lista lista a borrar
     */
    public void borrar(Lista lista) {
    		dao.borrarLista(lista, usuario);
    }
    
    /**
     * modifica una lista existente
     * @param nombre el nuevo nombre
     * @param lista lista a modificar
     */
    public void modificar(String nombre, Lista lista) throws ErrorAutenticacion{
    		lista.setNombre(nombre);
    		dao.setLista(lista, usuario);
    }

    /**
     * Crea una lista vacia (las canciones se anaden aparte) y la guarda en la DB
     * @param nombre nombre de la lista
     */
    @Override
    public void crearLista(String nombre) throws ErrorAutenticacion {
    		ListaNormal lista = new ListaNormal(/*l aputa id*/"a", nombre);
    		dao.setLista(lista, usuario);
    }

    /**
     * Crea una listaAuto con sus temas correspondientes y la guarda en la DB
     * @param nombre nombre de la lista
     * @param genero el genero del cual seleccionar las canciones
     */
    @Override
    public void crearListaAuto(String nombre, Genero genero) throws ErrorAutenticacion {
    		ListaAuto lista = new ListaAuto("a"/*TODO*/, nombre, genero);
    		//obtener lista de canciones con el genero que nos interesa
    		ArrayList<Cancion> canciones = dao.getCancionesGeneroDB(genero.getId());
    		for (Cancion cancion : canciones) {
    			this.anadirCancion(cancion, lista);
    		}
    		dao.setListaAuto(lista, usuario, genero);
    }

    /**
     * Guarda en la DB la pertenencia de una cancion a una lista, vamos que mete
     * la cancion en la lista
     * @param cancion cancion a anadir
     * @param lista lista objetivo
     */
    @Override
    public void anadirCancion(Cancion cancion, Lista lista) {
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
     */
    @Override
    public void eliminarCancion(Cancion cancion, Lista lista) {
    		if (dao.getCancionDB(cancion.getId()).equals(cancion)) {
    			lista.eliminarCancion(cancion);
    			dao.setLista(lista, usuario);
    		}
    }

    /**
     * Obtiene de la DB la lista seleccionada
     * @params idLista la id de la lista a mostrar, null si no se encuentra
     */
    @Override
	public Lista consulta(String idLista) {
		return dao.getListaDB(idLista);
	}
}
