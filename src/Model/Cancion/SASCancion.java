package Model.Cancion;

import Controlador.DAO.InterfazDAOFachada;
import Excepciones.ErrorCreacionObjeto;
import Model.Objetos.*;

public class SASCancion implements InterfazSASCancion {
	
	private InterfazDAOFachada dao;//esto no se donde deberia ir controlador quizas?

	//Para los siguientes metodos:
	//Si hubiese errores en el acceso a datos el dao nos notifica
	//Si letra (u otro atributo) no estuviese definida para el objeto, la gui recoge en null y no
	//	escribe nada en pantalla
	
	@Override
	public void creaCancion(String titulo, String autor, String album,
				int duracion, Letra letra, Video video, Genero genero) throws ErrorCreacionObjeto {
		if (/*validar que el usuario actual es admin*/ true){
			Cancion cancion = new Cancion(/*TODO generador de ids*/"a", titulo, autor, album, duracion, letra, video, genero);
			dao.setCancion(cancion);
			//la cancion deberia eliminarse anadirse sola a la biblioteca
		}
	}
	
	@Override
	public void eliminaCancion(Cancion cancion) {
		if (/*validar que el usuario actual es admin*/ true){
			dao.eliminarCancion(cancion);
			//la cancion deberia eliminarse sola de la biblioteca
		}
	}
	
	/**
	 * Devuelve una cancion de la DB
	 * @param cancion id de la cancion
	 * @return la cancion, null si no existe
	 */
	@Override
    public Cancion consultaCancion(String cancion) {
    		return this.dao.getCancionDB(cancion);
    }
	
	/**
	 * Devuelve la letra de una cancion
	 * @param cancion id de la cancion
	 * @return la letra, null si no existe
	 */
	@Override
	public Letra consultaLetra(String cancion) {
	    	return this.dao.getCancionDB(cancion).getLetra();
	}
	
	/**
	 * Devuelve el video de una cancion
	 * @param cancion id de la cancion
	 * @return el video, null si no existe
	 */
	@Override
    public Video consultaVideo(String cancion) {
    		return this.dao.getCancionDB(cancion).getVideo();
    }

	/**
	 * Devuelve el enlace de descarga del un video de la DB
	 * @param cancion id de la cancion
	 * @return el enlace a descarga video, null si no existe
	 */
	@Override
    public String descargaVideo(String cancion) {
    		return this.dao.getCancionDB(cancion).getVideo().getEnlaceDescarga();
    }
}
