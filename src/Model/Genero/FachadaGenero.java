package Model.Genero;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.Genero;
import Model.Objetos.Usuario;

public class FachadaGenero implements InterfazFachadaGenero {
	
    public InterfazSASGenero sasGenero;
    
    /**
     * Constructora de la clase.
     */
    public FachadaGenero() {
    	sasGenero = new SASGenero();
    }
 
	/**
	 * Añade un género a la DB.
	 * @param genero Género a añadir.
	 * @param usuario Usuario en el que se quiere añadir el género.
	 * @throws ErrorAutenticacion
	 * @throws ErrorGuardado
	 */
    @Override
    public void Anadir(Genero genero, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado {
    	sasGenero.Anadir(genero, usuario);
    }
    
    /**
     * Elimina un género de la DB.
     * @param genero género a eliminar.
     * @param usuario usuario que quiere eliminar el género.
     * @throws ErrorEliminacion
     * @throws ErrorAutenticacion
     */
    @Override
    public void Eliminar(Genero genero, Usuario usuario) throws ErrorEliminacion, ErrorAutenticacion {
    	sasGenero.Eliminar(genero, usuario);
    }
    
    /**
     * Obtiene un género de la DB.
     * @param idGenero id del género.
     * @return el género buscado, null si no existe.
     * @throws ErrorConsulta
     * @throws ErrorCreacionObjeto
     */
    @Override
    public Genero Consultar(String idGenero) throws ErrorConsulta, ErrorCreacionObjeto {
    	return sasGenero.Consultar(idGenero);
    }
}
