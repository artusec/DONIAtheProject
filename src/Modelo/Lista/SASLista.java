
import java.util.List;

import Controlador.DAO.InterfazDAOFachada;
import Modelo.Objetos.Cancion;
import Modelo.Objetos.Genero;
import Modelo.Objetos.Lista;

public class SASLista implements InterfazSASLista {
	
	private InterfazDAOFachada dao;
	//hay un objeto dao, solo que no se donde deberiamos ponerlo
	//tambien necesitamos en algunas clases (como esta) saber cual es el usuario con el que estamos trabajando ahora
	
	/**
	 * Devuelve la lista solicitada
	 * 
	 * TODO: quizas la lista deberia ser un string con la id
	 * 
	 * @param lista
	 * @return
	 */
    public Lista consultar(Lista lista) {
    		return dao.getListaDB(lista.getId());
    }

    public void borrar(Lista lista) {
    		dao.borrarLista(lista.getId, usuario);
    }

    public void modificar(String nombre, Lista lista) {
    		lista.setNombre(nombre);
    		dao.setLista(lista, usuario);
    }

    /**
     * Crea una lista vacia (las canciones se anaden aparte) y la guarda en la DB
     * @param nombre
     */
    public void crearLista(String nombre) {
    		Lista lista = new lista(nombre, genero);
    		dao.setLista(lista, usuario);
    }

    /**
     * Crea una listaAuto con sus temas correspondientes y la guarda en la DB
     * @param nombre
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
     * @param cancion
     * @param lista
     */
    public void anadirCancion(Cancion cancion, Lista lista) {
    		dao.setListaCancion(cancion, lista, usuario);
    }
}
