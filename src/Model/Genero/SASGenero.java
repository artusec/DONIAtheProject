package Model.Genero;

import Controlador.DAO.InterfazDAOFachada;
import Model.Objetos.Genero;

public class SASGenero implements InterfazSASGenero {
	
	private InterfazDAOFachada dao;
	//hay un objeto dao, solo que no se donde deberiamos ponerlo
	
	/**
	 * Anade un genero a la DB
	 * @param genero genero a anadir
	 */
    public void Anadir(Genero genero) {
    		dao.setGenero(genero);
    }

    /**
	 * Elimina un genero de la DB
	 * @param genero genero a eliminar
	 */
    public void Eliminar(Genero genero) {
    		dao.borrarGeneroDB(genero);
    	}

    /**
     * Obitiene un genero de la DB
     * @param id id del genero
     * @return el genero buscado, null si no existe
     */
    public Genero Consultar(String id) {
    		return dao.getGeneroDB(id);
    }
}
