package Model.Genero;

import DAO.DAOFachada;
import DAO.InterfazDAOFachada;
import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.Genero;
import Model.Objetos.Usuario;
import Vista.VentanaPrincipal;

/**
 * Servicio de aplicación de género.
 * @author Raúl
 *
 */
public class SASGenero implements InterfazSASGenero {
	
	private InterfazDAOFachada dao;
	
	/**
	 * Constructura de la clase.
	 */
	public SASGenero() {
		this.setDao();
	}
	
	/**
	 * Actualiza el atributo dao a un nuevo DAOFachada.
	 */
	private void setDao() {
		this.dao = new DAOFachada();
	}
	
	/**
	 * Añade un género a la DB.
	 * @param genero Género a anadir.
	 * @param usuario Usuario en el que se quiere añadir el género.
	 * @throws ErrorGuardado Si no se ha podido guardar la información.
	 * @throws ErrorAutenticacion Si el usuario no existe.
	 */
	@Override
    public void Anadir(Genero genero, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado { 
    		dao.setGenero(genero, usuario);
    }

    /**
	 * Elimina un género de la DB.
	 * @param genero género a eliminar.
	 * @param usuario usuario que quiere eliminar el género.
     * @throws ErrorAutenticacion Si el usuario no existe.
     * @throws ErrorEliminacion Si no se ha podido eliminar.
	 */
	@Override
    public void Eliminar(Genero genero, Usuario usuario) throws ErrorEliminacion, ErrorAutenticacion { 
		dao.eliminarGenero(genero, usuario);
    	}

    /**
     * Obtiene un género de la DB.
     * @param idGenero id del género.
     * @return el género buscado, null si no existe.
     * @throws ErrorConsulta Si se ha producido un error al buscar el género.
     * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
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
