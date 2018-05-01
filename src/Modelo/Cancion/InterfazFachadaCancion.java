import Modelo.Objetos.Cancion;
import Modelo.Objetos.Letra;
import Modelo.Objetos.Video;

public interface InterfazFachadaCancion {
	
    Cancion consultaCancion(String cancion);
    Letra consultaLetra(String cancion);
    Video consultaVideo(String cancion);
    String descargaVideo(String cancion);
    void creaCancion(String titulo, String artista, String album, String duracion, String genero, String letra, String video, String descarga);
    void eliminaCancion(String id);

}
