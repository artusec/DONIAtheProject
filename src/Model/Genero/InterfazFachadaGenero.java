package Model.Genero;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.Genero;
import Model.Objetos.Usuario;

public interface InterfazFachadaGenero {
	
	/**
	 * Añade un género a la base de datos.
	 * @param genero Género a añadir.
	 * @param usuario Usuario en el que se quiere añadir el género.
	 * @throws ErrorAutenticacion
	 * @throws ErrorGuardado
	 */
    void Anadir(Genero genero, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado;
    
    /**
     * Elimina un género de la base de datos.
     * @param genero género a eliminar.
     * @param usuario usuario que quiere eliminar el género.
     * @throws ErrorEliminacion
     * @throws ErrorAutenticacion
     */
    void Eliminar(Genero genero, Usuario usuario) throws ErrorEliminacion, ErrorAutenticacion;
    
    /**
     * Obtiene un género de la base de datos.
     * @param idGenero id del género.
     * @return el género buscado, null si no existe.
     * @throws ErrorConsulta
     * @throws ErrorCreacionObjeto
     */
    Genero Consultar(String idGenero) throws ErrorConsulta, ErrorCreacionObjeto;
}