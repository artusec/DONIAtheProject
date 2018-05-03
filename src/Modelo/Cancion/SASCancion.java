import Controlador.DAO.InterfazDAOFachada;
import Excepciones.ErrorConsultaLetra;
import Modelo.Objetos.Cancion;
import Modelo.Objetos.Letra;
import Modelo.Objetos.Video;

public class SASCancion implements InterfazSASCancion {
	
	private InterfazDAOFachada interfazDAOFachada;
	
   /* public Letra consultaLetra(String cancion) throws ErrorConsultaLetra {
	    	return this.interfazDAOFachada.getCancionDB(cancion).getLetra();
	    if (letra == null)
	    		throw new ErrorConsultaLetra();
	    	else
	    		return letra;
    }*/

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
    		return this.interfazDAOFachada.getCancionDB(cancion);
    }

    public String descargaVideo(String cancion) {
    		return this.interfazDAOFachada.getCancionDB(cancion).getVideo().getEnlaceDescarga();
    }
}
