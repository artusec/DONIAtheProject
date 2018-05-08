package Model.Genero;

import Controlador.DAO.InterfazDAOFachada;
import Excepciones.ErrorConsulta;
import Model.Objetos.Genero;
import Model.Objetos.Usuario;

public class SASGenero implements InterfazSASGenero {
	
	private InterfazDAOFachada dao;
	//hay un objeto dao, solo que no se donde deberiamos ponerlo
	
	/**
	 * Anade un genero a la DB
	 * @param genero genero a anadir
	 */
    public void Anadir(Usuario usuario, Genero genero) { //Falta acabar setgenero
    		dao.setGenero(usuario, genero);
    }

    /**
	 * Elimina un genero de la DB
	 * @param genero genero a eliminar
	 */
    public void Eliminar(Usuario usuario, Genero genero) { //Falta acabar borrargeneroDB
    		dao.borrarGeneroDB(usuario, genero);
    	}

    /**
     * Obitiene un genero de la DB
     * @param id id del genero
     * @return el genero buscado, null si no existe
     * @throws ErrorConsulta 
     */
    public Genero Consultar(String idGenero) throws ErrorConsulta {
    	Genero genero = dao.getGeneroDB(idGenero);
    	if (genero == null)
    		throw new ErrorConsulta("Error al consultar género");
    	else
    		return genero;
    }
}
