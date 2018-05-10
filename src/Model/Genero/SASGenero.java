package Model.Genero;

import Controlador.DAO.DAOFachada;
import Controlador.DAO.InterfazDAOFachada;
import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.Genero;
import Model.Objetos.Usuario;

public class SASGenero implements InterfazSASGenero {
	
	private InterfazDAOFachada dao;
	//hay un objeto dao, solo que no se donde deberiamos ponerlo
	
	public SASGenero() {
		this.setDao();
	}
	
	private void setDao() {
		this.dao = new DAOFachada();
	}
	
	/**
	 * Anade un genero a la DB
	 * @param genero genero a anadir
	 * @throws ErrorGuardado 
	 * @throws ErrorAutenticacion 
	 */
	@Override
    public void Anadir(Genero genero, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado { 
    		dao.setGenero(genero, usuario);
    }

    /**
	 * Elimina un genero de la DB
	 * @param genero genero a eliminar
	 * @param usuario usuario que quiere eliminar el genero
     * @throws ErrorAutenticacion 
     * @throws ErrorEliminacion 
	 */
	@Override
    public void Eliminar(Genero genero, Usuario usuario) throws ErrorEliminacion, ErrorAutenticacion { //Falta acabar borrargeneroDB y mirar luego el diagrama
    		dao.eliminarGenero(genero, usuario);
    	}

    /**
     * Obitiene un genero de la DB
     * @param id id del genero
     * @return el genero buscado, null si no existe
     * @throws ErrorConsulta 
     * @throws ErrorCreacionObjeto 
     */
	@Override
    public Genero Consultar(String idGenero) throws ErrorConsulta, ErrorCreacionObjeto {
    	Genero genero = dao.getGeneroDB(idGenero);
    	if (genero == null)
    		throw new ErrorConsulta("Error al consultar genero");
    	else
    		return genero;
    }
}
