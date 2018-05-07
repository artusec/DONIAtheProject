package Model.Cancion;

import Excepciones.ErrorCreacionObjeto;
import Model.Objetos.*;

public interface InterfazFachadaCancion {
    Cancion consultaCancion(String cancion);
    Letra consultaLetra(String cancion);
    Video consultaVideo(String cancion);
    String descargaVideo(String cancion);
    void creaCancion(String titulo, String autor, String album, int duracion,
    						Genero genero, Letra letra, Video video) throws ErrorCreacionObjeto;
    void eliminaCancion(Cancion cancion);
}
