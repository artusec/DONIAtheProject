import Controlador.DAO.InterfazDAOFachada;
import Modelo.Objetos.Cancion;
import Modelo.Objetos.Letra;
import Modelo.Objetos.Video;

public class SASCancion implements InterfazSASCancion {
	
	private InterfazDAOFachada dao;

	//Para los siguientes metodos:
	//Si hubiese errores en el acceso a datos el dao nos notifica
	//Si letra (u otro atributo) no estuviese definida para el objeto, la gui recoge en null y no
	//	escribe nada en pantalla
	
	/**
	 * Devuelve una cancion de la DB
	 * @param cancion id de la cancion
	 * @return
	 */
    public Cancion consultaCancion(String cancion) {
    		return this.dao.getCancionDB(cancion);
    }
	
	/**
	 * Devuelve la letra de una cancion
	 * @param cancion id de la cancion
	 * @return
	 */
	public Letra consultaLetra(String cancion) {
	    	return this.dao.getCancionDB(cancion).getLetra();
	}
	
	/**
	 * Devuelve el video de una cancion
	 * @param cancion id de la cancion
	 * @return
	 */
    public Video consultaVideo(String cancion) {
    		return this.dao.getCancionDB(cancion).getVideo();
    }

	/**
	 * Devuelve el enlace de descarga del un video de la DB
	 * @param cancion id de la cancion
	 * @return 
	 */
    public String descargaVideo(String cancion) {
    		return this.dao.getCancionDB(cancion).getVideo().getEnlaceDescarga();
    }
}
