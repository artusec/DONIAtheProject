import Controlador.DAO.InterfazDAOFachada;
import Excepciones.ErrorConsultaLetra;
import Modelo.Objetos.Cancion;
import Modelo.Objetos.Letra;
import Modelo.Objetos.Video;

public class SASCancion implements InterfazSASCancion {
	private InterfazDAOFachada interfazDAOFachada;
    public Letra consultaLetra(String cancion) throws ErrorConsultaLetra {
    	Letra letra =  this.interfazDAOFachada.getCancionDB(cancion).getLetra();
    	if (letra == null)
    		throw new ErrorConsultaLetra();
    	else
    		return letra;
    
    		
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
