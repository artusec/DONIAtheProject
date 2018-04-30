package Modelo.Cancions;



public interface InterfazFachadaCancion {
	
    void consultaCancion(String cancion);
    void consultaLetra(String cancion);
    void consultaVideo(String cancion);
    void descargaVideo(String cancion);
    void creaCancion(String titulo, String artista, String album, String duracion, String genero, String letra, String video, String descarga);
    void eliminaCancion(String id);

}
