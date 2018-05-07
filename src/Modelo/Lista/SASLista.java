
import java.util.List;

import Controlador.DAO.InterfazDAOFachada;
import Modelo.Objetos.Cancion;
import Modelo.Objetos.Genero;
import Modelo.Objetos.Lista;

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
	 * @return la lista
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
    public void modificar(String nombre, Lista lista) {
    		lista.setNombre(nombre);
    		dao.setLista(lista, usuario);
    }

    /**
     * Crea una lista vacia (las canciones se anaden aparte) y la guarda en la DB
     * @param nombre nombre de la lista
     */
    public void crearLista(String nombre) {
    		Lista lista = new lista(nombre, genero);
    		dao.setLista(lista, usuario);
    }

    /**
     * Crea una listaAuto con sus temas correspondientes y la guarda en la DB
     * @param nombre nombre de la lista
     * @param genero el genero del cual seleccionar las canciones
     */
    public void crearListaAuto(String nombre, Genero genero) {
    		ListaAuto lista = new listaAuto(nombre, genero);
    		//obtener lista de canciones con el genero que nos interesa
    		ArrayList<Cancion> canciones = dao.getCancionGeneroDB(idCancion, idGenero);
    		for (Cancion cancion : canciones) {
    			this.anadirCancion(cancion, lista);
    		}
    		dao.setListaAuto(lista, usuario, genero);
    }

    /**
     * Guarda en el dao la pertenencia de una cancion a una lista, vamos que mete
     * la cancion en la lista
     * @param cancion cancion a anadir
     * @param lista lista objetivo
     */
    public void anadirCancion(Cancion cancion, Lista lista) {
    		dao.setListaCancion(cancion, lista, usuario);
    }
}
