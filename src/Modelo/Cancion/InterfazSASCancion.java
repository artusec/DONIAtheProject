import Excepciones.ErrorConsultaLetra;
import Modelo.Objetos.Cancion;
import Modelo.Objetos.Letra;
import Modelo.Objetos.Video;

public interface InterfazSASCancion {
	
    String descargaVideo(String cancion);
    Cancion consultaCancion(String cancion);
    Letra consultaLetra(String cancion);
    Video consultaVideo(String cancion);

}
