import Controlador.DAO.InterfazDAOFachada;
import Modelo.Objetos.Cancion;
import Modelo.Objetos.Letra;
import Modelo.Objetos.Video;

public class SASCancion implements InterfazSASCancion {
	
	private InterfazDAOFachada interfazDAOFachada;

	//Para los siguientes metodos:
	//Si hubiese errores en el acceso a datos el dao nos notifica
	//Si letra (u otro atributo) no estuviese definida para el objeto, la gui recoge en null y no
	//	escribe nada en pantalla
	
	public Letra consultaLetra(String cancion) {
	    	return this.interfazDAOFachada.getCancionDB(cancion).getLetra();
	}
	
    public Video consultaVideo(String cancion) {
    		return this.interfazDAOFachada.getCancionDB(cancion).getVideo();
    }

    public Cancion consultaCancion(String cancion) {
		/*
		 * Segun nuestro diagrama de secuencia esto deberia devolver un enlace
		 * o un error
		 * ¿No habria que añadir la parte del error?
		 * 		(Que si el getCancionDB devuelve null, lanzaramos un error)
    	*/
    		return this.interfazDAOFachada.getCancionDB(cancion);
    }

    public String descargaVideo(String cancion) {
    		return this.interfazDAOFachada.getCancionDB(cancion).getVideo().getEnlaceDescarga();
    }
}
