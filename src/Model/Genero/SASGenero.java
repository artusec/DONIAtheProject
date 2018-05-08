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
	@Override
    public void Anadir(Genero genero, Usuario usuario) { //Falta acabar setgenero
    		dao.setGenero(genero, usuario);
    }

    /**
	 * Elimina un genero de la DB
	 * @param genero genero a eliminar
	 */
	@Override
    public void Eliminar(Genero genero, Usuario usuario) { //Falta acabar borrargeneroDB
    		dao.eliminarGenero(genero, usuario);
    	}

    /**
     * Obitiene un genero de la DB
     * @param id id del genero
     * @return el genero buscado, null si no existe
     * @throws ErrorConsulta 
     */
	@Override
    public Genero Consultar(String idGenero) throws ErrorConsulta {
    	Genero genero = dao.getGeneroDB(idGenero);
    	if (genero == null)
    		throw new ErrorConsulta("Error al consultar genero");
    	else
    		return genero;
    }
}
