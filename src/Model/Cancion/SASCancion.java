package Model.Cancion;

import DAO.DAOFachada;
import DAO.InterfazDAOFachada;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.*;

/**
 * Servicio de aplicación de canción.
 * @author Raúl
 *
 */
public class SASCancion implements InterfazSASCancion {
	
	private InterfazDAOFachada dao;
	
	/**
	 * Constructora de la clase.
	 */
	public SASCancion() {
		this.setDao();
	}
	
	/**
	 * Método que actualiza el atributo "dao" a un nuevo DAOFachada.
	 */
	private void setDao() {
		this.dao = new DAOFachada();
	}

	/**
	 * Anade una cancion a la base de datos
	 * @param cancion cancion que se quiere anadir a la base de datos.
	 * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
	 */
	@Override
	public void creaCancion(Cancion cancion) throws ErrorCreacionObjeto, ErrorGuardado {
		if (cancion == null)
			throw new ErrorCreacionObjeto("Error al crear la cancion");
		else
			dao.setCancion(cancion);
			//la cancion deberia eliminarse anadirse sola a la biblioteca
	}
	

	/**
	 * Elimina una cancion de la base de datos.
	 * @param cancion cancion a eliminar
	 * @throws ErrorEliminacion Si no se ha podido eliminar.
	 */
	@Override
	public void eliminaCancion(Cancion cancion) throws ErrorEliminacion { 
		dao.eliminarCancion(cancion);
	}
	
	/**
	 * Devuelve una canción de la base de datos.
	 * @param cancion id de la cancion
	 * @return la cancion, null si no existe
	 * @throws ErrorConsulta Si se ha producido un error al buscar la canción.
	 * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
	 */
	@Override
    public Cancion consultaCancion(String cancion) throws ErrorConsulta, ErrorCreacionObjeto {
    		Cancion cancion2 = this.dao.getCancionDB(cancion);
    		if (cancion2 == null)
    			throw new ErrorConsulta("Error al consultar cancion");
    		else
    			return cancion2;
    }
	
	/**
	 * Devuelve la letra de una canción.
	 * @param cancion id de la cancion
	 * @return la letra, null si no existe
	 * @throws ErrorConsulta Si se ha producido un error al buscar la letra.
	 * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
	 */
	@Override
	public Letra consultaLetra(String cancion) throws ErrorConsulta, ErrorCreacionObjeto {
		Letra letra = this.dao.getCancionDB(cancion).getLetra();
		if (letra == null)
			throw new ErrorConsulta("Error al consultar letra");
		else
			return letra;
	}
	
	/**
	 * Devuelve el video de una canción.
	 * @param cancion id de la cancion
	 * @return el video, null si no existe
	 * @throws ErrorConsulta Si se ha producido un error al buscar el video.
	 * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
	 */
	@Override
    public Video consultaVideo(String cancion) throws ErrorConsulta, ErrorCreacionObjeto {
		Video video = this.dao.getCancionDB(cancion).getVideo();
		if (video == null)
			throw new ErrorConsulta("Error al consultar video");
		else
			return video;			
    }

	/**
	 * Devuelve el enlace de descarga del un video de la base de datos.
	 * @param cancion id de la cancion
	 * @return el enlace a descarga video, null si no existe
	 * @throws ErrorConsulta Si se ha producido un error al buscar el video.
	 * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
	 */
	@Override
    public String descargaVideo(String cancion) throws ErrorConsulta, ErrorCreacionObjeto {
		String enlace = this.dao.getCancionDB(cancion).getVideo().getEnlaceDescarga();
		if (enlace == null)
			throw new ErrorConsulta("Enlace inexistente");
		else
			return enlace;
    }
}
