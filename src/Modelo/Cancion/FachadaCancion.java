import Modelo.Objetos.Cancion;
import Modelo.Objetos.Letra;
import Modelo.Objetos.Video;

public class FachadaCancion implements InterfazFachadaCancion {
    
	public InterfazSASCancion interfazSASCancion;

    public Video consultaVideo(String cancion) {
    	return interfazSASCancion.consultaVideo(cancion);
    }

    public Letra consultaLetra(String cancion) {
    	return interfazSASCancion.consultaLetra(cancion);
    	//¿Donde tratamos la excepcion?
    }

    public Cancion consultaCancion(String cancion) {
    	return interfazSASCancion.consultaCancion(cancion);
    }

    public String descargaVideo(String cancion) {
    	return interfazSASCancion.descargaVideo(cancion);
    }

    public void creaCancion(String titulo, String artista, String album, String duracion, String genero, String letra, String video, String descarga) {
    }

    public void eliminaCancion(String id) {
    }
}
