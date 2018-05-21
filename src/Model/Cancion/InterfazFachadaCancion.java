package Model.Cancion;

import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.*;

/**
 * Interfaz de la Fachada de canción.
 * @author Raúl
 *
 */
public interface InterfazFachadaCancion {
	/**
	 * Crea una canción con los atributos del objeto cancion que se pasa por parámetro.
	 * @param cancion Objeto creado que se actualizará con la canción creada.
	 * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
	 * @throws ErrorGuardado Si no se ha podido guardar la información.
	 */
	void creaCancion(Cancion cancion) throws ErrorCreacionObjeto, ErrorGuardado;
	
    /**
     * Elimina la canción que se pasa por parámetros.
     * @param cancion Canción que se quiere eliminar.
     * @throws ErrorEliminacion Si no se ha podido eliminar.
     */
	void eliminaCancion(Cancion cancion) throws ErrorEliminacion;
	
    /**
     * Obtiene el enlace de descarga de la canción cuyo id coincide con el que se pasa por parámetro.
     * @param cancion Id de la canción de la que se quiere descargar el video.
     * @throws ErrorConsulta Si se ha producido un error al buscar la cancións.
     * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
     * @return Enlace de descarga de la canción cuyo id coincide con el que se pasa por parámetro.
     */
    String descargaVideo(String cancion) throws ErrorConsulta, ErrorCreacionObjeto;
    
    /**
     * Obtiene la canción cuyo id coincide con el que se pasa por parámetro.
     * @param idCancion Id de la canción que se quiere consultar.
     * @throws ErrorConsulta Si se ha producido un error al buscar la canción.
     * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
     * @return Canción cuyo id coincide con el que se pasa por parámetro.
     */
    Cancion consultaCancion(String idCancion) throws ErrorConsulta, ErrorCreacionObjeto;
    
    /**
     * Obtiene la letra de la canción cuyo id coincide con el que se pasa por parámetro.
	 * @param idCancion Id de la canción de la que se quiere obtener la letra.
     * @throws ErrorConsulta Si se ha producido un error al buscar la letra.
     * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
     * @return Letra de la canción cuyo id coincide con el que se pasa por parámetro.
     */
    Letra consultaLetra(String idCancion) throws ErrorConsulta, ErrorCreacionObjeto;
    
	/**
	 * Obtiene el objeto video de la canción cuyo id coincide con el que se pasa por parámetros.
	 * @param idCancion Id de la canción de la que se quiere obtener el objeto Video.
	 * @throws ErrorConsulta Si se ha producido un error al buscar el video.
	 * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
	 * @return Video de la canción cuyo id coincide con el que se pasa por parámetro.
	 */
    Video consultaVideo(String idCancion) throws ErrorConsulta, ErrorCreacionObjeto;
}
