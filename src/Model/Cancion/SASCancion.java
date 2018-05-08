package Model.Cancion;

import Controlador.DAO.InterfazDAOFachada;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Model.Objetos.*;

public class SASCancion implements InterfazSASCancion {
	
	private InterfazDAOFachada dao;//esto no se donde deberia ir controlador quizas?

	//Para los siguientes metodos:
	//Si hubiese errores en el acceso a datos el dao nos notifica
	//Si letra (u otro atributo) no estuviese definida para el objeto, la gui recoge en null y no
	//	escribe nada en pantalla
	
	@Override
	/**
	 * Añade una canción a la base de datos
	 * @param titulo titulo de la canción
	 * @param autor autor de la canción
	 * @param album álbum al que pertenece la canción
	 * @param duracion duración de la canción
	 * @param letra letra de la canción
	 * @param video video de la canción
	 * @param genero género de la canción
	 * @throws ErrorCreacionObjeto
	 */
	public void creaCancion(String titulo, String autor, String album,
				int duracion, Letra letra, Video video, Genero genero) throws ErrorCreacionObjeto {
		//if (/*validar que el usuario actual es admin*/ true){ //Este if se hace en controlador
			Cancion cancion = new Cancion(/*TODO generador de ids*/"a", titulo, autor, album, duracion, letra, video, genero);
			if (cancion == null)
				throw new ErrorCreacionObjeto("Error al crear la canción");
			else
				dao.setCancion(cancion);
			//la cancion deberia eliminarse anadirse sola a la biblioteca
	}
	
	@Override
	/**
	 * Elimina una canción de la base de datos
	 * @param cancion canción a eliminar
	 * @throws 
	 */
	public void eliminaCancion(Cancion cancion) { 
		//if (/*validar que el usuario actual es admin*/ true){ //Se hace en el controlador
			dao.eliminarCancion(cancion);
			//la cancion deberia eliminarse sola de la biblioteca
	}
	
	/**
	 * Devuelve una cancion de la DB
	 * @param cancion id de la cancion
	 * @return la cancion, null si no existe
	 * @throws ErrorConsulta 
	 */
	@Override
    public Cancion consultaCancion(String cancion) throws ErrorConsulta {
    		Cancion cancion2 = this.dao.getCancionDB(cancion);
    		if (cancion2 == null)
    			throw new ErrorConsulta("Error al consultar cancion");
    		else
    			return cancion2;
    }
	
	/**
	 * Devuelve la letra de una cancion
	 * @param cancion id de la cancion
	 * @return la letra, null si no existe
	 * @throws ErrorConsulta 
	 */
	@Override
	public Letra consultaLetra(String cancion) throws ErrorConsulta {
		Letra letra = this.dao.getCancionDB(cancion).getLetra();
		if (letra == null)
			throw new ErrorConsulta("Error al consultar letra");
		else
			return letra;
	}
	
	/**
	 * Devuelve el video de una cancion
	 * @param cancion id de la cancion
	 * @return el video, null si no existe
	 * @throws ErrorConsulta 
	 */
	@Override
    public Video consultaVideo(String cancion) throws ErrorConsulta {
		Video video = this.dao.getCancionDB(cancion).getVideo();
		if (video == null)
			throw new ErrorConsulta("Error al consultar video");
		else
			return video;			
    }

	/**
	 * Devuelve el enlace de descarga del un video de la DB
	 * @param cancion id de la cancion
	 * @return el enlace a descarga video, null si no existe
	 * @throws ErrorConsulta 
	 */
	@Override
    public String descargaVideo(String cancion) throws ErrorConsulta {
		String enlace = this.dao.getCancionDB(cancion).getVideo().getEnlaceDescarga();
		if (enlace == null)
			throw new ErrorConsulta("Enlace inexistente");
		else
			return enlace;
    }
}
